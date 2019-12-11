package Entites;

import java.util.Date;

public class SinhVien {
	private String mssv;
	private String hoten;
	private Date ngaySinh;
	private int ngayVaoTruong;
	private int ngayRaTruong;
	private Khoa khoaSV;
	private User user;
	public SinhVien() { 
		super();
		// TODO Auto-generated constructor stub
	}
	public SinhVien(String mssv, String hoten, Date ngaySinh, int ngayVaoTruong,
			int ngayRaTruong, Khoa khoaSV,User user) {
		super();
		this.mssv = mssv;
		this.hoten = hoten;
		this.ngaySinh = ngaySinh;
		this.ngayVaoTruong = ngayVaoTruong;
		this.ngayRaTruong = ngayRaTruong;
		this.khoaSV = khoaSV;
		this.user = user;
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public int getNgayVaoTruong() {
		return ngayVaoTruong;
	}
	public void setNgayVaoTruong(int ngayVaoTruong) {
		this.ngayVaoTruong = ngayVaoTruong;
	}
	public int getNgayRaTruong() {
		return ngayRaTruong;
	}
	public void setNgayRaTruong(int ngayRaTruong) {
		this.ngayRaTruong = ngayRaTruong;
	}
	public Khoa getKhoaSV() {
		return khoaSV;
	}
	public void setKhoaSV(Khoa khoaSV) {
		this.khoaSV = khoaSV;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "SinhVien [mssv=" + mssv + ", hoten=" + hoten + ", ngaySinh=" + ngaySinh + ", ngayVaoTruong="
				+ ngayVaoTruong + ", ngayRaTruong=" + ngayRaTruong + ", khoaSV=" + khoaSV + ", user=" + user + "]";
	}
	
	
	
	
	
}
