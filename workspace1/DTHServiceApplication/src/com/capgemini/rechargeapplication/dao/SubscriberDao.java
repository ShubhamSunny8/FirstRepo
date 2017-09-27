package com.capgemini.rechargeapplication.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.capgemini.rechargeapplication.bean.SubscriberBean;
import com.capgemini.rechargeapplication.exception.RechargeException;
import com.capgemini.rechargeapplication.util.ConnectionUtil;

public class SubscriberDao implements ISubscriberDao {
	
	@Override
	public SubscriberBean getAccountDetails(long mobileNumber)
			throws RechargeException {
		ConnectionUtil util = new ConnectionUtil();
		Connection connect = util.getConnection();
		SubscriberBean subscriberBean = null;
		String query = "SELECT * FROM subscriber_account_details WHERE mobile_number = ?";
		ResultSet resultSet = null;
		
		try(
			PreparedStatement preparedStatement = connect.prepareStatement(query);
		){
			preparedStatement.setLong(1, mobileNumber);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int subscriberId = resultSet.getInt("SUBSCRIBER_ID");
				String packageId = resultSet.getString("PACKAGE_ID");
				float accountBalance = resultSet.getFloat("ACCOUNT_BALANCE");
				Date sqlRechargeDate = resultSet.getDate("RECHARGEDATE");
				LocalDate rechargeDate = sqlRechargeDate.toLocalDate();
				subscriberBean = new SubscriberBean(subscriberId, mobileNumber, packageId, accountBalance, rechargeDate);
			}
			
		} catch (SQLException e) {
			throw new RechargeException("Problem in opening resources.");
		}
		return subscriberBean;
	}


	@Override
	public boolean updateAccountDetails(long subscriberId,float updatedAmount) throws RechargeException {
		ConnectionUtil util = new ConnectionUtil();
		Connection connect = util.getConnection();
		String query = "UPDATE subscriber_account_details SET account_balance=?,rechargedate=SYSDATE+30 WHERE subscriber_id=?";
		int recsAffected = 0;
		
		try(
			PreparedStatement preparedStatement = connect.prepareStatement(query);
		){
			preparedStatement.setFloat(1, updatedAmount);
			preparedStatement.setLong(2, subscriberId);
			recsAffected = preparedStatement.executeUpdate(); // 1 for successful insert
			
			if(recsAffected > 0){
				return true;
			}
			else{
				return false;
			}
			
		} catch (SQLException e) {
			throw new RechargeException("Problem in opening resources.");
		}
		
	}

	@Override
	public float getPackageAmount(String packageId) throws RechargeException {
		ConnectionUtil util = new ConnectionUtil();
		Connection connect = util.getConnection();
		float packageAmount = 0;
		String query = "SELECT package_amount FROM datasky_packages where package_id=?";
		ResultSet resultSet = null;
		
		try(
			PreparedStatement preparedStatement = connect.prepareStatement(query);
		){
			preparedStatement.setString(1, packageId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				packageAmount = resultSet.getFloat("package_amount");
			}
			
		} catch (SQLException e) {
			throw new RechargeException("Problem in opening resources.");
		}
		return packageAmount;
	}

}
