package com.attract.InstitutionDemo.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "department")
@Getter @Setter
@ToString
public class Department implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "department_name")
	private String departmentName;
	
	@OneToMany(mappedBy = "department", cascade =  {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST
			,CascadeType.REFRESH,CascadeType.REMOVE})
	@JsonManagedReference
	private List<Employee> employees;
	
	public Department(){}
	
	public Department(String departmentName) {
		this.departmentName = departmentName;
	}

}
