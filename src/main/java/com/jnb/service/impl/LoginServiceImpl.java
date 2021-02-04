package com.jnb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jnb.modal.SettingBean;
import com.jnb.modal.UserBean;
import com.jnb.mybatis.dao.LoginDao;
import com.jnb.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private LoginDao loginDao;

	@Override
	public UserBean checkLogin(String userId, String password) {

		return loginDao.checkLogin(userId, password);
	}

	@Override
	public List<UserBean> userList() {

		return loginDao.userList();
	}

	@Override
	public void addUser(UserBean userBean) {
		if (userBean.getPk() != 0) {
			loginDao.editUser(userBean);
		} else {
			loginDao.addUser(userBean);
		}

	}

	@Override
	public UserBean getUserByPk(int pk) {

		return loginDao.getUserByPk(pk);
	}

	@Override
	public void deleteUserByPk(int pk) {
		loginDao.deleteUserByPk(pk);
	}

	@Override
	public UserBean getUserByName(String userName) {

		return loginDao.getUserByName(userName);
	}

	@Override
	public SettingBean getAppSetting() {

		SettingBean bean = new SettingBean();
		List<Map<String, Object>> list = loginDao.getSettings();
		if (list != null && list.size() > 0) {

			Map<String, Object> tmpMap = list.get(0);
			bean.setRegisEnabDis(Boolean.parseBoolean(String.valueOf(tmpMap.get("regis_enab_dis"))));
			bean.setAppVersion(String.valueOf(tmpMap.get("app_version")));
			bean.setGmailFbLogin(Boolean.parseBoolean(String.valueOf(tmpMap.get("gmail_fb_login"))));
			bean.setLogout(Boolean.parseBoolean(String.valueOf(tmpMap.get("is_logout"))));
		}
		return bean;
	}

	public void saveAppSetting(SettingBean bean) {

		loginDao.saveAppSetting(bean);
	}

	@Override
	public void resetPassword(String password, int pk) {
		loginDao.resetPassword(password, pk);
	}

	@Override
	public void changePassword(String userId, String newPassword) {
		loginDao.changePassword(newPassword, userId);
	}

	@Override
	public void changePasswordByUserPk(int userPk, String newPassword) {
		loginDao.changePasswordByUserPk(newPassword, userPk);
	}

}
