package com.jnb.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jnb.modal.GroupBean;
import com.jnb.modal.MenuBean;
import com.jnb.modal.RoleBean;
import com.jnb.mybatis.dao.AdminDao;
import com.jnb.service.IAdminService;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public List<RoleBean> roleList() {

		return adminDao.roleList();
	}

	@Override
	public void addRole(RoleBean roleBean) {

		adminDao.addRole(roleBean);
		int rolePk = roleBean.getPk();
		for (int menuPk : roleBean.getMenuPks()) {
			adminDao.addRoleMenuMapping(rolePk, menuPk);
		}
	}

	@Override
	public RoleBean roleByPk(int pk) {
		RoleBean roleBean = adminDao.roleByPk(pk);
		List<Integer> menuPks = adminDao.getRoleMenus(pk);
		roleBean.setMenuPks(menuPks);

		return roleBean;
	}

	@Override
	public void deleteRoleByPk(int pk) {
		adminDao.deleteRoleByPk(pk);
		adminDao.deleteRoleMenuMappingByPk(pk);
	}

	@Override
	public void updateRole(RoleBean roleBean) {
		adminDao.deleteRoleMenuMappingByPk(roleBean.getPk());
		adminDao.updateRole(roleBean);

		for (int menuPk : roleBean.getMenuPks()) {
			adminDao.addRoleMenuMapping(roleBean.getPk(), menuPk);
		}

	}

	@Override
	public List<GroupBean> groupList() {

		return adminDao.groupList();
	}

	@Override
	public void addGroup(GroupBean groupBean) {
		adminDao.addGroup(groupBean);
		int pk = groupBean.getPk();
		for (int userPk : groupBean.getUserPks()) {
			adminDao.addGroupUserMapping(pk, userPk);
		}
	}

	@Override
	public GroupBean groupByPk(int pk) {
		GroupBean groupBean = adminDao.groupByPk(pk);

		List<Integer> userPks = adminDao.getGroupUsers(pk);
		groupBean.setUserPks(userPks);

		return groupBean;
	}

	@Override
	public void deleteGroupByPk(int pk) {
		adminDao.deleteGroupByPk(pk);
		adminDao.deleteGroupUserMappingByPk(pk);
	}

	@Override
	public void updateGroup(GroupBean groupBean) {
		adminDao.deleteGroupUserMappingByPk(groupBean.getPk());
		adminDao.updateGroup(groupBean);

		for (int userPk : groupBean.getUserPks()) {
			adminDao.addGroupUserMapping(groupBean.getPk(), userPk);
		}
	}

	@Override
	public List<MenuBean> menuList() {

		return adminDao.menuList();
	}

	@Override
	public Map<String, List<MenuBean>> userWiseMenuDetails(int userPk) {

		Map<String, List<MenuBean>> returnMap = new LinkedHashMap<>();
		List<Map<String, Object>> data = null;

		if (userPk != 0) {
			data = adminDao.userWiseMenuDetails(userPk);
		} else {
			data = adminDao.allMenuList();
		}

		for (Map<String, Object> tmpMap : data) {

			String menuAction = String.valueOf(tmpMap.get("menu_action"));
			String menuName = String.valueOf(tmpMap.get("menu_name"));
			String isDisplay = String.valueOf(tmpMap.get("is_display"));
			String parent = String.valueOf(tmpMap.get("parent"));
			String menuCss = String.valueOf(tmpMap.get("menu_css"));

			if (parent == null || parent.equals("") || parent.equalsIgnoreCase("null")) {
				parent = menuName;
			}
			parent = parent + "#" + menuCss;
			MenuBean tmpBean = new MenuBean();
			tmpBean.setIsDisplay(isDisplay);
			tmpBean.setMenuAction(menuAction);
			tmpBean.setMenuName(menuName);
			tmpBean.setParent(parent);
			tmpBean.setMenuCss(menuCss);

			if (returnMap.containsKey(parent)) {
				returnMap.get(parent).add(tmpBean);
			} else {
				ArrayList<MenuBean> tmpList = new ArrayList<>();
				tmpList.add(tmpBean);

				returnMap.put(parent, tmpList);
			}
		}

		return returnMap;
	}

	@Override
	public List<MenuBean> userWiseMenuDetailsList(int userPk) {

		ArrayList<MenuBean> tmpList = new ArrayList<>();

		List<Map<String, Object>> data = adminDao.userWiseMenuDetails(userPk);
		for (Map<String, Object> tmpMap : data) {

			String menuAction = String.valueOf(tmpMap.get("menu_action"));
			String menuName = String.valueOf(tmpMap.get("menu_name"));
			String isDisplay = String.valueOf(tmpMap.get("is_display"));
			String parent = String.valueOf(tmpMap.get("parent"));
			String menuCss = String.valueOf(tmpMap.get("menu_css"));

			if (parent == null || parent.equals("") || parent.equalsIgnoreCase("null")) {
				parent = menuName;
			}

			MenuBean tmpBean = new MenuBean();
			tmpBean.setIsDisplay(isDisplay);
			tmpBean.setMenuAction(menuAction);
			tmpBean.setMenuName(menuName);
			tmpBean.setParent(parent);
			tmpBean.setMenuCss(menuCss);

			tmpList.add(tmpBean);
		}

		return tmpList;
	}

	@Override
	public List<MenuBean> allMenuList() {
		ArrayList<MenuBean> tmpList = new ArrayList<>();

		List<Map<String, Object>> data = adminDao.allMenuList();
		for (Map<String, Object> tmpMap : data) {

			String menuAction = String.valueOf(tmpMap.get("menu_action"));
			String menuName = String.valueOf(tmpMap.get("menu_name"));
			String isDisplay = String.valueOf(tmpMap.get("is_display"));
			String parent = String.valueOf(tmpMap.get("parent"));
			String menuCss = String.valueOf(tmpMap.get("menu_css"));

			if (parent == null || parent.equals("") || parent.equalsIgnoreCase("null")) {
				parent = menuName;
			}

			MenuBean tmpBean = new MenuBean();
			tmpBean.setIsDisplay(isDisplay);
			tmpBean.setMenuAction(menuAction);
			tmpBean.setMenuName(menuName);
			tmpBean.setParent(parent);
			tmpBean.setMenuCss(menuCss);

			tmpList.add(tmpBean);
		}

		return tmpList;
	}

	@Override
	public Map<String, String> menuActionParentMap() {
		Map<String, String> menuMap = new LinkedHashMap<>();

		for (MenuBean menuBean : adminDao.menuList()) {
			menuMap.put(menuBean.getMenuAction(), menuBean.getParent());
		}

		return menuMap;
	}

}
