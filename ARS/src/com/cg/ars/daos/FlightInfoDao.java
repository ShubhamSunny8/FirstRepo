package com.cg.ars.daos;

import java.util.ArrayList;
import java.util.Date;

import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;

public interface FlightInfoDao {

	//adminService
		public boolean createNewFlight(FlightInfoBean flightBean) throws AirlineException;
		
		//userService
		public ArrayList<FlightInfoBean> 
		getFlightList(String depCity,String arrCity, Date depDate) throws AirlineException;
		
		
		//executiveService and userService
		public FlightInfoBean getFlightDetailsOnId(int flightNo)
				throws AirlineException;
		
		
		//executiveService
		public ArrayList<FlightInfoBean> getFlightListOnDate(Date startDepDate, Date endDepDate)
				throws AirlineException;
		
		//userService
		public boolean updateSeatsOnBooking(int flightNo, String classType, int noOfPassengers) 
				throws AirlineException;
		
		//userService
		public boolean updateSeatsOnCancellation(int flightNo, String classType, int noOfPassengers) 
					throws AirlineException;
			
		//adminService
		public boolean removeFlight(int flightNo) throws AirlineException;
		
		//adminService
		public boolean updateFlightDetails(FlightInfoBean flightBean) throws AirlineException;
		
		//userService
		public ArrayList<String> getArrCityList() throws AirlineException;
		
		//userService
		public ArrayList<String> getDepCityList() throws AirlineException;
		
}
