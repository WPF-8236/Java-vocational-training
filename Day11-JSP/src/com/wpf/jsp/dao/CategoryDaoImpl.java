package com.wpf.jsp.dao;

import com.wpf.jsp.domain.Category;
import com.wpf.jsp.domain.JDBC;
import com.wpf.jsp.util.PageModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {
	@Override
	public int insertCategory(JDBC jdbc, Category category) throws Exception {
		String sql = "insert into category(c_id,c_name) values (?,?)";
		Object[] params = {category.getC_id(), category.getC_name()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public int deleteCategory(JDBC jdbc, Category category) throws Exception {
		String sql = "delete from category where c_id = ?";
		Object[] params = {category.getC_id()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public int updateCategory(JDBC jdbc, Category category) throws Exception {
		String sql = "update category set c_name = ? where c_id = ?";
		Object[] params = {category.getC_name(), category.getC_id()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public Category selectOneCategory(JDBC jdbc, String c_id) throws Exception {
		Category category = null;
		String sql = "select * from category where c_id = ?";
		Object[] params = {c_id};
		ResultSet resultSet = this.exeQuery(jdbc, sql, params);
		if (resultSet.next())
			category = new Category(resultSet.getString("c_id"),
					resultSet.getString("c_name"));
		return category;
	}

	@Override
	public List<Category> selectAllCategory(JDBC jdbc) throws Exception {
		List<Category> categories = new ArrayList<>();
		String sql = "select * from provider";
		ResultSet resultSet = this.exeQuery(jdbc, sql, null);
		while (resultSet.next())
			categories.add(new Category(resultSet.getString("c_id"),
					resultSet.getString("c_name")));
		return categories;
	}

	@Override
	public PageModel<Category> categoryPageModel(JDBC jdbc, int pageSize, int currentPage) throws Exception {
		String sql = "select * from category limit ?,?";
		Object[] params = {(currentPage - 1) * pageSize, pageSize};
		ResultSet resultSet = this.exeQuery(jdbc, sql, params);
		PageModel<Category> categoryPageModel = new PageModel<>();
		List<Category> categories = new ArrayList<>();
		while (resultSet.next())
			categories.add(new Category(resultSet.getString("c_id"),
					resultSet.getString("c_name")));
		categoryPageModel.setList(categories);
		categoryPageModel.setCurrentPage(currentPage);
		categoryPageModel.setPageSize(pageSize);
		String table = "select count(*) from category";
		categoryPageModel.setTotalRecord(this.getTotalDate(jdbc, table, null));
		return categoryPageModel;
	}
}
