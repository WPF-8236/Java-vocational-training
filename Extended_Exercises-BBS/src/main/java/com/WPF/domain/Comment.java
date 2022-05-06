package com.WPF.domain;

public class Comment {
	private String c_id;
	private String c_content;
	private String c_comment_u_id;
	private String c_comment_p_id;
	private String c_comment_time;
	private int c_floor;

	public Comment() {
	}

	public Comment(String c_id, String c_content, String c_comment_u_id, String c_comment_p_id, String c_comment_time, int c_floor) {
		this.c_id = c_id;
		this.c_content = c_content;
		this.c_comment_u_id = c_comment_u_id;
		this.c_comment_p_id = c_comment_p_id;
		this.c_comment_time = c_comment_time;
		this.c_floor = c_floor;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public String getC_comment_u_id() {
		return c_comment_u_id;
	}

	public void setC_comment_u_id(String c_comment_u_id) {
		this.c_comment_u_id = c_comment_u_id;
	}

	public String getC_comment_p_id() {
		return c_comment_p_id;
	}

	public void setC_comment_p_id(String c_comment_p_id) {
		this.c_comment_p_id = c_comment_p_id;
	}

	public String getC_comment_time() {
		return c_comment_time;
	}

	public void setC_comment_time(String c_comment_time) {
		this.c_comment_time = c_comment_time;
	}

	public int getC_floor() {
		return c_floor;
	}

	public void setC_floor(int c_floor) {
		this.c_floor = c_floor;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"c_id='" + c_id + '\'' +
				", c_content='" + c_content + '\'' +
				", c_comment_u_id='" + c_comment_u_id + '\'' +
				", c_comment_p_id='" + c_comment_p_id + '\'' +
				", c_comment_time='" + c_comment_time + '\'' +
				", c_floor=" + c_floor +
				'}';
	}
}
