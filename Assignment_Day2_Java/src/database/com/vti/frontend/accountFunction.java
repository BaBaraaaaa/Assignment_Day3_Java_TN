package database.com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import database.com.vti.backend.presentationlayer.AccountController;
import database.com.vti.backend.presentationlayer.DepartmentController;
import database.com.vti.backend.presentationlayer.PossitionController;
import database.com.vti.entity.Account;
import database.com.vti.entity.Department;
import database.com.vti.entity.Position;
import database.com.vti.ultis.ScannerUltis;
public class accountFunction {
	public static void getListAllAccount()
			throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		AccountController accountControler = new AccountController();
		List<Account> listAcc1 = accountControler.getListAccounts();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

		for (Account acc : listAcc1) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullName(),
					acc.getDepartment(), acc.getPosition(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

	}

	public static void getAccountByID() throws Exception {
		System.out.println("Tìm kiếm Account theo ID: ");
		System.out.println("Nhập vào ID cần tìm kiếm: ");
		int idFind = ScannerUltis.inputIntPositive();
		AccountController accountControler = new AccountController();
		Account acc2 = accountControler.getAccountByID(idFind);
		if (acc2 != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(
					"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

			System.out.format(leftAlignFormat, acc2.getId(), acc2.getEmail(), acc2.getUsername(), acc2.getFullName(),
					acc2.getDepartment(), acc2.getPosition(), acc2.getCreateDate());

			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

		} else {
			System.out.println("Không tồn tại account này trên HT");
		}

	}

	public static void isAccNameExists()
			throws Exception {
		System.out.println("Kiểm tra tên account đã có trên hệ thông? ");
		System.out.println("Nhập vào tên cần kiểm tra: ");
		String nameCheck = ScannerUltis.inputString();
		AccountController accountControler = new AccountController();
		if (accountControler.isAccNameExists(nameCheck)) {
			System.out.println("Tên đã có trên hệ thống.");
		} else {
			System.out.println("Tên chưa có trên hệ thống.");
		}
	}

	public static void createAccount() throws ClassNotFoundException, SQLException, Exception {
		Account acc = new Account();
		System.out.println("Nhập vào Email: ");
		acc.setEmail(ScannerUltis.inputEmail());
		System.out.println("Nhập vào UserName: ");
		acc.setUsername(ScannerUltis.inputString());
		System.out.println("Nhập vào FullName: : ");
		acc.setFullName(ScannerUltis.inputString());
		System.out.println("Hãy chọn phòng nhân viên: ");
		int depId = getDep();
		System.out.println("Hãy chọn Position nhân viên: ");
		int posid = getPos();
		AccountController accountControler = new AccountController();
		if (accountControler.createAccount(acc, depId, posid)) {
			System.out.println("Tạo thành công: ");
			getListAllAccount();
		} else {
			System.out.println("Tạo không thành công, hãy kiểm tra lại");
		}
	}

	private static int getPos() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			PossitionController possitionControler = new PossitionController();
			List<Position> listpos = possitionControler.getListPosition();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : listpos) {
				System.out.format(leftAlignFormat, position.getId(), position.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn Position theo ID:");
			int choosePos = ScannerUltis.inputIntPositive();
			if (possitionControler.getPosByID(choosePos) != null) {
				return choosePos;
			} else {
				System.out.println("Không có Position này, hãy chọn lại: ");
			}
		}
	}

