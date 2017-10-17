package com.cg.ars.services;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.ars.daos.BookingInfoDao;
import com.cg.ars.daos.FlightInfoDao;
import com.cg.ars.dtos.BookingInfoBean;
import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private FlightInfoDao flightInfoDao;
	
	@Resource
	private BookingInfoDao bookingInfoDao;
	
	//insert new flight into FlightInfoDao
	@Override
	public boolean createNewFlight(FlightInfoBean flightBean)
			throws AirlineException {
		
		boolean isFlightCreated = flightInfoDao.createNewFlight(flightBean);
		System.out.println(flightBean);
		
		return isFlightCreated;
	}


	//viewFlightDetailsOnId...FlightInfoDao
	@Override
	public FlightInfoBean viewFlightDetailsOnId(int flightNo)
			throws AirlineException {
		
		FlightInfoBean flightBean = flightInfoDao.getFlightDetailsOnId(flightNo);
		
		return flightBean;
	}
	
	//viewBookingListOnFlightNo...BookingInfoDao...to see whether booking exists on a flightNo or not
	@Override
	public ArrayList<BookingInfoBean> viewBookingListOnFlightNo(int flightNo)
			throws AirlineException {
		
		ArrayList<BookingInfoBean> bookingList = bookingInfoDao.getBookingListOnFlightNo(flightNo);
		
		return bookingList;
	}

	
	//remove a flight having no bookings
	@Override
	public boolean removeFlight(int flightNo) throws AirlineException {
		
		boolean isFlightRemoved = false;
		//retrieve relevant details of that flight
		FlightInfoBean flightBean = flightInfoDao.getFlightDetailsOnId(flightNo);
		int bussSeats = flightBean.getBussSeats();
		int bussSeatsAvailable = flightBean.getBussSeatsAvailable();
		int firstSeats = flightBean.getFirstSeats();
		int firstSeatsAvailable = flightBean.getFirstSeatsAvailable();
	
		//check whether booking has been made on this flight or not
		if(bussSeats == bussSeatsAvailable && firstSeats == firstSeatsAvailable)
		{
			isFlightRemoved = flightInfoDao.removeFlight(flightNo);
		} else
		{
			System.out.println("Bookings have been made on this flight");  //check
			isFlightRemoved = false;
		}
			return isFlightRemoved;
	}

	//update flightDetails
	@Override
	public boolean updateFlightDetails(FlightInfoBean flightBean)
			throws AirlineException {
		
		boolean isFlightUpdated = flightInfoDao.updateFlightDetails(flightBean);
		
		return isFlightUpdated;
	}

	
}
