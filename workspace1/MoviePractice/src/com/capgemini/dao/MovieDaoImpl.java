package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.capgemini.bean.MovieMaster;
import com.capgemini.exception.BookingException;
import com.capgemini.utility.DbConnection;

public class MovieDaoImpl implements MovieDao {

	

	@Override
	public ArrayList<MovieMaster> getMoviebyId(String MovieId,String City) throws BookingException,
			SQLException, NamingException {
		System.out.println("Connection in dao impl");
		Connection connect=DbConnection.getConnection();
		//Statement stmt=connect.createStatement(); 
		ArrayList n1=null;
	 	MovieMaster movie=null;
	 	ResultSet rs=null;
		String qry="Select * from movie_master where movie_name=? and city=?";
		try(PreparedStatement stat=connect.prepareStatement(qry);)
		  {
			System.out.println("prepatred Ststemnt done");
			  stat.setString(1, MovieId);
			  stat.setString(2, City);
			  rs=stat.executeQuery();
			 // System.out.println("rs next val is "+""+rs.next());
				  while(rs.next())
				  {
					  System.out.println("Result set is true");
					 String movie_id = rs.getString("movie_id");
					 String movie_name = rs.getString("movie_name");
					 String  theatre_name = rs.getString("theatre_name");
					 String theatre_location  = rs.getString("theatre_location");
					 String  city=rs.getString("city");
					 String show_timing=rs.getString("show_timing");
					 String  status=rs.getString("status");
					
					 movie=new MovieMaster(movie_id,movie_name,theatre_name,theatre_location,city,show_timing,status);
					 n1.add(movie);
				  }
				 
		  	}
		  System.out.println(n1);
		  return n1;
	}
	@Override
	public boolean update(String MovieId) throws BookingException,
			SQLException, NamingException {
		Connection connect=DbConnection.getConnection();
	 	int rs=0;
		String qry="update MOVIE_MASTER set STATUS='NotAvailable' where MOVIE_ID=?";
		try(PreparedStatement stat=connect.prepareStatement(qry);)
		  {
			System.out.println("prepatred Ststemnt done");
			  stat.setString(1, MovieId);
			  //stat.setString(2, City);
			  rs=stat.executeUpdate();
		  }catch (Exception e) {
			throw new BookingException("Not updated"+e.getMessage());
		}
		if(rs!=0){
			return true;
		}
		else return false;
}
}
