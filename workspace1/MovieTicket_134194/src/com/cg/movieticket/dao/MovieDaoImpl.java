package com.cg.movieticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.movieticket.bean.Ticket;
import com.cg.movieticket.exception.MovieException;
import com.cg.movieticket.utility.DbConnection;

public class MovieDaoImpl implements MovieDao {


	PreparedStatement preparedStatement = null;
	Connection conn = null;
	ResultSet resultSet = null;
	
	//for showing movie details
	@Override
	public ArrayList<Ticket> showMovieDetails(String city,String movie) throws MovieException {
		ArrayList<Ticket> list = new ArrayList<>();
		Ticket bean = null;
		String qry = "select * from MOVIE_MASTER where city=? and MOVIE_NAME=?";
		
		try {
			conn = DbConnection.getConnection();
			preparedStatement = conn.prepareStatement(qry);
			preparedStatement.setString(1, city);
			preparedStatement.setString(2, movie);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Inside DaoImpl");
			while (resultSet.next()){
				String movieId = resultSet.getString(1);
				String movieName = resultSet.getString(2);
				String theatreName = resultSet.getString(3);
				String theatreLocation = resultSet.getString(4);
				String cityName = resultSet.getString(5);
				String showTiming = resultSet.getString(6);
				String status = resultSet.getString(7);
				
				//insertion in list
				bean = new Ticket(movieId, movieName, theatreName, theatreLocation, cityName, showTiming, status);
				list.add(bean);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new MovieException("SQL Error"+e);
		} finally {	//closing resources
			try {
				if (conn != null) {
					preparedStatement.close();
					conn.close();
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MovieException("Could not close the connection"+e);
			}
		}
		System.out.println("DaoImpl Done");
		return list;
		
	
	}

	
	//for updating the status

	@Override
	public boolean updateStatus(String movieId) throws MovieException {
		int recAffected = 0;
		String qry = "update MOVIE_MASTER set STATUS=? where MOVIE_ID=?";
		String stat = "NotAvailable";
		
		try {
			conn = DbConnection.getConnection();
			preparedStatement = conn.prepareStatement(qry);
			preparedStatement.setString(1, stat);
			preparedStatement.setString(2, movieId);
			recAffected = preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new MovieException("SQL error while updation"+e);
		} finally {		//closing resources
			try {
				if (conn != null) {
					preparedStatement.close();
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MovieException("Could not close the connection"+e);
			}
		}
		
		return (recAffected==0)?true:false;
	}

	

}
