package com.attract.InstitutionDemo.Service;

import java.util.List;

import com.attract.InstitutionDemo.Entity.Employee;
import com.attract.InstitutionDemo.Entity.EmployeeDesignation;

public interface EmployeeService {

	public List<Employee> findAll();//Get Mapping
	
	public Employee findById(Integer rowId);//GetMapping
	
	public Employee save(Employee employee);//PostMapping & PutMapping
	
	public void deleteById(int id);//DeleteMapping
	
	public List<Employee> findGtGivenSalaryByDepartment(Integer departmentId);
	
	public List<Employee> findGtGivenSalary();
	
	public List<Employee> findByDesignation(EmployeeDesignation designation);
	
	public List<Employee> findByEmployeeId(Integer employeeId);

}
