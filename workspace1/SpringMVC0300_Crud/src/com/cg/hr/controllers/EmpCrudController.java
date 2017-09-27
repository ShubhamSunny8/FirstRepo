package com.cg.hr.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.hr.dto.Employee;
import com.cg.hr.exception.EmpException;
import com.cg.hr.services.EmpServices;
@Controller
public class EmpCrudController {
	
	
	@Resource
	private EmpServices service;
	
	@RequestMapping("/getEmpList.do")
	public ModelAndView getEmpList() throws EmpException{
		System.out.println("Printing...>>>>>>>>>>>>>>>>>>>>>>");
		List<Employee> empList =service.getEmpList();
		ModelAndView mAndV= new ModelAndView();
		mAndV.addObject("empList",empList);
		mAndV.addObject("pageHead", "Employee List");
		System.out.println(empList);
		mAndV.setViewName("EmpList");
		return mAndV;
	}
	
	@RequestMapping("/getEmpDetails.do")
	public  ModelAndView getEmpDetails(@RequestParam("empNo") int empNo) throws EmpException
	{
		Employee emp=service.getEmployeeEmpOnId(empNo);
		ModelAndView mAndV= new ModelAndView();
		mAndV.addObject("emp",emp);
		mAndV.addObject("pageHead", "Employee Details");
		System.out.println(emp);
		mAndV.setViewName("EmpDetails");
		return mAndV;
	}
	
	@RequestMapping("/getEntryPage.do")
	public ModelAndView getEntryPage(){
		ModelAndView mAndV= new ModelAndView("EntryPage");
		Employee emp=new Employee();
		mAndV.addObject("employee",emp);
		return mAndV;
	}
	
	@RequestMapping("/getHomePage.do")
	public ModelAndView getHomePage(){
		ModelAndView mAndView =new ModelAndView();
		mAndView.setViewName("HomePage");
		return mAndView;
	}
	
	@RequestMapping(value="/submitEmpDetails.do",method=RequestMethod.POST)
	public String setEmpDetails(@ModelAttribute("employee") Employee emp,Model mAndV) throws EmpException
	{
		service.insertNewEmployee(emp);
			
		mAndV.addAttribute("emp",emp);
		mAndV.addAttribute("pageHead", "setEmpDetails");
		
		return "SuccEmpJoining";
	}
	@RequestMapping("/getUpdateNamePage.do")
	public ModelAndView getUpdateNamePage() throws EmpException{
		ModelAndView mAndV= new ModelAndView("UpdateNamePage");
		List<Integer> idList=service.getEmpNoList();
		
		mAndV.addObject("idList",idList);
		mAndV.addObject("pageHead", "Update Name of Employee");
		return mAndV;
	}
	@RequestMapping("/submitNewEmpname.do")
	public String submitNewEmpname(
			@RequestParam("empNo")int empNo,
			@RequestParam("newName")String newName,
			Model mAndV) throws EmpException
		{
			System.out.println(empNo+" "+newName);
			service.updateEmployee(empNo, newName);
			
			Employee emp=	service.getEmployeeEmpOnId(empNo);
			mAndV.addAttribute("emp",emp);
			mAndV.addAttribute("pageHead", "Sucess");
			return "SuccEmpUpdate";
		}
	
}
