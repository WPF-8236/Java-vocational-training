package com.wpf.collection.controller;

import com.wpf.collection.service.ListService;
import com.wpf.collection.service.impl.ListServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListController {
	public static void main(String[] args) {
		/*//增加
		List<Integer> list = new LinkedList<>();
		list.add(14);
		list.add(24);
		list.add(34);
		list.add(44);
		list.add(54);
//		list.add("1213");
//		list.add(12f);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("==============");
		int i = 0;
		while (i < list.size()) {
			System.out.println(list.get(i));
			i++;
		}
		System.out.println("===============");
		i = 0;
		do {
			System.out.println(list.get(i));
			i++;
		} while (i < list.size());

		System.out.println("==============");
		//利用迭代器显示list
		//首先需要一个有迭代器,迭代器总是与while循环连在一起的
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext())
//			System.out.println(iterator);
			System.out.println(iterator.next());

		System.out.println("===============");
		for (Integer integer : list) {
			System.out.println(integer);
		}

		//删
		System.out.println("==============");
		list.remove(3);

		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("删除所有");
		list.clear();
		if (list.size() == 0)
			System.out.println("删除所有");

		//改
		list.add(14);
		list.add(24);
		list.add(34);
		list.add(44);
		list.add(54);
		System.out.println("修改模式");
		list.set(2, 124);
		System.out.println(list.get(2));

		//查
		System.out.println("查找24");
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j) == 24) {
				System.out.println(j);
				break;
			}
		}
		System.out.println("查找模式");
		System.out.println(list.indexOf(24));*/

		List<Integer> list = new ArrayList<>();
		ListService listService = new ListServiceImpl();
		listService.add(list, 10);
		listService.add(list, 11);
		listService.add(list, 12);
		listService.add(list, 13);
		listService.add(list, 14);

		listService.disp(list);
		/*for (Integer integer : list) {
			System.out.println(integer);
		}*/

		List<String> stringList = new ArrayList<>();
		listService.add(stringList, "王五");
		listService.add(stringList, "王五");
		listService.add(stringList, "王五");
		listService.add(stringList, "李四");
		listService.add(stringList, "张三");

		listService.disp(stringList);

		System.out.println("========删除========");
		listService.del(stringList,"王五");

		listService.disp(stringList);
		/*for (String s : stringList) {
			System.out.println(s);
		}
*/
	}
}
