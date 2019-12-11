package Entites;

import java.sql.Date;
import java.time.LocalDate;

public class ChiTietLuanVan {
	private SinhVien sinhVien;
	private LuanVan luanVan;
	private Date ngayDangKi;
	public ChiTietLuanVan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietLuanVan(SinhVien sinhVien, LuanVan luanVan, Date ngayDangKi) {
		super();
		this.sinhVien = sinhVien;
		this.luanVan = luanVan;
		this.ngayDangKi = ngayDangKi;
	}
	public SinhVien getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	public LuanVan getLuanVan() {
		return luanVan;
	}
	public void setLuanVan(LuanVan luanVan) {
		this.luanVan = luanVan;
	}
	public Date getNgayDangKi() {
		return ngayDangKi;
	}
	public void setNgayDangKi(Date date) {
		this.ngayDangKi =  date;
	}
	@Override
	public String toString() {
		return "ChiTietLuanVan [sinhVien=" + sinhVien + ", luanVan=" + luanVan + ", ngayDangKi=" + ngayDangKi + "]";
	}
	
	
	
}
