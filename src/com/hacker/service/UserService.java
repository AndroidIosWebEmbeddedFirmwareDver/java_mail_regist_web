package com.hacker.service;

import com.hacker.domain.User;

public interface UserService {

	public void regist(User user) throws Exception;

	public User findUserByCode(String code) throws Exception;

	public void update(User user) throws Exception;
}
