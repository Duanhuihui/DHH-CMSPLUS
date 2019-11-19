package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Role;

public class RoleExtend extends Role{
	private RolePrivilegeExtend rolePrivilegeExtend;

	public RolePrivilegeExtend getRolePrivilegeExtend() {
		return rolePrivilegeExtend;
	}

	public void setRolePrivilegeExtend(RolePrivilegeExtend rolePrivilegeExtend) {
		this.rolePrivilegeExtend = rolePrivilegeExtend;
	}

}
