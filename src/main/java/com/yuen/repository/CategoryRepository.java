package com.yuen.repository;

import org.springframework.data.repository.CrudRepository;

import com.yuen.domain.web.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
