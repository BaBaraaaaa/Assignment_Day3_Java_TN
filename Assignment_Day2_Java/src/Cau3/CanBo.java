package Cau3;

import java.util.Scanner;

/**
 * @author Thang
 *
 */
public class CanBo {
	private String Name;
	private String GioiTinh;
	private String DiaChi;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.GioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		this.DiaChi = diaChi;
	}

	public CanBo() {
	}

	public CanBo(String name, String gioiTinh, String diaChi) {
		this.Name = name;
		this.GioiTinh = gioiTinh;
		this.DiaChi = diaChi;
	}

	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap Ten");
		this.Name = sc.nextLine();
		System.out.println("Chon gioi Tinh ");
		System.out.println("1. Nam ; 2. Nữ 3. Khác");
		int a = Integer.parseInt(sc.nextLine());
		if (a == 1) {
			this.GioiTinh = "Nam";
		} else if (a == 2) {
			this.GioiTinh = "Nu";
		} else {
			this.GioiTinh = "Khac";
		}
		System.out.println("Nhap Dia Chi");
		this.DiaChi = sc.nextLine();

	}

	public void Xuat() {
		System.out.printf("Hoten: " + this.Name + " Gioi Tinh: " + this.GioiTinh + " Dia Chi: " + this.DiaChi);
	}

}
