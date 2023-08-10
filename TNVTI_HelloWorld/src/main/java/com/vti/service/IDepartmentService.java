package com.vti.service;

import java.util.List;

import com.vti.com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;

public interface IDepartmentService {
	public List<Department> getAllDepartments();

	public Department getDepartmentByID(int id);

	public Department getDepartmentByName(String name);

	public void createDepartment(DepartmentFormForCreating form);

	public void updateDepartment(int id, DepartmentFormForUpdating form);

	public void deleteDepartment(int id);

	public boolean isDepartmentExistsByID(int id);

	public boolean isDepartmentExistsByName(String name);

}
