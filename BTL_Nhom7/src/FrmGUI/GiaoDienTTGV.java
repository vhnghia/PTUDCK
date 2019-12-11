package FrmGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.GiangVienDAO;
import DAO.SinhVienDAO;
import Entites.GiangVien;
import Entites.LuanVan;
import Entites.SinhVien;

public class GiaoDienTTGV extends JFrame implements ActionListener{
	private JButton btnCapNhatTTGV,btnChinhSuaThongTin;
	private JPanel jp;
	private JLabel lbHoTen, lbChucDanh, lbDonViCongTac, lbMaSoGiangVien, lbKhoa, lbLinhVuc;
	private JTextField jtHoTen, jtChucDanh, jtDonViCongTac, jtMaSoGiangVien, jtKhoa, jtLinhVuc;
	private JMenuItem menuI1 ,menuIMatKhau, menuDangXuat, menuThoat,menuHome;
	private JMenu menu1,menu2,menu3,menu4; 
	private JMenuBar menuBar;
	private String tk;
	private JTable jtTable;
	private DefaultTableModel modelLuanVan;
	public GiaoDienTTGV() {
		setTitle("Giao Diện Giảng Viên");
		setSize(1250, 750);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GiaoDienTTGV();
	}
	
	public void GiaoDienTTGV() {
		jp = new JPanel();
		tk= "120";
		System.out.println(tk);
		jp.setLayout(new BorderLayout());
		//Jpanel West
		menuBar = new JMenuBar();

		menu1 = new JMenu("Giảng Viên");
		menu2 = new JMenu("Hệ thống");
		menuBar.add(menu1);
		menuBar.add(menu2);
		//Menu Con chức năng 
		menuI1 = new JMenuItem("Thông tin giảng viên");
		menuIMatKhau = new JMenuItem("Cập nhật mật khẩu");
		menuDangXuat = new JMenuItem("Đăng xuất");
		menuThoat = new JMenuItem("Thoát hệ thống");
		menuHome = new JMenuItem("Trang chủ");
		menu1.add(menuI1);
		menu1.add(menuIMatKhau);
		menu2.add(menuDangXuat);
		menu2.add(menuThoat);
		menu2.add(menuHome);
		
		ImageIcon img2 = new ImageIcon("Images/gv.png");
		ImageIcon img4 = new ImageIcon("Images/dx.png");
		ImageIcon img5 = new ImageIcon("Images/ht.png");
		ImageIcon img6 = new ImageIcon("Images/thoat.png");
		ImageIcon img7 = new ImageIcon("Images/ps.png");
		ImageIcon img1 = new ImageIcon("Images/home.png");		

		
		menu1.setIcon(img2);
		menu2.setIcon(img5);
		menuDangXuat.setIcon(img4);
		menuI1.setIcon(img2);
		menuIMatKhau.setIcon(img7);
		menuThoat.setIcon(img6);
		menuHome.setIcon(img1);
		
		jp.add(menuBar,BorderLayout.NORTH);

		//Jpanel Center
		JPanel jpCenter = new JPanel();
		jpCenter.setPreferredSize(new Dimension(1120,680));
		jp.add(jpCenter,BorderLayout.CENTER);
		
		

		//JPanel Thong Tin Sinh Vien
		JPanel jpTTSVNorth = new JPanel();
		jpTTSVNorth.setPreferredSize(new Dimension(1120,160));
		jpTTSVNorth.setBackground(Color.WHITE);
		jpTTSVNorth.setBorder(BorderFactory.createTitledBorder("Thong Tin Sinh Vien"));
		jpTTSVNorth.setLayout(null);
		btnChinhSuaThongTin = new JButton("Chỉnh Sửa Thông Tin");
		jpTTSVNorth.add(btnChinhSuaThongTin);
		btnCapNhatTTGV = new JButton("Cập Nhật Thông Tin");
		btnCapNhatTTGV.setEnabled(false);
		jpTTSVNorth.add(btnCapNhatTTGV);
		
		lbMaSoGiangVien = new JLabel("Mã Số Giảng Viên:");
		jpTTSVNorth.add(lbMaSoGiangVien);
		jtMaSoGiangVien = new JTextField(10);
		jpTTSVNorth.add(jtMaSoGiangVien);
		jtMaSoGiangVien.setEditable(false);
		
		lbHoTen = new JLabel("Họ Và Tên:");
		jpTTSVNorth.add(lbHoTen);
		jtHoTen = new JTextField(10);
		jtHoTen.setEditable(false);
		jpTTSVNorth.add(jtHoTen);
	
		lbKhoa = new JLabel("Khoa:");
		jpTTSVNorth.add(lbKhoa);
		jtKhoa = new JTextField(10);
		jtKhoa.setEditable(false);
		jpTTSVNorth.add(jtKhoa);
		
		lbLinhVuc = new JLabel("Lĩnh vực:");
		jpTTSVNorth.add(lbLinhVuc);
		jtLinhVuc = new JTextField(10);
		jtLinhVuc.setEditable(false);
		jpTTSVNorth.add(jtLinhVuc);
		
		lbChucDanh = new JLabel("Chức danh:");
		jpTTSVNorth.add(lbChucDanh);
		jtChucDanh = new JTextField(10);
		jtChucDanh.setEditable(false);
		jpTTSVNorth.add(jtChucDanh);
		
		
		lbDonViCongTac = new JLabel("Đơn vị công tác:");
		jpTTSVNorth.add(lbDonViCongTac);
		jtDonViCongTac = new JTextField(10);
		jtDonViCongTac.setEditable(false);
		jpTTSVNorth.add(jtDonViCongTac);
		//Can Chinh cac Compoent
		btnChinhSuaThongTin.setBounds(20,20,150,20);
		btnCapNhatTTGV.setBounds(180,20,150,20);
		
		lbMaSoGiangVien.setBounds(20,50,220,20);
		jtMaSoGiangVien.setBounds(135,50, 180, 20);
		
		lbHoTen.setBounds(20,80,220,20);
		jtHoTen.setBounds(135, 80,180 , 20);
		
		lbKhoa.setBounds(20,110,220,20);
		jtKhoa.setBounds(135,110,180,20);
		
		lbLinhVuc.setBounds(420,50,220,20);
		jtLinhVuc.setBounds(540,50,180,20);
		
		lbChucDanh.setBounds(420,80,220,20);
		jtChucDanh.setBounds(540,80,180,20);
		
		lbDonViCongTac.setBounds(420,110,220,20);
		jtDonViCongTac.setBounds(540,110,180,20);
		jpCenter.add(jpTTSVNorth,BorderLayout.NORTH);

		GiangVien gv = new GiangVien();
		GiangVienDAO gvDAO = new GiangVienDAO();
		gv = gvDAO.TimTheoMaGiangVien(tk);
		if(gv==null) {
			System.out.println("Null");
		}
		System.out.println(gv.toString());
		GanThongTin(gv);
		
		JPanel jpQLDT = new JPanel();
		jpQLDT.setBackground(Color.white);
		JScrollPane scrollhd;
		String Header [] = {"MSGV","Họ Tên Giảng Viên","Tên Luận Văn","Tóm Tắt","Nội Dung","MSSV","Tên Sinh Viên"};
		modelLuanVan = new DefaultTableModel(Header,0);
		jtTable = new JTable(modelLuanVan);
		jp.add(scrollhd = new JScrollPane(jtTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd.setBorder(BorderFactory.createTitledBorder("Thông Tin Luận Văn Của Sinh Viên"));
		scrollhd.setPreferredSize(new Dimension(1110,150));
		jpQLDT.add(scrollhd);		
		jpCenter.add(jpQLDT);
		
		jtTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jtTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtTable.getColumnModel().getColumn(1).setPreferredWidth(130);
		jtTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		jtTable.getColumnModel().getColumn(3).setPreferredWidth(250);
		jtTable.getColumnModel().getColumn(4).setPreferredWidth(300);
		jtTable.getColumnModel().getColumn(5).setPreferredWidth(50);
		jtTable.getColumnModel().getColumn(6).setPreferredWidth(100);
		
		List<LuanVan> dslv = new ArrayList<LuanVan>();
		GiangVienDAO gvDAO1 = new GiangVienDAO();
		dslv = gvDAO1.getAllQLDT(jtMaSoGiangVien.getText());
		
		ThemVaoBang(dslv);
		
		Box b = Box.createVerticalBox();
		Box b_lb= Box.createHorizontalBox();
		JLabel south_lb = new JLabel("Đại Học Công Nghiệp Thành Phố Hồ Chí Minh", SwingConstants.CENTER);
		south_lb.setFont(new Font("Arial", Font.BOLD, 20));
		b.add(Box.createVerticalStrut(10));
		b_lb.add(south_lb);
		b.add(b_lb);
		
		Box b_lb1 = Box.createHorizontalBox();
		JLabel south_lb1 = new JLabel("12 Nguyễn Văn Bảo, phường 7, Quận Gò Vấp",SwingConstants.CENTER);
		b.add(Box.createVerticalStrut(10));
		b_lb1.add(south_lb1);
		b.add(b_lb1);
		jp.add(b,BorderLayout.SOUTH);
		
		add(jp);
		menuIMatKhau.addActionListener(this);
		menuDangXuat.addActionListener(this);
		menuThoat.addActionListener(this);
		menuHome.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(menuIMatKhau)) {
			GiaoDienCapNhatMatKhau gdcnmk = new GiaoDienCapNhatMatKhau();
			gdcnmk.setVisible(true);
		}

		if(e.getSource().equals(menuDangXuat)) {
			GiaoDienDangNhap gddn = new GiaoDienDangNhap();
			gddn.setVisible(true);
			dispose();
		}

		if(e.getSource().equals(menuThoat)) {
			int click = JOptionPane.showConfirmDialog(null,"Bạn có muốn thoát hệ thống không?","Thoát hệ thống",JOptionPane.YES_NO_OPTION);
			if(click == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		
		if(e.getSource().equals(menuHome)) {
			GiaoDienAdmin gdgv = new GiaoDienAdmin();
			gdgv.setVisible(true);
			dispose();
		}
		
	}
	
	public void GanThongTin(GiangVien gv) {
		jtMaSoGiangVien.setText(gv.getMaGiangVien());
		jtHoTen.setText(gv.getTenGiangVien());
		jtKhoa.setText(gv.getKhoa().getMaKhoa());
		jtLinhVuc.setText(gv.getLinhVuc());
		jtChucDanh.setText(gv.getChucDanh());
		jtDonViCongTac.setText(gv.getDonViCongtac());
	}
	
	public void ThemVaoBang(List<LuanVan> dslv) {
		for(int i=0; i<dslv.size(); i++) {
			String data[] = {
					jtMaSoGiangVien.getText(),
					dslv.get(i).getGiangVien().getTenGiangVien(),
					dslv.get(i).getTenLuanVan(),
					dslv.get(i).getTomTatLuanVan(),
					dslv.get(i).getNoiDung(),
			};
			modelLuanVan.addRow(data);
		}
	}
	
}
