package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.extend.PrivilegeExtend;

public interface IPrivilegeService {

	List<Privilege> findAll();

	List<Privilege> findByParentId(long id);

	void saveOrUpdate(Privilege privilege);

	List<PrivilegeExtend> findPrivilegeTree();

}
