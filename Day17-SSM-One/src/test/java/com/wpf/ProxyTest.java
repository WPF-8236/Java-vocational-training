package com.wpf;

import com.wpf.proxy.MyProxy;
import com.wpf.service.UserService;
import com.wpf.service.impl.UserServiceImpl;
import com.wpf.service.impl.UserServiceProxy;
import org.junit.Test;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
	@Test
	public void Test() {
		UserService userService = new UserServiceProxy();
		userService.save("zs");
		userService.update("ls");
	}

	@Test
	public void testProxy() {
		UserService us = new UserServiceImpl();
		InvocationHandler ih = new MyProxy(us);
		//动态代理。是jdk提供的。
		UserService userService = (UserService) Proxy.newProxyInstance(us.getClass().getClassLoader(), us.getClass().getInterfaces(), ih);
		userService.save("zs");
		userService.update("zsf");

	}
}
