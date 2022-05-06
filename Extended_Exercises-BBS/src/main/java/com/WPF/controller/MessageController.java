package com.WPF.controller;

import com.WPF.domain.Comment;
import com.WPF.domain.Plate;
import com.WPF.domain.Post;
import com.WPF.service.MessageService;
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
@RequestMapping("/message")
public class MessageController {
	@Resource
	private MessageService messageService;

	private String json;
	private final ObjectMapper objectMapper = new ObjectMapper();
	private PrintWriter printWriter;

	@RequestMapping("/getPostByPId")
	@ResponseBody
	public Post getPostByPId(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("p_id");
		return messageService.getPostByPId(objectMapper.readValue(json, String.class));
	}

	@RequestMapping("/getPostListPPId")
	@ResponseBody
	public List<Post> getPostListPPId(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("p_id");
		return messageService.getPostListPPId(objectMapper.readValue(json, String.class));
	}

	@RequestMapping("/getCommentList")
	@ResponseBody
	public List<Comment> getCommentList(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("p_id");
		return messageService.getCommentList(objectMapper.readValue(json, String.class));
	}

	@RequestMapping("/changePostPBrowseCount")
	public void changePostPBrowseCount(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("p_id");
		messageService.changePostPBrowseCount(objectMapper.readValue(json, String.class));
	}

	@RequestMapping("/putThumbs")
	public void putThumbs(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		json = request.getParameter("p_id");
		messageService.putThumbs(objectMapper.readValue(json, String.class));
	}

	@RequestMapping("/putAComment")
	public void putAComment(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		printWriter = response.getWriter();
		json = request.getParameter("comment");
		Comment comment = objectMapper.readValue(json, Comment.class);
		comment.setC_id(new Date().toLocaleString());
		comment.setC_comment_time(new Date().toLocaleString());
		if (messageService.putAComment(comment) != 0) {
			json = objectMapper.writeValueAsString("添加成功");
			printWriter.print(json);
			printWriter.close();
		} else {
			json = objectMapper.writeValueAsString("添加失败！！");
			printWriter.print(json);
			printWriter.close();
		}
	}
}
