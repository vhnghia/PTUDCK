package FrmGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import DAO.DiemVongDAO;
import DAO.SinhVienDAO;
import Entites.DiemVong;
import Entites.SinhVien;

public class GiaoDienKetQuaHocTap extends JFrame implements ActionListener{
	private JPanel jp;
	private JLabel lbHoTen, lbNamVaoTruong, lbNamTotNghiep, lbMaSoSinhVien, lbKhoa,lbKhoaHoc,lbLogo;
	private JTextField jtHoTen, jtNamVaoTruong, jtNamTotNghiep, jtMaSoSinhVien, jtKhoa, jtKhoaHoc;
	private String tenTK="100";
	private JTable jtTable,jtTable1;
	private DefaultTableModel modelLuanVan, modelLuanVan1;
	private JMenuItem menuI1 ,menuIMatKhau, menuDangXuat, menuThoat,menuHome,menuKQHT;
	private JMenu menu1,menu2,menu3,menu4; 
	private JMenuBar menuBar;
	DiemVongDAO dvDAO = new DiemVongDAO();
	public GiaoDienKetQuaHocTap() {
		setTitle("Sinh Vien");
		setSize(1250, 750);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GiaoDienKetQuaHocTap();
	}

	public void GiaoDienKetQuaHocTap() {
		jp = new JPanel();
		jp.setLayout(new BorderLayout());
		//Jpanel West
		menuBar = new JMenuBar();

		menu1 = new JMenu("Sinh viên");
		menu2 = new JMenu("Hệ thống");
		menuBar.add(menu1);
		menuBar.add(menu2);
		//Menu Con chức năng 
		menuI1 = new JMenuItem("Thông tin sinh viên");
		menuIMatKhau = new JMenuItem("Cập nhật mật khẩu");
		menuDangXuat = new JMenuItem("Đăng xuất");
		menuThoat = new JMenuItem("Thoát hệ thống");
		menuHome = new JMenuItem("Trang chủ");
		menuKQHT = new JMenuItem("Kết quả học tập");
		menu1.add(menuI1);
		menu1.add(menuIMatKhau);
		menu1.add(menuKQHT);
		menu2.add(menuDangXuat);
		menu2.add(menuThoat);
		menu2.add(menuHome);
		
		ImageIcon img1 = new ImageIcon("Images/home.png");		
		ImageIcon img2 = new ImageIcon("Images/st.png");
		ImageIcon img3 = new ImageIcon("Images/kqht.png");
		ImageIcon img4 = new ImageIcon("Images/dx.png");
		ImageIcon img5 = new ImageIcon("Images/ht.png");
		ImageIcon img6 = new ImageIcon("Images/thoat.png");
		ImageIcon img7 = new ImageIcon("Images/ps.png");
		
		menuHome.setIcon(img1);
		menu1.setIcon(img2);
		menu2.setIcon(img5);
		menuDangXuat.setIcon(img4);
		menuKQHT.setIcon(img3);
		menuI1.setIcon(img2);
		menuIMatKhau.setIcon(img7);
		menuThoat.setIcon(img6);
		
		jp.add(menuBar,BorderLayout.NORTH);

		//Jpanel Center
		JPanel jpCenter = new JPanel();
		jpCenter.setPreferredSize(new Dimension(1120,680));
		jp.add(jpCenter,BorderLayout.CENTER);




		//JPanel Thong Tin Sinh Vien
		JPanel jpTTSVNorth = new JPanel();
		jpTTSVNorth.setPreferredSize(new Dimension(1120,160));
		jpTTSVNorth.setBackground(Color.WHITE);
		jpTTSVNorth.setBorder(BorderFactory.createTitledBorder("Thông Tin Sinh Viên"));
		jpTTSVNorth.setLayout(null);
		lbMaSoSinhVien = new JLabel("Mã Số Sinh Viên:");
		jpTTSVNorth.add(lbMaSoSinhVien);
		jtMaSoSinhVien = new JTextField(10);
		jpTTSVNorth.add(jtMaSoSinhVien);
		jtMaSoSinhVien.setEditable(false);
		lbHoTen = new JLabel("Họ Và Tên:");
		jpTTSVNorth.add(lbHoTen);
		jtHoTen = new JTextField(10);
		jtHoTen.setEditable(false);
		jpTTSVNorth.add(jtHoTen);
		lbKhoa = new JLabel("Khoa Đào Tạo:");
		jpTTSVNorth.add(lbKhoa);
		jtKhoa = new JTextField(10);
		jtKhoa.setEditable(false);
		jpTTSVNorth.add(jtKhoa);
		lbNamVaoTruong = new JLabel("Năm Vào Trường:");
		jpTTSVNorth.add(lbNamVaoTruong);
		jtNamVaoTruong = new JTextField(10);
		jtNamVaoTruong.setEditable(false);
		jpTTSVNorth.add(jtNamVaoTruong);
		lbNamTotNghiep = new JLabel("Năm Tốt Nghiệp:");
		jpTTSVNorth.add(lbNamTotNghiep);
		jtNamTotNghiep = new JTextField(10);
		jtNamTotNghiep.setEditable(false);
		jpTTSVNorth.add(jtNamTotNghiep);
		lbKhoaHoc = new JLabel("Khoá:");
		jpTTSVNorth.add(lbKhoaHoc);
		jtKhoaHoc = new JTextField(10);
		jtKhoaHoc.setEditable(false);
		jpTTSVNorth.add(jtKhoaHoc);
		//Can Chinh cac Compoent
		lbMaSoSinhVien.setBounds(20,50,220,20);
		jtMaSoSinhVien.setBounds(135,50, 180, 20);
		lbHoTen.setBounds(20,80,220,20);
		jtHoTen.setBounds(135, 80,180 , 20);
		lbKhoa.setBounds(20,110,220,20);
		jtKhoa.setBounds(135,110,180,20);
		lbNamVaoTruong.setBounds(420,50,220,20);
		jtNamVaoTruong.setBounds(540,50,180,20);
		lbNamTotNghiep.setBounds(420,80,220,20);
		jtNamTotNghiep.setBounds(540,80,180,20);
		lbKhoaHoc.setBounds(420,110,220,20);
		jtKhoaHoc.setBounds(540,110,180,20);
		jpCenter.add(jpTTSVNorth,BorderLayout.NORTH);
		//Lay thong tin 1 sinh vien
		SinhVien sv = new SinhVien();
		sv = ThongTinMotSinhVien(tenTK);
		//gan thong tin mot sinh vien
		GanThongTin(sv);

		JPanel jpKeQuaHocTap = new JPanel();
		jpKeQuaHocTap.setBackground(Color.WHITE);
		JScrollPane scrollhd;
		String Header [] = {"Tên Vòng","Điểm","Tên Giảng Viên"};
		modelLuanVan = new DefaultTableModel(Header,0);
		jtTable = new JTable(modelLuanVan);
		jp.add(scrollhd = new JScrollPane(jtTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd.setBorder(BorderFactory.createTitledBorder("Kết Quả Điểm Thi Sinh Viên Vòng Thẩm Định"));
		scrollhd.setPreferredSize(new Dimension(1110,150));
		jpKeQuaHocTap.add(scrollhd);		
		jpCenter.add(jpKeQuaHocTap);

		DiemVong dv = new DiemVong();
		String maVong = "TD";
		dv = dvDAO.getDiemVongThamDinh("100",maVong);
		NapVaoBang(dv);

		JPanel jpKeQuaHocTap1 = new JPanel();
		jpKeQuaHocTap1.setBackground(Color.WHITE);
		JScrollPane scrollhd1;
		String Header1 [] = {"Tên Vòng","Điểm","Tên Giảng Viên"};
		modelLuanVan1 = new DefaultTableModel(Header,0);
		jtTable1 = new JTable(modelLuanVan1);
		jp.add(scrollhd1 = new JScrollPane(jtTable1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd1.setBorder(BorderFactory.createTitledBorder("Kết Quả Điểm Thi Sinh Viên Vòng Phản Biện"));
		scrollhd1.setPreferredSize(new Dimension(1110,150));
		jpKeQuaHocTap1.add(scrollhd1);		
		jpCenter.add(jpKeQuaHocTap1);

		DiemVong dv1 = new DiemVong();
		String maVong1 = "PB";
		dv1 = dvDAO.getDiemVongPhanBien("100",maVong1);
		NapVaoBang1(dv1);
		
		menuI1.addActionListener(this);
		menuDangXuat.addActionListener(this);
		menuThoat.addActionListener(this);
		menuHome.addActionListener(this);
		menuIMatKhau.addActionListener(this);
		
		jp.add(menuBar,BorderLayout.NORTH);

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
	}

	public SinhVien ThongTinMotSinhVien(String tenTK) {
		SinhVien sv = new SinhVien();
		SinhVienDAO svDAO = new SinhVienDAO(); 
		sv = svDAO.TimTheoMaSinhVien(tenTK);
		return sv;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(menuDangXuat)) {
			GiaoDienDangNhap gddn = new GiaoDienDangNhap();
			gddn.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIMatKhau)) {
			GiaoDienCapNhatMatKhau gdcnmk = new GiaoDienCapNhatMatKhau();
			gdcnmk.setVisible(true);
		}
		if(e.getSource().equals(menuThoat)) {
			int click = JOptionPane.showConfirmDialog(null,"Bạn có muốn thoát hệ thống không?","Thoát hệ thống",JOptionPane.YES_NO_OPTION);
			if(click == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		
		if(e.getSource().equals(menuHome)) {
			GiaoDienAdmin gdql = new GiaoDienAdmin();
			gdql.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuI1)) {
			GiaoDienTTSV gdttsv = new GiaoDienTTSV();
			gdttsv.setVisible(true);
			dispose();
		}
		
	}

	public void GanThongTin(SinhVien sv) {
		jtMaSoSinhVien.setText(sv.getMssv());
		jtHoTen.setText(sv.getHoten());
		jtKhoa.setText(sv.getKhoaSV().getTenKhoa());
		jtNamVaoTruong.setText(sv.getNgayVaoTruong()+"");
		jtNamTotNghiep.setText(sv.getNgayRaTruong()+"");
		jtKhoaHoc.setText(sv.getNgayVaoTruong() +"-"+ (sv.getNgayVaoTruong()+1) +"");
	}
	
	public void NapVaoBang(DiemVong dv) {
		int k = dv.getDiem().size();
		for(int i=0; i<k; i++) {
			String row [] = {
					"Thẩm Định",
					dv.getDiem().get(i)+"",
					dv.getGiangVien().get(i)
			};
			modelLuanVan.addRow(row);
		}
		float diem = 0;
		for(int i=0; i<k; i++) {
			diem+= dv.getDiem().get(i);
		}
		
		String row1[] = {
				"",
				"",
				""
		};
		 modelLuanVan.addRow(row1);
		
		String row2[] = {
				"Điểm Trung Bình",
				(diem/5)+"",
				""
		};
		 modelLuanVan.addRow(row2);
		
	}
	
	public void NapVaoBang1(DiemVong dv) {
		int k = dv.getDiem().size();
		for(int i=0; i<k; i++) {
			String row [] = {
					"Phản Biện",
					dv.getDiem().get(i)+"",
					dv.getGiangVien().get(i)
			};
			modelLuanVan1.addRow(row);
		}
		float diem = 0;
		for(int i=0; i<k; i++) {
			diem+= dv.getDiem().get(i);
		}
		String row1[] = {
				"",
				"",
				""
		};
		 modelLuanVan1.addRow(row1);
		String row2[] = {
				"Điểm Trung Bình",
				(diem/5)+"",
				""
		};
		 modelLuanVan1.addRow(row2);
	}

}
