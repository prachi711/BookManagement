package com.own.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.own.model.Book;

import com.own.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value="addBook")
	public String getaddBookPage()
	{
		return "addBook";
	}
	
	@RequestMapping(value="addBookdata", method=RequestMethod.POST)
	 public ModelAndView add(@ModelAttribute("book") Book book) throws Exception{
	  
		bookService.save(book);
	  
	  
		return new ModelAndView("redirect:/viewBook");
	 }
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("bookcode") String bookcode){
	  bookService.delete(bookcode);
	  
	  return new ModelAndView("redirect:/list");
	 }
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("bookcode") String bookcode){
	  ModelAndView model = new ModelAndView("viewBook");
	  
	  Book book = bookService.getBookByBookcode(bookcode);
	  model.addObject("bookform", book);
	  
	  return model;
	 }
	
	@RequestMapping(value = "/bookreg", method = RequestMethod.GET)
	  public ModelAndView showBooks() {
	    ModelAndView mav = new ModelAndView("bookreg");
	    mav.addObject("book", new Book());
	  
		//((Model) mav).addAttribute("Name", user.getName());
	    return mav;
	  }
}
