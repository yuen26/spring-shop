package com.yuen.repository;

import org.springframework.data.repository.CrudRepository;

import com.yuen.domain.web.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	
	Role findByName(String name);

}
