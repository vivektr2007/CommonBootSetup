package com.jnb.service;

import java.util.List;

import com.jnb.modal.SettingBean;
import com.jnb.modal.UserBean;

public interface ILoginService {

	public UserBean checkLogin(String userId, String password);

	public List<UserBean> userList();

	public void addUser(UserBean userBean);

	public void resetPassword(String password, int pk);

	public UserBean getUserByPk(int pk);

	public void deleteUserByPk(int pk);

	public UserBean getUserByName(String userName);

	public SettingBean getAppSetting();

	public void saveAppSetting(SettingBean bean);

	public void changePassword(String userId, String newPassword);

	public void changePasswordByUserPk(int userPk, String newPassword);
}
