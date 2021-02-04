package com.jnb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jnb.modal.ChangePasswordBean;
import com.jnb.modal.SettingBean;
import com.jnb.modal.UserBean;
import com.jnb.service.IAdminService;
import com.jnb.service.ILoginService;
import com.jnb.util.GistUtil;

/**
 * 
 * @Description Dummy Controller for request mapping JSP pages contains
 *              reference to the html pages.
 *
 */
@Controller
@PropertySource("classpath:application.properties")
public class LoginController {

	@Autowired
	private IAdminService adminService;

	@Autowired
	private ILoginService loginService;

	@Value("${static.file.version}")
	private String version;

	@GetMapping(value = { "/", "login" })
	public String showLogin(ModelMap map) {
		return "login";
	}

	@RequestMapping(value = "userList", method = { RequestMethod.GET, RequestMethod.POST })
	public String userList(Model model, HttpServletRequest request) {

		List<UserBean> userList = loginService.userList();
		model.addAttribute("userList", userList);
		model.addAttribute("msg", request.getParameter("msg"));

		return "admin/userList";
	}

	@ResponseBody
	@RequestMapping(value = "checkDuplicateUserName", method = { RequestMethod.GET, RequestMethod.POST })
	public String checkDuplicateUserName(@RequestParam String userName, HttpServletRequest request) {
		String result = "1";
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");

		userBean = loginService.getUserByName(userName);
		if (userBean != null && userBean.getId() != null) {
			result = "0";
		}

		return result;
	}
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="checkDuplicateUserAndDBName", method=
	 * {RequestMethod.GET, RequestMethod.POST}) public String
	 * checkDuplicateUserAndDBName(@RequestParam String userName,@RequestParam
	 * String dbName, HttpServletRequest request ) { String result = "1";
	 * 
	 * UserBean userBean = (UserBean)request.getSession().getAttribute("userBean");
	 * String = userBean.get();
	 * 
	 * UserBean userBean = loginService.getUserByName(userName); if(userBean != null
	 * && userBean.getId() != null) { result = "0" ; } SchoolBean sBean =
	 * schoolService.schoolByDBName(dbName); if(sBean != null &&
	 * sBean.getAdminUserId() != null) { result = "2" ; }
	 * 
	 * return result; }
	 */

	@RequestMapping(value = "/CheckLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String CheckLogin(@RequestParam String userId, @RequestParam String password, HttpSession session,
			HttpServletRequest request, Model model) {
		try {
			UserBean userBean = loginService.checkLogin(userId, password);
			if (userBean != null) {
				session.setAttribute("userBean", userBean);
				int userPk = userBean.getPk();
				if (userBean.getIsAdmin().equals("Y")) {
					userPk = 0;
				}
				userBean.setUserMenus(adminService.userWiseMenuDetails(userPk));
				userBean.setMenusList(adminService.userWiseMenuDetailsList(userPk));
				userBean.setAllMenusList(adminService.allMenuList());
				userBean.setMenuActionWithParentMap(adminService.menuActionParentMap());

				session.setAttribute("version", version);

				return "redirect:index.html";
			} else {
				request.setAttribute("loginError",
						"<font color='red'>User Id or Password entered is incorrect.</font>");

				return "login";
			}
		} catch (Exception e) {
			request.setAttribute("loginError",
					"<font color='red'>User Id/Password/Domain name entered is incorrect.</font>");

			return "login";
		}

	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showDashboard(ModelMap map, Model model, HttpSession session) {
		Map<String, Object> summaryMap = new HashMap<>();

		model.addAttribute("summaryMap", summaryMap);

		return "index";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(Model model, @RequestParam(required = false) Integer pk, HttpServletRequest request) {

		if (pk != null && pk != 0) {
			model.addAttribute("userBean", loginService.getUserByPk(pk));
		} else {
			model.addAttribute("userBean", new UserBean());
		}

		return "admin/addUser";
	}

	@RequestMapping(value = "/viewUser", method = RequestMethod.GET)
	public String viewUser(Model model, @RequestParam(required = false) Integer pk, HttpServletRequest request) {

		model.addAttribute("userBean", loginService.getUserByPk(pk));

		return "admin/viewUser";
	}

	@RequestMapping(value = "/addUserSubmit", method = RequestMethod.POST)
	public String addUserSubmit(ModelMap map, HttpSession session, @ModelAttribute UserBean userBean,
			HttpServletRequest request) {

		loginService.addUser(userBean);

		return "redirect:userList.html";
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(ModelMap map, HttpSession session, @RequestParam int pk) {

		loginService.deleteUserByPk(pk);

		return "redirect:userList.html";
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public String resetPassword(ModelMap map, HttpSession session, @RequestParam int pk) {

		String password = GistUtil.generateRandomPassword();

		loginService.resetPassword(password, pk);

		return "redirect:userList.html?msg=" + GistUtil.encodeString("Password changed successfully.");
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(ModelMap map) {
		return "error";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap map, HttpSession session) {
		session.removeAttribute("userBean");
		session.invalidate();

		return "redirect:login";
	}

	@RequestMapping(value = "appSettingsMaster", method = { RequestMethod.GET, RequestMethod.POST })
	public String appSettingsMaster(Model model) {

		model.addAttribute("settingBean", loginService.getAppSetting());

		return "admin/appSettings";
	}

	@RequestMapping(value = "appSettingsMasterSave", method = { RequestMethod.GET, RequestMethod.POST })
	public String appSettingsMasterSave(@ModelAttribute("settingBean") SettingBean bean) {
		try {
			loginService.saveAppSetting(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:appSettingsMaster";
	}

	@RequestMapping(value = "changePassword", method = { RequestMethod.GET, RequestMethod.POST })
	public String changePassword() {

		return "admin/changePassword";
	}

	@RequestMapping(value = "changedPasswordSubmit", method = { RequestMethod.GET, RequestMethod.POST })
	public String changedPassword(@ModelAttribute("changePasswordBean") ChangePasswordBean changePasswordBean,
			HttpSession session, Model model) {
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		if ((userBean.getPassword()).equals(changePasswordBean.getOldPassword())
				&& (changePasswordBean.getNewPassword()).equals(changePasswordBean.getConfirmNewPassword())) {
			loginService.changePassword(userBean.getId(), changePasswordBean.getNewPassword());
			model.addAttribute("changePasswordMsg", "<font color='green'>Password changed successfully.</font>");
			return "admin/changePassword";
		} else {
			model.addAttribute("changePasswordMsg", "Old or Confirm Password Missmatch !");
			return "admin/changePassword";
		}
	}

}
