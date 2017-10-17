package com.cg.ars.controllers;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.ars.dtos.UsersBean;
import com.cg.ars.exceptions.AirlineException;
import com.cg.ars.services.CustomerService;
import com.cg.ars.services.ValidateService;


@Controller
public class ARSController {

	@Resource
	ValidateService validateService;
	@Resource
	CustomerService customerService;
	
	
	@RequestMapping("/getLoginPage.do")
	public ModelAndView getHomePage() throws AirlineException{
		
		ModelAndView mAndV = new ModelAndView();
		
		UsersBean userBean = new UsersBean();
		mAndV.addObject("LoginUserBean", userBean);
		
		mAndV.setViewName("LoginPage");
		return mAndV;
	}
	
	@RequestMapping(value="/submitLoginDetails.do", method=RequestMethod.POST)
	public String submitEmpDetails(@ModelAttribute("LoginUserBean") UsersBean userBean, Model mAndV, HttpSession session)
			throws AirlineException {
		
		boolean checkUser = false;
		String target = null;
		System.out.println(userBean);
			
		
			checkUser = validateService.validateUser(userBean);
			if(checkUser == true){
				String role = userBean.getRole();
				String userName = userBean.getUserName();
				session.setAttribute("userName", userName);
				
				switch(role){
				case "customer":{
					target = "CustomerInterface";
					break;
				}// end of case 1
				case "executive":{
					target = "ExecutiveInterface";
					break;
				}// end of case 2
				case "admin":{
					target = "AdminInterface";
					break;
				}// end of case 3
				}// end of switch
				
				return target;
				}else{
					String message = "Invalid username or password.";
					mAndV.addAttribute("message", message);
					return "LoginPage";
			} 
		
			
	}
	
	
	@RequestMapping("/getSignUpPage.do")
	public ModelAndView getSignUpPage() throws AirlineException{
		
		ModelAndView mAndV = new ModelAndView();
		
		mAndV.setViewName("SignUp");
		return mAndV;
	}
	
	@RequestMapping(value="/submitSignUpDetails.do", method=RequestMethod.POST)
	public String submitSignUpDetails(Model mAndV, HttpServletRequest request)
			throws AirlineException {
		
		boolean checkUser = false;
		String message = null;
		boolean isAdded = false;
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String role = "customer";
		
		UsersBean user = new UsersBean(firstName, lastName, userName, password, role);
		
		System.out.println(user);
			
			checkUser = validateService.validateUserName(userName);
			System.out.println(checkUser);
			if(checkUser == true){
				isAdded = customerService.addNewCustomer(user);
					if(isAdded){
						message = "User added successfully";
					} else{
						message = "Username already exists.";
					}
				}else{
					message = "Some error occured while creating new customer";
			} 
		
			mAndV.addAttribute("message", message);
			return "LoginPage";
	}
		
}
	


