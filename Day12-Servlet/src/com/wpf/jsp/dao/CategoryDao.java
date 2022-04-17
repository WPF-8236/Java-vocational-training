package com.wpf.jsp.dao;

import com.wpf.jsp.domain.JDBC;
import com.wpf.jsp.domain.Category;
import com.wpf.jsp.util.PageModel;

import java.util.List;

public interface CategoryDao {
	int insertCategory(JDBC jdbc, Category category) throws Exception;

	int deleteCategory(JDBC jdbc, Category category) throws Exception;

	int updateCategory(JDBC jdbc, Category category) throws Exception;

	Category selectOneCategory(JDBC jdbc, String c_id) throws Exception;

	List<Category> selectAllCategory(JDBC jdbc) throws Exception;

	PageModel<Category> categoryPageModel(JDBC jdbc, int pageSize, int currentPage) throws Exception;
}
