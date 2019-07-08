package com.attract.InstitutionDemo.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.attract.InstitutionDemo.Entity.Department;
import com.attract.InstitutionDemo.Entity.Employee;
import com.attract.InstitutionDemo.Entity.EmployeeDesignation;
	
@SuppressWarnings("serial")
public class EmployeeSpecification implements Specification<Employee> {
	
	private Integer departmentId;
	private EmployeeDesignation designation;
	private QueryFor queryFor;
	
	public static enum QueryFor{
		GtThanSalaryAsc,
		GtThanSalaryWithDepartmentIdDesc, 
		byId,
		byDesignation
	}
	
	public EmployeeSpecification(QueryFor queryFor,Integer departmentId,EmployeeDesignation designation) {
		this.queryFor = queryFor;
		this.departmentId = departmentId;
		this.designation = designation;
	}

	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if(this.queryFor == QueryFor.GtThanSalaryAsc) {
			query.orderBy(criteriaBuilder.asc(root.get("firstName")));
			return criteriaBuilder.greaterThanOrEqualTo(root.<String> get("salary"),"5000");
		}else if(this.queryFor == QueryFor.GtThanSalaryWithDepartmentIdDesc) {
			query.orderBy(criteriaBuilder.desc(root.get("salary")));
			Join<Employee,Department> department = root.join("department");
			
			criteriaBuilder.greaterThanOrEqualTo(root.<String> get("salary"),"3000");
			
			return criteriaBuilder.equal(department.get("id"),this.departmentId);
		}else if(this.queryFor == QueryFor.byId) {
			return criteriaBuilder.equal(root.get("id"), this.departmentId);
		}else if(this.queryFor == QueryFor.byDesignation) {
			return criteriaBuilder.equal(root.get("employeeDesignation"), this.designation);
		}
		
		return null;
	}

}
