package com.cg.ars.services;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.ars.daos.BookingInfoDao;
import com.cg.ars.daos.FlightInfoDao;
import com.cg.ars.daos.UsersDao;
import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.dtos.UsersBean;
import com.cg.ars.exceptions.AirlineException;


@Service
@Transactional
public class ValidateServiceImpl implements ValidateService{

	@Resource
	private UsersDao usersDao;
	
	@Resource
	private FlightInfoDao flightInfoDao;
	
	@Resource
	private BookingInfoDao bookingInfoDao;
	
	
	//validate User...usersDao
	@Override
	public boolean validateUser(UsersBean usersBean) throws AirlineException {
		
		ArrayList<String> userNameList = usersDao.getUserNameList();
		boolean isExisting = false;
		if(userNameList.contains(usersBean.getUserName())){
			ArrayList<UsersBean> usersList = usersDao.getUsersList();
			UsersBean user1 = new UsersBean();
			for(UsersBean user : usersList){
				if(user.getUserName().equals(usersBean.getUserName())){
					user1 = user;
				}
					
			}
			if(user1.getPassword().equals(usersBean.getPassword()) && user1.getRole().equals(usersBean.getRole())){
				isExisting = true;
			}else{
				isExisting = false;
			}
		}
		return isExisting;
	}


	//FlightInfoDao
	@Override
	public boolean validateFlightNo(int flightNo) throws AirlineException {
		
		boolean isFlightNoValid = false;
		FlightInfoBean flightBean = flightInfoDao.getFlightDetailsOnId(flightNo);
		
		if(flightBean != null)
		{
			isFlightNoValid = true;
		} else
		{
			isFlightNoValid = false;
		}
			return isFlightNoValid;
	}


	//usersDao...userName unique validation
	@Override
	public boolean validateUserName(String userName) throws AirlineException {
		
		boolean isUserNameUnique = false;
		
		ArrayList<String> userNameList = usersDao.getUserNameList();
		if(userNameList.contains(userName))
		{
			isUserNameUnique =  false;
		} else
		{
			isUserNameUnique = true;
		}
		return isUserNameUnique;
	}

		
	
}
