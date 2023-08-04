package Cau3;

import java.util.ArrayList;
import java.util.Scanner;

public class QLCB {
	private ArrayList<CanBo> dsCanbo;
	Scanner sc = new Scanner(System.in);

	public QLCB() {
		this.dsCanbo = new ArrayList<>();
	}

	public void ThemCanbo() {
		System.out.printf("Nhap Nhan Su Can Them");
		System.out.printf("1. Công Nhân : 2. Kỹ Sư : 3. Nhân Viên");

		int chon = sc.nextInt();
		switch (chon) {
		case 1:
			CanBo congnhan = new CongNhan();
			congnhan.Nhap();
			dsCanbo.add(congnhan);
			break;
		case 2:
			CanBo kysu = new KySu();
			kysu.Nhap();
			dsCanbo.add(kysu);
			break;
		case 3:
			CanBo nhanvien = new NhanVien();
			nhanvien.Nhap();
			dsCanbo.add(nhanvien);
			break;
		default:
			System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");

		}

	};

	public void timKiemTheoHoTen() {
		System.out.print("Nhập họ tên cán bộ cần tìm:");
		String hoTen = sc.nextLine();
		for (CanBo canbo : dsCanbo) {
			if (canbo.getName().equals(hoTen)) {
				System.out.println("Thông tin cán bộ có tên '" + hoTen + "':");
				canbo.Xuat();
				return;
			}
		}
		System.out.println("Không tìm thấy cán bộ có tên '" + hoTen + "'.");
	};

	public void ShowCanBo() {
		System.out.println("Danh sách các cán bộ:");
		if (dsCanbo.isEmpty()) {
			System.out.println("Danh sách rỗng ");
		} else {
			for (CanBo canBo : dsCanbo) {
				canBo.Xuat();
			}
		}
	};

	public void XoaTheoTen() {
		System.out.print("Nhập họ tên cán bộ cần xóa: ");
		String hoTen = sc.nextLine();
		for (CanBo canbo : dsCanbo) {
			if (canbo.getName().equals(hoTen)) {
				dsCanbo.remove(canbo);
				System.out.println("Đã xóa cán bộ có tên '" + hoTen + "'.");
				return;
			}

		}
		System.out.println("Không tìm thấy cán bộ có tên '" + hoTen + "'.");
	};

}
