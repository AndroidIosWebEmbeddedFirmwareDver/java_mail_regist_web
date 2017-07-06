package com.hacker.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hacker.dao.UserDao;
import com.hacker.domain.User;
import com.hacker.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	// DAO 保存用户的方法
	public void regist(User user) throws Exception {
		// TODO Auto-generated method stub

		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into user values (?,?,?,?,?,?,?)";
		Object[] param = { user.getUid(), user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(),
				user.getState(), user.getCode() };
		queryRunner.update(sql, param);

	}

	@Override
	// DAO中 根据激活码查询用户的方法
	public User findUserByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where code= ?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class), code);
		return user;
	}

	@Override
	// DAO中 修改用户的方法
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update  user  set username=?,password=?,nickname=?,email=?,state=?,code=? where uid=?";
		Object[] param = { user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(), user.getState(),
				user.getCode(), user.getUid() };
		queryRunner.update(sql, param);
	}

}
