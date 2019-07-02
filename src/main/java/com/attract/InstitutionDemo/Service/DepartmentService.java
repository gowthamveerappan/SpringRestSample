package com.attract.InstitutionDemo.Service;

import java.util.List;

import com.attract.InstitutionDemo.Entity.Department;

public interface DepartmentService {

	public List<Department> findAll();//GetMapping
	
	public Department findById(int id);//GetMapping
	
	public Department save(Department department);//PostMapping  && PutMapping
	
	public void delete(int id);//DeleteMapping

}
