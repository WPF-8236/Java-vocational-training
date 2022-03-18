package com.wpf.collection.controller;

import com.wpf.collection.service.SetService;
import com.wpf.collection.service.impl.SetServiceImpl;

import java.util.HashSet;
import java.util.Set;

public class SetController {
	public static void main(String[] args) {
		Set<Integer> integerSet = new HashSet<>();
		SetService setService = new SetServiceImpl();
		setService.add(integerSet, 123);
		setService.add(integerSet, 123);
		setService.disp(integerSet);
		setService.replace(integerSet,123,12);
		setService.disp(integerSet);



	}
}
