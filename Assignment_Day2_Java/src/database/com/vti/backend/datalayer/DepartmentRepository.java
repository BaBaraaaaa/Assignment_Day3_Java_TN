package database.com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.com.vti.entity.Department;
import database.com.vti.ultis.jdbcUltis;

public class DepartmentRepository implements IDepartmentRepository {
	private jdbcUltis jdbc;

	public DepartmentRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Department> getListDepartment() throws SQLException, ClassCastException, ClassNotFoundException {
		String sql = "SELECT * FROM Department ORDER BY DepartmentID";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Department> listDep = new ArrayList<Department>();
		while (resultSet.next()) {
			Department dep = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
			listDep.add(dep);
		}
		jdbc.disConnection();
		return listDep;

	}

	@Override
	public Department getDepByID(int id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Department WHERE DepartmentID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet result = preStatement.executeQuery();
		if (result.next()) {
			Department dep = new Department(result.getInt("DepartmentID"), result.getNString("DepartmentName"));
			return dep;
		} else {
			jdbc.disConnection();
			return null;
		}
	}

	@Override
	public Boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Department WHERE DepartmentName = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, name);
		ResultSet result = preStatement.executeQuery();

		if (result.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean createDep(String name) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Department (DepartmentName) VALUES (?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, name);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
		Department depID = getDepByID(id);
		if (depID == null) {
			return false;
		} else {
			String sql = "UPDATE Department SET DepartmentName = ? WHERE (DepartmentID = ?);";
			PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
			preStatement.setNString(1, newName);
			preStatement.setInt(2, id);
			int result = preStatement.executeUpdate();
			if (result == 1) {
				jdbc.disConnection();
				return true;
			} else {
				jdbc.disConnection();
				return false;
			}

		}
	}

	@Override
	public boolean delDepByID(int id) throws ClassNotFoundException, SQLException {
		Department depID = getDepByID(id);
		if (depID == null) {
			return false;
		} else {
			String sql = "DELETE FROM department WHERE (DepartmentID = ?);";
			PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
			preStatement.setInt(1, id);
			int result = preStatement.executeUpdate();
			if (result == 1) {
				jdbc.disConnection();
				return true;
			} else {
				jdbc.disConnection();
				return false;
			}

		}
	}

}
