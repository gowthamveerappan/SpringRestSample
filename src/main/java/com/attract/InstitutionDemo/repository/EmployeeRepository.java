package com.attract.InstitutionDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attract.InstitutionDemo.Entity.Department;
import com.attract.InstitutionDemo.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
