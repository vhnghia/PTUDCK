package FrmGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.ChiTietLuanVanDAO;
import DAO.GiangVienDAO;
import DAO.KhoaDAO;
import DAO.LuanVanDAO;
import Entites.GiangVien;
import Entites.Khoa;
import Entites.LuanVan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.LuanVanDAO;
import Entites.LuanVan;

public class GiaoDienThemLuanVan extends JFrame implements ActionListener,MouseListener{
	private JButton btnTimKiem, btnClear,btnThem,btnSua,btnXoa;
	private JPanel jp;
	private JLabel lbTenLuanVan, lbTomTat, lbNoiDung, lbMaGV, lbGVHD, lbTTLV,lbLogo,lbKhoa;
	private JTextField jtTenLuanVan, jtMGV, jtNoiDung, jtTomTat, jtGVHD,jtKhoa, jtMSSV1;
	private JMenuItem menuIQLSV , menuIDangXuat, menuIThoat, menuIQLGV, menuIThongKe, menuIThemHoiDong,MenuIDiem, menuQLDSV, menuIXemThongTinSV,menuIDoiMatKhauSV,menuIXemKQHT, menuIXemThongTinGV,menuIDoiMatKhauGV;
	private JMenu menu1,menu2,menuThongKe,menuSinhVien,menuGiangVien; 
	private JMenuBar menuBar;
	private JComboBox comboKhoa;
	private DefaultTableModel modelLuanVan, modelGiangVien;
	private JTable jtTable,jtTableGiangVien;
	private LuanVanDAO lvDAO;
	private List<LuanVan> lv;
	private List<GiangVien> gv;
	private int pos=0;
	private GiangVienDAO gvDAO;
	private ArrayList<String> items = new ArrayList<String>();
	public GiaoDienThemLuanVan() {
		setTitle("Giao Diện Admin");
		setSize(1250, 750);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Show();
	}
	
