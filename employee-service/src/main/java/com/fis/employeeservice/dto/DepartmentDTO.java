package com.fis.employeeservice.dto;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fis.employeeservice.bean.Department;
import com.fis.employeeservice.bean.Employee;

public class DepartmentDTO{
	private static final Logger LOGGER = LoggerFactory.getLogger(Department.class);

	private int id;

	private String name;

	private Set<Employee> employeeList;

	public DepartmentDTO() {
		LOGGER.debug("Inside Department Constructor.");

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", name=" + name + "]";
	}

}
