package com.capgemini.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.capgemini.dto.RechargeDAO;
import com.capgemini.dto.User;
import com.capgemini.exception.MobileException;
import com.capgemini.utility.DbConnection;





public class IRechargeServiceImp implements IRechargeService {
	//PreparedStatement preparedStatement = null;
	
	@Override
	public void addRecharge(User u) throws MobileException, NamingException, SQLException {
		Connection connect=DbConnection.getConnection();
			// TODO Auto-generated method stub
			String qry="insert into user_details (name,num) values(?,?)";
			int resAffected=0;
			try(PreparedStatement stmt=connect.prepareStatement(qry);)
				{
				stmt.setString(1,u.getName());
				stmt.setInt(2, u.getNum());
				resAffected=stmt.executeUpdate();
				}
			catch (SQLException e)
				{
				throw new MobileException("Problem in Inserting data"+e);
				}
			if(resAffected==1)
			{
				System.out.println("User Added");
			}
		
	}
	
	@Override
	public ArrayList<RechargeDAO> viewList() throws MobileException, SQLException, NamingException {
		ArrayList<RechargeDAO> list = new ArrayList<>();
		Connection connect=DbConnection.getConnection();
		Statement stmt=connect.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from newrecharge");
		//System.out.println(rs.next());
	while(rs.next()){
		int r=rs.getInt("rid");
		String nm =rs.getNString("rechargename");
		int am=rs.getInt("amount");
		int val=rs.getInt("vadidity");
		
				list.add(new RechargeDAO(r,nm,am,val));
				System.out.println(r+" "+nm+" "+am+" "+val);
	}
	System.out.println(list);
	return list;
	}
}
