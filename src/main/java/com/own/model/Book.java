package com.own.model;


public class Book {
	
	private String  bookcode;
	private String bookname;
	private String booktype;
	private int price;
	private String description;
	public String getBookcode() {
		return bookcode;
	}
	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Book(String bookcode, String bookname, String booktype, int price, String description) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.booktype = booktype;
		this.price = price;
		this.description = description;
	}
	public Book() {
		super();
	}
	
	
	
	public Book(String bookcode) {
		super();
		this.bookcode = bookcode;
	}
	@Override
	public String toString() {
		return "Book [bookcode=" + bookcode + ", bookname=" + bookname + ", booktype=" + booktype + ", price=" + price
				+ ", description=" + description + "]";
	}
	
	
	

}
