package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.extend.PrivilegeExtend;

public interface PrivilegeExtendMapper {

	List<Privilege> selectAll();

	List<Privilege> selectByParentId(long id);

	List<PrivilegeExtend> selectCascade();
	
	
}
