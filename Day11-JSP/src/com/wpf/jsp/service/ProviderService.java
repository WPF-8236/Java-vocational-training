package com.wpf.jsp.service;

import com.wpf.jsp.domain.Provider;

import java.util.List;

public interface ProviderService {
	int add(Provider provider);

	int remove(Provider provider);

	int change(Provider provider);

	Provider findOne(String p_id);

	List<Provider> findAll();

	List<Provider> getProvidersLimit(int pageSize, int currentPage);

	List<Provider> getProvidersLimitUpPage();
	List<Provider> getProvidersLimitFirst();
	List<Provider> getProvidersLimitEnd();

	List<Provider> getProvidersLimitDownPage();
}
