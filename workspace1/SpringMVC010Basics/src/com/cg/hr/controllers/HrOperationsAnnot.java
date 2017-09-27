package com.cg.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HrOperationsAnnot{
	@RequestMapping("/hello.obj")
	public ModelAndView sayHello()
	{
		System.out.println("I am inside Annot controller");
		ModelAndView mAndV =new ModelAndView();
		mAndV.addObject("pageHead", "Welcome Mr./Ms.");
		mAndV.setViewName("/Welcome.jsp");
		return mAndV;
	}
	
}
