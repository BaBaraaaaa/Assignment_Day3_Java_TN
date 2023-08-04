package database.com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import database.com.vti.backend.businesslayer.DepartmentService;
import database.com.vti.backend.businesslayer.IDepartmentService;
import database.com.vti.entity.Department;

public class DepartmentController {
	private IDepartmentService departmenttService;

	public DepartmentController() throws FileNotFoundException, IOException {
		departmenttService = new DepartmentService();

	}

	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException {

		return departmenttService.getListDepartment();

	}

	public Department getDepByID(int id) throws ClassNotFoundException, SQLException {

		return departmenttService.getDepByID(id);
	}
	

	public Boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
		
		return departmenttService.isDepartmentNameExists(name);
	}


	public boolean createDep(String name) throws ClassNotFoundException, SQLException {
		
		return departmenttService.createDep(name);
	}


	public boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
		
		return departmenttService.updateDepartmentName(id, newName);
	}


	public boolean delDepByID(int id) throws ClassNotFoundException, SQLException {
		
		return departmenttService.delDepByID(id);
	}

}
