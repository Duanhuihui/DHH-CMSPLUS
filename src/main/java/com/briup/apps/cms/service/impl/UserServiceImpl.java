package com.briup.apps.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.UserExample;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.bean.extend.UserModel;
import com.briup.apps.cms.dao.UserMapper;
import com.briup.apps.cms.dao.extend.UserExtendMapper;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserExtendMapper userExtendMapper;
	@Override
	public List<User> findAll() {
		
		return userExtendMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(User user) {
		if(user.getId() != null) {
			
			if(userMapper.selectByPrimaryKey(user.getId()) != null) {
				userMapper.updateByPrimaryKey(user);
			}else {
				throw new CustomerException(user.getId()+" 不存在！！");
			}
		}else {
			user.setRegisterTime(new Date().getTime());
			user.setStatus(UserExtend.NORMAL);
			userMapper.insert(user);
		}
		
		
	}

	@Override
	public String saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void login(UserModel userModel) {
		if(userModel.getUsername() != null) {
			UserExample example = new UserExample();
			example.createCriteria().andUsernameEqualTo(userModel.getUsername());
			List<User> list = userMapper.selectByExample(example);
			if(list != null) {
				for (User user : list) {
					if(user.getPassword() != userModel.getPassword()) {
						throw new   CustomerException("密码错误");
					}
				}
			}else {
				throw new   CustomerException("密码不能为空");
			}
			
		}else {
			throw new   CustomerException("用户名不能为空");
		}
	}

	@Override
	public void add(User user) {
		
		
	}

	@Override
	public void authority(long userId, long roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(long userId) {
		if(userMapper.selectByPrimaryKey(userId) != null) {
			userMapper.deleteByPrimaryKey(userId);
		}else {
			throw new CustomerException("给用户不存在");
		}
		
	}

	

}
