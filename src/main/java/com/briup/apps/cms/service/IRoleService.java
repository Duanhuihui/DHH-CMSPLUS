package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.bean.extend.RoleInfo;
import com.briup.apps.cms.utils.CustomerException;

public interface IRoleService {
	List<Role> findAll();
	
	void removeById(long id) throws CustomerException;

	void saveOrUpdate(Role role);
	
	List<RoleExtend> cascadePrivilegeFindAll();
	
	List<RoleInfo> cascadeFindPrivilege();
}
