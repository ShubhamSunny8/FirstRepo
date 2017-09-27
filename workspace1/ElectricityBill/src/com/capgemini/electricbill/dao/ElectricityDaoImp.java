package com.capgemini.electricbill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;




import com.capgemini.electricbill.bean.Customer;
import com.capgemini.electricbill.exception.Electricbillexception;
import com.capgemini.electricbill.utility.DbConnection;


public class ElectricityDaoImp implements ElectricityDao {
	public ArrayList viewList() throws Electricbillexception, SQLException, NamingException {
		ArrayList<Customer> list = new ArrayList<>();
		Connection connect=DbConnection.getConnection();
		Statement stmt=connect.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from Consumers");
		//System.out.println(rs.next());
		while(rs.next()){
		int num=rs.getInt("consumer_num");
				String name=rs.getString("consumer_name");
		String address=rs.getString("address");
				list.add(new Customer(num,name,address));
				System.out.println(num+" "+name+" "+address+" ");
	}
	System.out.println(list);
	return list;
	}

	@Override
	public Customer getCustomerbyId(int id) throws Electricbillexception,
			SQLException, NamingException {
		Connection connect=DbConnection.getConnection();
		Statement stmt=connect.createStatement();
		 Customer csp=null;
		  ResultSet rs=null;
		  String qry="Select consumer_num,consumer_name,address from Consumers where consumer_num=?";
		  try(PreparedStatement stat=connect.prepareStatement(qry);)
		  {
				
			  stat.setInt(1,id);
			  rs=stat.executeQuery();
				  if(rs.next())
				  {
					 String name=rs.getString("consumer_name");
					 String address=rs.getString("address");
					 csp=new Customer(id,name,address);
				  }
			}catch(SQLException e)
			  {
				
				  throw new Electricbillexception("Problem in reading Table",e);
			  }
		  finally{
					  if(rs!=null)
					  {
						  try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  }
		 		}
		  System.out.println(csp+"object>>>>>>>>>>>>>>>>");
		  return csp;
	}
}
	

