package com.wpf.jsp.dao;

import com.wpf.jsp.domain.JDBC;
import com.wpf.jsp.domain.Provider;
import com.wpf.jsp.util.PageModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProviderDaoImpl extends BaseDao implements ProviderDao {
	@Override
	public int insertProvider(JDBC jdbc, Provider provider) throws Exception {
		String sql = "insert into provider(p_id,p_name,p_tele,p_email,p_address) values (?,?,?,?,?)";
		Object[] params = {provider.getP_id(), provider.getP_name(), provider.getP_tele(), provider.getP_email(), provider.getP_address()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public int deleteProvider(JDBC jdbc, Provider provider) throws Exception {
		String sql = "delete from provider where p_id = ?";
		Object[] params = {provider.getP_id()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public int updateProvider(JDBC jdbc, Provider provider) throws Exception {
		String sql = "update provider set p_name = ?,p_tele = ?,p_email = ?,p_address =? where p_id = ?";
		Object[] params = {provider.getP_name(), provider.getP_tele(), provider.getP_email(), provider.getP_address(), provider.getP_id()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public Provider selectOneProvider(JDBC jdbc, String p_id) throws Exception {
		Provider provider = null;
		String sql = "select * from provider where p_id = ?";
		Object[] params = {p_id};
		ResultSet resultSet = this.exeQuery(jdbc, sql, params);
		if (resultSet.next())
			provider = new Provider(resultSet.getString("p_id"),
					resultSet.getString("p_name"),
					resultSet.getString("p_tele"),
					resultSet.getString("p_email"),
					resultSet.getString("p_address"));
		return provider;
	}

	@Override
	public List<Provider> selectAllProvider(JDBC jdbc) throws Exception {
		List<Provider> providers = new ArrayList<>();
		String sql = "select * from provider";
		ResultSet resultSet = this.exeQuery(jdbc, sql, null);
		while (resultSet.next())
			providers.add(new Provider(resultSet.getString("p_id"),
					resultSet.getString("p_name"),
					resultSet.getString("p_tele"),
					resultSet.getString("p_email"),
					resultSet.getString("p_address")));
		return providers;
	}

	@Override
	public PageModel<Provider> providerPageModel(JDBC jdbc, int pageSize, int currentPage) throws Exception {
		String sql = "select * from provider limit ?,?";
		Object[] params = {(currentPage - 1) * pageSize, pageSize};
		ResultSet resultSet = this.exeQuery(jdbc, sql, params);
		PageModel<Provider> providerPageModel = new PageModel<>();
		List<Provider> providers = new ArrayList<>();
		while (resultSet.next())
			providers.add(new Provider(resultSet.getString("p_id"),
					resultSet.getString("p_name"),
					resultSet.getString("p_tele"),
					resultSet.getString("p_email"),
					resultSet.getString("p_address")));
		providerPageModel.setList(providers);
		providerPageModel.setCurrentPage(currentPage);
		providerPageModel.setPageSize(pageSize);
		String table = "select count(*) from provider";
		providerPageModel.setTotalRecord(this.getTotalDate(jdbc, table, null));
		return providerPageModel;
	}
}