	private static int getDep() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			DepartmentController departmentControler = new DepartmentController();
			List<Department> listDep = departmentControler.getListDepartment();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Depament Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : listDep) {
				System.out.format(leftAlignFormat, department.getId(), department.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn phòng theo ID:");
			int chooseDep = ScannerUltis.inputIntPositive();
			if (departmentControler.getDepByID(chooseDep) != null) {
				return chooseDep;
			} else {
				System.out.println("Không có phòng này, hãy chọn lại: ");
			}
		}

	}

	public static void updateAccount() throws Exception {
		AccountController accountController = new AccountController();
		DepartmentController departmentController = new DepartmentController();
		while (true) {
			switch (getMenuQues6()) {
			case 1:
				int id = getidCase1();
				System.out.println("Nhập vào New Email: ");
				String newEmail = ScannerUltis.inputEmail();
				if (accountController.updateByEmai(id, newEmail)) {
					System.out.println("Update thành công.");
				} else {
					System.out.println("update không thành công, kiểm tra lại.");
				}
				break;
			case 2:
				int id2 = getidCase1();
				System.out.println("Nhập vào New UserName: ");
				String newUserName = ScannerUltis.inputString();
				if (accountController.updateByUserName(id2, newUserName)) {
					System.out.println("Update thành công.");
				} else {
					System.out.println("update không thành công, kiểm tra lại.");
				}
				break;
			case 3:
				int id3 = getidCase1();
				System.out.println("Nhập vào New FullName: ");
				String newFullName = ScannerUltis.inputString();
				if (accountController.updateByFullName(id3, newFullName)) {
					System.out.println("Update thành công.");
				} else {
					System.out.println("update không thành công, kiểm tra lại.");
				}
				break;
			case 4:
				int id4 = getidCase1();
				int idDep = getNewIDDep();
				if (accountController.updateByDepId(id4, idDep)) {
					System.out.println("Update thành công.");

				} else {
					System.out.println("Có lỗi xảy ra, Hãy kiểm tra lại");
				}
				break;
			case 5:
				int id5 = getidCase1();
				int idPos = getNewIDPos();
				if (accountController.updateByPosId(id5, idPos)) {
					System.out.println("Update thành công.");

				} else {
					System.out.println("Có lỗi xảy ra, Hãy kiểm tra lại");
				}
				break;
			case 6:
				return;
			}
		}

	}

	private static int getNewIDPos() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		PossitionController possitionControler = new PossitionController();
		System.out.println("Chọn Position:");
		while (true) {
			List<Position> listpos = possitionControler.getListPosition();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : listpos) {
				System.out.format(leftAlignFormat, position.getId(), position.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn ID của Position cần Update:");
			int id = ScannerUltis.inputIntPositive();
			if (possitionControler.getPosByID(id) != null) {
				return id;
			} else {
				System.out.println("Không có Position này, hãy nhập lại: ");
			}
		}
	}

	private static int getNewIDDep() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		System.out.println("Chọn phòng");
		while (true) {
			List<Department> listDep = departmentController.getListDepartment();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Depament Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : listDep) {
				System.out.format(leftAlignFormat, department.getId(), department.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn ID của phòng cần Update:");
			int id = ScannerUltis.inputIntPositive();
			if (departmentController.getDepByID(id) != null) {
				return id;
			} else {
				System.out.println("Không có phòng này, hãy nhập lại: ");
			}
		}
	}

	private static int getidCase1() throws Exception {
		while (true) {
			System.out.println("Nhập vào ID của account cần Update: ");
			int id = ScannerUltis.inputIntPositive();
			AccountController accountControler = new AccountController();
			if (accountControler.getAccountByID(id) != null) {
				return id;
			} else {
				System.out.println("Không có account này trên hệ thống, Nhập lại: ");
			}
		}

	}

	private static int getMenuQues6() {
		while (true) {
			System.out.println("Bạn muốn update trường nào??");
			System.out.println("1.Email, 2.UserName, 3.FullName, 4.Department, 5.Position, 6.Exit ");
			int i = ScannerUltis.inputIntPositive();
			if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
				return i;
			} else {
				System.out.println("Chọn lại: ");
			}
		}

	}

	public static void deleteById() throws Exception {
		AccountController accountController = new AccountController();
		int id = getIdDel();
		if (accountController.delAccByID(id)) {
			System.out.println("Xóa thành công");
		} else {
			System.out.println("Đã có lỗi xảy ra.");
		}
	}

	private static int getIdDel() throws Exception {
		AccountController accountController = new AccountController();
		while (true) {
			System.out.println("Nhập vào ID Account cần xóa: ");
			int id = ScannerUltis.inputIntPositive();
			if (accountController.getAccountByID(id) != null) {
				return id;
			} else {
				System.out.println("Không có Account này trên hệ thống, Nhập lại: ");
			}
		}
	}

}
