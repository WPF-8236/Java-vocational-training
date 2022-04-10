package com.wpf.jsp.domain;

public class Provider {
	private String p_id;
	private String p_name;
	private String p_tele;
	private String p_email;
	private String p_address;

	public Provider() {
	}

	public Provider(String p_id, String p_name, String p_tele, String p_email, String p_address) {
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_tele = p_tele;
		this.p_email = p_email;
		this.p_address = p_address;
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

	public String getP_tele() {
		return p_tele;
	}

	public void setP_tele(String p_tele) {
		this.p_tele = p_tele;
	}

	public String getP_email() {
		return p_email;
	}

	public void setP_email(String p_email) {
		this.p_email = p_email;
	}

	public String getP_address() {
		return p_address;
	}

	public void setP_address(String p_address) {
		this.p_address = p_address;
	}

	@Override
	public String toString() {
		return "Provider{" +
				"p_id='" + p_id + '\'' +
				", p_name='" + p_name + '\'' +
				", p_tele='" + p_tele + '\'' +
				", p_email='" + p_email + '\'' +
				", p_address='" + p_address + '\'' +
				'}';
	}
}
