package com.attract.InstitutionDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attract.InstitutionDemo.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
