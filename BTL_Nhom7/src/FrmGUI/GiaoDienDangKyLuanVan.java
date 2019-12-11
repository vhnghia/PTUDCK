package FrmGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
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
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.ChiTietLuanVanDAO;
import DAO.LuanVanDAO;
import DAO.SinhVienDAO;
import Entites.ChiTietLuanVan;
import Entites.LuanVan;
import Entites.SinhVien;

public class GiaoDienDangKyLuanVan extends JFrame implements ActionListener{
	private JLabel lbMaLuanVan, lbTenLuanVan, lbTomTatLuanVan, lbTenGiangVien;
	private JTextField jtMaLuanVan, jtTenLuanVan, jtTomTatLuanVan, jtTenGiangVien;
	private JButton btnDangKy;
	private JPanel jp;
	private JMenuItem menuIQLSV , menuIDangXuat, menuIThoat, menuIQLGV, menuIThongKe, menuIThemHoiDong,MenuIDiem, menuQLDSV, menuIXemThongTinSV,menuIDoiMatKhauSV,menuIXemKQHT, menuIDKLV,menuIGDAdmin,menuIThemLV,menuIXemThongTinGV,menuIDoiMatKhauGV, menuIHome;
	private JMenu menu1,menu2,menuThongKe,menuSinhVien,menuGiangVien; 
	private JMenuBar menuBar;
	private DefaultTableModel modelDangKy;
	private JTable jtTableDangKy;
	private List<LuanVan> listLV;
	private LuanVanDAO lvDAO;
	public GiaoDienDangKyLuanVan() {
		// TODO Auto-generated constructor stub
		setTitle("Đăng Ký Luận Văn Sinh Viên");
		setSize(1400,750);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Show();
	}
	
	public void Show() {
		jp = new JPanel();
		jp.setLayout(new BorderLayout());
		
		menuBar = new JMenuBar();
		menuBar = new JMenuBar();
		menu1 = new JMenu("Quản lý");
		menu2 = new JMenu("Hệ thống");
		menuThongKe = new JMenu("Thống kê");
		menuSinhVien = new JMenu("Sinh Viên");
		menuGiangVien = new JMenu("Giảng Viên");
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menuThongKe);
		menuBar.add(menuSinhVien);
		menuBar.add(menuGiangVien);
		//Menu Con chức năng 
		menuIQLSV = new JMenuItem("Quản lý sinh viên");
		menuIQLGV = new JMenuItem("Quản lý giảng viên");
		menuIThongKe = new JMenuItem("Thống kê luận văn");
		menuQLDSV = new JMenuItem("Quản lí điểm sinh viên");
		menuIXemThongTinSV = new JMenuItem("Xem thông tin");
		menuIDoiMatKhauSV = new JMenuItem("Đổi mật khẩu");
		menuIXemKQHT = new JMenuItem("Kết quả điểm thi");
		menuIDoiMatKhauGV = new JMenuItem("Đổi mật khẩu");
		menuIXemThongTinGV = new JMenuItem("Xem thông tin");
		menuIThemLV = new JMenuItem("Thêm luận văn");
		menuIDKLV = new JMenuItem("Đăng ký luận văn");
		menuIGDAdmin = new JMenuItem("Tìm kiếm luận văn");
		menuIHome =  new JMenuItem("Trang chủ");
		menuIDangXuat = new JMenuItem("Đăng xuất");
		menuIThoat = new JMenuItem("Thoát hệ thống");
		menuIThemHoiDong = new JMenuItem("Tạo hội đồng");
		MenuIDiem = new JMenuItem("Chấm điểm sinh viên");
		menu1.add(menuIQLGV);
		menu1.add(menuIQLSV);
		menu1.add(menuIThemHoiDong);
		menu2.add(menuIDangXuat);
		menu2.add(menuIThoat);
		menu1.add(MenuIDiem);
		menu1.add(menuQLDSV);
		menu1.add(menuIThemLV);
		menu1.add(menuIGDAdmin);
		menu2.add(menuIHome);
		menuThongKe.add(menuIThongKe);
		menuSinhVien.add(menuIXemThongTinSV);
		menuSinhVien.add(menuIDoiMatKhauSV);
		menuSinhVien.add(menuIXemKQHT);
		menuSinhVien.add(menuIDKLV);
		menuGiangVien.add(menuIXemThongTinGV);
		menuGiangVien.add(menuIDoiMatKhauGV);
		
