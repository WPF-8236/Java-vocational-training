package com.wpf.jsp.dao;

import com.wpf.jsp.domain.JDBC;
import com.wpf.jsp.domain.Provider;
import com.wpf.jsp.util.PageModel;

import java.util.List;

public interface ProviderDao {
	int insertProvider(JDBC jdbc, Provider provider) throws Exception;

	int deleteProvider(JDBC jdbc, Provider provider) throws Exception;

	int updateProvider(JDBC jdbc, Provider provider) throws Exception;

	Provider selectOneProvider(JDBC jdbc, String p_id) throws Exception;

	List<Provider> selectAllProvider(JDBC jdbc) throws Exception;

	PageModel<Provider> providerPageModel(JDBC jdbc, int pageSize, int currentPage) throws Exception;

}
