package Cau3;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QLCB qlcb = new QLCB();
		Scanner sc = new Scanner(System.in);
	
		 int choice;

	        do {
	            System.out.println("\n---- CHƯƠNG TRÌNH QUẢN LÝ CÁN BỘ ----");
	            System.out.println("1. Thêm mới cán bộ.");
	            System.out.println("2. Tìm kiếm theo họ tên.");
	            System.out.println("3. Hiển thị danh sách cán bộ.");
	            System.out.println("4. Nhập vào tên cán bộ và xóa cán bộ đó.");
	            System.out.println("5. Thoát khỏi chương trình.");
	            System.out.print("Nhập lựa chọn của bạn (1-5): ");
	            choice = Integer.parseInt(sc.next());
	            
	            switch (choice) {
                case 1:
                    qlcb.ThemCanbo();
                    break;
                case 2:
                    qlcb.timKiemTheoHoTen();
                    break;
                case 3:
                    qlcb.ShowCanBo();
                    break;
                case 4:
             
                    qlcb.XoaTheoTen();
                    break;
                case 5:
                    System.out.println("Đã thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }

        } while (choice != 5);
	        sc.close();
	}

}
