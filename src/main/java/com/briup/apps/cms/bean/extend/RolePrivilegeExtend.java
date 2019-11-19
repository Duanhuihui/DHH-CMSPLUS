package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.RolePrivilege;

public class RolePrivilegeExtend extends RolePrivilege{
	private Privilege privilege;

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	

}
