package database.com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import database.com.vti.entity.Department;

public interface IDepartmentRepository {
	public List<Department> getListDepartment() throws SQLException, ClassCastException, ClassNotFoundException;

	public Department getDepByID(int id) throws SQLException, ClassCastException, ClassNotFoundException ;

	public Boolean isDepartmentNameExists(String name) throws SQLException, ClassCastException, ClassNotFoundException ;

	public boolean createDep(String name) throws SQLException, ClassCastException, ClassNotFoundException ;

	public boolean updateDepartmentName(int id, String newName) throws SQLException, ClassCastException, ClassNotFoundException ;

	public boolean delDepByID(int id) throws SQLException, ClassCastException , ClassNotFoundException;

}
