package com.own.dao;

import java.util.List;

import com.own.model.Book;


public interface BookDao {
	
	void save(Book book);
	public List<Book> getBook();
	public void delete(String bookcode);
	public Book getBookByBookcode(String bookcode);
	public List<Book> getBookByBooktype(String booktype);
	public int update(Book book);
}


