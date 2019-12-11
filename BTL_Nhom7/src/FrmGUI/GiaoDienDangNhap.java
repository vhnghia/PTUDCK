package FrmGUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DAO.SinhVienDAO;
import DAO.GiangVienDAO;
import Entites.GiangVien;
import Entites.SinhVien;

public class GiaoDienDangNhap extends JFrame implements ActionListener, KeyListener{
	private Label lbUserName, lbPassword;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JButton btnLogin, btnExit;
	private SinhVienDAO sinhVienDAO;
	private GiangVienDAO giangVienDAO;
	
	public GiaoDienDangNhap() {
		setTitle("Đăng nhập vào hệ thống");
		setSize(400, 200);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		LayoutLogin();
	}
	
	public void LayoutLogin() {
		JPanel jpLogin = new  JPanel();
		jpLogin.setPreferredSize(new Dimension(280,180));
		jpLogin.setLayout(null); // Absolute layout
		// add compoent vao Jpanel
		lbUserName = new Label("Tài Khoản: ");
		lbPassword = new Label("Mật Khẩu: ");
		jpLogin.add(lbUserName);
		jpLogin.add(lbPassword);
		txtUserName = new JTextField();
		txtPassword = new JPasswordField();
		jpLogin.add(txtUserName);
		jpLogin.add(txtPassword);
		
		btnLogin = new JButton("Login");
		btnExit = new JButton("Exit");
		jpLogin.add(btnLogin);
		jpLogin.add(btnExit);
		
		int  wdn1 = 120, wdn2 = 200, hdn = 20 , xdn1=10, xdn2= xdn1+wdn1;
		lbUserName.setBounds(xdn1, 40, wdn1, hdn);
		txtUserName.setBounds(xdn2, 40, wdn2, hdn);
		lbPassword.setBounds(xdn1, 70, wdn1, hdn);
		txtPassword.setBounds(xdn2, 70, wdn2, hdn);
		btnLogin.setBounds(xdn1+40, 110, wdn1, 30);
		btnExit.setBounds(xdn2+70, 110, wdn1, 30);
		add(jpLogin);
		
		// add su kien cho btnLogin, btnExit
		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
		txtUserName.addKeyListener(this);
		txtPassword.addKeyListener(this);
		
	}
//	public int KiemTraSinhVien(String tenTK, String matKhau) {
//		sinhVienDAO = new SinhVienDAO();
//		ArrayList<SinhVien> sv = sinhVienDAO.GetAll();
//		for(int i=0;i<sv.size();i++) {
//			if(tenTK.equalsIgnoreCase(sv.get(i).getUser().getTenTK()) && matKhau.equalsIgnoreCase(sv.get(i).getUser().getMatKhau())) {
//				return 1;
//			}
//		}
//		return 0;
//	}
//	public int KiemTraGiangVien(String tenTK, String matKhau) {
//		giangVienDAO = new GiangVienDAO();
//		ArrayList<GiangVien> gv = giangVienDAO.GetAll();
//		for(int i=0;i<gv.size();i++) {
//			if(tenTK.equalsIgnoreCase(gv.get(i).getUser().getTenTK()) && matKhau.equalsIgnoreCase(gv.get(i).getUser().getMatKhau())) {
//				return 2;
//			}
//		}
//		return 0;
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource().equals(btnLogin)) {
//			String tenTK = txtUserName.getText();
//			String matKhau = txtPassword.getText();
//			if(tenTK.equalsIgnoreCase("") || matKhau.equalsIgnoreCase("")) 
//				JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Đầy Đủ Thông Tin");
//			else{
//				if(KiemTraSinhVien(tenTK,matKhau)==1) {
//					GIaoDienSinhVien gdql = new GIaoDienSinhVien(tenTK);
//					gdql.setVisible(true);
//					dispose();
//				} 
//				else if(KiemTraGiangVien(tenTK,matKhau)==2)
//				{
//					String tk = tenTK;
//					GiaoDienGiangVien gdgv = new GiaoDienGiangVien(tk);
//					gdgv.setVisible(true);
//					System.out.println("Giang Vien");
//					dispose();
//				}
//				else if(tenTK.equalsIgnoreCase("admin") && matKhau.equalsIgnoreCase("admin")) {
//					GiaoDienAdmin admin = new GiaoDienAdmin();
//					admin.setVisible(true);
//					dispose();
//				}
//				else
//					JOptionPane.showMessageDialog(null, "Sai Tên Đăng Nhập Hoặc Mật Khẩu");
//			}
//}
		
		if(e.getSource().equals(btnLogin)) {
			if(txtUserName.getText().toString().equalsIgnoreCase("admin") && txtPassword.getText().toString().equalsIgnoreCase("admin")) {
				GiaoDienAdmin gdadmin = new GiaoDienAdmin();
				gdadmin.setVisible(true);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
			}
			
		}
		
		if(e.getSource().equals(btnExit))
			System.exit(0);
		
	}
	private void eventEnter(java.awt.event.KeyEvent evt) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			btnLogin.doClick();
		}
	}
}
