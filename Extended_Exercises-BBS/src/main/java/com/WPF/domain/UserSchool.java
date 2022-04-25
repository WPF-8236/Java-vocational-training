package com.WPF.domain;

public class UserSchool {
	private String u_id;
	private String u_school_name;
	private String u_school_profession;
	private String u_school_start;
	private String u_school_end;
	private String u_school_education;

	public UserSchool() {
	}

	public UserSchool(String u_id, String u_school_name, String u_school_profession, String u_school_start, String u_school_end, String u_school_education) {
		this.u_id = u_id;
		this.u_school_name = u_school_name;
		this.u_school_profession = u_school_profession;
		this.u_school_start = u_school_start;
		this.u_school_end = u_school_end;
		this.u_school_education = u_school_education;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_school_name() {
		return u_school_name;
	}

	public void setU_school_name(String u_school_name) {
		this.u_school_name = u_school_name;
	}

	public String getU_school_profession() {
		return u_school_profession;
	}

	public void setU_school_profession(String u_school_profession) {
		this.u_school_profession = u_school_profession;
	}

	public String getU_school_start() {
		return u_school_start;
	}

	public void setU_school_start(String u_school_start) {
		this.u_school_start = u_school_start;
	}

	public String getU_school_end() {
		return u_school_end;
	}

	public void setU_school_end(String u_school_end) {
		this.u_school_end = u_school_end;
	}

	public String getU_school_education() {
		return u_school_education;
	}

	public void setU_school_education(String u_school_education) {
		this.u_school_education = u_school_education;
	}

	@Override
	public String toString() {
		return "UserSchool{" +
				"u_id='" + u_id + '\'' +
				", u_school_name='" + u_school_name + '\'' +
				", u_school_profession='" + u_school_profession + '\'' +
				", u_school_start='" + u_school_start + '\'' +
				", u_school_end='" + u_school_end + '\'' +
				", u_school_education='" + u_school_education + '\'' +
				'}';
	}
}
