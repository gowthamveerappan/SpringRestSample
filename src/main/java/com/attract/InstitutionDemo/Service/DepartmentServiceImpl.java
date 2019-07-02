package com.attract.InstitutionDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attract.InstitutionDemo.Entity.Department;
import com.attract.InstitutionDemo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}
	
	@Override
	public Department findById(int departmentId) {
		
		Optional<Department> result = departmentRepository.findById(departmentId);
		
		Department department = null;
		
		if(result.isPresent()) {
			department = result.get();
		}else {
			throw new RuntimeException("No Reecord found for this Department Id ::: "+ departmentId);
		}
		
		return department;
	}

	@Override
	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public void delete(int id) {
		departmentRepository.deleteById(id);
	}
}
