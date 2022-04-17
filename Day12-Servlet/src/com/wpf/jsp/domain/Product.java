package com.wpf.jsp.domain;

public class Product {
	private int pt_id;
	private String pt_name;
	private double pt_price;
	private int pt_c_id;
	private int pt_p_id;

	public Product() {
	}

	public Product(int pt_id) {
		this.pt_id = pt_id;
	}

	public Product(String pt_name, double pt_price, int pt_c_id, int pt_p_id) {
		this.pt_name = pt_name;
		this.pt_price = pt_price;
		this.pt_c_id = pt_c_id;
		this.pt_p_id = pt_p_id;
	}

	public Product(int pt_id, String pt_name, double pt_price, int pt_c_id, int pt_p_id) {
		this.pt_id = pt_id;
		this.pt_name = pt_name;
		this.pt_price = pt_price;
		this.pt_c_id = pt_c_id;
		this.pt_p_id = pt_p_id;
	}

	public int getPt_id() {
		return pt_id;
	}

	public void setPt_id(int pt_id) {
		this.pt_id = pt_id;
	}

	public String getPt_name() {
		return pt_name;
	}

	public void setPt_name(String pt_name) {
		this.pt_name = pt_name;
	}

	public double getPt_price() {
		return pt_price;
	}

	public void setPt_price(double pt_price) {
		this.pt_price = pt_price;
	}

	public int getPt_c_id() {
		return pt_c_id;
	}

	public void setPt_c_id(int pt_c_id) {
		this.pt_c_id = pt_c_id;
	}

	public int getPt_p_id() {
		return pt_p_id;
	}

	public void setPt_p_id(int pt_p_id) {
		this.pt_p_id = pt_p_id;
	}

	@Override
	public String toString() {
		return "Product{" +
				"pt_id=" + pt_id +
				", pt_name='" + pt_name + '\'' +
				", pt_price=" + pt_price +
				", pt_c_id=" + pt_c_id +
				", pt_p_id=" + pt_p_id +
				'}';
	}
}
