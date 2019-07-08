package com.attract.InstitutionDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.attract.InstitutionDemo.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee> {

	
}
