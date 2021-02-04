package com.jnb.modal;

import java.util.ArrayList;
import java.util.List;

public class RoleBean {

	private int pk;
	private String roleName;
	private String roleDesc;
	private List<Integer> menuPks = new ArrayList<>();
	
	private List<MenuBean> menuList = new ArrayList<>();

	
	public List<Integer> getMenuPks() {
		return menuPks;
	}

	public void setMenuPks(List<Integer> menuPks) {
		this.menuPks = menuPks;
	}

	public Integer getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public List<MenuBean> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuBean> menuList) {
		this.menuList = menuList;
	}

	
	
}
