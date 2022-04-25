package com.WPF.handler;

import com.WPF.domain.UserBasic;
import com.WPF.domain.UserGrade;
import com.WPF.service.LoginService;
import com.WPF.service.UserService;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {
	@Resource
	private UserService userService;
	@Resource
	private LoginService loginService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		String user_id = request.getParameter("id");
		String password = request.getParameter("password");
		UserGrade userGrade = loginService.login(user_id, password);
		UserBasic userBasic = userService.getUserBasicByUId(user_id);
		HttpSession session = request.getSession();
		session.setAttribute("userBasic", userBasic);
		if (userBasic == null && userGrade != null) {
			printWriter.print("\t\t<script>\n" +
					"\t\t\talert(\"" + "信息不完全请完善信息！！" + "\")\n" +
					"\t\t</script>");
			response.setHeader("refresh", "0.1;url=./UserCenter.jsp");
			printWriter.close();
			return true;
		} else
			return true;
	}
}
