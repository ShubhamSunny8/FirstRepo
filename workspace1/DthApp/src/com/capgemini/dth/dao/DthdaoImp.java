package com.capgemini.dth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.naming.NamingException;

import com.capgemini.dth.bean.Customer;
import com.capgemini.dth.exception.Dthexception;
import com.capgemini.dth.utility.DbConnection;




public class DthdaoImp implements Dthdao {
	@Override
	public Customer getCustomerbyId(String id) throws Dthexception,
			SQLException, NamingException {
		Connection connect=DbConnection.getConnection();
		Statement stmt=connect.createStatement();  
			Customer csp=new Customer();
		  String qry="Select * from subscriber_account_details where mobile_number=?";
		  PreparedStatement stat=connect.prepareStatement(qry);
		  Long n=Long.parseLong(id);
				System.out.println(n+">>");
			  stat.setLong(1,n);
			  System.out.println("hele1  "+stat);
			  ResultSet rs=stat.executeQuery();
			  System.out.println(rs+" "+ "hello1resukt set");
				 if(rs.next()){
					  long sid=rs.getLong("subscriber_ID");	 
					  String pid=rs.getString("package_id");
					 float fp=rs.getFloat("account_balance");
					 Date d=rs.getDate("rechargedate");
					 System.out.println(sid+" "+pid+" "+fp);
					 
					 csp=new Customer(sid,id,pid,fp,d);
		  System.out.println(csp+"object>>>>>>>>>>>>>>>>");
				 }
				 else{
					 System.out.println("false");
				 }
		  return csp;
}
	
	
	public boolean update(float amount,long id) throws Dthexception, NamingException, SQLException{
		Connection connect=DbConnection.getConnection();
		Statement stmt=connect.createStatement();  
		Customer csp=new Customer();
		String qry="UPDATE subscriber_account_details SET account_balance=? WHERE mobile_number=?";
		int recsAffected = 0;	
		try(
			PreparedStatement preparedStatement = connect.prepareStatement(qry);
		){
			preparedStatement.setFloat(1, amount);
			preparedStatement.setLong(2, id);
			System.out.println(qry);
			System.out.println(preparedStatement);
			recsAffected = preparedStatement.executeUpdate(); // 1 for successful insert
			System.out.println(recsAffected);
			if(recsAffected > 0){
				return true;
			}
			else{
				return false;
			}
			
		} catch (SQLException e) {
			throw new Dthexception("Problem in opening resources.");
		}
		
	
	}


	
}
		
		
		
		
		
		
	

