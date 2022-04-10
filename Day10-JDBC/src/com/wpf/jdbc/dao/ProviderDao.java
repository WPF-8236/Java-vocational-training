package com.wpf.jdbc.dao;

import com.wpf.jdbc.domain.JDBC;
import com.wpf.jdbc.domain.Provider;
import com.wpf.jdbc.domain.User;
import com.wpf.jdbc.util.PageModel;

import java.util.List;

public interface ProviderDao {
	int insertProvider(JDBC jdbc, Provider provider) throws Exception;

	int deleteProvider(JDBC jdbc, Provider provider) throws Exception;

	int updateProvider(JDBC jdbc, Provider provider) throws Exception;

	Provider selectOneProvider(JDBC jdbc, String p_id) throws Exception;

	List<Provider> selectAllProvider(JDBC jdbc) throws Exception;

	PageModel<Provider> providerPageModel(JDBC jdbc, int pageSize, int currentPage) throws Exception;

}
