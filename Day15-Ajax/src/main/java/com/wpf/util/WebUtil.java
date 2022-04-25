package com.wpf.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	//添加cookie  buycard
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		//buycart
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if (maxAge > 0) {
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
	}

	// name就是 buycart，想一个，这个方法返回的是什么？是不是你想要的。
	public static String getCookieValueByName(HttpServletRequest request, String name) {
		//获取硬盘上所有的cookie
		Cookie[] cookies = request.getCookies();
		String value = null;    //这个value到底是什么？
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (name.equals(cookies[i].getName())) {
					value = cookies[i].getValue();
					break;
				}
			}
		}
		return value;
	}

}
