package DAO;
import DAO.AdminDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Database.DBconnect;
import Entites.Khoa;
import Entites.SinhVien;
import Entites.User;
import DAO.KhoaDAO;
public class SinhVienDAO {
	public ArrayList<SinhVien> GetAll(){
		ArrayList<SinhVien> dssv = new ArrayList<SinhVien>();
		try {
			Connection con = DBconnect.getInstance().getConnection();
			String sql = "select * from SinhVien";
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				String mssv = rs.getString(1);
				String hoten = rs.getString(2);
				Date ngaySinh = rs.getDate(3);
				int ngayVaoTruong = rs.getInt(4);
				String makhoa = rs.getString(5);
				int ngayRaTruong = rs.getInt(6);
				
				KhoaDAO khoaDAO = new KhoaDAO();
				Khoa a = new Khoa();
				a = khoaDAO.TimKhoa(makhoa);
				UserDAO userDAO = new UserDAO();
				User user = userDAO.getUser(mssv);
				SinhVien sv = new SinhVien(mssv,hoten,ngaySinh,ngayVaoTruong,ngayRaTruong,a,user);
				dssv.add(sv);
			}
		}
		catch (Exception e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		return dssv;
	}
	public SinhVien TimTheoMaSinhVien(String mssv) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			PreparedStatement stm = con.prepareStatement("select * from SinhVien where mssv like ?");
			stm.setString(1, mssv);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				String mssvjdbc = rs.getString(1);
				String hoTen = rs.getString(2);
				Date d = rs.getDate(3);
				int namVaoTruong = rs.getInt(4);
				String khoa = rs.getString(5); 
				int namTotNghiep = rs.getInt(6);
				String tt = rs.getString(7);
				Khoa khoa2 = new Khoa();
				KhoaDAO kd = new KhoaDAO();
				khoa2 = kd.TimKhoa(khoa);
				UserDAO userDAO = new UserDAO();
				User user = userDAO.getUser(mssvjdbc);
				SinhVien sv = new SinhVien(mssvjdbc,hoTen,d, namVaoTruong,namTotNghiep, khoa2, user);
				return sv;
			}
		}catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean CapNhatMatKhau(String mssv1, String matKhau) {
		SinhVien sv = TimTheoMaSinhVien(mssv1);
		if(sv.getUser().getMatKhau().equalsIgnoreCase(matKhau)) {
			return true;
		}
		return false;
}
	public void CapNhatMatKhau1(String tk2, String mkm) {
		Connection con = DBconnect.getInstance().getConnection();
		int i = 0;
		try {
			PreparedStatement stm = con.prepareStatement("Update UserPassword set matKhau = ? where tenTK = ?");
			stm.setString(1, mkm);
			stm.setString(2, tk2);
			i = stm.executeUpdate();
			stm.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void CapNhatThongTinSinhVien(String hoTen,String mssv) {
		Connection con = DBconnect.getInstance().getConnection();
		int i = 0;
		try {
			PreparedStatement stm = con.prepareStatement("Update SinhVien set hoTenSV = ? where mssv = ?");
			stm.setString(1, hoTen);
			stm.setString(2, mssv);
			i = stm.executeUpdate();
			stm.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public String KiemTraSVLV (String mssv) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "select LV.mssv from SinhVien as GV, LuanVan as LV where GV.mssv = LV.mssv";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(mssv))
					{
						return rs.getString(2); 
					}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "";
	}
	
	public List<SinhVien>getAllSVDTD(String maVong,int diem){
		Connection con = DBconnect.getInstance().getConnection();
		List<SinhVien> dsSV = new ArrayList<SinhVien>();
		try {
			String sql = "select * from SinhVien\n" + 
					"WHERE mssv in (\n" + 
					"select maSinhVien from VongBaoCao vong join DiemVong dv on vong.maVong=dv.maVong\n" + 
					"where vong.maVong=?\n" + 
					"group by maSinhVien\n" + 
					"HAVING avg(diem)>=?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, maVong);
			stm.setInt(2, diem);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String mssv = rs.getString(1);
				String hoten = rs.getString(2);
				Date ngaySinh = rs.getDate(3);
				int ngayVaoTruong = rs.getInt(4);
				String makhoa = rs.getString(5);
				int ngayRaTruong = rs.getInt(6);
				
				KhoaDAO khoaDAO = new KhoaDAO();
				Khoa a = new Khoa();
				a = khoaDAO.TimKhoa(makhoa);
				UserDAO userDAO = new UserDAO();
				User user = userDAO.getUser(mssv);
				SinhVien sv = new SinhVien(mssv,hoten,ngaySinh,ngayVaoTruong,ngayRaTruong,a,user);
				dsSV.add(sv);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsSV;
	}
	
}
