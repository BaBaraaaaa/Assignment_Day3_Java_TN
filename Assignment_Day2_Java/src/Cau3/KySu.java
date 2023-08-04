package Cau3;

import java.util.Scanner;

public class KySu extends CanBo{
	private String NganhDaoTao;
	
	public String getNganhDaoTao() {
		return NganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		NganhDaoTao = nganhDaoTao;
	}

	public KySu(String name, String gioiTinh, String diaChi,String NghanhDaoTao) {
		super(name, gioiTinh, diaChi);
		// TODO Auto-generated constructor stub
		this.NganhDaoTao = NghanhDaoTao;
	}
	public KySu() {}

	@Override
	public void Nhap() {
		// TODO Auto-generated method stub
		super.Nhap();
		System.out.printf("Nhap Nghanh Dao Tao");
		Scanner sc = new Scanner(System.in);
		this.NganhDaoTao = sc.nextLine();
		
	}

	@Override
	public void Xuat() {
		// TODO Auto-generated method stub
		super.Xuat();
		System.out.println(" Cong Viec: "+ this.NganhDaoTao);
	}

}
