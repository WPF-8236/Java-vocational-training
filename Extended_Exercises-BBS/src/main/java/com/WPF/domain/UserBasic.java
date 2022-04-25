package com.WPF.domain;

public class UserBasic {
	private String u_id;
	private String u_name;
	private String u_gender;
	private String u_age;
	private String u_introduction;
	private String u_address;

	private String u_img;

	public UserBasic() {
	}

	public UserBasic(String u_id, String u_name, String u_gender, String u_age, String u_introduction, String u_address) {
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_gender = u_gender;
		this.u_age = u_age;
		this.u_introduction = u_introduction;
		this.u_address = u_address;
	}

	public UserBasic(String u_id, String u_name, String u_gender, String u_age, String u_introduction, String u_address, String u_img) {
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_gender = u_gender;
		this.u_age = u_age;
		this.u_introduction = u_introduction;
		this.u_address = u_address;
		this.u_img = u_img;
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

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public String getU_age() {
		return u_age;
	}

	public void setU_age(String u_age) {
		this.u_age = u_age;
	}

	public String getU_introduction() {
		return u_introduction;
	}

	public void setU_introduction(String u_introduction) {
		this.u_introduction = u_introduction;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public String getU_img() {
		return u_img;
	}

	public void setU_img(String u_img) {
		this.u_img = u_img;
	}

	@Override
	public String toString() {
		return "UserBasic{" +
				"u_id='" + u_id + '\'' +
				", u_name='" + u_name + '\'' +
				", u_gender='" + u_gender + '\'' +
				", u_age='" + u_age + '\'' +
				", u_introduction='" + u_introduction + '\'' +
				", u_address='" + u_address + '\'' +
				", u_img='" + u_img + '\'' +
				'}';
	}
}
