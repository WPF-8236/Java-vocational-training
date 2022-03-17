package com.wpf.collection.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListController {
	public static void main(String[] args) {
		//增加
		List<Integer> list = new LinkedList<>();
		list.add(123);
		list.add(24);
//		list.add("1213");
//		list.add(12f);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
