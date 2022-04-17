package com.wpf.jsp.service.impl;

import com.wpf.jsp.dao.ProductDao;
import com.wpf.jsp.dao.ProductDaoImpl;
import com.wpf.jsp.domain.JDBC;
import com.wpf.jsp.domain.Product;
import com.wpf.jsp.service.ProductService;
import com.wpf.jsp.util.DButil;
import com.wpf.jsp.util.PageModel;

import java.util.List;

public class ProductServiceImpl implements ProductService {
	private PageModel<Product> productPageModel;
	private final JDBC jdbc = new JDBC();
	private final ProductDao productDao = new ProductDaoImpl();
	private int num;
	private Product product;
	private List<Product> products;
	private static ProductServiceImpl productService;

	private ProductServiceImpl() {

	}

	private static class Inner {
		static final ProductServiceImpl productService = new ProductServiceImpl();
	}

	public static ProductServiceImpl getProductService() {
		return Inner.productService;
	}


	@Override
	public int add(Product product) {
		num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = productDao.insertProduct(jdbc, product);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public int remove(Product product) {
		num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = productDao.deleteProduct(jdbc, product);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public int change(Product product) {
		num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = productDao.updateProduct(jdbc, product);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public Product findOne(String pt_id) {
		product = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			product = productDao.selectOneProduct(jdbc, pt_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return product;
	}

	@Override
	public List<Product> findAll() {
		products = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			products = productDao.selectAllProduct(jdbc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return products;
	}

	@Override
	public List<Product> getProductsLimit(int pageSize, int currentPage) {
		products = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			productPageModel = productDao.ProductPageModel(jdbc, pageSize, currentPage);
			products = productPageModel.getList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return products;
	}

	@Override
	public List<Product> getProductsLimitUpPage() {
		products = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			productPageModel = productDao.ProductPageModel(jdbc, productPageModel.getPageSize(), productPageModel.getPageUp());
			products = productPageModel.getList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return products;
	}

	@Override
	public List<Product> getProductsLimitFirst() {
		return this.getProductsLimit(productPageModel.getPageSize(), 1);
	}

	@Override
	public List<Product> getProductsLimitEnd() {
		return this.getProductsLimit(productPageModel.getPageSize(), productPageModel.getTotalPage());
	}

	@Override
	public List<Product> getProductsLimitDownPage() {
		products = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			productPageModel = productDao.ProductPageModel(jdbc, productPageModel.getPageSize(), productPageModel.getPageDown());
			products = productPageModel.getList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return products;
	}
}
