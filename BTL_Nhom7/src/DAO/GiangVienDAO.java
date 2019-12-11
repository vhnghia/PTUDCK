package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Database.DBconnect;
import Entites.GiangVien;
import Entites.Khoa;
import Entites.LuanVan;
import Entites.SinhVien;
import Entites.User;

public class GiangVienDAO {
	
	public ArrayList<GiangVien> GetAll(){
		ArrayList<GiangVien> dsgv = new ArrayList<GiangVien>();
		try {
			Connection con = DBconnect.getInstance().getConnection();
			String sql = "select * from GiangVien";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String maGV = rs.getString(1);
				String tenGV = rs.getString(2);
				String chucDanh = rs.getString(3);
				KhoaDAO aDAO = new KhoaDAO();
				Khoa a = new Khoa();
				a = aDAO.TimKhoa(rs.getString(4));
				String tenKhoaLuan = rs.getString(5);
				String linhVuc = rs.getString(6);
				String donViCongTac = rs.getString(7);
				User user = new User();
				UserDAO userDAO = new UserDAO();
				user = userDAO.getUser(maGV);
				GiangVien gv = new GiangVien(maGV,tenGV,chucDanh,a,tenKhoaLuan,linhVuc,donViCongTac,user);
				dsgv.add(gv);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsgv;
	}
	
	public GiangVien TimTheoMaGiangVien(String maGV) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			PreparedStatement stm = con.prepareStatement("select * from GiangVien where maGiaoVien=?");
			stm.setString(1, maGV);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				String mgvjdbc = rs.getString(1);
				String hoTen = rs.getString(2);
				String chucDanh = rs.getString(3);
				String khoa = rs.getString(4);
				String tenLV = rs.getString(5);
				String linhVuc = rs.getString(6);
				String donViCongTac = rs.getString(7);
				Khoa khoa2 = new Khoa();
				KhoaDAO kd = new KhoaDAO();
				khoa2 = kd.TimKhoa(khoa);
				UserDAO userDAO = new UserDAO();
				User user = new User();
				user = userDAO.getUser(mgvjdbc);
				GiangVien gv = new GiangVien(mgvjdbc,hoTen,chucDanh,khoa2,tenLV,linhVuc,donViCongTac,user);
				return gv;
			}
		}catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
		return null;
	}
	
	public List<LuanVan> getAllQLDT(String maGV){
		Connection con = DBconnect.getInstance().getConnection();
		List<LuanVan> dslv = new ArrayList<LuanVan>();
		try {			
			String sql = "select * from LuanVan as LV, GiangVien as GV  where LV.maGiangVien = GV.maGiaoVien and LV.maGiangVien = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, maGV);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				int maLuanVan = rs.getInt(1);
				String mgv = rs.getString(2);
				String tenLV = rs.getString(3);
				String lv = rs.getString(4);
				String ttlv = rs.getString(5);
				String nd = rs.getString(6);
				String maKhoa = rs.getString(7);
				Khoa khoa = new Khoa();
				KhoaDAO kDAO = new KhoaDAO();
				khoa = kDAO.TimKhoa(maKhoa);
				GiangVien gv = new GiangVien();
				GiangVienDAO gvDAO = new GiangVienDAO();
				gv = gvDAO.TimTheoMaGiangVien(mgv);
				LuanVan lv1 = new LuanVan(maLuanVan,gv,tenLV,lv,ttlv,nd,khoa);
				dslv.add(lv1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dslv;
	}
}
