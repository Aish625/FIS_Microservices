package com.fis.employeeservice.controller;

import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.employeeservice.EmployeeConstants;
import com.fis.employeeservice.bean.Employee;
import com.fis.employeeservice.bean.Skill;
import com.fis.employeeservice.dto.DepartmentDTO;
import com.fis.employeeservice.dto.EmployeeDTO;
import com.fis.employeeservice.dto.SkillDTO;
import com.fis.employeeservice.exception.EmployeeNotFoundException;
import com.fis.employeeservice.service.EmployeeService;
//import com.fis.springlearn.SpringLearnConstants;

//@Component
@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("employees")
public class EmployeeController {
	private EmployeeService employeeService;

	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		EmployeeConstants.LOGGER.debug("Inside EmployeeController Constructor");
		this.employeeService = employeeService;
	}

//	@GetMapping
//	public List<Employee> getAllEmployees() {
//		return employeeService.getAllEmployees();
//	}

	private EmployeeDTO[] transformEmployeeToDTO(List<Employee> employees) {
		EmployeeDTO[] employeesDTO = new EmployeeDTO[employees.size()];
		int i = 0;
		for (Employee emp : employees) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setId(emp.getId());
			employeeDTO.setName(emp.getName());
			employeeDTO.setPermanent(emp.isPermanent());
			employeeDTO.setDateOfBirth(emp.getDateOfBirth());
			employeeDTO.setSalary(emp.getSalary());
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setId(emp.getDepartment().getId());
			departmentDTO.setName(emp.getDepartment().getName());
			employeeDTO.setDepartment(departmentDTO);
			for (Skill skill : emp.getSkillList()) {
				SkillDTO skillDTO = new SkillDTO();
				skillDTO.setId(skill.getId());
				skillDTO.setName(skill.getName());
				if (employeeDTO.getSkillList() == null) {
					employeeDTO.setSkillList(new HashSet<SkillDTO>());
					employeeDTO.getSkillList().add(skillDTO);
				}
				employeeDTO.getSkillList().add(skillDTO);
			}
			employeesDTO[i] = employeeDTO;
			System.out.println(employeesDTO[i]);
			i++;

		}
		return employeesDTO;
	}

	@GetMapping
	public EmployeeDTO[] getAllEmployees() {
		return transformEmployeeToDTO(employeeService.getAllEmployees());
	}

	@PutMapping
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		int departmentId = employee.getDepartment().getId();
		employeeService.get(employee.getId());
		employeeService.save(employee);

	}

	@PostMapping
	public void addEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		employeeService.save(employee);
	}

	@GetMapping("{id}")
	public Employee getEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		return employeeService.get(id);
//		return employeeService.getEmployee(id);
	}
//
//	@PutMapping
//	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
//		employeeService.updateEmployee(employee);
//	}

}
