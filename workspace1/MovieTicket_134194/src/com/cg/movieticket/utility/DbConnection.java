package com.cg.movieticket.utility;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.movieticket.exception.MovieException;

public class DbConnection {

	public static Connection getConnection() throws MovieException {
		Connection conn = null;

		try {
			InitialContext ic = new InitialContext();
			System.out.println("hello inside conectiomn");
			DataSource ds = (DataSource) ic.lookup("java:/OracleDS");
			System.out.println("hello inside conectiomn2");
			conn = ds.getConnection();
		}

		catch (SQLException e) {
			throw new MovieException("SQL Error:"+e.getMessage());
		} catch (NamingException e) {
			throw new MovieException("message from DB/NamingExc:"
					+ e.getMessage());
		}
		return conn;
	}

}
