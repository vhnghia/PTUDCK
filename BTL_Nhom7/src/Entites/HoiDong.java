package Entites;

public class HoiDong {
	private int maHD;
	private String tenHD;
	private String maVong;
	private Khoa khoa;
	private int soLanCham;
	public HoiDong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoiDong(int maHD, String tenHD, String maVong, Khoa khoa, int soLanCham) {
		super();
		this.maHD = maHD;
		this.tenHD = tenHD;
		this.maVong = maVong;
		this.khoa = khoa;
		this.soLanCham = soLanCham;
	}
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public String getTenHD() {
		return tenHD;
	}
	public void setTenHD(String tenHD) {
		this.tenHD = tenHD;
	}
	public String getMaVong() {
		return maVong;
	}
	public void setMaVong(String maVong) {
		this.maVong = maVong;
	}
	public Khoa getKhoa() {
		return khoa;
	}
	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}
	public int getSoLanCham() {
		return soLanCham;
	}
	public void setSoLanCham(int soLanCham) {
		this.soLanCham = soLanCham;
	}
	@Override
	public String toString() {
		return "HoiDong [maHD=" + maHD + ", tenHD=" + tenHD + ", maVong=" + maVong + ", khoa=" + khoa + ", soLanCham="
				+ soLanCham + "]";
	}
	
	
	
	
}