	public void Show() {
		jp = new JPanel();
		jp.setLayout(new BorderLayout());
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
		menuThongKe.add(menuIThongKe);
		menuSinhVien.add(menuIXemThongTinSV);
		menuSinhVien.add(menuIDoiMatKhauSV);
		menuSinhVien.add(menuIXemKQHT);
		menuGiangVien.add(menuIXemThongTinGV);
		menuGiangVien.add(menuIDoiMatKhauGV);
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
		jp.add(menuBar,BorderLayout.NORTH);
		
		JPanel jpCenter = new JPanel();
		jpCenter.setPreferredSize(new Dimension(1120,160));
		jp.add(jpCenter,BorderLayout.CENTER);
		
		JPanel jpTTSVNorth = new JPanel();
		jpTTSVNorth.setPreferredSize(new Dimension(1120,350));
		jpTTSVNorth.setLayout(null);

		lbTTLV = new JLabel("QUẢN LÍ KHOÁ LUẬN TỐT NGHIỆP");
		lbTTLV.setFont(new Font("Arial",Font.BOLD, 24));
		lbTTLV.setForeground(Color.RED);
		jpTTSVNorth.add(lbTTLV);
		
		gv = new ArrayList<GiangVien>();
		gvDAO = new GiangVienDAO();
		gv = gvDAO.GetAll();
		JPanel jpThemLuanVan = new JPanel();
		JScrollPane scrollhd1;
		String Header1 [] = {"Mã giảng viên","Tên giảng viên","Khoa"};
		modelGiangVien = new DefaultTableModel(Header1,0);
		jtTableGiangVien = new JTable(modelGiangVien);
		jp.add(scrollhd1 = new JScrollPane(jtTableGiangVien,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd1.setBorder(BorderFactory.createTitledBorder("Thông Tin Quản Lý Luận Văn Giảng Viên"));
		scrollhd1.setPreferredSize(new Dimension(550,180));
		jpThemLuanVan.add(scrollhd1);
		jpThemLuanVan.setBounds(550,90,600,400);
		jpTTSVNorth.add(jpThemLuanVan);
		NapVaoBangGiangVien();

		
		
		lbTenLuanVan = new JLabel("Tên luận văn: ");
		jtTenLuanVan = new JTextField(10);
		jpTTSVNorth.add(lbTenLuanVan);		
		jpTTSVNorth.add(jtTenLuanVan);
		
		lbTomTat = new JLabel("Tóm tắt luận văn: ");
		jtTomTat = new JTextField(10);
		jpTTSVNorth.add(lbTomTat);
		jpTTSVNorth.add(jtTomTat);
		
		lbNoiDung = new JLabel("Nội dung: ");
		jtNoiDung = new JTextField(10);
		jpTTSVNorth.add(lbNoiDung);
		jpTTSVNorth.add(jtNoiDung);
		
		KhoaDAO kDAO = new KhoaDAO();
		List<String> list = kDAO.maKhoa();
		String [] maKhoa = new String[list.size()];
		for(int i = 0; i<list.size(); i++)
			maKhoa[i] = list.get(i);
		comboKhoa = new JComboBox<String>();
		comboKhoa.setModel(new DefaultComboBoxModel<String>(maKhoa));
		lbKhoa = new JLabel("Khoa:");
		jpTTSVNorth.add(lbKhoa);
		jpTTSVNorth.add(comboKhoa);
		
		lbMaGV= new JLabel("Mã giảng viên: ");
		jtMGV= new JTextField(10);
		jpTTSVNorth.add(lbMaGV);
		jpTTSVNorth.add(jtMGV);

		lbGVHD = new JLabel("Giáo viên hướng dẫn:");
		jtGVHD = new JTextField(10);
		jpTTSVNorth.add(lbGVHD);
		jpTTSVNorth.add(jtGVHD);

		btnTimKiem = new JButton("Tìm kiếm: ");
		jtMSSV1 = new JTextField(10);
		jpTTSVNorth.add(btnTimKiem);
		jpTTSVNorth.add(jtMSSV1);
		//thiet lap compoent
		
		btnClear = new JButton("Xoá Trắng");
		jpTTSVNorth.add(btnClear);
		
		btnThem = new JButton("Thêm");
		jpTTSVNorth.add(btnThem);
		
		btnXoa = new JButton("Xoá");
		jpTTSVNorth.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		jpTTSVNorth.add(btnSua);
		
		
		lbTTLV.setBounds(350,20,500,30);
		
		lbTenLuanVan.setBounds(60,100,150,20);
		jtTenLuanVan.setBounds(210,100,300,20);
		
		lbTomTat.setBounds(60,135,150,20);
		jtTomTat.setBounds(210,135,300,20);
		
		lbNoiDung.setBounds(60,165,150,20);
		jtNoiDung.setBounds(210,165,300,20);
		
		lbKhoa.setBounds(60,195,150,20);
		comboKhoa.setBounds(210,195,300,20);
		
		lbMaGV.setBounds(60,225,150,20);
		jtMGV.setBounds(210,225,300,20);
		
		lbGVHD.setBounds(60,255,150,20);
		jtGVHD.setBounds(210,255,300,20);
		
		btnThem.setBounds(60, 310, 150,20);
		btnXoa.setBounds(220,310,150,20);
		
		btnSua.setBounds(380,310,150,20);
		
//		btnThem.setBounds(500,310,150,20);
//		btnXoa.setBounds(620,310,150,20);
//		btnSua.setBounds(740,310,150,20);
		jpCenter.add(jpTTSVNorth,BorderLayout.NORTH);
		
		JPanel jpLuanVan = new JPanel();
		JScrollPane scrollhd;
		String Header [] = {"Mã luận văn","Tên luận văn","Tóm tắt","Nội dung","Khoa","Giáo viên hướng dẫn"};
		modelLuanVan = new DefaultTableModel(Header,0);
		jtTable = new JTable(modelLuanVan);
		jp.add(scrollhd = new JScrollPane(jtTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd.setBorder(BorderFactory.createTitledBorder("Thông Tin Quản Lý Luận Văn Giảng Viên"));
		scrollhd.setPreferredSize(new Dimension(1110,180));
		jpLuanVan.add(scrollhd);
		jpCenter.add(jpLuanVan);
		
		lvDAO = new LuanVanDAO();
		lv = new ArrayList<LuanVan>();
		lv = lvDAO.getAllLuanVan();
		NapVaoBang(lv);
		
		JPanel jpBot = new JPanel();
		jpBot.setPreferredSize(new Dimension(1200,100));
		jpBot.setLayout(null);
		btnTimKiem = new JButton("Tìm kiếm:");
		jpBot.add(btnTimKiem);
		btnTimKiem.setBounds(50,30,120,30);
		
		jtMSSV1 = new JTextField(10);
		jpBot.add(jtMSSV1);
		jtMSSV1.setBounds(180,30,120,30);
		
		btnClear = new JButton("Xoá trắng");
		jpBot.add(btnClear);
		btnClear.setBounds(300,30,120,30);
		
		jpCenter.add(jpBot,BorderLayout.SOUTH);
		
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
		// Dang Ky su kien

		menuIDangXuat.addActionListener(this);
		menuIThoat.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnClear.addActionListener(this);
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
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		jtTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = jtTable.getSelectedRow();
				fillForm(row);
			}
		});
		jtTableGiangVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row1 = jtTableGiangVien.getSelectedRow();
				fillForm1(row1);
			}
		});
		
		for (int i = 0; i < jtTable.getRowCount(); i++)
			items.add(jtTable.getValueAt(i, 0).toString());
		setupAutoComplete(jtMSSV1, items);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource().equals(btnThem)) {
			int dongDaChon = jtTableGiangVien.getSelectedRow();
			if(!jtTenLuanVan.getText().toString().equalsIgnoreCase("") && !jtNoiDung.getText().toString().equalsIgnoreCase("") && !jtTomTat.getText().toString().equalsIgnoreCase("") && !jtMGV.getText().toString().equalsIgnoreCase("") && !jtGVHD.getText().toString().equalsIgnoreCase("")) {
				if(dongDaChon==-1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn giảng viên trên bảng");
				}else {

							LuanVan luanVan = new LuanVan();
							Khoa khoa = new Khoa();
							KhoaDAO kDAO = new KhoaDAO();
							khoa = kDAO.TimKhoa(comboKhoa.getItemAt(comboKhoa.getSelectedIndex())+"");
							System.out.println(khoa.getMaKhoa());
							GiangVien gv = new GiangVien();
							GiangVienDAO gvDAO = new GiangVienDAO();
							gv = gvDAO.TimTheoMaGiangVien(jtMGV.getText().toString());
							luanVan.setTenLuanVan(jtTenLuanVan.getText().toString());
							luanVan.setTomTatLuanVan(jtTomTat.getText().toString());
							luanVan.setNoiDung(jtNoiDung.getText().toString());
							luanVan.setKhoa(khoa);
							luanVan.setGiangVien(gv);
							if(khoa.getMaKhoa().equalsIgnoreCase("CNTT") || khoa.getMaKhoa().equalsIgnoreCase("XD"))
								luanVan.setLinhVuc("Ki Thuat");
							else
								luanVan.setLinhVuc("Kinh Te");
							lvDAO.ThemLuanVan(luanVan);
							int n = modelLuanVan.getRowCount();
							for(int sl=0; sl<n; sl++) {
								modelLuanVan.removeRow(modelLuanVan.getRowCount()-1);
							}
							lv = new ArrayList<LuanVan>();
							lv = lvDAO.getAllLuanVan();
							NapVaoBang(lv);
							jtTableGiangVien.clearSelection();
							Clear();
				}	
										
			}else {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin luận văn");
			}
		}
		
		if(e.getSource().equals(btnXoa)) {
			int i = jtTable.getSelectedRow();
			if(i==-1)
				JOptionPane.showMessageDialog(null, "Vui lòng chọn luận văn muốn xoá");
			else {
				int ma = Integer.parseInt(jtTable.getValueAt(i, 0)+"");
				int click = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xoá luận văn này không?","Xoá luận văn",JOptionPane.YES_NO_OPTION);
				if(click==JOptionPane.YES_OPTION) 
				{
					ChiTietLuanVanDAO ctlvDAO = new ChiTietLuanVanDAO();
					int soLuong = ctlvDAO.soLuong(ma);
					if(soLuong>=2) {
						JOptionPane.showMessageDialog(null,"Đã đủ số lượng không thể xoá luận văn");
					}
					else
						{							
							lvDAO.XoaLuanVan(ma);
							jtTable.clearSelection();
							int soDong = modelLuanVan.getRowCount();
							for(int k=0;k<soDong; k++) 
								modelLuanVan.removeRow(modelLuanVan.getRowCount()-1);
							lv = new ArrayList<LuanVan>();
							lv = lvDAO.getAllLuanVan();
							NapVaoBang(lv);
							Clear();
							JOptionPane.showMessageDialog(null, "Xoá thành công");
						}
				}
			}
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
		
		if(e.getSource().equals(btnSua)) {
			int dongDaChon = jtTable.getSelectedRow();
			if(dongDaChon==-1) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn luận văn để cập nhật");
			}else {
				if(!jtTenLuanVan.getText().toString().equalsIgnoreCase("") && !jtNoiDung.getText().toString().equalsIgnoreCase("") && !jtTomTat.getText().toString().equalsIgnoreCase("")) {
					int mssv = Integer.parseInt(jtTable.getValueAt(dongDaChon, 0)+"");
					String tenLV = jtTenLuanVan.getText().toString();
					String noiDung = jtNoiDung.getText().toString();
					String tomTat = jtTomTat.getText().toString();
					lvDAO.CapNhatLuanVan(mssv,tenLV,noiDung,tomTat);
					jtTable.setValueAt(jtTenLuanVan.getText().toString(), dongDaChon, 1);
					jtTable.setValueAt(jtTomTat.getText().toString(), dongDaChon, 2);
					jtTable.setValueAt(jtNoiDung.getText().toString(), dongDaChon, 3);
					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					Clear();
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
			}
		}
		
		if(e.getSource().equals(btnClear)) {
			Clear();
			jtTable.clearSelection();
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
		
		if(e.getSource().equals(menuIXemThongTinGV)) {
			GiaoDienTTGV ttgv = new GiaoDienTTGV();
			ttgv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(btnTimKiem)) {
			String ma = jtMSSV1.getText().toString();
			if (ma.equalsIgnoreCase("") || ma.equalsIgnoreCase(null)) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mã số sinh ");
			} else {
				LuanVanDAO lvdao = new LuanVanDAO();
				int i = lvdao.getAllLuanVan(ma);
				jtTable.requestFocus();
				jtTable.changeSelection(i, 1, false, false);

			}
		}
		
	}

	public void NapVaoBangGiangVien() {
		for(int i=0; i<gv.size(); i++) {
			String rowdata[] = {
					gv.get(i).getMaGiangVien(),
					gv.get(i).getTenGiangVien(),
					gv.get(i).getKhoa().getTenKhoa()
			};
			modelGiangVien.addRow(rowdata);
	
		}
	}
	
	public void NapVaoBang (List<LuanVan> lv) {
		for(int i=0; i<lv.size(); i++) {
			String row[] = {
					lv.get(i).getMaLuanVan()+"",
					lv.get(i).getTenLuanVan(),
					lv.get(i).getTomTatLuanVan(),
					lv.get(i).getNoiDung(),
					lv.get(i).getKhoa().getTenKhoa(),
					lv.get(i).getGiangVien().getTenGiangVien()
			};
			modelLuanVan.addRow(row);
	
		}
		
	}
	
	public void fillForm(int row) {
		if(row!=-1) {
			jtTenLuanVan.setText(jtTable.getValueAt(row,1)+"");
			jtTomTat.setText(jtTable.getValueAt(row,2)+"");
			jtNoiDung.setText(jtTable.getValueAt(row,3)+"");
		}
	}
	
	public void fillForm1(int row1) {
		String tenKhoa = "";
		if(row1!=-1) {
			jtMGV.setText(jtTableGiangVien.getValueAt(row1, 0)+"");
			jtGVHD.setText(jtTableGiangVien.getValueAt(row1, 1)+"");
			tenKhoa = jtTableGiangVien.getValueAt(row1, 2)+"";
			if(tenKhoa.equalsIgnoreCase("Cong Nghe Thong Tin"))
				comboKhoa.setSelectedItem("CNTT");
			else if(tenKhoa.equalsIgnoreCase("Xay Dung"))
				comboKhoa.setSelectedItem("XD");
			else
				comboKhoa.setSelectedItem("QTKD");
		}
	}
	
	public void Clear() {
		comboKhoa.setSelectedIndex(0);
		jtMGV.setText("");
		jtGVHD.setText("");
		jtTenLuanVan.setText("");
		jtTomTat.setText("");
		jtNoiDung.setText("");
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private static boolean isAdjusting(JComboBox cbInput) {
		if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
			return (Boolean) cbInput.getClientProperty("is_adjusting");
		}
		return false;
	}

	private static void setAdjusting(JComboBox cbInput, boolean adjusting) {
		cbInput.putClientProperty("is_adjusting", adjusting);
	}

	public static void setupAutoComplete(JTextField txtInput, ArrayList<String> items) {
		final DefaultComboBoxModel model = new DefaultComboBoxModel();
		final JComboBox cbInput = new JComboBox(model) {
			public Dimension getPreferredSize() {
				return new Dimension(super.getPreferredSize().width, 0);
			}
		};
		setAdjusting(cbInput, false);
		for (String item : items) {
			model.addElement(item);
		}
		cbInput.setSelectedItem(null);
		cbInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isAdjusting(cbInput)) {
					if (cbInput.getSelectedItem() != null) {
						txtInput.setText(cbInput.getSelectedItem().toString());
					}
				}
			}
		});

		txtInput.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				setAdjusting(cbInput, true);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (cbInput.isPopupVisible()) {
						e.setKeyCode(KeyEvent.VK_ENTER);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					e.setSource(cbInput);
					cbInput.dispatchEvent(e);
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						txtInput.setText(cbInput.getSelectedItem().toString());
						cbInput.setPopupVisible(false);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					cbInput.setPopupVisible(false);
				}
				setAdjusting(cbInput, false);
			}
		});
		txtInput.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateList();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateList();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateList();
			}

			private void updateList() {
				setAdjusting(cbInput, true);
				model.removeAllElements();
				String input = txtInput.getText();
				if (!input.isEmpty()) {
					for (String item : items) {
						if (item.toLowerCase().startsWith(input.toLowerCase())) {
							model.addElement(item);
						}
					}
				}
				cbInput.setPopupVisible(model.getSize() > 0);
				setAdjusting(cbInput, false);
			}
		});
		txtInput.setLayout(new BorderLayout());
		txtInput.add(cbInput, BorderLayout.SOUTH);
	}
	
}
