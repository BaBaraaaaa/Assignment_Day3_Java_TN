package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.repository.IDepartmentRepository;
@Service
public class DepartmentService implements IDepartmentService {
	
	@Autowired
	private IDepartmentRepository departmentRepository;
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentByID(int id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id).get();
	}

	@Override
	public Department getDepartmentByName(String name) {
		// TODO Auto-generated method stub
		return departmentRepository.findByName(name);
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		Department dep = getDepartmentByID(id);
		departmentRepository.delete(dep);
	}

	@Override
	public boolean isDepartmentExistsByID(int id) {
		// TODO Auto-generated method stub
		return departmentRepository.existsById(id);
	}

	@Override
	public boolean isDepartmentExistsByName(String name) {
		// TODO Auto-generated method stub
		return departmentRepository.existsByName(name);
	}

	@Override
	public void createDepartment(DepartmentFormForCreating form) {
		// chuyển từ form sang entity
		// get author
		Department department = new Department(form.getName());
		departmentRepository.save(department);
		
	}

	@Override
	public void updateDepartment(int id, DepartmentFormForUpdating form) {
		// TODO Auto-generated method stub
		Department department = getDepartmentByID(id);
		department.setName(form.getName());
		departmentRepository.save(department);
		
	}

}
