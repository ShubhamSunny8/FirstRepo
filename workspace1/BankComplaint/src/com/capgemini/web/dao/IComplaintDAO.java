package com.capgemini.web.dao;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.capgemini.web.dto.ComplaintBean;
import com.capgemini.web.exception.ComplaintException;

public interface IComplaintDAO {
	public int raiseComplaint(ComplaintBean complaint) throws  ComplaintException;
	public ComplaintBean getComplaintStatus(int complaintId) throws  ComplaintException, SQLException, NamingException;
}
