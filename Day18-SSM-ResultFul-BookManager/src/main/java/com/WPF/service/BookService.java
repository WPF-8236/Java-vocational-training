package com.WPF.service;

import com.WPF.domain.Book;

import java.util.List;

public interface BookService {
	List<Book> getBookList();

	int removeBookByBookNo(String book_no);

	int addBook(Book book);

	int changeBook(Book book);
}
