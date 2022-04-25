package com.WPF.controller;

import com.WPF.domain.UserGrade;
import com.WPF.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
public class LoginController {
	@Resource
	private LoginService loginService;

	@RequestMapping("/login")
	public String login(HttpServletResponse response, HttpServletRequest request, String id, String password) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserGrade userGrade = loginService.login(id, password);
		PrintWriter printWriter = response.getWriter();
		if (userGrade == null) {
			printWriter.print("\t\t<script>\n" +
					"\t\t\talert(\"" + "用户不存在！！请注册！！" + "\")\n" +
					"\t\t</script>");
			response.setHeader("refresh", "0.1;url=./Resign.jsp");
			printWriter.close();
			return "";
		} else {
			request.getSession().setAttribute("userGrade", userGrade);
		}
		return "index";
	}
}
