package database.com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import database.com.vti.backend.datalayer.DepartmentRepository;
import database.com.vti.entity.Department;

public class DepartmentService implements IDepartmentService {
	private DepartmentRepository departmentRepository;

	public DepartmentService() throws FileNotFoundException, IOException {
		departmentRepository = new DepartmentRepository();
	}

	@Override
	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException {
		
		return departmentRepository.getListDepartment();
	}

	@Override
	public Department getDepByID(int id) throws ClassNotFoundException, SQLException {
		
		return departmentRepository.getDepByID(id);
	}

	@Override
	public Boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
		
		return departmentRepository.isDepartmentNameExists(name);
	}

	@Override
	public boolean createDep(String name) throws ClassNotFoundException, SQLException {
		
		return departmentRepository.createDep(name);
	}

	@Override
	public boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
		
		return departmentRepository.updateDepartmentName(id, newName);
	}

	@Override
	public boolean delDepByID(int id) throws ClassNotFoundException, SQLException {
		
		return departmentRepository.delDepByID(id);
	}

}
