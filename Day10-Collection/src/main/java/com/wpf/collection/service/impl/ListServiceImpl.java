package com.wpf.collection.service.impl;

import com.wpf.collection.service.ListService;

import java.util.List;

public class ListServiceImpl implements ListService {
	@Override
	public void add(List list, Object o) {
		list.add(o);
	}

	@Override
	public void del(List list, Object o) {
		while (true) {
			if (!list.remove(o))
				break;
		}
	}

	@Override
	public void disp(List list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}
}
