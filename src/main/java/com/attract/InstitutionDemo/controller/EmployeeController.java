package com.attract.InstitutionDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attract.InstitutionDemo.Entity.Department;
import com.attract.InstitutionDemo.Entity.Employee;
import com.attract.InstitutionDemo.Service.DepartmentServiceImpl;
import com.attract.InstitutionDemo.Service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	DepartmentServiceImpl departmentServiceImpl;
	
	public EmployeeController() {
	}
	
	@GetMapping("")
	public List<Employee> getEmployees() {
		return employeeServiceImpl.findAll();
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployees(@PathVariable Integer employeeId) {
		return employeeServiceImpl.findById(employeeId);
	}
	
	@PostMapping("")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeServiceImpl.save(employee);
	}
	
	@PutMapping("")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeServiceImpl.save(employee);
	}
	
	@DeleteMapping("/{employeeId}")
	public void saveEmployee(@PathVariable int employeeId) {
		employeeServiceImpl.deleteById(employeeId);
	}
	
	@PutMapping("/mapEmployeeToDepartment")
	public Employee mapEmployeeToDepartment(@RequestParam int departmentId,@RequestParam int employeeId) {
		Employee employee = employeeServiceImpl.findById(employeeId);
		
		Department department = departmentServiceImpl.findById(departmentId);
		employee.setDepartment(department);
		
		return employeeServiceImpl.save(employee);
	}
	
	
}
