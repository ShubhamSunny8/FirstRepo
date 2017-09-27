package com.cg.hr.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.hr.entities.User;
import com.cg.hr.exception.EmpException;
import com.cg.hr.services.AuthService;


//http:localhost:8080/SpringMVC020WebFlow/getLoginPage.hr
@Controller()
public class Authenticate {
	@Resource
	private AuthService service;
	
	@RequestMapping("/getLoginPage.hr")
	public ModelAndView getLoginPage(){
		ModelAndView mAndV =new ModelAndView("Login.jsp");
		mAndV.addObject("pageHead", "Login Page");
		return mAndV;
	}
	@RequestMapping(value="/authenticate.hr",method=RequestMethod.POST)
	public ModelAndView authenticateUser(HttpServletRequest request) throws EmpException
	{
		String username=request.getParameter("userName");
		String password=request.getParameter("password");
		User user =new User(username,password);
		ModelAndView mAndV =new ModelAndView();
		user=service.isAuthenticated(user);
		if(user.isAuthSucc())
		{
			mAndV.setViewName("MainMenu.jsp");
			mAndV.addObject("userDetails", user);
			mAndV.addObject("pageHead", "MainMenu Page");
		}else{
			mAndV.setViewName("Login.jsp");
			mAndV.addObject("userDetails", user);
			mAndV.addObject("pageHead", "Login Page");
		}
		return mAndV;
		
	}
}
