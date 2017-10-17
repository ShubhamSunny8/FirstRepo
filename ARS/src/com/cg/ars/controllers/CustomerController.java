package com.cg.ars.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.ars.dtos.BookingInfoBean;
import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;
import com.cg.ars.services.CustomerService;

@Controller
public class CustomerController {

	@Resource
	CustomerService customerService;
	
	@RequestMapping("/getCustomerHomePage.do")
	public ModelAndView getHomePage(){
		ModelAndView mAndV = new ModelAndView("CustomerInterface");
		return mAndV;
	}
	
	@RequestMapping("/getBookFlight.do")
	public ModelAndView getBookFlightPage() throws AirlineException{
		
		ModelAndView mAndV = new ModelAndView();
		
		ArrayList<String> arrCityList = customerService.getArrCityList();
		ArrayList<String> depCityList = customerService.getDepCityList();
		
		LocalDate date = LocalDate.now();
		
		mAndV.addObject("arrCityList", arrCityList);
		mAndV.addObject("depCityList", depCityList);
		mAndV.addObject("today", date);
		
		mAndV.setViewName("BookFlightPage");
		return mAndV;
	}
	
	
	@RequestMapping(value="/getFlightListForBooking.do", method=RequestMethod.POST)
	public ModelAndView getFlightListForBooking(@RequestParam("source") String depCity, @RequestParam("destination") String arrCity,
			@RequestParam("doj") String doj) throws AirlineException{
		
		String message = null;
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date depDate = null;
		try {
			depDate = format.parse(doj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ModelAndView mAndV = new ModelAndView();
		
		ArrayList<FlightInfoBean> flightList = customerService.viewFlightList(depCity, arrCity, depDate);
		
		if(flightList.isEmpty()){
			message = "No Flights for given Data.";
			mAndV.addObject("message", message);
			ArrayList<String> arrCityList = customerService.getArrCityList();
			ArrayList<String> depCityList = customerService.getDepCityList();
			
			LocalDate date = LocalDate.now();
			
			mAndV.addObject("arrCityList", arrCityList);
			mAndV.addObject("depCityList", depCityList);
			mAndV.addObject("today", date);
			mAndV.setViewName("BookFlightPage");
		} else{
			mAndV.addObject("flightList", flightList);
			mAndV.setViewName("ViewFlightList");
		}
		
	
		return mAndV;
	}
	
	@RequestMapping(value="/ViewFlightDetailsForBooking.do", method=RequestMethod.GET)
	public ModelAndView ViewFlightDetailsForBooking(@RequestParam("flightNo") int flightNo, HttpSession session) throws AirlineException{
		
		FlightInfoBean flightBean = customerService.viewFlightDetailsOnId(flightNo);
		
		
		ModelAndView mAndV = new ModelAndView();
		
		mAndV.addObject("flightBean", flightBean);
		mAndV.setViewName("ViewFlightDetails");
		
		session.setAttribute("flightNo", flightNo);
		
		
	
		return mAndV;
	}
	
	@RequestMapping(value="/getFarePage.do", method=RequestMethod.POST)
	public ModelAndView getFarePage(@RequestParam("class") String classType,
			@RequestParam("noOfPassengers") int noOfPassengers, HttpSession session) throws AirlineException{
		
		int flightNo = (int) session.getAttribute("flightNo");
		System.out.println(flightNo); //check
		
		float totalFare = 0;
		ModelAndView mAndV = new ModelAndView();
		session.setAttribute("classType", classType);
		session.setAttribute("noOfPassengers", noOfPassengers);
		
		FlightInfoBean flightBean = customerService.viewFlightDetailsOnId(flightNo);
		
		
		
		if("BUSINESS".equals(classType))
		{
			int bussSeatsAvailable = flightBean.getBussSeatsAvailable();
			if(noOfPassengers <= bussSeatsAvailable)
			{
				totalFare = customerService.generateTotalFare(flightNo, classType, noOfPassengers);
				System.out.println(totalFare);   //check
				mAndV.setViewName("FareDetailsPage");
			}
			else
			{
				String message = "Seats not available for the given number of passengers.";
				mAndV.addObject("message", message);
				mAndV.addObject("flightBean", flightBean);
				mAndV.setViewName("ViewFlightDetails");
			}
		}
		else if("FIRST".equals(classType))
		{
			int firstSeatsAvailable = flightBean.getFirstSeatsAvailable();
			if(noOfPassengers <= firstSeatsAvailable)
			{
				totalFare = customerService.generateTotalFare(flightNo, classType, noOfPassengers);
				System.out.println(totalFare);   //check
				mAndV.setViewName("FareDetailsPage");
			}
			else
			{
				String message = "Seats not available for the given number of passengers.";
				mAndV.addObject("message", message);
				mAndV.addObject("flightBean", flightBean);
				mAndV.setViewName("ViewFlightDetails");
			}		
		}
		
		session.setAttribute("totalFare", totalFare);
	
		return mAndV;
	}
	
	@RequestMapping(value="/getSuccessBookingPage.do", method=RequestMethod.POST)
	public ModelAndView getSuccessBookingPage(@RequestParam("custEmail") String custEmail,
									  @RequestParam("creditCardInfo") String creditCardInfo, 
									  HttpSession session) throws AirlineException{
		
		
		int flightNo = (int) session.getAttribute("flightNo");
		int noOfPassengers = (int) session.getAttribute("noOfPassengers");
		String classType = (String) session.getAttribute("classType");
		float totalFare = (float) session.getAttribute("totalFare");
		String userName = (String) session.getAttribute("userName");
		System.out.println(userName);
		
		FlightInfoBean flightBean = customerService.viewFlightDetailsOnId(flightNo);
		
		BookingInfoBean bookingBean = new BookingInfoBean();
		
		
		bookingBean.setFlightNo(flightNo);
		bookingBean.setCustEmail(custEmail);
		bookingBean.setNoOfPassengers(noOfPassengers);
		bookingBean.setClassType(classType);
		bookingBean.setDepDate(flightBean.getDepDate());
		bookingBean.setArrDate(flightBean.getArrDate());
		bookingBean.setDepTime(flightBean.getDepTime());
		bookingBean.setArrTime(flightBean.getArrTime());
		bookingBean.setTotalFare(totalFare);
		bookingBean.setCreditCardInfo(creditCardInfo);
		bookingBean.setSrcCity(flightBean.getDepCity());
		bookingBean.setDestCity(flightBean.getArrCity());
		bookingBean.setUserName(userName);
		
		
		
		ModelAndView mAndV = new ModelAndView();
		int bookingId = customerService.bookFlight(bookingBean);
		
		session.setAttribute("bookingId", bookingId);
		
		mAndV.setViewName("SuccessBookingPage");
		
		return mAndV;
	}
	
	// *********************************************
	
	@RequestMapping("/getBookingIdEntryPage.do")
	public ModelAndView getBookingIdEntryPage(){
		ModelAndView mAndV = new ModelAndView("BookingDetailsOnId");
		return mAndV;
	}
	
	@RequestMapping(value="/showBookingDetailsPage.do", method=RequestMethod.POST)
	public ModelAndView showBookingDetailsPage(@RequestParam("bookingId") int bookingId,
			HttpSession session) throws AirlineException{
		
		String userName = (String) session.getAttribute("userName");
		
		BookingInfoBean bookingBean = customerService.viewBookingOnId(bookingId,userName);
		System.out.println(bookingBean);
		
		ModelAndView mAndV = new ModelAndView();
		
		if(bookingBean != null){
			mAndV.addObject("bookingBean", bookingBean);
			
		} 
		else{
			String message = "No bookings available on the Id : " + bookingId;
			mAndV.addObject("message", message);
		}
		
		mAndV.setViewName("BookingDetailsOnId");
		
		return mAndV;
	}
	
	// *********************************************
	

	@RequestMapping("/getCancelIdEntryPage.do")
	public ModelAndView getCancelIdEntryPage(){
		ModelAndView mAndV = new ModelAndView("CancelBookingOnId");
		return mAndV;
	}
	
	@RequestMapping(value="/showCancelDetailsPage.do", method=RequestMethod.POST)
	public ModelAndView showCancelDetailsPage(@RequestParam("bookingId") int bookingId,
			HttpSession session) throws AirlineException{
		
		String userName = (String) session.getAttribute("userName");
		
		BookingInfoBean bookingBean = customerService.viewBookingOnId(bookingId,userName);
		System.out.println(bookingBean);
		
		ModelAndView mAndV = new ModelAndView();
		
		if(bookingBean != null){
			mAndV.addObject("bookingBean", bookingBean);
			
		} 
		else{
			String message = "No bookings available on the Id : " + bookingId;
			mAndV.addObject("message", message);
		}
		
		mAndV.setViewName("CancelBookingOnId");
		
		return mAndV;
	}
	
	@RequestMapping(value="/CancelBooking.do", method=RequestMethod.POST)
	public ModelAndView CancelBooking(@RequestParam("bookingId") int bookingId,
			HttpSession session) throws AirlineException{
		
		String userName = (String) session.getAttribute("userName");
		
		Boolean isCancelled = customerService.cancelBookingOnId(bookingId, userName);
				
		ModelAndView mAndV = new ModelAndView();
		
		if(isCancelled){
			String message = "Booking with Id :" + bookingId + " cancelled successfully";
			mAndV.addObject("message", message);
			
		} 
		else{
			String message = "There was an error while cancelling the Booking Id : " + bookingId;
			mAndV.addObject("message", message);
		}
		
		mAndV.setViewName("CancelBookingOnId");
		
		return mAndV;
	}
	
}
