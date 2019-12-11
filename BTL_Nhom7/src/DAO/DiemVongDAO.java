package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DBconnect;
import Entites.DiemVong;

public class DiemVongDAO {
		public DiemVong getDiemVongThamDinh(String ma, String maVong) {
			List<Float> diem = new ArrayList<>();
			List<String> gv = new ArrayList<String>();
			Connection con = DBconnect.getInstance().getConnection();
			try {
				String sql = "select v.tenVong,gv.hoTen, diem, sv.hoTenSV from SinhVien sv join DiemVong dv on sv.mssv=dv.maSinhVien join GiangVien gv on gv.maGiaoVien= dv.maGiangVien join VongBaoCao v on v.maVong=dv.maVong WHERE sv.mssv= ? and dv.maVong = ?";
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setString(1, ma);
				stm.setString(2, maVong);
				ResultSet rs = stm.executeQuery();
				while(rs.next()) {
					gv.add(rs.getString(2));
					diem.add(rs.getFloat(3));
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			DiemVong dv = new DiemVong(null,null,null,diem,null,null,gv);
			return dv;
		}
		
		public DiemVong getDiemVongPhanBien(String ma1, String maVong1) {
			List<Float> diem = new ArrayList<>();
			List<String> gv = new ArrayList<String>();
			Connection con = DBconnect.getInstance().getConnection();
			try {
				String sql = "select v.tenVong,gv.hoTen, diem, sv.hoTenSV from SinhVien sv join DiemVong dv on sv.mssv=dv.maSinhVien join GiangVien gv on gv.maGiaoVien= dv.maGiangVien join VongBaoCao v on v.maVong=dv.maVong WHERE sv.mssv= ? and dv.maVong = ?";
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setString(1, ma1);
				stm.setString(2, maVong1);
				ResultSet rs = stm.executeQuery();
				while(rs.next()) {
					gv.add(rs.getString(2));
					diem.add(rs.getFloat(3));
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			DiemVong dv = new DiemVong(null,null,null,diem,null,null,gv);
			return dv;
		}
		
		public void themDiemGiangVien(String maSV,String maGV, String maVong, float diem) {
			Connection con = DBconnect.getInstance().getConnection();
			int i = 0;
			try {
				String sql = "INSERT INTO DiemVong(maSinhVien,maGiangVien,maVong,diem) VALUES(?,?,?,?)";
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setString(1, maSV);
				stm.setString(2, maGV);
				stm.setString(3, maVong);
				stm.setFloat(4,diem);
				i = stm.executeUpdate();
				stm.close();
				con.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		public void UpdateDiemSinhVien(float diem, String maGV, String maSV, String maVong) {
			Connection con = DBconnect.getInstance().getConnection();
			int i = 0;
			try {
				String sql = "Update DiemVong set diem = ? where maGiangVien = ? and maSinhVien = ? and maVong = ?";
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setFloat(1,diem);
				stm.setString(2, maGV);
				stm.setString(3, maSV);
				stm.setString(4,maVong);
				i = stm.executeUpdate();
				stm.close();
				con.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		public List<String> getAllMaGV(String maSV, String maVong){
			Connection con = DBconnect.getInstance().getConnection();
			List<String> list = new ArrayList<String>();
			try {
				String sql = "select maGiangVien from DiemVong where maSinhVien = ? and maVong = ? ";
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setString(1, maSV);
				stm.setString(2, maVong);
				ResultSet rs = stm.executeQuery();
				while(rs.next()) {
					String s = rs.getString(1);
					list.add(s);
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return list;
		}
		
}
