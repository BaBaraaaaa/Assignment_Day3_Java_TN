package Cau3;

import java.util.Scanner;

public class CongNhan extends CanBo{
	

	private int Bac;

	public int getBac() {
		return Bac;
	}

	public void setBac(int bac) {
		this.Bac = bac;
	}
	public CongNhan(String name, String gioiTinh, String diaChi,int Bac) {
		super(name, gioiTinh, diaChi);
		this.Bac= Bac;
	}
	public CongNhan() {}

	@Override
	public void Nhap() {
		super.Nhap();
		System.out.printf("Nhap Cap bac");
		Scanner sc = new Scanner(System.in);
		this.Bac = Integer.parseInt(sc.nextLine());
	}

	@Override
	public void Xuat() {
		super.Xuat();
		System.out.println(" Cap bac: " + this.Bac );
	}
	
	
}
