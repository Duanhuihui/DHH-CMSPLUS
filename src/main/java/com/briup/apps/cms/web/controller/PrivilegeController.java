package com.briup.apps.cms.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.extend.PrivilegeExtend;
import com.briup.apps.cms.service.IPrivilegeService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
	@Resource
	private IPrivilegeService privilegeService;
	
	@GetMapping("findAll")
	public Message findAll() {
		List<Privilege> list = privilegeService.findAll();
		return MessageUtil.success("查询成功",list );
	}
	@GetMapping("findByParentId")
	public Message findByParentId(long id) {
		List<Privilege> list = privilegeService.findByParentId(id);
		return MessageUtil.success("查询成功",list );
	}
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdate( Privilege privilege) {
		privilegeService.saveOrUpdate(privilege);
		return MessageUtil.success("查询成功");
	}
	@GetMapping("findPrivilegeTree")
	public Message findPrivilegeTree() {
	 List<PrivilegeExtend> list = privilegeService.findPrivilegeTree();
		return MessageUtil.success("查询成功",list);
	}

}
