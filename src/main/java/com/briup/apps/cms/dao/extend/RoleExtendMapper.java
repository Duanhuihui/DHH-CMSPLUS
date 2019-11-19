package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.bean.extend.RoleInfo;

public interface RoleExtendMapper {
	
	List<Role> selectAll();

	List<RoleExtend> selectCascadePrivilege();
	
	List<RoleInfo> cascadePrivilege();

}
