package com.wpf.domain;

public class Book {
	private String b_id;
	private String b_name;
	private String b_price;
	private String b_author;
	private String b_publishing;
	private String b_image;

	public Book() {
	}

	public Book(String b_id, String b_name, String b_price, String b_author, String b_publishing, String b_image) {
		this.b_id = b_id;
		this.b_name = b_name;
		this.b_price = b_price;
		this.b_author = b_author;
		this.b_publishing = b_publishing;
		this.b_image = b_image;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_price() {
		return b_price;
	}

	public void setB_price(String b_price) {
		this.b_price = b_price;
	}

	public String getB_author() {
		return b_author;
	}

	public void setB_author(String b_author) {
		this.b_author = b_author;
	}

	public String getB_publishing() {
		return b_publishing;
	}

	public void setB_publishing(String b_publishing) {
		this.b_publishing = b_publishing;
	}

	public String getB_image() {
		return b_image;
	}

	public void setB_image(String b_image) {
		this.b_image = b_image;
	}

	@Override
	public String toString() {
		return "Book{" +
				"b_id='" + b_id + '\'' +
				", b_name='" + b_name + '\'' +
				", b_price='" + b_price + '\'' +
				", b_author='" + b_author + '\'' +
				", b_publishing='" + b_publishing + '\'' +
				", b_image='" + b_image + '\'' +
				'}';
	}
}
