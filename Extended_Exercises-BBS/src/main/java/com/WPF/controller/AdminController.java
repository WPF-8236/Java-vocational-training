package com.WPF.controller;

import com.WPF.domain.Plate;
import com.WPF.domain.UserList;
import com.WPF.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private AdminService adminService;

	private String json;
	private final ObjectMapper objectMapper = new ObjectMapper();
	private PrintWriter printWriter;

	@RequestMapping("/getUserList")
	@ResponseBody
	public List<UserList> getUserList(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		return adminService.getUserList();
	}

	@RequestMapping("/getPlateList")
	@ResponseBody
	public List<Plate> getPlateList(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		return adminService.getPlateList();
	}

	@RequestMapping("/getModerator")
	@ResponseBody
	public List<UserList> getModerator(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		return adminService.getModerator();
	}

	@RequestMapping("/changeUGrade")
	public void changeUGrade(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		String u_id = request.getParameter("u_id");
		String tag = request.getParameter("tag");
		if (adminService.changeUGrade(objectMapper.readValue(u_id, String.class), objectMapper.readValue(tag, String.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/changeUStatus")
	public void changeUStatus(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		String u_id = request.getParameter("u_id");
		String tag = request.getParameter("tag");
		if (adminService.changeUStatus(objectMapper.readValue(u_id, String.class), objectMapper.readValue(tag, String.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/changePStatus")
	public void changePStatus(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		String p_id = request.getParameter("p_id");
		String tag = request.getParameter("tag");
		if (adminService.changePStatus(objectMapper.readValue(p_id, String.class), objectMapper.readValue(tag, String.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/updateAUser")
	public void updateAUser(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		String u_id = request.getParameter("u_id");
		String u_name = request.getParameter("u_name");
		String u_password = request.getParameter("u_password");
		if (adminService.updateAUser(objectMapper.readValue(u_id, String.class), objectMapper.readValue(u_name, String.class), objectMapper.readValue(u_password, String.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/updateAPlate")
	public void updateAPlate(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("changePlate");
		if (adminService.updateAPlate(objectMapper.readValue(json, Plate.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}


	@RequestMapping("/searchUser")
	@ResponseBody
	public List<UserList> searchUser(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String input = request.getParameter("input");
		String select = request.getParameter("select");
		return adminService.getUserList(objectMapper.readValue(input, String.class), objectMapper.readValue(select, String.class));
	}

	@RequestMapping("/addAPlate")
	public void addAPlate(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("addPlate");
		Plate plate = objectMapper.readValue(json, Plate.class);
		plate.setP_id(new Date().toLocaleString());
		if (adminService.addAPlate(plate) != 0) {
			json = objectMapper.writeValueAsString("添加成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("添加失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/removePlate")
	public void removePlate(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("p_id");
		if (adminService.removePlate(objectMapper.readValue(json, String.class)) != 0) {
			json = objectMapper.writeValueAsString("删除成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("删除失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}
}
