package DAO;
import DAO.SinhVienDAO;
import Database.DBconnect;
import Entites.GiangVien;
import Entites.Khoa;
import Entites.SinhVien;
import Entites.User;
import Entites.Khoa;
import DAO.KhoaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.GiangVienDAO;
public class AdminDAO {
	ArrayList<SinhVien> sv = new ArrayList<SinhVien>();
	public ArrayList<SinhVien> GetAllSinhVien(){
		sv = new ArrayList<SinhVien>();
		SinhVienDAO svdao = new SinhVienDAO();
		sv = svdao.GetAll();
		return sv;
	}
	
	public int ViTri(String mssv) {
		int i = 0;
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "select * from SinhVien";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String mssv1 = rs.getString(1);
				if(mssv1.equalsIgnoreCase(mssv))
					return i;
				i++;
			}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public int ViTri1(String msgv) {
		int i = 0;
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "select * from GiangVien";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String mssv1 = rs.getString(1);
				if(mssv1.equalsIgnoreCase(msgv))
					return i;
				i++;
			}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<SinhVien> LocTheoKhoa(String khoa){
		ArrayList<SinhVien> sv = new ArrayList<SinhVien>();
		Connection con = DBconnect.getInstance().getConnection();
		String sql = "select * from SinhVien";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String mssv = rs.getString(1);
				String hoten = rs.getString(2);
				Date ngaySinh = rs.getDate(3);
				int ngayVaoTruong = rs.getInt(4);
				String makhoa = rs.getString(5);
				int ngayRaTruong = rs.getInt(6);
				KhoaDAO khoaDAO = new KhoaDAO();
				Khoa a = new Khoa();
				UserDAO userDAO = new UserDAO();
				User user = userDAO.getUser(mssv);
				a = khoaDAO.TimKhoa(makhoa);
				if(a.getMaKhoa().equalsIgnoreCase(khoa))
					{
						SinhVien sv1 = new SinhVien(mssv,hoten,ngaySinh,ngayVaoTruong,ngayRaTruong,a,user);
						sv.add(sv1);
					}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sv;
	
	}
	public ArrayList<GiangVien> LocTheoKhoa1(String tenKhoa){
		ArrayList<GiangVien> gv = new ArrayList<GiangVien>();
		Connection con = DBconnect.getInstance().getConnection();
		String sql = "select * from GiangVien";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String msgv = rs.getString(1);
				String hoten = rs.getString(2);
				String chucDanh = rs.getString(3);
				String makhoa = rs.getString(4);
				String tenLV = rs.getString(5);
				String linhVuc = rs.getString(6);
				String dvct = rs.getString(7);
				KhoaDAO khoaDAO = new KhoaDAO();
				Khoa a = new Khoa();
				UserDAO userDAO = new UserDAO();
				User user = userDAO.getUser(msgv);
				a = khoaDAO.TimKhoa(makhoa);
				if(a.getMaKhoa().equalsIgnoreCase(tenKhoa))
					{
						GiangVien sv1 = new GiangVien(msgv,hoten,chucDanh,a,tenLV,linhVuc,dvct,user);
						gv.add(sv1);
					}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return gv;
	
	}
	
	public List<GiangVien> getAllGiangVien(){
		List<GiangVien> dsgv = new ArrayList<GiangVien>();
		GiangVienDAO gvDAO = new GiangVienDAO();
		dsgv = gvDAO.GetAll();
		return dsgv;
	}
	
	public int RotVongThamDinh(String maVong) {
		Connection con = DBconnect.getInstance().getConnection();
		int n = 0;
		try {
			PreparedStatement stm = con.prepareStatement("select COUNT(*) as DSRot from SinhVien\n" + 
					"WHERE mssv in (\n" + 
					"select maSinhVien from VongBaoCao vong join DiemVong dv on vong.maVong=dv.maVong\n" + 
					"where vong.maVong=?\n" + 
					"group by maSinhVien\n" + 
					"HAVING avg(diem)<5)");
			stm.setString(1, maVong);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				n = rs.getInt(1);
				return n;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n;
	}
	
	public int RotVongPhanBien(String maVong) {
		int n=0;
		Connection con = DBconnect.getInstance().getConnection();
		try {
			PreparedStatement stm = con.prepareStatement("select COUNT(*) as DSRot from SinhVien\n" + 
					"WHERE mssv in (\n" + 
					"select maSinhVien from VongBaoCao vong join DiemVong dv on vong.maVong=dv.maVong\n" + 
					"where vong.maVong=?\n" + 
					"group by maSinhVien\n" + 
					"HAVING avg(diem)<5)");
			stm.setString(1, maVong);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				n = rs.getInt(1);
				return n;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n;
	}
	
	public int DauVongPhanBien(String maVong) {
		Connection con = DBconnect.getInstance().getConnection();
		int n = 0;
		try {
			PreparedStatement stm = con.prepareStatement("select COUNT(*) as Dau from SinhVien\n" + 
					"WHERE mssv in (\n" + 
					"select maSinhVien from VongBaoCao vong join DiemVong dv on vong.maVong=dv.maVong\n" + 
					"where vong.maVong=?\n" + 
					"group by maSinhVien\n" + 
					"HAVING avg(diem)>=5)");
			stm.setString(1, maVong);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				n = rs.getInt(1);
				return n;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n;
	}
}