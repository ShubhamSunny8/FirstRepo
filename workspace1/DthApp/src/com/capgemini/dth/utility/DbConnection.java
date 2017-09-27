package com.capgemini.dth.utility;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DbConnection {
	public static Connection getConnection() throws  NamingException, SQLException {
		Connection conn = null;

	
			InitialContext ic = new InitialContext();
			System.out.println("HOGYE Connect0+++++++++++++++++++++");
			DataSource ds = (DataSource)ic.lookup("java:/OracleDS");
			conn = ds.getConnection();
			System.out.println("HOGYE Connect+++++++++++++++++++++");
		

	
	return conn;
}
}
