package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DBconnect;
import Entites.HoiDong;
import Entites.Khoa;

public class HoiDongDAO {
	public void addHoiDong(HoiDong hd) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "insert into HoiDong(tenHoiDong,maVong,khoa,soLanCham) OUTPUT inserted.maHoiDong values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,hd.getTenHD());
			pst.setString(2, hd.getMaVong());
			pst.setString(3, hd.getKhoa().getMaKhoa());
			pst.setInt(4, hd.getSoLanCham());
			int i = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<HoiDong> getAllHoiDong(){
		Connection con = DBconnect.getInstance().getConnection();
		ArrayList<HoiDong> hd = new ArrayList<HoiDong>();
		try {
			String sql = "Select * from HoiDong";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				int maHD = rs.getInt(1);
				String tenHD = rs.getString(2);
				String maVong = rs.getString(3);
				String maKhoa = rs.getString(4);
				int soLanCham = rs.getInt(5);
				Khoa k = new Khoa();
				KhoaDAO kDAO = new KhoaDAO();
				k = kDAO.TimKhoa(maKhoa);
				HoiDong hd1 = new HoiDong(maHD,tenHD,maVong,k,soLanCham);
				hd.add(hd1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hd;
		
	}
	
	public int soLanCham(int maHD) {
		int n = 0;
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "select soLanCham from HoiDong where maHoiDong = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1,maHD);
			ResultSet rs = stm.executeQuery();
			if(rs.next())
				n = rs.getInt(1);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n;
	}
	
	public void CapNhatSoLanChamHoiDong(int maHD) {
		Connection con = DBconnect.getInstance().getConnection();
		int n = soLanCham(maHD)+1;
		int i = 0;
		try {
			String sql = "Update HoiDong SET soLanCham = ? where maHoiDong = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, n);
			stm.setInt(2, maHD);
			i = stm.executeUpdate();
			stm.close();
			con.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
