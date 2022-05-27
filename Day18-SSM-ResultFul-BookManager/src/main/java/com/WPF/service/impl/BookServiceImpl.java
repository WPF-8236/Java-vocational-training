package com.WPF.service.impl;

import com.WPF.dao.BookDao;
import com.WPF.domain.Book;
import com.WPF.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {
	@Resource
	private BookDao bookDao;

	@Override
	public List<Book> getBookList() {
		return bookDao.selectAllBook();
	}

	@Override
	public int removeBookByBookNo(String book_no) {
		return bookDao.deleteBookByBookNo(book_no);
	}

	@Override
	public int addBook(Book book) {
		return bookDao.insertBook(book);
	}

	@Override
	public int changeBook(Book book) {
		return bookDao.updateBook(book);
	}
}
