package com.WPF.controller;

import com.WPF.domain.*;
import com.WPF.service.AdminService;
import com.WPF.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private AdminService adminService;

	private String json;
	private final ObjectMapper objectMapper = new ObjectMapper();
	private PrintWriter printWriter;

	@RequestMapping("/fileupload")
	public String fileupload(HttpServletResponse response, HttpServletRequest request, MultipartFile upload) throws Exception {
		String path = request.getSession().getServletContext().getRealPath("/img/");
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		String filename = upload.getOriginalFilename();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		filename = uuid + "-" + filename;
		upload.transferTo(new File(path, filename));
		String img = "img/" + filename;
		UserBasic userBasic = (UserBasic) request.getSession().getAttribute("userBasic");
		userBasic.setU_img(img);
		userService.updateImg(userBasic);
		return "UserCenter";
	}

	@RequestMapping("/getUserSchool")
	@ResponseBody
	public UserSchool getUserSchool(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("u_id");
		return userService.getUserSchoolByUId(objectMapper.readValue(json, String.class));
	}

	@RequestMapping("/getUserBasic")
	@ResponseBody
	public UserBasic getUserBasic(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("u_id");
		return userService.getUserBasicByUId(objectMapper.readValue(json, String.class));
	}

	@RequestMapping("/getUserCompany")
	@ResponseBody
	public UserCompany getUserCompany(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("u_id");
		return userService.getUserCompanyByUId(objectMapper.readValue(json, String.class));
	}

	@RequestMapping("/getUserInterestLike")
	@ResponseBody
	public List<UserInterest> getUserInterestLike(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("u_id");
		return userService.getUserInterestByUId(objectMapper.readValue(json, String.class), 0);
	}

	@RequestMapping("/getUserInterestDislike")
	@ResponseBody
	public List<UserInterest> getUserInterestDislike(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("u_id");
		return userService.getUserInterestByUId(objectMapper.readValue(json, String.class), 1);
	}

	@RequestMapping("/getPlateListByUId")
	@ResponseBody
	public List<Plate> getPlateListByUId(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("u_id");
		return userService.getPlateListByUId(objectMapper.readValue(json, String.class));
	}

	@RequestMapping("/getPostListByUId")
	@ResponseBody
	public List<Post> getPostListByUId(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("u_id");
		return userService.getPostListByUId(objectMapper.readValue(json, String.class));
	}

	@RequestMapping("/getPostListByPPId")
	@ResponseBody
	public List<Post> getPostListByPPId(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("p_id");
		return userService.getPostListByPPId(objectMapper.readValue(json, String.class));
	}


	@RequestMapping("/putChangeUserBasic")
	public void putChangeUserBasic(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("userBasic");
		if (userService.updateUserBasic(objectMapper.readValue(json, UserBasic.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/putChangeUserSchool")
	public void putChangeUserSchool(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("userSchool");
		if (userService.updateUserSchool(objectMapper.readValue(json, UserSchool.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/putChangeUserCompany")
	public void putChangeUserCompany(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("userCompany");
		if (userService.updateUserCompany(objectMapper.readValue(json, UserCompany.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/removeUserInterest")
	public void removeUserInterest(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("u_interest_id");
		if (userService.deleteUserInterestByUInterestId(objectMapper.readValue(json, String.class)) != 0) {
			json = objectMapper.writeValueAsString("删除成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("删除失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/putLikeTag")
	public void putLikeTag(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("likeTag");
		UserInterest userInterest = objectMapper.readValue(json, UserInterest.class);
		userInterest.setU_interest_id(new Date().toLocaleString());
		if (userService.insertUserInterest(userInterest) != 0) {
			json = objectMapper.writeValueAsString("添加成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("添加失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/putDislikeTag")
	public void putDislikeTag(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("dislikeTag");
		UserInterest userInterest = objectMapper.readValue(json, UserInterest.class);
		userInterest.setU_interest_id(new Date().toLocaleString());
		if (userService.insertUserInterest(userInterest) != 0) {
			json = objectMapper.writeValueAsString("添加成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("添加失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/putChangeUPassword")
	public void putChangeUPassword(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		String u_id = request.getParameter("u_id");
		String u_password = request.getParameter("u_password");
		if (userService.updateUserPassword(objectMapper.readValue(u_id, String.class), objectMapper.readValue(u_password, String.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/putUserPhone")
	public void putUserPhone(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		String u_id = request.getParameter("u_id");
		String u_phone = request.getParameter("u_phone");
		if (userService.updateUserPhone(objectMapper.readValue(u_id, String.class), objectMapper.readValue(u_phone, String.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/putUserEmail")
	public void putUserEmail(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		String u_id = request.getParameter("u_id");
		String u_email = request.getParameter("u_email");
		if (userService.updateUserEmail(objectMapper.readValue(u_id, String.class), objectMapper.readValue(u_email, String.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/deleteUser")
	public void deleteUser(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("u_id");
		if (userService.deleteUserByUId(objectMapper.readValue(json, String.class)) != 0) {
			json = objectMapper.writeValueAsString("注销成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("注销失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/addAPlate")
	public void addAPlate(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("addPlate");
		Plate plate = objectMapper.readValue(json, Plate.class);
		plate.setP_id(new Date().toLocaleString());
		plate.setP_status(2);
		if (userService.addAPlate(plate) != 0) {
			json = objectMapper.writeValueAsString("添加成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("添加失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/addAPost")
	public void addAPost(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("addPost");
		Post post = objectMapper.readValue(json, Post.class);
		post.setP_id(new Date().toLocaleString());
		post.setP_time(new Date().toLocaleString());
		post.setP_status(2);
		if (userService.addAPost(post) != 0) {
			json = objectMapper.writeValueAsString("添加成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("添加失败！！");
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
		Plate plate = objectMapper.readValue(json, Plate.class);
		plate.setP_status(2);
		if (adminService.updateAPlate(plate) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}

	@RequestMapping("/updateAPost")
	public void updateAPost(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("changePost");
		if (userService.updateAPost(objectMapper.readValue(json, Post.class)) != 0) {
			json = objectMapper.writeValueAsString("修改成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("修改失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}
}
