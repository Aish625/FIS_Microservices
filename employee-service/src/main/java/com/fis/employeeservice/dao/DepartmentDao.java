package com.fis.employeeservice.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.fis.employeeservice.EmployeeConstants;
import com.fis.employeeservice.bean.Department;
//import com.fis.springlearn.SpringLearnConstants;
@Component
public class DepartmentDao {
	
	static ArrayList<Department> DEPARTMENT_LIST;
	public ArrayList<Department> getAllDepartments(){
		EmployeeConstants.LOGGER.debug("Inside DepartmentDao Constructor");
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = context.getBean("departmentList", ArrayList.class);
		for (Department department : DEPARTMENT_LIST) {
			EmployeeConstants.LOGGER.debug(department.toString());
		}
		return DEPARTMENT_LIST;
	}
}
