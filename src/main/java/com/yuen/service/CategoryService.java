package com.yuen.service;

import com.yuen.domain.web.Category;

public interface CategoryService {

	Iterable<Category> findAll();
	
	Category findOne(Integer id);
	
	long countAll();

	Category save(Category category);
	
	void delete(Integer id);
	
}
