package com.attract.InstitutionDemo.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.attract.InstitutionDemo.Entity.Employee;
import com.attract.InstitutionDemo.Entity.EmployeeDesignation;
import com.attract.InstitutionDemo.repository.EmployeeRepository;
import com.attract.InstitutionDemo.repository.EmployeeSpecification;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Integer rowId) {
		Optional<Employee> result = employeeRepository.findById(rowId);
		
		Employee employee = null;
		
		if(result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("No Record found for this Employee Id ::: "+ rowId);
		}
		
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
	
	//Queries using Specifications
	//TO DO :: Get Employees by department Id(foreign key) 
	// 2. Salary greater than some value 
	// 3. Order by Salary (Desc)
	@Override
	public List<Employee> findGtGivenSalaryByDepartment(Integer departmentId){
		return employeeRepository.findAll(new EmployeeSpecification(EmployeeSpecification.QueryFor.GtThanSalaryWithDepartmentIdDesc,departmentId,null));
	}
	
	//TO DO :: Get Employees by salary above some value
	// 2. Order by Employee Name
	@Override
	public List<Employee> findGtGivenSalary(){
		return employeeRepository.findAll(new EmployeeSpecification(EmployeeSpecification.QueryFor.GtThanSalaryAsc,null,null));
	}
	
	//TO DO : Employees list by employee designation
	@Override
	public List<Employee> findByDesignation(EmployeeDesignation designation){
		return employeeRepository.findAll(new EmployeeSpecification(EmployeeSpecification.QueryFor.byDesignation,null,designation));
	}
	
	//TO DO : Employee by id
	@Override
	public List<Employee> findByEmployeeId(Integer employeeId) {
		return employeeRepository.findAll(new EmployeeSpecification(EmployeeSpecification.QueryFor.byId,employeeId,null));
	}
	
}
