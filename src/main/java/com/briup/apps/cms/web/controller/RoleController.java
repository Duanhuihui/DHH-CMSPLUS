package com.briup.apps.cms.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.bean.extend.RoleInfo;
import com.briup.apps.cms.service.IRoleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Resource
	private IRoleService roleService;
	
	@GetMapping("findAll")
	public Message findAll() {
		List<Role> list = roleService.findAll();
		return MessageUtil.success("查询成功",list);
	}
	@GetMapping("removeById") 
	public Message removeById(long id) {
		roleService.removeById(id);
		return MessageUtil.success("移出成功");
	}
	@PostMapping("saveOrUpdate") 
	public Message saveOrUpdate(Role role) {
		roleService.saveOrUpdate(role);
		return MessageUtil.success("操作成功");
	}
	@ApiOperation("该接口有bug")
	@GetMapping("cascadePrivilegeFindAll") 
	public Message cascadePrivilegeFindAll() {
		List<RoleExtend> list = roleService.cascadePrivilegeFindAll();
		return MessageUtil.success("操作成功",list);
	}
	@GetMapping("cascadeFindPrivilege") 
	public Message cascadeFindPrivilege() {
		 List<RoleInfo> list = roleService.cascadeFindPrivilege();
		return MessageUtil.success("操作成功",list);
	}
}
