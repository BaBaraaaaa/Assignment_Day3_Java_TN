package Cau3;

import java.util.Scanner;

public class NhanVien extends CanBo{
	private String CongViec;
	
	public String getCongViec() {
		return CongViec;
	}

	public void setCongViec(String congViec) {
		CongViec = congViec;
	}
	public NhanVien(String name, String gioiTinh, String diaChi,String CongViec) {
		super(name, gioiTinh, diaChi);
		// TODO Auto-generated constructor stub
		this.CongViec = CongViec;
	}
	public NhanVien() {}
	@Override
	public void Nhap() {
		// TODO Auto-generated method stub
		super.Nhap();
		System.out.printf("Nhap Cong Viec");
		Scanner sc = new Scanner(System.in);
		this.CongViec = sc.nextLine();
	}

	@Override
	public void Xuat() {
		// TODO Auto-generated method stub
		super.Xuat();
		System.out.println(" Cong Viec: "+ this.CongViec);
	}

	
	

}
