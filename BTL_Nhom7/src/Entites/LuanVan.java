package Entites;

public class LuanVan {
	private int maLuanVan;
	private GiangVien giangVien;
	private String tenLuanVan;
	private String linhVuc;
	private String tomTatLuanVan;
	private String noiDung;
	private Khoa khoa;
	public LuanVan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LuanVan(int maLuanVan, GiangVien giangVien, String tenLuanVan, String linhVuc, String tomTatLuanVan,
			String noiDung, Khoa khoa) {
		super();
		this.maLuanVan = maLuanVan;
		this.giangVien = giangVien;
		this.tenLuanVan = tenLuanVan;
		this.linhVuc = linhVuc;
		this.tomTatLuanVan = tomTatLuanVan;
		this.noiDung = noiDung;
		this.khoa = khoa;
	}
	public int getMaLuanVan() {
		return maLuanVan;
	}
	public void setMaLuanVan(int maLuanVan) {
		this.maLuanVan = maLuanVan;
	}
	public GiangVien getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
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
	public String getTomTatLuanVan() {
		return tomTatLuanVan;
	}
	public void setTomTatLuanVan(String tomTatLuanVan) {
		this.tomTatLuanVan = tomTatLuanVan;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public Khoa getKhoa() {
		return khoa;
	}
	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}
	@Override
	public String toString() {
		return "LuanVan [maLuanVan=" + maLuanVan + ", giangVien=" + giangVien + ", tenLuanVan=" + tenLuanVan
				+ ", linhVuc=" + linhVuc + ", tomTatLuanVan=" + tomTatLuanVan + ", noiDung=" + noiDung + ", khoa="
				+ khoa + "]";
	}

	

}
