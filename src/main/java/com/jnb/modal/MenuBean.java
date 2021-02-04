package com.jnb.modal;

public class MenuBean {

	private int pk;
	private String menuName;
	private String menuAction;
	private String isDisplay;
	private String parent;
	private String menuCss;
	
	
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuAction() {
		return menuAction;
	}
	public void setMenuAction(String menuAction) {
		this.menuAction = menuAction;
	}
	public String getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}
	
	@Override
	public int hashCode() {
		return menuAction.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.menuAction.equals(((MenuBean)obj).getMenuAction());
	}
	public String getMenuCss() {
		return menuCss;
	}
	public void setMenuCss(String menuCss) {
		this.menuCss = menuCss;
	}
	
}