		ImageIcon imgDKLV = new ImageIcon("Images/dklv.png");
		ImageIcon imgTLV = new ImageIcon("Images/tlv.png");
		ImageIcon imgTK = new ImageIcon("Images/TimKiem.png");
		ImageIcon imgGV = new ImageIcon("Images/gv.png");
		ImageIcon imgPW = new ImageIcon("Images/ps.png");
		ImageIcon imgKQHT = new ImageIcon("Images/kqht.png");
		ImageIcon imgStudent = new ImageIcon("Images/st.png");
		ImageIcon imgQLD = new ImageIcon("Images/qldiem.png");
		ImageIcon img2 = new ImageIcon("Images/ql.png");
		ImageIcon img4 = new ImageIcon("Images/dx.png");
		ImageIcon img5 = new ImageIcon("Images/ht.png");
		ImageIcon img6 = new ImageIcon("Images/thoat.png");
		ImageIcon img1 = new ImageIcon("Images/st.png");
		ImageIcon img3 = new ImageIcon("Images/gv.png");
		ImageIcon img7 = new ImageIcon("Images/tk.png");		
		ImageIcon img8 = new ImageIcon("Images/kqtk.png");
		ImageIcon img9 = new ImageIcon("Images/HD.png");
		ImageIcon imgDiem = new ImageIcon("Images/diem.png");
		ImageIcon imgHome = new ImageIcon("Images/home.png");
		menu1.setIcon(img2);
		menu2.setIcon(img5);
		menuIDangXuat.setIcon(img4);
		menuIQLSV.setIcon(img2);
		menuIThoat.setIcon(img6);
		menuIQLGV.setIcon(img3);
		menuIQLSV.setIcon(img1);
		menuIThongKe.setIcon(img8);
		menuThongKe.setIcon(img7);
		menuIThemHoiDong.setIcon(img9);
		MenuIDiem.setIcon(imgDiem);
		menuQLDSV.setIcon(imgQLD);
		menuSinhVien.setIcon(imgStudent);
		menuIDoiMatKhauSV.setIcon(imgPW);
		menuIXemKQHT.setIcon(imgKQHT);
		menuIXemThongTinSV.setIcon(imgStudent);
		menuIDoiMatKhauGV.setIcon(imgPW);
		menuGiangVien.setIcon(imgGV);
		menuIXemThongTinGV.setIcon(imgGV);
		menuIDKLV.setIcon(imgDKLV);
		menuIThemLV.setIcon(imgTLV);
		menuIGDAdmin.setIcon(imgTK);
		menuIHome.setIcon(imgHome);
		jp.add(menuBar,BorderLayout.NORTH);
		
		
		JPanel jpCenter = new JPanel();
		jpCenter.setPreferredSize(new Dimension(1120,680));
		jp.add(jpCenter,BorderLayout.CENTER);
		
		JPanel jpTTSVNorth = new JPanel();
		jpTTSVNorth.setPreferredSize(new Dimension(1300,100));
		jpTTSVNorth.setBackground(Color.WHITE);
		jpTTSVNorth.setLayout(null);
		
		lbMaLuanVan = new JLabel("Mã luận văn:");
		jpTTSVNorth.add(lbMaLuanVan);
		jtMaLuanVan = new JTextField(10);
		jpTTSVNorth.add(jtMaLuanVan);
		jtMaLuanVan.setEditable(false);
		lbMaLuanVan.setBounds(30,40,130,30);
		jtMaLuanVan.setBounds(120,40,130,30);
		
		lbTenLuanVan = new JLabel("Tên luận văn:");
		jpTTSVNorth.add(lbTenLuanVan);
		jtTenLuanVan = new JTextField(10);
		jpTTSVNorth.add(jtTenLuanVan);
		lbTenLuanVan.setBounds(260,40,130,30);
		jtTenLuanVan.setBounds(360,40,220,30);
		
