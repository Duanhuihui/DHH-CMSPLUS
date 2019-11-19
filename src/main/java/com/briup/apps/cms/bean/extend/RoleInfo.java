package com.briup.apps.cms.bean.extend;

import java.util.List;

import com.briup.apps.cms.bean.Privilege;

public class RoleInfo {
	private long id;
	private String name;
	private List<Privilege> privileges;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	
}
