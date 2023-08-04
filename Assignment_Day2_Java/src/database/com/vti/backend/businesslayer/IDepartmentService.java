package database.com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import database.com.vti.entity.Department;

public interface IDepartmentService {
	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException;

	public Department getDepByID(int id) throws ClassNotFoundException, SQLException;

	public Boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException;

	public boolean createDep(String name) throws ClassNotFoundException, SQLException;

	public boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException;

	public boolean delDepByID(int id) throws ClassNotFoundException, SQLException;

}
