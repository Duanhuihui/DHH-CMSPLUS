package com.briup.apps.cms.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserModel;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService iUserService;
	
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdate(
			String username,
			String password,
			String telephone,
			String realName, 
			String gender,
			long birth,
			String userFace) {
		User cUser = new User();
		cUser.setUsername(username);
		cUser.setPassword(password);
		cUser.setTelephone(telephone);
		cUser.setRealname(realName);
		cUser.setGender(gender);
		cUser.setBirth(birth);
		cUser.setUserFace(userFace);
		iUserService.saveOrUpdate(cUser);
		return MessageUtil.success("操作成功", cUser);
	}
	@GetMapping("findAll")
	public Message findAll() {
		List<User> list = iUserService.findAll();
		return MessageUtil.success(list);
	}
	@PostMapping("login")
	public Message login(@RequestBody UserModel userModel) {
		iUserService.login(userModel);
		return MessageUtil.success("登录成功");
	}


}
