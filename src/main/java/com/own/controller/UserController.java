package com.own.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.own.model.User;
import com.own.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/")
	public String getIndexPage()
	{
		return "index";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String getLoginPage()
	{
		return "login";
	}
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String getRegisterPage()
	{
		return "register";
	}
	
	@RequestMapping(value = "loginuser", method = RequestMethod.POST)
	  public ModelAndView loginProcess(@RequestParam("username")String username,@RequestParam("password")String password) throws Exception {
	    ModelAndView mav = null;
	    User user = userService.checkUser(username,password);
	    if (null != user) {
	    mav = new ModelAndView("welcome");
	    mav.addObject("Name", user.getName());
	    } else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }
	
	
	@RequestMapping(value="registeruser", method=RequestMethod.POST)
	 public ModelAndView add(@ModelAttribute("user") User user){
	  
		userService.addUser(user);
	  
	  
		return new ModelAndView("welcome", "Name", user.getName());
	 }
	

	
}
