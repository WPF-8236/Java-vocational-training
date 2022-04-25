package com.WPF.domain;

public class UserGrade {
	private String u_id;
	private String u_password;
	private int u_grade;
	private int u_state;

	public UserGrade() {
	}

	public UserGrade(String u_id, String u_password) {
		this.u_id = u_id;
		this.u_password = u_password;
	}

	public UserGrade(String u_id, String u_password, int u_grade, int u_state) {
		this.u_id = u_id;
		this.u_password = u_password;
		this.u_grade = u_grade;
		this.u_state = u_state;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
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

	public int getU_state() {
		return u_state;
	}

	public void setU_state(int u_state) {
		this.u_state = u_state;
	}

	@Override
	public String toString() {
		return "UserGrade{" +
				"u_id='" + u_id + '\'' +
				", u_password='" + u_password + '\'' +
				", u_grade=" + u_grade +
				", u_state=" + u_state +
				'}';
	}
}
