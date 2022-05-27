package com.wpf.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler {
	private Object object;

	public MyProxy(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("您好啊----" + method.getName());
		//调用代理对象的方法
		Object result = method.invoke(object, args);
		System.out.println("再见！");
		return result;
	}
}
