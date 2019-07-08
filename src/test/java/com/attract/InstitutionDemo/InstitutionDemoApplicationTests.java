package com.attract.InstitutionDemo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.attract.InstitutionDemo.Entity.Department;
import com.attract.InstitutionDemo.Entity.Employee;
import com.attract.InstitutionDemo.Entity.EmployeeDesignation;
import com.attract.InstitutionDemo.repository.DepartmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstitutionDemoApplicationTests {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Test
	public void contextLoads() {
		
		Department department = new Department("IT");
		
		Employee employee1 = new Employee("Lithvik","test","lithvik@gmail.com",EmployeeDesignation.ARCHITECT,2000.00);
		Employee employee2 = new Employee("Vaasudhev","test","vaasudhev@gmail.com",EmployeeDesignation.ASSOCIATE,3000.00);
		
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		department.setEmployees(employeeList);
		
		departmentRepository.save(department);
		
	}

}
