package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.bean.extend.RoleInfo;
import com.briup.apps.cms.dao.RoleMapper;
import com.briup.apps.cms.dao.extend.RoleExtendMapper;
import com.briup.apps.cms.service.IRoleService;
import com.briup.apps.cms.utils.CustomerException;
@Service
public class RoleServiceImpl implements IRoleService{
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private RoleExtendMapper roleExtendMapper;
	@Override
	public List<Role> findAll() {
		return roleExtendMapper.selectAll();
	}

	@Override
	public void removeById(long id) {
		if(roleMapper.selectByPrimaryKey(id) != null) {
			roleMapper.deleteByPrimaryKey(id);
		}else {
			throw new CustomerException("角色不存在");
		}
		
	}

	@Override
	public void saveOrUpdate(Role role) {
		if(role.getId() != null) {
			if(roleMapper.selectByPrimaryKey(role.getId()) != null) {
				roleMapper.updateByPrimaryKey(role);
			}else {
				roleMapper.insert(role);
			}
			
		}else {
			throw new CustomerException("数据传输有误");
		}
		
	}

	@Override
	public List<RoleExtend> cascadePrivilegeFindAll() {
		return roleExtendMapper.selectCascadePrivilege();
	}

	@Override
	public List<RoleInfo> cascadeFindPrivilege() {
		return roleExtendMapper.cascadePrivilege();
	}

}
