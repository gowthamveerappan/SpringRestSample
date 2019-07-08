package com.attract.InstitutionDemo.Entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employees")
@Getter @Setter
@ToString
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "designation")
	private EmployeeDesignation employeeDesignation;
	
	@Column(name = "salary")
	private Double salary;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}) 
	@JoinColumn(name = "department_id",updatable = true,insertable = true)
	@JsonBackReference
	Department department;
	
	public Employee() {
	}
	
	public Employee(String firstName, String lastName, String email, EmployeeDesignation employeeDesignation,
			Double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeDesignation = employeeDesignation;
		this.salary = salary;
	}
	
}
