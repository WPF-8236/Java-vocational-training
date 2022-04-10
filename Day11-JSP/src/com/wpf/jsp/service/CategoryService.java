package com.wpf.jsp.service;

import com.wpf.jsp.domain.Category;

import java.util.List;

public interface CategoryService {
	int add(Category category);

	int remove(Category category);

	int change(Category category);

	Category findOne(String c_id);

	List<Category> findAll();

	List<Category> getCategoriesLimit(int pageSize, int currentPage);

	List<Category> getCategoriesLimitUpPage();

	List<Category> getCategoriesLimitDownPage();
}
