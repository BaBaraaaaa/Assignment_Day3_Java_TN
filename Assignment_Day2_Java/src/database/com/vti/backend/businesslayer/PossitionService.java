package database.com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import database.com.vti.backend.datalayer.PossitionRepository;
import database.com.vti.entity.Position;

public class PossitionService  implements IPossitionService{
	private PossitionRepository possitionRepository;

	public PossitionService() throws FileNotFoundException, IOException {
		possitionRepository = new PossitionRepository();
	}

	@Override
	public List<Position> getListPosition() throws ClassNotFoundException, SQLException {

		return possitionRepository.getListPosition();
	}

	@Override
	public Position getPosByID(int id) throws ClassNotFoundException, SQLException {

		return possitionRepository.getPosByID(id);
	}

}
