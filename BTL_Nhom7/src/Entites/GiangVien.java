package Entites;

public class GiangVien {
	private String maGiangVien;
	private String tenGiangVien;
	private String chucDanh;
	private Khoa khoa;
	private String tenLuanVan;
	private String linhVuc;
	private String donViCongtac;
	private User user;
	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GiangVien(String maGiangVien, String tenGiangVien, String chucDanh, Khoa khoa, String tenLuanVan,
			String linhVuc, String donViCongtac, User user) {
		super();
		this.maGiangVien = maGiangVien;
		this.tenGiangVien = tenGiangVien;
		this.chucDanh = chucDanh;
		this.khoa = khoa;
		this.tenLuanVan = tenLuanVan;
		this.linhVuc = linhVuc;
		this.donViCongtac = donViCongtac;
		this.user = user;
	}
	public String getMaGiangVien() {
		return maGiangVien;
	}
	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}
	public String getTenGiangVien() {
		return tenGiangVien;
	}
	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}
	public String getChucDanh() {
		return chucDanh;
	}
	public void setChucDanh(String chucDanh) {
		this.chucDanh = chucDanh;
	}
	public Khoa getKhoa() {
		return khoa;
	}
	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}
	public String getTenLuanVan() {
		return tenLuanVan;
	}
	public void setTenLuanVan(String tenLuanVan) {
		this.tenLuanVan = tenLuanVan;
	}
	public String getLinhVuc() {
		return linhVuc;
	}
	public void setLinhVuc(String linhVuc) {
		this.linhVuc = linhVuc;
	}
	public String getDonViCongtac() {
		return donViCongtac;
	}
	public void setDonViCongtac(String donViCongtac) {
		this.donViCongtac = donViCongtac;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "GiangVien [maGiangVien=" + maGiangVien + ", tenGiangVien=" + tenGiangVien + ", chucDanh=" + chucDanh
				+ ", khoa=" + khoa + ", tenLuanVan=" + tenLuanVan + ", linhVuc=" + linhVuc + ", donViCongtac="
				+ donViCongtac + ", user=" + user + "]";
	}
	
	
	
	
	
}
