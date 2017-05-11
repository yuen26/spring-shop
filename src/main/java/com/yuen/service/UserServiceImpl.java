package com.yuen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuen.domain.web.User;
import com.yuen.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public User findOne(Integer id) {
		return userRepository.findOne(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public long countAll() {
		return userRepository.count();
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		userRepository.delete(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public com.yuen.domain.api.User checkLogin(com.yuen.domain.api.User user) {
		com.yuen.domain.api.User ret = null;
		
		User dbUser = userRepository.findByEmail(user.getEmail());
		
		if (dbUser != null 
				&& passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
			ret = new com.yuen.domain.api.User();
			ret.setId(dbUser.getId());
			ret.setName(dbUser.getName());
			ret.setEmail(dbUser.getEmail());
		}
		
		return ret;
	}
	
	@Override
	@Transactional
	public boolean register(User user) {
		// Check email exists
		if (userRepository.findByEmail(user.getEmail()) != null) {
			return false; 
		} 
		
		userRepository.save(user);
		
		return true;
	}

}