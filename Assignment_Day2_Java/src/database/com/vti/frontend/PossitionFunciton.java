package database.com.vti.frontend;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import database.com.vti.backend.presentationlayer.PossitionController;
import database.com.vti.entity.Position;
import database.com.vti.ultis.ScannerUltis;
public class PossitionFunciton {
	public static void getListPossition()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		PossitionController possitionController = new PossitionController();
		List<Position> listpos1 = possitionController.getListPosition();
		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Possition  Name       |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Position possition : listpos1) {
			System.out.format(leftAlignFormat, possition.getId(), possition.getName());
		}
		System.out.format("+--------+-----------------------+%n");

	}

	public static void getPossitonByID()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		PossitionController possitionController = new PossitionController();
		System.out.println("Tìm kiếm phòng theo ID: ");
		System.out.println("Nhập vào ID cần tìm kiếm: ");
		int idFind = ScannerUltis.inputIntPositive();
		Position pos = possitionController.getPosByID(idFind);
		if (pos != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   |  Possition Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, pos.getId(), pos.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tồn tại");
		}
	}

}
