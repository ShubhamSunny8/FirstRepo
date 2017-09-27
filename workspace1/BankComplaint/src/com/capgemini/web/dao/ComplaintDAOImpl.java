package com.capgemini.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import com.capgemini.web.dto.ComplaintBean;
import com.capgemini.web.exception.ComplaintException;
import com.capgemini.web.util.DBUtil;

public class ComplaintDAOImpl implements IComplaintDAO {

	public int generateComplaintId() throws ComplaintException, SQLException, NamingException
	{
		int complaintId;
		try(Connection con=DBUtil.getConnection())
		{
			Statement stm =con.createStatement();
			ResultSet rs=stm.executeQuery("select complaintId_seq.nextVal from dual");
			if(rs.next()!= true)
			{
				throw new ComplaintException("could nt generate complaint id");
			}
			complaintId = rs.getInt(1);
		}
		return  complaintId;
	}
	@Override
	public int raiseComplaint(ComplaintBean complaint)
			throws ComplaintException {
	int complaintid=0;
	try(Connection con=DBUtil.getConnection())
	{
		complaintid =generateComplaintId();
		complaint.setId(complaintid);
		PreparedStatement psmt=con.prepareStatement("insert into Complaint values(?,?,?,?,?,?,?,?)");
		psmt.setInt(1, complaint.getId());
		psmt.setString(2,complaint.getCustomerName());
		psmt.setInt(3, complaint.getAccountId());
		psmt.setString(4,complaint.getCateogary());
		psmt.setDate(5, new java.sql.Date(complaint.getComplaintDate().getTime()));
		psmt.setString(6,complaint.getDescription());
		psmt.setString(7,complaint.getPriority());
		psmt.setString(8,complaint.getStatus());
		psmt.execute();
	}
	catch(Exception e)
	{
		throw new ComplaintException(e);
	}
	return complaintid;
	}

	@Override
	public ComplaintBean getComplaintStatus(int complaintId)
			throws ComplaintException, SQLException, NamingException {
		ComplaintBean complaint=null;
		try(Connection con=DBUtil.getConnection())
		{
			
			PreparedStatement psmt=con.prepareStatement("select * from Complaint where id=?");
			psmt.setInt(1,complaintId);
			ResultSet rs=psmt.executeQuery();
			if(rs.next()!=true)
			{
				throw new ComplaintException("no complaint with complaint id"+complaintId);
			}
			complaint =new ComplaintBean();
			complaint.setId(rs.getInt(1));
			complaint.setCustomerName(rs.getString(2));
			complaint.setAccountId(rs.getInt(3));
			complaint.setCateogary(rs.getString(4));
			complaint.setComplaintDate(rs.getDate(5));
			complaint.setDescription(rs.getString(6));
			complaint.setPriority(rs.getString(7));
			complaint.setStatus(rs.getString(8));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return complaint;
	}
	
	
}
