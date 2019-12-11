package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import FrmGUI.GiaoDienTTSV;
import Database.DBconnect;
import Entites.GiangVien;
import Entites.Khoa;
import Entites.LuanVan;
import Entites.SinhVien;

public class LuanVanDAO {
	private ArrayList<LuanVan> lv = new ArrayList<LuanVan>();
	public ArrayList<LuanVan> LuanVanSinhVien(String tenTK) {
		lv = new ArrayList<LuanVan>();
		Connection con = DBconnect.getInstance().getConnection();
		SinhVienDAO svDAO = new SinhVienDAO();
		GiangVienDAO gvDAO = new GiangVienDAO();
		String magv = svDAO.KiemTraSVLV(tenTK);
		try{
			PreparedStatement stm = con.prepareStatement("select * from LuanVan");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				int maLuanVan = rs.getInt(1);
				String magv1 = rs.getString(2);
				String tenLV1 = rs.getString(3);
				String linhVuc1 = rs.getString(4);
				String tomTatLV = rs.getString(5);
				String noiDung1 = rs.getString(6);
				String maKhoa = rs.getString(7);
				Khoa khoa = new Khoa();
				KhoaDAO kDAO = new KhoaDAO();
				khoa = kDAO.TimKhoa(maKhoa);
				GiangVien gv =new GiangVien();
				gv = gvDAO.TimTheoMaGiangVien(magv1);
				LuanVan lv1 = new LuanVan(maLuanVan,gv,tenLV1,linhVuc1,tomTatLV,noiDung1,khoa);
				lv.add(lv1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lv;
	}
	
	public LuanVan TimLuanVan(String tenTK) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "select * from LuanVan where maLuanVan=?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, tenTK);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
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
				return lv1;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public ArrayList<LuanVan> getAllLuanVan(){
		Connection con = DBconnect.getInstance().getConnection();
		ArrayList<LuanVan> dslv = new ArrayList<LuanVan>();
		try {			
			String sql = "select * from LuanVan as LV, GiangVien as GV  where LV.maGiangVien = GV.maGiaoVien";
			PreparedStatement stm = con.prepareStatement(sql);
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
	
	public int getAllLuanVan(String mssv1){
		Connection con = DBconnect.getInstance().getConnection();
		int i=0;
		try {			
			String sql = "select * from LuanVan as LV, GiangVien as GV  where LV.maGiangVien = GV.maGiaoVien";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String mssv = rs.getString(1);
				String mgv = rs.getString(2);
				if(mssv.equalsIgnoreCase(mssv1))
					return i;
				i++;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public void XoaLuanVan(int maLuanVan) {
		Connection con = DBconnect.getInstance().getConnection();
		int i = 0;
		try {
			String sql = "Delete FROM LuanVan where maLuanVan = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, maLuanVan);
			stm.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void CapNhatLuanVan(int maLuanVan,String tenLV,String noiDung, String tomTat) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "Update LuanVan set tenLuanVan = ?, noiDung = ?, tomTatLuanVan = ? where maLuanVan = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, tenLV);
			pre.setString(2, noiDung);
			pre.setString(3, tomTat);
			pre.setInt(4, maLuanVan);
			pre.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void ThemLuanVan(LuanVan lv) {
		Connection con = DBconnect.getInstance().getConnection();
		String makhoa = lv.getKhoa().getMaKhoa();
		try {
			String sql = "insert into LuanVan(maGiangVien,tenLuanVan,linhVucNghienCuu,tomTatLuanVan,noiDung,khoa) OUTPUT inserted.maLuanVan values(?,?,?,?,?,?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1,lv.getGiangVien().getMaGiangVien());
			stm.setString(2, lv.getTenLuanVan());
			stm.setString(3, lv.getLinhVuc());
			stm.setString(4,lv.getTomTatLuanVan());
			stm.setString(5, lv.getNoiDung());
			stm.setString(6, lv.getKhoa().getMaKhoa());
			stm.executeUpdate();
			stm.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
