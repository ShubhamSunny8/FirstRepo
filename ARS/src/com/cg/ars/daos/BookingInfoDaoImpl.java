package com.cg.ars.daos;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.ars.dtos.BookingInfoBean;
import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;

@Repository
public class BookingInfoDaoImpl implements BookingInfoDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public int createNewBooking(BookingInfoBean bookingInfoBean)
			throws AirlineException {
		
		manager.persist(bookingInfoBean);
		int bookingId = bookingInfoBean.getBookingId();
		return bookingId;
		
		
	}

	@Override
	public BookingInfoBean getBookingOnId(int bookingId, String userName)
			throws AirlineException {
		
		String strQry = "SELECT b FROM BookingInfoBean b WHERE b.bookingId=:bookingId AND b.userName=:userName";
		TypedQuery<BookingInfoBean> qry = manager.createQuery(strQry, BookingInfoBean.class);
		qry.setParameter("bookingId", bookingId);
		qry.setParameter("userName", userName);
		BookingInfoBean bookingBean;
		try {
			bookingBean = (BookingInfoBean) qry.getSingleResult();
		} catch (Exception e) {
			bookingBean = null;
		}
		return bookingBean;
	}

	@Override
	public boolean removeBookingOnId(int bookingId) throws AirlineException {
		
		BookingInfoBean bookingBean = manager.find(BookingInfoBean.class, bookingId);
		try {
			manager.remove(bookingBean);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public ArrayList<BookingInfoBean> getBookingListOnFlightNo(int flightNo)
			throws AirlineException {
		
		String strQry = "SELECT b FROM BookingInfoBean b WHERE b.flightNo=:flightNo";
		TypedQuery<BookingInfoBean> qry = manager.createQuery(strQry, BookingInfoBean.class);
		qry.setParameter("flightNo", flightNo);
		ArrayList<BookingInfoBean> bookingList = (ArrayList<BookingInfoBean>) qry.getResultList();
		
		return bookingList;
		
	}

}
