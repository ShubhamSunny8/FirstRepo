package com.cg.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.cg.hr.entities.Employee;
import com.cg.hr.exceptions.EmpException;
/*
 * component is super annotation
 * 1.@service annotation is used for service classes
 * 2.@Repository annotation is used for Dao classes
 * 3.@Controller is used for Controller classes
 * 4.@RestController is used for Restful Webservices
 * 
 * These sub annotations are for document purpose only just to document the nature of a bean
 * 
 */

//@Component("empDao")
@Repository("empDao")
@Scope("singleton") //prototype
@Lazy(false)
public class EmpDaoImpl implements EmpDao {

	@Resource
	private DataSource datasource;
	public EmpDaoImpl() {
		//procure data source
		System.out.println("in constructor of EmpDao Impl");
	}

	@Override
	public List<Employee> getAllEmps() throws EmpException {
		System.out.println("In getAllEmps() of empDaoImpl");
		List<Employee> empList =new ArrayList<>();
		try(Connection connect =datasource.getConnection();
			Statement stmt =connect.createStatement();
				ResultSet rs=stmt.executeQuery("select empno,ename,sal from emp");
				){
			while(rs.next()){
				int empNo=rs.getInt("empno");
				String empNm=rs.getString("ename");
				float empSal =rs.getFloat("SAL");
				
				Employee emp= new Employee(empNo,empNm,empSal);
				empList.add(emp);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
		
	}

	@Override
	public Employee getEmpOnId(int id) throws EmpException {
		 Employee emp=null;
		  ResultSet rs=null;
		  
		  String qry="Select empno,ename,sal from emp where empno=?";
		  try(Connection connect =datasource.getConnection();
				  PreparedStatement stat=connect.prepareStatement(qry);)
		  {
			stat.setInt(1, id);
			  rs=stat.executeQuery();
				  if(rs.next())
				  {
					 String empNm=rs.getString("ename");
					 float empSal=rs.getFloat("sal");
					 emp=new Employee(id,empNm,empSal);
				  }
			}catch(SQLException e)
			  {
				
				  throw new EmpException("Problem in reading Table",e);
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
		  return emp;
	}

}
