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
import org.springframework.web.bind.annotation.RestController;

import com.attract.InstitutionDemo.Entity.Department;
import com.attract.InstitutionDemo.Service.DepartmentServiceImpl;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentServiceImpl departmentServiceImpl;
	
	public DepartmentController() {
	}
	
	@GetMapping("")
	public List<Department> getEmployees() {
		return departmentServiceImpl.findAll();
	}
	
	@GetMapping("/{departmentId}")
	public Department getEmployees(@PathVariable int departmentId) {
		return departmentServiceImpl.findById(departmentId);
	}
	
	@PostMapping("")
	public Department saveEmployee(@RequestBody Department department) {
		return departmentServiceImpl.save(department);
	}
	
	@DeleteMapping("/{departmentId}")
	public void deleteDepartment(@PathVariable int departmentId) {
		System.out.println(">>>>>>>>>>>"+departmentId);
		departmentServiceImpl.delete(departmentId);
	}
	
	@PutMapping("")
	public Department updateDepartment(@RequestBody Department department) {
		return departmentServiceImpl.save(department);
	}
}
