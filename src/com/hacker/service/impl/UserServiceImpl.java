package com.hacker.service.impl;

import com.hacker.dao.UserDao;
import com.hacker.dao.impl.UserDaoImpl;
import com.hacker.domain.User;
import com.hacker.service.UserService;
import com.hacker.utils.MailUtils;

public class UserServiceImpl implements UserService {

	// 业务层 用户注册的方法
	@Override
	public void regist(User user) throws Exception {
		// TODO Auto-generated method stub
		// 将数据存入数据库，
		UserDao userDao = new UserDaoImpl();
		userDao.regist(user);
		// 同时发送一份激活邮件
		MailUtils.sendMail(user.getEmail(), user.getCode(), "来自XXXX的邮件");
	}

	// 业务层 根据激活码查询用户的方法
	@Override
	public User findUserByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		// 查询数据库，
		UserDao userDao = new UserDaoImpl();
		return userDao.findUserByCode(code);
	}

	// 业务层 修改用户的方法
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub

		UserDao userDao = new UserDaoImpl();
		userDao.update(user);
	}

}
