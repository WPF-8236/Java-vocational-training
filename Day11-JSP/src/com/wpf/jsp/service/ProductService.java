package com.wpf.jsp.service;

import com.wpf.jsp.domain.Product;

import java.util.List;

public interface ProductService {
	int add(Product product);

	int remove(Product product);

	int change(Product product);

	Product findOne(String pt_id);

	List<Product> findAll();

	List<Product> getProductsLimit(int pageSize, int currentPage);

	List<Product> getProductsLimitUpPage();

	List<Product> getProductsLimitDownPage();
}
