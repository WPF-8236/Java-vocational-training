package com.wpf.jsp.test;

import com.wpf.jsp.service.ProviderService;
import com.wpf.jsp.service.impl.ProviderServiceImpl;

public class Test02 {
	public static void main(String[] args) {
		ProviderService providerService = new ProviderServiceImpl();
//		providerService.add(new Provider("202201", "王潘锋", "123456789", "123456789@qq.com", "天眼"));
//		providerService.add(new Provider("202202", "陆家豪", "123456789", "123456789@qq.com", "天眼"));
//		providerService.add(new Provider("202203", "张深", "123456789", "123456789@qq.com", "天眼"));
//		providerService.add(new Provider("202204", "陈成东", "123456789", "123456789@qq.com", "天眼"));
//		providerService.add(new Provider("202205", "包一番", "123456789", "123456789@qq.com", "天眼"));
//		providerService.add(new Provider("202206", "胡闻涛", "123456789", "123456789@qq.com", "天眼"));
//		providerService.add(new Provider("202207", "黄鹤楼", "123456789", "123456789@qq.com", "天眼"));
//		providerService.add(new Provider("202208", "张豪", "123456789", "123456789@qq.com", "天眼"));
//		providerService.add(new Provider("202209", "罗贤妃", "123456789", "123456789@qq.com", "天眼"));
//		providerService.add(new Provider("202210", "郑汉森", "123456789", "123456789@qq.com", "天眼"));
//		providerService.add(new Provider("202211", "张闻天", "123456789", "123456789@qq.com", "天眼"));
//		providerService.add(new Provider("202212", "沈浩", "123456789", "123456789@qq.com", "天眼"));
//		System.out.println(providerService.findOne("1"));
//		System.out.println(providerService.findAll());
		System.out.println(providerService.getProvidersLimit(5, 1));
//		System.out.println(providerService.getProvidersLimitUpPage());
		System.out.println(providerService.getProvidersLimitDownPage());
		System.out.println(providerService.getProvidersLimitDownPage());
	}
}
