package com.wpf.jdbc.service.impl;

import com.wpf.jdbc.dao.ProviderDao;
import com.wpf.jdbc.dao.ProviderDaoImpl;
import com.wpf.jdbc.domain.JDBC;
import com.wpf.jdbc.domain.Provider;
import com.wpf.jdbc.service.ProviderService;
import com.wpf.jdbc.util.DButil;
import com.wpf.jdbc.util.PageModel;

import java.util.List;

public class ProviderServiceImpl implements ProviderService {
	private PageModel<Provider> providerPageModel;
	private final JDBC jdbc = new JDBC();
	private final ProviderDao providerDao = new ProviderDaoImpl();
	private int num;
	private Provider provider;
	private List<Provider> providers;

	@Override
	public int add(Provider provider) {
		num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = providerDao.insertProvider(jdbc, provider);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public int remove(Provider provider) {
		num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = providerDao.deleteProvider(jdbc, provider);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public int change(Provider provider) {
		num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = providerDao.updateProvider(jdbc, provider);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public Provider findOne(String p_id) {
		provider = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			provider = providerDao.selectOneProvider(jdbc, p_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return provider;
	}

	@Override
	public List<Provider> findAll() {
		providers = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			providers = providerDao.selectAllProvider(jdbc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return providers;
	}

	@Override
	public List<Provider> getProvidersLimit(int pageSize, int currentPage) {
		providers = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			providerPageModel = providerDao.providerPageModel(jdbc, pageSize, currentPage);
			providers = providerPageModel.getList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return providers;
	}

	@Override
	public List<Provider> getProvidersLimitUpPage() {
		providers = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			providerPageModel = providerDao.providerPageModel(jdbc, providerPageModel.getPageSize(), providerPageModel.getPageUp());
			providers = providerPageModel.getList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return providers;
	}

	@Override
	public List<Provider> getProvidersLimitDownPage() {
		providers = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			providerPageModel = providerDao.providerPageModel(jdbc, providerPageModel.getPageSize(), providerPageModel.getPageDown());
			providers = providerPageModel.getList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return providers;
	}
}
