package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserModel;
import com.briup.apps.cms.utils.CustomerException;

public interface IUserService {

	List<User> findAll();
	
	void saveOrUpdate(User user) throws CustomerException;

	String saveUser(User user);

	void login(UserModel userModel);
	
	//添加角色
	void add(User user);
	
	//授权角色,不用查看当前用户的权利，在登录的时候控制当前用户是否有权限控制权利
	void authority(long userId,long roleId);
	
	void remove(long userId);

	
	
}
