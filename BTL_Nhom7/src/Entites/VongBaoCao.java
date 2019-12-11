package Entites;

public class VongBaoCao {
	private String maVong;
	private String tenVong;
	public VongBaoCao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VongBaoCao(String maVong, String tenVong) {
		super();
		this.maVong = maVong;
		this.tenVong = tenVong;
	}
	public String getMaVong() {
		return maVong;
	}
	public void setMaVong(String maVong) {
		this.maVong = maVong;
	}
	public String getTenVong() {
		return tenVong;
	}
	public void setTenVong(String tenVong) {
		this.tenVong = tenVong;
	}
	@Override
	public String toString() {
		return "VongBaoCao [maVong=" + maVong + ", tenVong=" + tenVong + "]";
	}
	
	
	
}
