package com.cg.ars.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;
import com.cg.ars.services.ExecutiveService;

@Controller
public class ExecutiveController {

	@Resource
	ExecutiveService executiveService;
	
	@RequestMapping("/getExecutiveHomePage.do")
	public ModelAndView getHomePage(){
		
		ModelAndView mAndV = new ModelAndView("ExecutiveInterface");
		return mAndV;
	}
	
	@RequestMapping("/getFlightNoForOccupancy.do")
	public ModelAndView getFlightNoForOccupancy() throws AirlineException{
		
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("OccupancyOnFlight");
		return mAndV;
	}
	
	@RequestMapping(value="/getOccupancyOnFlight.do", method=RequestMethod.GET)
	public ModelAndView ViewFlightDetailsForBooking(@RequestParam("flightNo") int flightNo) throws AirlineException{
		
		FlightInfoBean flightBean = executiveService.viewFlightOccupancyOnId(flightNo);
		
		ModelAndView mAndV = new ModelAndView();
		
		if(flightBean!=null){
			mAndV.addObject("flightBean", flightBean);
		} else{
			String message = "No flight exists for entered Flight No : " + flightNo;
			mAndV.addObject("message", message);
		}
		
		mAndV.setViewName("OccupancyOnFlight");
	
		return mAndV;
	}
	
	//****************************************
	
	@RequestMapping("/getDateForOccupancy.do")
	public ModelAndView getDateForOccupancy() throws AirlineException{
		
		ModelAndView mAndV = new ModelAndView();
		LocalDate date = LocalDate.now();
		mAndV.addObject("today", date);
		
		mAndV.setViewName("OccupancyBetweenDate");
		return mAndV;
	}
	
	@RequestMapping(value="/getOccupancyOnDate.do", method=RequestMethod.POST)
	public ModelAndView getOccupancyOnDate(@RequestParam("start") String start,@RequestParam("end") String end)
			throws AirlineException{
		
		
		ModelAndView mAndV = new ModelAndView();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = format.parse(start);
			endDate = format.parse(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(startDate.compareTo(endDate)<=0){
			ArrayList<FlightInfoBean> flightList = executiveService.viewFlightOccupancyOnDate(startDate, endDate);
			
			if(flightList.isEmpty()){
				String message = "No flights found between entered dates";
				mAndV.addObject("message", message);
			} else{
				mAndV.addObject("startDate", startDate);
				mAndV.addObject("endDate", endDate);
				mAndV.addObject("flightList", flightList);
			}
		} else{
			String message = "Please ensure Start Date is less than or equal to End Date.";
			mAndV.addObject("message", message);
		}
		
		mAndV.setViewName("OccupancyBetweenDate");
	
		return mAndV;
	}
}
