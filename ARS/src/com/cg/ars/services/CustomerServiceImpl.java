package com.cg.ars.services;


import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.ars.daos.BookingInfoDao;
import com.cg.ars.daos.FlightInfoDao;
import com.cg.ars.daos.UsersDao;
import com.cg.ars.dtos.BookingInfoBean;
import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.dtos.UsersBean;
import com.cg.ars.exceptions.AirlineException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private UsersDao usersDao;
	
	@Resource
	private FlightInfoDao flightInfoDao;
	
	@Resource
	private BookingInfoDao bookingInfoDao;
	
	
	
	//UsersDao...sign up, considering userName is unique
	@Override
	public boolean addNewCustomer(UsersBean usersBean) throws AirlineException {
		
		boolean	isCustomerAdded = usersDao.addNewCustomer(usersBean);

		return isCustomerAdded;
	}
	
	
	//FlightInfoDao
	@Override
	public ArrayList<String> getDepCityList() throws AirlineException {
		
		ArrayList<String> depCityList = flightInfoDao.getDepCityList();
		
		return depCityList;
	}

	//FlightInfoDao
	@Override
	public ArrayList<String> getArrCityList() throws AirlineException {

		ArrayList<String> arrCityList = flightInfoDao.getArrCityList();
		
		return arrCityList;
	}

	//FlightInfoDao
	@Override
	public ArrayList<FlightInfoBean> viewFlightList(String depCity,
			String arrCity, Date depDate) throws AirlineException {
		
		ArrayList<FlightInfoBean> flightList = flightInfoDao.getFlightList(depCity, arrCity, depDate);
		return flightList;
	}

	//FlightInfoDao
	@Override
	public FlightInfoBean viewFlightDetailsOnId(int flightNo)
			throws AirlineException {
		
		FlightInfoBean flightBean = flightInfoDao.getFlightDetailsOnId(flightNo);
	
		return flightBean;
	}

	
	//generate Total Fare...CustomerService
	@Override
	public float generateTotalFare(int flightNo, String classType,
			int noOfPassengers) throws AirlineException {
		
		float baseFare = 0;
		float totalFare = 0;
		FlightInfoBean flightBean = new FlightInfoBean();
		
		try {
			flightBean = flightInfoDao.getFlightDetailsOnId(flightNo);
			
			if("FIRST".equals(classType)){
				baseFare = flightBean.getFirstSeatFare();
			}
			else if("BUSINESS".equals(classType)){
				baseFare = flightBean.getBussSeatFare();
			}
			else{
				throw new AirlineException("Not a correct class type.");
			}
			totalFare = baseFare * noOfPassengers;
			
		} catch (AirlineException e) {
			throw new AirlineException("Problem in generating fare", e);
		}
		return totalFare;
		
		}
	
	
	//bookFlight...insert into BookingInfodao and update FlightInfoDao
	@Override
	public int bookFlight(BookingInfoBean bookingBean)
			throws AirlineException {
	
		//insert
		int bookingId = bookingInfoDao.createNewBooking(bookingBean);
		
		//update seats
		int flightNo = bookingBean.getFlightNo();
		String classType = bookingBean.getClassType();
		int noOfPassengers = bookingBean.getNoOfPassengers();
		boolean isUpdateSucc = flightInfoDao.updateSeatsOnBooking(flightNo, classType, noOfPassengers);
		
		if(isUpdateSucc == true){
			return bookingId;
			}
		else{
			throw new AirlineException("Problem in booking ticket");
		}
	}
	
	//BookingInfoDao
	@Override
	public BookingInfoBean viewBookingOnId(int bookingId, String userName)
			throws AirlineException {
		
		return bookingInfoDao.getBookingOnId(bookingId, userName);
	}

	//cancelBookingOnId...delete from BookingInfoDao and update FlightInfoDao
	@Override
	public boolean cancelBookingOnId(int bookingId, String userName) throws AirlineException {
		
		//get booking details on id
		BookingInfoBean bookingBean = bookingInfoDao.getBookingOnId(bookingId, userName);
		int flightNo = bookingBean.getFlightNo();
		String classType = bookingBean.getClassType();
		int noOfPassengers = bookingBean.getNoOfPassengers();
		
		//remove booking
		boolean isBookingCancelled = bookingInfoDao.removeBookingOnId(bookingId);
		
		if(isBookingCancelled){
			//update seats in FlightInfoDao
			boolean isUpdateSucc = flightInfoDao.updateSeatsOnCancellation(flightNo, classType, noOfPassengers);
				
			return isUpdateSucc;
		}
		else{
			throw new AirlineException("Problem in cancelling booking");
		}
	}

	

	

	
}
