package Entites;

public class User {
	private String tenTK;
	private String matKhau;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String tenTK, String matKhau) {
		super();
		this.tenTK = tenTK;
		this.matKhau = matKhau;
	}
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "User [tenTK=" + tenTK + ", matKhau=" + matKhau + "]";
	}
	
	
	
}
