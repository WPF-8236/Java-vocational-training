package com.wpf.jdbc.service;

import com.wpf.jdbc.domain.Provider;
import com.wpf.jdbc.domain.User;

import java.util.List;

public interface ProviderService {
	int add(Provider provider);

	int remove(Provider provider);

	int change(Provider provider);

	Provider findOne(String p_id);

	List<Provider> findAll();

	List<Provider> getProvidersLimit(int pageSize, int currentPage);

	List<Provider> getProvidersLimitUpPage();

	List<Provider> getProvidersLimitDownPage();
}
