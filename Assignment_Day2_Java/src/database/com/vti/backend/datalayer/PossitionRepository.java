package database.com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.com.vti.entity.Position;
import database.com.vti.ultis.jdbcUltis;

public class PossitionRepository implements IPossitionRepository{
	private jdbcUltis jdbc;

	public PossitionRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Position> getListPosition() throws SQLException, ClassNotFoundException  {
		List<Position> listPosition = new ArrayList<Position>();
		String sql = "SELECT * FROM position";
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			Position pos = new Position(resultSet.getInt(1), resultSet.getString(2));
			listPosition.add(pos);
		}
		jdbc.disConnection();
		return listPosition;
	}

	@Override
	public Position getPosByID(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM position WHERE PositionID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet result = preStatement.executeQuery();
		if (result.next()) {
			Position pos = new Position(result.getInt(1), result.getString(2));
			return pos;
		} else {
			jdbc.disConnection();
			return null;
		}

	}


}
