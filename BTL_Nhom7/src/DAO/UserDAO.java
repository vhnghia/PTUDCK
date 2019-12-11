package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DBconnect;
import Entites.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	public User getUser(String id){
		
		try {
			Connection con = DBconnect.getInstance().getConnection();
			String sql = "select * from UserPassword where tenTK = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				String tenTK = rs.getString(1);
				String matKhau = rs.getString(2);
				User user = new User(tenTK,matKhau);
				return user;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
}
