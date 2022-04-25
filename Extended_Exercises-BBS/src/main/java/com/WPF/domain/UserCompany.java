package com.WPF.domain;

public class UserCompany {
	private String u_id;
	private String u_company_name;
	private String u_company_posts;
	private String u_company_industry;

	public UserCompany() {
	}

	public UserCompany(String u_id, String u_company_name, String u_company_posts, String u_company_industry) {
		this.u_id = u_id;
		this.u_company_name = u_company_name;
		this.u_company_posts = u_company_posts;
		this.u_company_industry = u_company_industry;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_company_name() {
		return u_company_name;
	}

	public void setU_company_name(String u_company_name) {
		this.u_company_name = u_company_name;
	}

	public String getU_company_posts() {
		return u_company_posts;
	}

	public void setU_company_posts(String u_company_posts) {
		this.u_company_posts = u_company_posts;
	}

	public String getU_company_industry() {
		return u_company_industry;
	}

	public void setU_company_industry(String u_company_industry) {
		this.u_company_industry = u_company_industry;
	}

	@Override
	public String toString() {
		return "UserCompany{" +
				"u_id='" + u_id + '\'' +
				", u_company_name='" + u_company_name + '\'' +
				", u_company_posts='" + u_company_posts + '\'' +
				", u_company_industry='" + u_company_industry + '\'' +
				'}';
	}
}
