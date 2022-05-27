package com.WPF.controller;

import com.WPF.domain.Book;
import com.WPF.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
	@Resource
	private BookService bookService;

	@GetMapping("/getBookList")
	@ResponseBody
	private List<Book> getBookList() {
		return bookService.getBookList();
	}

	@DeleteMapping(value = "/removeBookByBookNo/{book_no}", produces = "application/json; charset=utf-8")
	@ResponseBody
	private String removeBookByBookNo(@PathVariable String book_no) {
		if (bookService.removeBookByBookNo(book_no) != 0)
			return "删除成功";
		else
			return "删除失败";
	}

	@PostMapping(value = "/addBook", produces = "application/json; charset=utf-8")
	@ResponseBody
	private String addBook(@RequestBody Book book) {
		if (bookService.addBook(book) != 0)
			return "添加成功";
		else
			return "添加失败";
	}

	@PutMapping(value = "/changeBook", produces = "application/json; charset=utf-8")
	@ResponseBody
	private String changeBook(@RequestBody Book book) {
		if (bookService.changeBook(book) != 0)
			return "修改成功";
		else
			return "修改失败";
	}
}
