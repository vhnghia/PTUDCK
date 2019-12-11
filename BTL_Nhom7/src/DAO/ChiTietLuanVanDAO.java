package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import Database.DBconnect;
import Entites.ChiTietLuanVan;

public class ChiTietLuanVanDAO {
	public int TimMa(String mssv) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "select * from ChiTietLuanVan where mssv=?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, mssv);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				int maLuanVan = rs.getInt(2);
				return maLuanVan;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public void DangKyLuanVan(ChiTietLuanVan ctlv) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
		String sql = "Insert into ChiTietLuanVan(mssv,maLuanVan,ngayDangKy) values (?,?,?)";
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, ctlv.getSinhVien().getMssv());
		pre.setInt(2, ctlv.getLuanVan().getMaLuanVan());
		pre.setDate(3,ctlv.getNgayDangKi());
		int i = pre.executeUpdate();
		pre.close();
		con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int soLuong(int maLuanVan) {
		Connection con = DBconnect.getInstance().getConnection();
		int i=0;
		try {
			String sql = "select * from ChiTietLuanVan where maLuanVan=?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, maLuanVan);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				i++;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	
}
