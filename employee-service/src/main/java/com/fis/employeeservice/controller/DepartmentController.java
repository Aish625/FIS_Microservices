package com.fis.employeeservice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.employeeservice.bean.Department;
import com.fis.employeeservice.service.DepartmentService;
@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/departments")
	public ArrayList<Department> getAllDepartments(){
		return departmentService.getAllDepartments();
	}
}

