package com.attract.InstitutionDemo.Service;

import java.util.List;

import com.attract.InstitutionDemo.Entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();//Get Mapping
	
	public Employee findById(Integer rowId);//GetMapping
	
	public Employee save(Employee employee);//PostMapping & PutMapping
	
	public void deleteById(int id);//DeleteMapping

}
