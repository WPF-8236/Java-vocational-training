package com.wpf.jsp.service.impl;

import com.wpf.jsp.dao.CategoryDao;
import com.wpf.jsp.dao.CategoryDaoImpl;
import com.wpf.jsp.dao.ProviderDao;
import com.wpf.jsp.dao.ProviderDaoImpl;
import com.wpf.jsp.domain.Category;
import com.wpf.jsp.domain.JDBC;
import com.wpf.jsp.domain.Provider;
import com.wpf.jsp.service.CategoryService;
import com.wpf.jsp.util.DButil;
import com.wpf.jsp.util.PageModel;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
	private PageModel<Category> categoryPageModel;
	private final JDBC jdbc = new JDBC();
	private final CategoryDao categoryDao = new CategoryDaoImpl();
	private int num;
	private Category category;
	private List<Category> categories;

	@Override
	public int add(Category category) {
		num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = categoryDao.insertCategory(jdbc, category);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public int remove(Category category) {
		num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = categoryDao.deleteCategory(jdbc, category);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public int change(Category category) {
		num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = categoryDao.updateCategory(jdbc, category);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public Category findOne(String c_id) {
		category = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			category = categoryDao.selectOneCategory(jdbc, c_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return category;
	}

	@Override
	public List<Category> findAll() {
		categories = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			categories = categoryDao.selectAllCategory(jdbc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return categories;
	}

	@Override
	public List<Category> getCategoriesLimit(int pageSize, int currentPage) {
		categories = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			categoryPageModel = categoryDao.categoryPageModel(jdbc, pageSize, currentPage);
			categories = categoryPageModel.getList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return categories;
	}

	@Override
	public List<Category> getCategoriesLimitUpPage() {
		categories = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			categoryPageModel = categoryDao.categoryPageModel(jdbc, categoryPageModel.getPageSize(), categoryPageModel.getPageUp());
			categories = categoryPageModel.getList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return categories;
	}

	@Override
	public List<Category> getCategoriesLimitDownPage() {
		categories = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			categoryPageModel = categoryDao.categoryPageModel(jdbc, categoryPageModel.getPageSize(), categoryPageModel.getPageDown());
			categories = categoryPageModel.getList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return categories;
	}
}