		lbTomTatLuanVan = new JLabel("Tóm tắt luận văn:");
		jpTTSVNorth.add(lbTomTatLuanVan);
		jtTomTatLuanVan = new JTextField(10);
		jpTTSVNorth.add(jtTomTatLuanVan);
		lbTomTatLuanVan.setBounds(580,40,130,30);
		jtTomTatLuanVan.setBounds(700,40,250,30);
		
		lbTenGiangVien = new JLabel("GV hướng dẫn:");
		jpTTSVNorth.add(lbTenGiangVien);
		jtTenGiangVien = new JTextField(10);
		jpTTSVNorth.add(jtTenGiangVien);
		lbTenGiangVien.setBounds(980,40,130,30);
		jtTenGiangVien.setBounds(1080,40,180,30);
		
		jpCenter.add(jpTTSVNorth,BorderLayout.NORTH);
		
		JPanel jpBangDangKy = new JPanel();
		JScrollPane scrollhd;
		String [] Header = {"Mã luận văn","Tên luận văn","Tóm tắt","Nội dung","Giảng viên hướng dẫn"};
		modelDangKy = new DefaultTableModel(Header,0);
		jtTableDangKy = new JTable(modelDangKy);
		jp.add(scrollhd = new JScrollPane(jtTableDangKy, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd.setBorder(BorderFactory.createTitledBorder("Danh Sách Luận Văn"));
		scrollhd.setPreferredSize(new Dimension(1300,500));
		jpBangDangKy.add(scrollhd);
		jpCenter.add(jpBangDangKy,BorderLayout.CENTER);
		
		JPanel jpSouth = new JPanel();
		jpSouth.setPreferredSize(new Dimension(1300,100));
		jpSouth.setLayout(null);
		
		btnDangKy = new JButton("Đăng ký");
		jpSouth.add(btnDangKy);
		btnDangKy.setBounds(1150,30,150,30);
		jpCenter.add(jpSouth,BorderLayout.SOUTH);
		
		listLV = new ArrayList<LuanVan>();
		lvDAO = new LuanVanDAO();
		listLV = lvDAO.getAllLuanVan();
		NapDanhSachLuanVan();
		
		
		add(jp);
		menuIDangXuat.addActionListener(this);
		menuIThoat.addActionListener(this);
		menuIQLGV.addActionListener(this);
		menuIQLSV.addActionListener(this);
		menuIThongKe.addActionListener(this);
		menuIThemHoiDong.addActionListener(this);
		MenuIDiem.addActionListener(this);
		menuQLDSV.addActionListener(this);
		menuIXemKQHT.addActionListener(this);
		menuIDoiMatKhauSV.addActionListener(this);
		menuIXemThongTinSV.addActionListener(this);
		menuIXemThongTinGV.addActionListener(this);
		menuIDoiMatKhauGV.addActionListener(this);
		menuIDKLV.addActionListener(this);
		menuIGDAdmin.addActionListener(this);
		menuIThemLV.addActionListener(this);
		menuIHome.addActionListener(this);
		jtTableDangKy.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = jtTableDangKy.getSelectedRow();
				fillForm(row);
			}
		});
		btnDangKy.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(menuIDKLV))
		{
			GiaoDienDangKyLuanVan gddklv = new GiaoDienDangKyLuanVan();
			gddklv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIGDAdmin)) {
			GiaoDienAdmin gda = new GiaoDienAdmin();
			gda.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIThemLV)) {
			GiaoDienThemLuanVan gdtlv = new GiaoDienThemLuanVan();
			gdtlv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIDangXuat)) {
			GiaoDienDangNhap gddn = new GiaoDienDangNhap();
			gddn.setVisible(true);
			dispose();
		}

		if(e.getSource().equals(menuIThoat)) {
			int click = JOptionPane.showConfirmDialog(null,"Bạn có muốn thoát hệ thống không?","Thoát hệ thống",JOptionPane.YES_NO_OPTION);
			if(click == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		
		if(e.getSource().equals(menuIQLGV)) {
			GiaoDienQuanLiGiangVien gdqlgv = new GiaoDienQuanLiGiangVien();
			gdqlgv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIQLSV)) {
			GiaoDienQuanLiSinhVien gdqlsv = new GiaoDienQuanLiSinhVien();
			gdqlsv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIThongKe)) {
			GiaoDienThongKe gdtk = new GiaoDienThongKe();
			gdtk.setVisible(true);
		}
		
		if(e.getSource().equals(menuIThemHoiDong)) {
			GiaoDienThemHoiDong gdthd = new GiaoDienThemHoiDong();
			gdthd.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(MenuIDiem)) {
			GiaoDienChamDiemSinhVien gdcdsv = new GiaoDienChamDiemSinhVien();
			gdcdsv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuQLDSV)) {
			GiaoDienQuanLiDiemSinhVien gdqldsv = new GiaoDienQuanLiDiemSinhVien();
			gdqldsv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIXemKQHT)) {
			GiaoDienKetQuaHocTap gdkqht = new GiaoDienKetQuaHocTap();
			gdkqht.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIDoiMatKhauSV)) {
			GiaoDienCapNhatMatKhau gdcnmk = new GiaoDienCapNhatMatKhau();
			gdcnmk.setVisible(true);
		}
		
		if(e.getSource().equals(menuIXemThongTinSV)) {
			GiaoDienTTSV gdttsv = new GiaoDienTTSV();
			gdttsv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIHome)) {
			GiaoDienAdmin1 gda1 = new GiaoDienAdmin1();
			gda1.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIXemThongTinGV)) {
			GiaoDienTTGV ttgv = new GiaoDienTTGV();
			ttgv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(btnDangKy)) {
			int dongDaChon = jtTableDangKy.getSelectedRow();
			if(dongDaChon==-1) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn luận văn trên bảng");
				return;
			}
			ChiTietLuanVanDAO ctlvDAO = new ChiTietLuanVanDAO();
			int n = ctlvDAO.TimMa("103");
			if(n!=0) {
				JOptionPane.showMessageDialog(null, "Sinh viên đã có luận văn không thể đăng ký");
			}else {
				LuanVan lv = new LuanVan();
				LuanVanDAO lvDAO = new LuanVanDAO();
				lv = lvDAO.TimLuanVan(jtMaLuanVan.getText().toString());
				SinhVien sv = new SinhVien();
				SinhVienDAO svDAO = new SinhVienDAO();
				sv = svDAO.TimTheoMaSinhVien("103");
				if(lv.getKhoa().getMaKhoa().equalsIgnoreCase(sv.getKhoaSV().getMaKhoa())) {
					int soLuong = ctlvDAO.soLuong(Integer.parseInt(jtMaLuanVan.getText().toString()));
					if(soLuong>=2){
						JOptionPane.showMessageDialog(null, "Đã đủ số lượng sinh viên không thể đăng ký luận văn này");
					}else {
						ChiTietLuanVan ctlv = new ChiTietLuanVan();
						ctlv.setSinhVien(sv);
						ctlv.setLuanVan(lv);
						LocalDate lc = LocalDate.now();
						Date date = new Date(lc.getYear()-1900,lc.getMonth().getValue(),lc.getDayOfMonth());
						ctlv.setNgayDangKi(date);
						ctlvDAO.DangKyLuanVan(ctlv);
						JOptionPane.showMessageDialog(null, "Ok");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn luận văn cùng khoa sinh viên");
				}
			}
		}
	}
	
	public void fillForm(int row) {
		if(row!=-1) {
			jtMaLuanVan.setText(jtTableDangKy.getValueAt(row, 0)+"");
			jtTenLuanVan.setText(jtTableDangKy.getValueAt(row, 1)+"");
			jtTomTatLuanVan.setText(jtTableDangKy.getValueAt(row, 2)+"");
			jtTenGiangVien.setText(jtTableDangKy.getValueAt(row, 4)+"");
		}
	}
	
	public void NapDanhSachLuanVan() {
		for(int i = 0; i<listLV.size(); i++)
			NapDanhSachVaoBang(listLV.get(i));
	}
	
	public void NapDanhSachVaoBang(LuanVan lv) {
		String row [] = {
				lv.getMaLuanVan()+"",
				lv.getTenLuanVan()+"",
				lv.getTomTatLuanVan(),
				lv.getNoiDung(),
				lv.getGiangVien().getTenGiangVien()
		};
		modelDangKy.addRow(row);
	}
}
