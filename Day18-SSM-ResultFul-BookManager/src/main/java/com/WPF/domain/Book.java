package com.WPF.domain;

public class Book {
	private String book_no;
	private String sort_no;
	private String title;
	private String author;
	private Double price;
	private String lo_no;

	public Book() {
	}

	public Book(String book_no, String sort_no, String title, String author, Double price, String lo_no) {
		this.book_no = book_no;
		this.sort_no = sort_no;
		this.title = title;
		this.author = author;
		this.price = price;
		this.lo_no = lo_no;
	}

	public String getBook_no() {
		return book_no;
	}

	public void setBook_no(String book_no) {
		this.book_no = book_no;
	}

	public String getSort_no() {
		return sort_no;
	}

	public void setSort_no(String sort_no) {
		this.sort_no = sort_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getLo_no() {
		return lo_no;
	}

	public void setLo_no(String lo_no) {
		this.lo_no = lo_no;
	}

	@Override
	public String toString() {
		return "Book{" +
				"book_no='" + book_no + '\'' +
				", sort_no='" + sort_no + '\'' +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", price=" + price +
				", lo_no='" + lo_no + '\'' +
				'}';
	}
}
