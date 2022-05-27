package com.WPF.dao;

import com.WPF.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
	List<Book> selectAllBook();

	int deleteBookByBookNo(@Param("book_no") String book_no);

	int insertBook(Book book);

	int updateBook(Book book);
}
