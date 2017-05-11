package com.yuen.service;

import java.util.List;

import com.yuen.domain.web.User;

public interface UserService {

	List<User> findAll();
	
	User findOne(Integer id);
	
	long countAll();
	
	void delete(Integer id);
	
	com.yuen.domain.api.User checkLogin(com.yuen.domain.api.User user);
	
	boolean register(User user);
	
}
