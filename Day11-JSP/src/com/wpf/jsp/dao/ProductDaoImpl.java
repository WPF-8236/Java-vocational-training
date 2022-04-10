package com.wpf.jsp.dao;

import com.wpf.jsp.domain.Product;
import com.wpf.jsp.domain.JDBC;
import com.wpf.jsp.util.PageModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDao implements ProductDao {
	@Override
	public int insertProduct(JDBC jdbc, Product product) throws Exception {
		String sql = "insert into product(pt_id,pt_name,pt_price,pt_c_id,pt_p_id) values (?,?,?,?,?)";
		Object[] params = {product.getPt_id(), product.getPt_name(), product.getPt_price(), product.getPt_c_id(), product.getPt_p_id()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public int deleteProduct(JDBC jdbc, Product product) throws Exception {
		String sql = "delete from product where pt_id = ?";
		Object[] params = {product.getPt_id()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public int updateProduct(JDBC jdbc, Product product) throws Exception {
		String sql = "update product set pt_name = ?,pt_price = ?,pt_c_id = ?,pt_p_id = ? where pt_id = ?";
		Object[] params = {product.getPt_name(), product.getPt_price(), product.getPt_c_id(), product.getPt_p_id(), product.getPt_id()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public Product selectOneProduct(JDBC jdbc, String pt_id) throws Exception {
		Product product = null;
		String sql = "select * from product where pt_id = ?";
		Object[] params = {pt_id};
		ResultSet resultSet = this.exeQuery(jdbc, sql, params);
		if (resultSet.next())
			product = new Product(resultSet.getString("pt_id"),
					resultSet.getString("pt_name"), resultSet.getDouble("pt_price"), resultSet.getString("pt_c_id"), resultSet.getString("pt_p_id"));
		return product;
	}

	@Override
	public List<Product> selectAllProduct(JDBC jdbc) throws Exception {
		List<Product> products = new ArrayList<>();
		String sql = "select * from product";
		ResultSet resultSet = this.exeQuery(jdbc, sql, null);
		while (resultSet.next())
			products.add(new Product(resultSet.getString("pt_id"),
					resultSet.getString("pt_name"), resultSet.getDouble("pt_price"), resultSet.getString("pt_c_id"), resultSet.getString("pt_p_id")));
		return products;
	}

	@Override
	public PageModel<Product> ProductPageModel(JDBC jdbc, int pageSize, int currentPage) throws Exception {
		String sql = "select * from product limit ?,?";
		Object[] params = {(currentPage - 1) * pageSize, pageSize};
		ResultSet resultSet = this.exeQuery(jdbc, sql, params);
		PageModel<Product> productPageModel = new PageModel<>();
		List<Product> products = new ArrayList<>();
		while (resultSet.next())
			products.add(new Product(resultSet.getString("pt_id"), resultSet.getString("pt_name"), resultSet.getDouble("pt_price"), resultSet.getString("pt_c_id"), resultSet.getString("pt_p_id")));
		productPageModel.setList(products);
		productPageModel.setCurrentPage(currentPage);
		productPageModel.setPageSize(pageSize);
		String table = "select count(*) from product";
		productPageModel.setTotalRecord(this.getTotalDate(jdbc, table, null));
		return productPageModel;
	}
}
