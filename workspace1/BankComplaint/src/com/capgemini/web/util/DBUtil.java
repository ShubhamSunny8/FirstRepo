package com.capgemini.web.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.capgemini.web.exception.ComplaintException;



public class DBUtil {

	public static Connection getConnection() throws ComplaintException, NamingException, SQLException {
		Connection conn = null;

	
			InitialContext ic = new InitialContext();
			System.out.println("HOGYE Connect0+++++++++++++++++++++");
			DataSource ds = (DataSource)ic.lookup("java:/OracleDS");
			conn = ds.getConnection();
			System.out.println("HOGYE Connect+++++++++++++++++++++");
		

	
	return conn;
}

}
