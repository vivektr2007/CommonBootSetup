package com.jnb.modal;

import java.util.ArrayList;
import java.util.List;

public class GroupBean {

	private Integer pk;
	private String groupName;
	private String groupDesc;
	private int rolePk;

	private List<Integer> userPks = new ArrayList<>();

	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public int getRolePk() {
		return rolePk;
	}

	public void setRolePk(int rolePk) {
		this.rolePk = rolePk;
	}

	public List<Integer> getUserPks() {
		return userPks;
	}

	public void setUserPks(List<Integer> userPks) {
		this.userPks = userPks;
	}

}
