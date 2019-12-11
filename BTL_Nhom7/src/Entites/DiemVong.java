package Entites;

import java.util.List;

public class DiemVong {
	private String mssv;
	private String maGiangVien;
	private String maVong;
	private List<Float> diem;
	private VongBaoCao maVong1;
	private SinhVien sinhVien;
	private List<String> giangVien;
	public DiemVong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiemVong(String mssv, String maGiangVien, String maVong, List<Float> diem, VongBaoCao maVong1,
			SinhVien sinhVien, List<String> giangVien) {
		super();
		this.mssv = mssv;
		this.maGiangVien = maGiangVien;
		this.maVong = maVong;
		this.diem = diem;
		this.maVong1 = maVong1;
		this.sinhVien = sinhVien;
		this.giangVien = giangVien;
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getMaGiangVien() {
		return maGiangVien;
	}
	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}
	public String getMaVong() {
		return maVong;
	}
	public void setMaVong(String maVong) {
		this.maVong = maVong;
	}
	public List<Float> getDiem() {
		return diem;
	}
	public void setDiem(List<Float> diem) {
		this.diem = diem;
	}
	public VongBaoCao getMaVong1() {
		return maVong1;
	}
	public void setMaVong1(VongBaoCao maVong1) {
		this.maVong1 = maVong1;
	}
	public SinhVien getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	public List<String> getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(List<String> giangVien) {
		this.giangVien = giangVien;
	}
	@Override
	public String toString() {
		return "DiemVong [mssv=" + mssv + ", maGiangVien=" + maGiangVien + ", maVong=" + maVong + ", diem=" + diem
				+ ", maVong1=" + maVong1 + ", sinhVien=" + sinhVien + ", giangVien=" + giangVien + "]";
	}
	
	
	
}
