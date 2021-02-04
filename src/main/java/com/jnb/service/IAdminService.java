package com.jnb.service;

import java.util.List;
import java.util.Map;

import com.jnb.modal.GroupBean;
import com.jnb.modal.MenuBean;
import com.jnb.modal.RoleBean;

public interface IAdminService {

	public List<RoleBean> roleList();

	public void addRole(RoleBean roleBean);

	public RoleBean roleByPk(int pk);

	public void deleteRoleByPk(int pk);

	public void updateRole(RoleBean roleBean);

	public List<GroupBean> groupList();

	public void addGroup(GroupBean groupBean);

	public GroupBean groupByPk(int pk);

	public void deleteGroupByPk(int pk);

	public void updateGroup(GroupBean roleBean);

	public List<MenuBean> menuList();

	public Map<String, List<MenuBean>> userWiseMenuDetails(int userPk);

	public List<MenuBean> userWiseMenuDetailsList(int userPk);

	public List<MenuBean> allMenuList();

	public Map<String, String> menuActionParentMap();

}
