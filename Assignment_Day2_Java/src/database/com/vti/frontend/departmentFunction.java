package database.com.vti.frontend;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import database.com.vti.backend.presentationlayer.DepartmentController;
import database.com.vti.entity.Department;
import database.com.vti.ultis.ScannerUltis;
public class departmentFunction {
	public static void getListDepartment() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		List<Department> listDep1 = departmentController.getListDepartment();
		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Department department : listDep1) {
			System.out.format(leftAlignFormat, department.getId(), department.getName());
		}
		System.out.format("+--------+-----------------------+%n");
	}

	public static void getDepByID() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		System.out.println("Tìm kiếm phòng theo ID: ");
		System.out.println("Nhập vào ID cần tìm kiếm: ");
		int idFind = ScannerUltis.inputIntPositive();
		Department depQues3 = departmentController.getDepByID(idFind);
		if (depQues3 != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Department Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, depQues3.getId(), depQues3.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}

	}

	public static void isDepartmentNameExists()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		System.out.println("Kiểm tra tên phòng đã có trên hệ thông? ");
		System.out.println("Nhập vào tên cần kiểm tra: ");
		String nameCheck = ScannerUltis.inputString();
		Boolean checkResult = departmentController.isDepartmentNameExists(nameCheck);
		if (checkResult) {
			System.out.println("Tên đã có trên hệ thống.");
			getListDepartment();
		} else {
			System.out.println("Tên chưa có trên hệ thống.");
		}
	}

	public static void createDep() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		String newNameDep = getNewName();
		if (departmentController.createDep(newNameDep)) {
			System.out.println("Tạo thành công.");
			getListDepartment();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}

	private  static String getNewName() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		while (true) {
			System.out.println("Nhập vào tên phòng cần tạo: ");
			String newName = ScannerUltis.inputString();
			if (departmentController.isDepartmentNameExists(newName)) {
				System.out.println("Đã có phòng trên hệ thống");
			} else {
				return newName;
			}
		}
	}

	public static void updateDepartmentName() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		int updateID = getIdUpdate();
		System.out.println("Nhập vào tên cần Updare: ");
		String newName = ScannerUltis.inputString();
		if (departmentController.updateDepartmentName(updateID, newName)) {
			System.out.println("Update tên phòng thành công: ");
			getListDepartment();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}

	private static int getIdUpdate() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		while (true) {
			System.out.println("Nhập ID phòng cần thao tác: ");
			int id = ScannerUltis.inputIntPositive();
			Department dep = departmentController.getDepByID(id);
			if (dep == null) {
				System.out.println("Không có ID này trên HT");
			} else {
				return id;
			}
		}
	}

	public static void delDepByID() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		int updateID = getIdUpdate();
		if (departmentController.delDepByID(updateID)) {
			System.out.println("Xóa phòng thành công");
			getListDepartment();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}

}
