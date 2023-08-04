package database.com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import database.com.vti.entity.Position;

public interface IPossitionRepository {
	public List<Position> getListPosition()  throws SQLException ,ClassNotFoundException;
	public Position getPosByID(int id) throws ClassNotFoundException, SQLException ;

}
