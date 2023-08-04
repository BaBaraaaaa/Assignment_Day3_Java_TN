package database.com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import database.com.vti.backend.businesslayer.IPossitionService;
import database.com.vti.backend.businesslayer.PossitionService;
import database.com.vti.entity.Position;

public class PossitionController {
	private IPossitionService possitionService;

	public PossitionController() throws FileNotFoundException, IOException {
		possitionService = new PossitionService();
	}

	public List<Position> getListPosition() throws ClassNotFoundException, SQLException {
		return possitionService.getListPosition();

	}

	public Position getPosByID(int id) throws ClassNotFoundException, SQLException {
		return possitionService.getPosByID(id);

	}

}
