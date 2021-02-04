package com.jnb.modal;

public class SettingBean {

	private boolean regisEnabDis;
	private String appVersion;
	private boolean gmailFbLogin;
	private boolean isLogout;

	public boolean isRegisEnabDis() {
		return regisEnabDis;
	}

	public void setRegisEnabDis(boolean regisEnabDis) {
		this.regisEnabDis = regisEnabDis;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public boolean isGmailFbLogin() {
		return gmailFbLogin;
	}

	public void setGmailFbLogin(boolean gmailFbLogin) {
		this.gmailFbLogin = gmailFbLogin;
	}

	public boolean isLogout() {
		return isLogout;
	}

	public void setLogout(boolean isLogout) {
		this.isLogout = isLogout;
	}

}
