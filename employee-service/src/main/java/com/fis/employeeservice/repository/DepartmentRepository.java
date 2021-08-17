package com.fis.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.employeeservice.bean.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
