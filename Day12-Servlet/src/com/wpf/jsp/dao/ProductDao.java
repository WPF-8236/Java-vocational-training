package com.wpf.jsp.dao;

import com.wpf.jsp.domain.JDBC;
import com.wpf.jsp.domain.Product;
import com.wpf.jsp.util.PageModel;

import java.util.List;

public interface ProductDao {
	int insertProduct(JDBC jdbc, Product product) throws Exception;

	int deleteProduct(JDBC jdbc, Product product) throws Exception;

	int updateProduct(JDBC jdbc, Product product) throws Exception;

	Product selectOneProduct(JDBC jdbc, String pt_id) throws Exception;

	List<Product> selectAllProduct(JDBC jdbc) throws Exception;

	PageModel<Product> ProductPageModel(JDBC jdbc, int pageSize, int currentPage) throws Exception;
}
