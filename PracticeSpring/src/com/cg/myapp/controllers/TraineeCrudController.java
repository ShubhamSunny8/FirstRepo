package com.cg.myapp.controllers;

import java.util.List;

import javax.annotation.Resource;

import oracle.net.aso.i;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.myapp.dto.Trainee;
import com.cg.myapp.exception.TraineeException;
import com.cg.myapp.services.TraineeServices;

@Controller
public class TraineeCrudController {
	
	
	@Resource
	private TraineeServices service;
	//getTraineeList.do
	
	@RequestMapping(value="/LoginDetails.do",method=RequestMethod.POST)
	public ModelAndView getEmpList(@RequestParam("username")String usr,
			@RequestParam("password")String pass
			) throws TraineeException{
		ModelAndView mandV= new ModelAndView();
		if("system".equals(usr) && "sys".equals(pass))
		{
		mandV.setViewName("TMS");
		return mandV;
		}else{
			mandV.setViewName("Login");
			return mandV;
		}
	}
	
	@RequestMapping("/getTraineeList.do")
	public ModelAndView getEmpList() throws TraineeException{
		System.out.println("Printing...>>>>>>>>>>>>>>>>>>>>>>");
		List<Trainee> TraineeList =service.getTraineeList();
		ModelAndView mAndV= new ModelAndView();
		mAndV.addObject("TraineeList",TraineeList);
		mAndV.addObject("pageHead", "Trainee List");
		System.out.println(TraineeList);
		mAndV.setViewName("ListAllTrainees");
		return mAndV;
	}
	
	@RequestMapping("/addTrainee.do")
	public ModelAndView getEntryPage(){
		System.out.println("Inside get Entry page");
		ModelAndView mAndV= new ModelAndView();
		Trainee trainee =new Trainee();
		System.out.println("Inside get Entry page2");
		mAndV.addObject(trainee);
		mAndV.setViewName("EnterTraineeDetails");
		return mAndV;
	}
	@RequestMapping(value="/submitTraineeDetails.do",method=RequestMethod.POST)
	public String setTraineeDetails(@ModelAttribute("trainee") Trainee trainee,Model mAndV) throws TraineeException
	{
		System.out.println("Inside set traineeDetails");
		System.out.println(trainee);
		service.insertNewTrainee(trainee);
		System.out.println(trainee);
		mAndV.addAttribute("Trainee",trainee);
		mAndV.addAttribute("pageHead", "TraineeDetailsAdded");
		System.out.println("Done with addition of trainee");
		return "SuccessfullyAddedTrainee";
	}
	//retrieveTrainee.do
	
	@RequestMapping("/retrieveTrainee.do")
	public ModelAndView enterTraineeid(){
		ModelAndView mAndV= new ModelAndView("EnterTraineeId");
		Trainee tr=new Trainee();
		mAndV.addObject("tr",tr);
		return mAndV;
	}
	
	@RequestMapping("/listSingleTrainee.do")
	public  ModelAndView getTraineeDetails(@RequestParam("id") int traineeId) throws TraineeException
	{
		Trainee tr=service.getTraineeOnId(traineeId);
		ModelAndView mAndV= new ModelAndView();
		mAndV.addObject("trainee",tr);
		mAndV.addObject("pageHead", "Trainee Detail");
		System.out.println(tr);
		mAndV.setViewName("TraineeSingleDetails");
		return mAndV;
	}
	
	//traineeInfo.do
	@RequestMapping("/traineeInfo.do")
	public ModelAndView traineeInfo(@RequestParam("id") int traineeId) throws TraineeException{
		Trainee tr=service.getTraineeOnId(traineeId);
		ModelAndView mAndV= new ModelAndView();
		mAndV.addObject("trainee",tr);
		mAndV.addObject("pageHead", "Trainee Detail");
		System.out.println(tr);
		mAndV.setViewName("TraineeModify");
		return mAndV;
	}
	//ModifyOperation.do

	@RequestMapping("/ModifyOperation.do")
	public ModelAndView modifyOp(){
		ModelAndView mAndV= new ModelAndView("ModifyOperation");
		return mAndV;
	}
	
	
	
	
	//modifyNow.do
	@RequestMapping("/modifyNow.do")
	public  ModelAndView modify(@RequestParam("traineeId") String traineeId,
			@RequestParam("traineeName") String traineeName,
			@RequestParam("traineeLocation") String traineeLocation,
			@RequestParam("traineedomain") String traineedomain) throws TraineeException
	{
		System.out.println("TraineeId is"+traineeId);
		int tid=Integer.parseInt(traineeId);
		Trainee tr=new Trainee(tid,traineeName,traineeLocation,traineedomain);
		System.out.println("Before Updation"+tr);
		service.updateTrainee(tr);
		System.out.println("After Updation"+tr);
		ModelAndView m =new ModelAndView();
		
		System.out.println("Printing...>>>>>>>>>>>>>>>>>>>>>>");
		List<Trainee> TraineeList =service.getTraineeList();
		
		m.addObject("TraineeList",TraineeList);
		m.addObject("pageHead", "Trainee List");
		System.out.println(TraineeList);
		
		m.setViewName("ListAllTrainees");
		return m;
	}
	
	
	/*
	@RequestMapping("/getEmpDetails.do")
	public  ModelAndView getEmpDetails(@RequestParam("empNo") int empNo) throws EmpException
	{
		Trainee emp=service.getEmployeeEmpOnId(empNo);
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
		Trainee emp=new Trainee();
		mAndV.addObject("employee",emp);
		return mAndV;
	}
	
	@RequestMapping("/getHomePage.do")
	public ModelAndView getHomePage(){
		ModelAndView mAndView =new ModelAndView();
		mAndView.setViewName("HomePage");
		return mAndView;
	}
	
	@RequestMapping(value="/submitTraineeDetails.do",method=RequestMethod.POST)
	public String setEmpDetails(@ModelAttribute("employee") Trainee emp,Model mAndV) throws EmpException
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
			
			Trainee emp=	service.getEmployeeEmpOnId(empNo);
			mAndV.addAttribute("emp",emp);
			mAndV.addAttribute("pageHead", "Sucess");
			return "SuccEmpUpdate";
		}*/
	
}
