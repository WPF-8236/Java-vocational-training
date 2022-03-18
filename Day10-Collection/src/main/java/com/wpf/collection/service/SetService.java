package com.wpf.collection.service;

import java.util.Set;

public interface SetService {
	//增
	void add(Set set, Object o);

	//删
	void del(Set set,Object o);

	//改
	void replace(Set set,Object oldObj,Object newObj);

	//查
	Object get(Set set,Object o);
	//显示
	void disp(Set set);

}
