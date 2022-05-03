package com.WPF.domain;

public class UserList {
	private String u_id;
	private String u_password;
	private int u_grade;
	private int u_status;
	private String u_name;

	public UserList() {
	}

	public UserList(String u_id, String u_password, int u_grade, int u_status, String u_name) {
		this.u_id = u_id;
		this.u_password = u_password;
		this.u_grade = u_grade;
		this.u_status = u_status;
		this.u_name = u_name;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public int getU_grade() {
		return u_grade;
	}

	public void setU_grade(int u_grade) {
		this.u_grade = u_grade;
	}

	public int getU_status() {
		return u_status;
	}

	public void setU_status(int u_status) {
		this.u_status = u_status;
	}

	@Override
	public String toString() {
		return "UserList{" +
				"u_id='" + u_id + '\'' +
				", u_password='" + u_password + '\'' +
				", u_grade=" + u_grade +
				", u_status=" + u_status +
				", u_name='" + u_name + '\'' +
				'}';
	}
}
