package com.wpf.collection.service.impl;

import com.wpf.collection.service.SetService;

import java.util.Iterator;
import java.util.Set;

public class SetServiceImpl implements SetService {
	//增
	@Override
	public void add(Set set, Object o) {
		set.add(o);
	}

	//删
	@Override
	public void del(Set set, Object o) {
		set.remove(o);
	}

	//改
	@Override
	public void replace(Set set, Object oldObj, Object newObj) {
		if (set.remove(oldObj))
			set.add(newObj);
	}

	//查
	@Override
	public Object get(Set set, Object o) {
		Iterator iterator = set.iterator();
		while (iterator.hasNext()){
			Object next = iterator.next();
			if (next.equals(o))
				return next;
		}
		return null;
	}

	//显示
	@Override
	public void disp(Set set) {
		for (Object o : set) {
			System.out.println(o);
		}
	}
}
