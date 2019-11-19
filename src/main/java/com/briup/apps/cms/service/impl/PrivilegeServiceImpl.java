package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.extend.PrivilegeExtend;
import com.briup.apps.cms.dao.PrivilegeMapper;
import com.briup.apps.cms.dao.extend.PrivilegeExtendMapper;
import com.briup.apps.cms.service.IPrivilegeService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class PrivilegeServiceImpl implements IPrivilegeService{
	@Resource
	private PrivilegeMapper privilegeMapper;
	@Resource
	private PrivilegeExtendMapper privilegeExtendMapper;

	@Override
	public List<Privilege> findAll() {
		List<Privilege>  list =privilegeExtendMapper.selectAll();
		return list;
	}

	@Override
	public List<Privilege> findByParentId(long id) {
		List<Privilege> privilege = privilegeExtendMapper.selectByParentId(id);
		return privilege;
	}

	@Override
	public void saveOrUpdate(Privilege privilege) {
		if(privilege != null) {
			if(privilegeMapper.selectByPrimaryKey(privilege.getId()) != null) {
				privilegeMapper.updateByPrimaryKey(privilege);
			}else {
				privilegeMapper.insert(privilege);
			}
		}else {
			throw new CustomerException("权限不能为空");
		}
		
	}

	@Override
	public List<PrivilegeExtend> findPrivilegeTree() {
		List<PrivilegeExtend> list =  privilegeExtendMapper.selectCascade();
		return list;
	}

}
