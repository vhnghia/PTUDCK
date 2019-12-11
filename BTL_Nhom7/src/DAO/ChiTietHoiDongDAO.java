package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DBconnect;
import Entites.GiangVien;

public class ChiTietHoiDongDAO {
	
	public void addChiTietHoiDong(String maGV, int maHD) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "Insert into ChiTietHoiDong(maGiangVien,maHoiDong) values (?,?)";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, maGV);
			pre.setInt(2, maHD);
			int i = pre.executeUpdate();
			pre.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<GiangVien> danhSachChiTietHoiDong(int maHD){
		List<GiangVien> ds = new ArrayList<GiangVien>();
		GiangVienDAO gvDAO = new GiangVienDAO();
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "select GV.maGiaoVien from GiangVien as GV, ChiTietHoiDong as CTHD where GV.maGiaoVien = CTHD.maGiangVien and CTHD.maHoiDong = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, maHD);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String maGV = rs.getString(1);
				GiangVien gv = new GiangVien();
				gv = gvDAO.TimTheoMaGiangVien(maGV);
				ds.add(gv);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}

}
