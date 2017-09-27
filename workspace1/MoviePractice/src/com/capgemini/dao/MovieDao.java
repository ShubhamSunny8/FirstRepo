package com.capgemini.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.capgemini.bean.MovieMaster;
import com.capgemini.exception.BookingException;


public interface MovieDao {
	public ArrayList<MovieMaster> getMoviebyId(String MovieId,String City) throws BookingException, SQLException, NamingException;
	public boolean update(String MovieId) throws BookingException, SQLException, NamingException;
}