package com.own.service;

import java.util.List;

import com.own.model.Book;

public interface BookService {
	
	void save(Book book) throws Exception;

	void delete(String bookcode);

	void update(Book book);

	Book getBookByBookcode(String bookcode);

	List<Book> getBookByBooktype(String booktype);

	

}
