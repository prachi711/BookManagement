package com.own.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.own.dao.BookDao;

import com.own.model.Book;

public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao bookDao;

	public void save(Book book) {
		bookDao.save(book);
		
	}

	public void delete(String bookcode) {
	     bookDao.delete(bookcode);
		
	}

	public void update(Book book) {
		bookDao.update(book);
		
	}

	public Book getBookByBookcode(String bookcode) {
		
		return bookDao.getBookByBookcode(bookcode);
	}

	public List<Book> getBookByBooktype(String booktype) {
		
		return bookDao.getBookByBooktype(booktype);
	}

	
	
	
}
