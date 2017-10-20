package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	@Query("SELECT e.firstName FROM Employee e where e.employeeId = :id") 
    String findEmployeeById(@Param("id") Long id);
}