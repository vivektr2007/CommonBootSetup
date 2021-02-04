package com.jnb.modal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserBean {

	private String id;
	private String password;
	private String name;
	private int pk;
	private String databaseName;
	private String emailId;
	private String isAdmin;
	private int mainPk;

	private Map<String, List<MenuBean>> userMenus = new LinkedHashMap<>();
	private List<MenuBean> menusList = new ArrayList<>();
	private List<MenuBean> allMenusList = new ArrayList<>();
	private Map<String, String> menuActionWithParentMap = new HashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMainPk() {
		return mainPk;
	}

	public void setMainPk(int mainPk) {
		this.mainPk = mainPk;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Map<String, String> getMenuActionWithParentMap() {
		return menuActionWithParentMap;
	}

	public void setMenuActionWithParentMap(Map<String, String> menuActionWithParentMap) {
		this.menuActionWithParentMap = menuActionWithParentMap;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public List<MenuBean> getAllMenusList() {
		return allMenusList;
	}

	public void setAllMenusList(List<MenuBean> allMenusList) {
		this.allMenusList = allMenusList;
	}

	public List<MenuBean> getMenusList() {
		return menusList;
	}

	public void setMenusList(List<MenuBean> menusList) {
		this.menusList = menusList;
	}

	public Map<String, List<MenuBean>> getUserMenus() {
		return userMenus;
	}

	public void setUserMenus(Map<String, List<MenuBean>> userMenus) {
		this.userMenus = userMenus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

}
