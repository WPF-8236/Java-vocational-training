package com.WPF.domain;

public class Plate {
	private String p_id;
	private String p_name;
	private int p_p_count;
	private int p_comment_count;
	private String p_description;
	private String p_u_id;
	private int p_status;

	public Plate() {
	}

	public Plate(String p_id, String p_name, int p_p_count, int p_comment_count, String p_description, String p_u_id) {
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_p_count = p_p_count;
		this.p_comment_count = p_comment_count;
		this.p_description = p_description;
		this.p_u_id = p_u_id;
	}

	public Plate(String p_id, String p_name, int p_p_count, int p_comment_count, String p_description, String p_u_id, int p_status) {
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_p_count = p_p_count;
		this.p_comment_count = p_comment_count;
		this.p_description = p_description;
		this.p_u_id = p_u_id;
		this.p_status = p_status;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_p_count() {
		return p_p_count;
	}

	public void setP_p_count(int p_p_count) {
		this.p_p_count = p_p_count;
	}

	public int getP_comment_count() {
		return p_comment_count;
	}

	public void setP_comment_count(int p_comment_count) {
		this.p_comment_count = p_comment_count;
	}

	public String getP_description() {
		return p_description;
	}

	public void setP_description(String p_description) {
		this.p_description = p_description;
	}

	public String getP_u_id() {
		return p_u_id;
	}

	public void setP_u_id(String p_u_id) {
		this.p_u_id = p_u_id;
	}

	public int getP_status() {
		return p_status;
	}

	public void setP_status(int p_status) {
		this.p_status = p_status;
	}

	@Override
	public String toString() {
		return "Plate{" +
				"p_id='" + p_id + '\'' +
				", p_name='" + p_name + '\'' +
				", p_p_count=" + p_p_count +
				", p_comment_count=" + p_comment_count +
				", p_description='" + p_description + '\'' +
				", p_u_id='" + p_u_id + '\'' +
				", p_status=" + p_status +
				'}';
	}
}
