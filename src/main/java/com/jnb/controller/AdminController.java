package com.jnb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jnb.modal.GroupBean;
import com.jnb.modal.RoleBean;
import com.jnb.service.IAdminService;
import com.jnb.service.ILoginService;

@Controller
public class AdminController {

	@Autowired
	private IAdminService adminService;

	@Autowired
	private ILoginService loginService;

	@RequestMapping(value = "roleList", method = RequestMethod.GET)
	public String roleList(Model model, HttpSession session) {

		model.addAttribute("roleList", adminService.roleList());

		return "admin/roleList";
	}

	@RequestMapping(value = "addRole", method = RequestMethod.GET)
	public String addRole(Model model, @RequestParam(required = false) Integer pk, HttpSession session) {

		if (pk != null && pk != 0) {
			model.addAttribute("roleBean", adminService.roleByPk(pk));
		} else {
			model.addAttribute("roleBean", new RoleBean());
		}
		model.addAttribute("menuList", adminService.menuList());

		return "admin/addRole";
	}

	@RequestMapping(value = "viewRole", method = RequestMethod.GET)
	public String viewRole(Model model, @RequestParam Integer pk, HttpSession session) {

		if (pk != null && pk != 0) {
			model.addAttribute("roleBean", adminService.roleByPk(pk));
		} else {
			model.addAttribute("roleBean", new RoleBean());
		}
		model.addAttribute("menuList", adminService.menuList());

		return "admin/viewRole";
	}

	@RequestMapping(value = "deleteRole", method = RequestMethod.GET)
	public String deleteRole(Model model, @RequestParam Integer pk, HttpSession session) {

		adminService.deleteRoleByPk(pk);

		return "redirect:roleList?msg=success";
	}

	@RequestMapping(value = "addRoleSubmit", method = RequestMethod.POST)
	public String addRoleSubmit(Model model, @ModelAttribute("roleBean") RoleBean roleBean, HttpSession session) {

		if (roleBean.getPk() != null && roleBean.getPk() != 0) {
			adminService.updateRole(roleBean);
		} else {
			adminService.addRole(roleBean);
		}

		return "redirect:roleList?msg=success";
	}

	/* Role details ends */

	/* Group details */

	@RequestMapping(value = "groupList", method = RequestMethod.GET)
	public String groupList(Model model, HttpSession session) {

		model.addAttribute("groupList", adminService.groupList());

		return "admin/groupList";
	}

	@RequestMapping(value = "addGroup", method = RequestMethod.GET)
	public String addGroup(Model model, @RequestParam(required = false) Integer pk, HttpServletRequest request) {

		if (pk != null && pk != 0) {
			model.addAttribute("groupBean", adminService.groupByPk(pk));
		} else {
			model.addAttribute("groupBean", new GroupBean());
		}
		model.addAttribute("roleList", adminService.roleList());
		model.addAttribute("userList", loginService.userList());

		return "admin/addGroup";
	}

	@RequestMapping(value = "viewGroup", method = RequestMethod.GET)
	public String viewGroup(Model model, @RequestParam Integer pk, HttpServletRequest request) {

		if (pk != null && pk != 0) {
			model.addAttribute("groupBean", adminService.groupByPk(pk));
		} else {
			model.addAttribute("groupBean", new GroupBean());
		}

		model.addAttribute("roleList", adminService.roleList());
		model.addAttribute("userList", loginService.userList());

		return "admin/viewGroup";
	}

	@RequestMapping(value = "deleteGroup", method = RequestMethod.GET)
	public String deleteGroup(Model model, @RequestParam Integer pk, HttpSession session) {

		adminService.deleteGroupByPk(pk);

		return "redirect:groupList?msg=success";
	}

	@RequestMapping(value = "addGroupSubmit", method = RequestMethod.POST)
	public String addGroupSubmit(Model model, @ModelAttribute("groupBean") GroupBean roleBean, HttpSession session) {

		if (roleBean.getPk() != null && roleBean.getPk() != 0) {
			adminService.updateGroup(roleBean);
		} else {
			adminService.addGroup(roleBean);
		}

		return "redirect:groupList?msg=success";
	}

}
