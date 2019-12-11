package FrmGUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.DiemVongDAO;
import DAO.LuanVanDAO;
import DAO.SinhVienDAO;
import Entites.DiemVong;
import Entites.LuanVan;
import Entites.SinhVien;

public class GiaoDienQuanLiDiemSinhVien extends JFrame implements ActionListener{
	private JLabel lbDiemPB1, lbDiemPB2, lbDiemPB3, lbDiemPB4, lbDiemPB5,lbTenSinhVien, lbTenLuanVan,lbMSSV, lbTenGiangVien, lbDiemTD1,lbDiemTD2,lbDiemTD3,lbDiemTD4,lbDiemTD5, lbKhoa;
	private JTextField jtDiemPB1, jtDiemPB2, jtDiemPB3, jtDiemPB4, jtDiemPB5,jtTenSinhVien, jtTenLuanVan, jtTenGiangVien,jtDiemTD1,jtDiemTD2,jtDiemTD3,jtDiemTD4,jtDiemTD5;
	private JTable jtTableDiemSinhVien;
	private DefaultTableModel modelDiemSinhVien;
	private List<SinhVien> listSV;
	private JTextField jtMSVV, jttenSV, jtTenDeTai, jtTomTat, jtGVHD,jtKhoa, jtMSSV1;
	private JMenuItem menuIQLSV , menuIDangXuat, menuIThoat, menuIQLGV, menuIThongKe, menuIThemHoiDong,MenuIDiem, menuQLDSV, menuIXemThongTinSV,menuIDoiMatKhauSV,menuIXemKQHT, menuIDKLV,menuIGDAdmin,menuIThemLV,menuIXemThongTinGV,menuIDoiMatKhauGV, menuIHome;
	private JMenu menu1,menu2,menuThongKe,menuSinhVien,menuGiangVien; 
	private JMenuBar menuBar;
	private JPanel jp;
	private List<LuanVan> listLV;
	private List<DiemVong> listDiemVongPB;
	private List<DiemVong> listDiemVongTD;
	private LuanVanDAO lvDAO;
	private DiemVongDAO dvDAO;
	private SinhVienDAO svDAO;
	private Button btnLuu;
	private JComboBox jtMSSV;
	public GiaoDienQuanLiDiemSinhVien() {
		setTitle("Quản Lý Chỉnh Sửa Điểm Vòng Phản Biện");
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

		dvDAO = new DiemVongDAO();
		listSV = new ArrayList<SinhVien>();
		svDAO = new SinhVienDAO();
		listSV = svDAO.GetAll();
		listDiemVongTD = new ArrayList<DiemVong>();

		JPanel jpCenter = new JPanel();
		jpCenter.setPreferredSize(new Dimension(1300,680));
		jp.add(jpCenter,BorderLayout.CENTER);

		JPanel jpTTSVNorth = new JPanel();
		jpTTSVNorth.setPreferredSize(new Dimension(1380,170));
		jpTTSVNorth.setBackground(Color.white);
		jpTTSVNorth.setBorder(BorderFactory.createTitledBorder("Cập nhật điểm sinh viên"));
		jpTTSVNorth.setLayout(null);

		lbMSSV = new JLabel("Mã sinh viên:");
		jpTTSVNorth.add(lbMSSV);
		String [] masv = new String [listSV.size()];
		for(int i=0; i<listSV.size(); i++)
			masv[i] = listSV.get(i).getMssv();
		jtMSSV = new JComboBox<String>();
		jtMSSV.setModel(new DefaultComboBoxModel<String>(masv));
		jpTTSVNorth.add(jtMSSV);
		lbMSSV.setBounds(20,30,120,30);
		jtMSSV.setBounds(120,30,160,30);

		lbTenSinhVien = new JLabel("Tên sinh viên:");
		jpTTSVNorth.add(lbTenSinhVien);
		jtTenSinhVien = new JTextField();
		jpTTSVNorth.add(jtTenSinhVien);
		lbTenSinhVien.setBounds(300,30,120,30);
		jtTenSinhVien.setBounds(400,30,160,30);

		lbKhoa = new JLabel("khoa:");
		jpTTSVNorth.add(lbKhoa);
		jtKhoa = new JTextField();
		jpTTSVNorth.add(jtKhoa);
		lbKhoa.setBounds(580,30,120,30);
		jtKhoa.setBounds(620,30,240,30);

		lbTenLuanVan = new JLabel("Tên luận văn:");
		jpTTSVNorth.add(lbTenLuanVan);
		jtTenLuanVan = new JTextField();
		jpTTSVNorth.add(jtTenLuanVan);
		lbTenLuanVan.setBounds(880,30,120,30);
		jtTenLuanVan.setBounds(980,30,280,30);

		lbDiemTD1 = new JLabel("Điểm thẩm định 1:");
		jpTTSVNorth.add(lbDiemTD1);
		jtDiemTD1 = new JTextField();
		jpTTSVNorth.add(jtDiemTD1);
		lbDiemTD1.setBounds(20,80,160,30);
		jtDiemTD1.setBounds(140,80,100,30);
		jtDiemTD1.setEditable(false);

		lbDiemTD2 = new JLabel("Điểm thẩm định 2:");
		jpTTSVNorth.add(lbDiemTD2);
		jtDiemTD2 = new JTextField();
		jpTTSVNorth.add(jtDiemTD2);
		lbDiemTD2.setBounds(300,80,160,30);
		jtDiemTD2.setBounds(420,80,100,30);
		jtDiemTD2.setEditable(false);

		lbDiemTD3 = new JLabel("Điểm thẩm định 3:");
		jpTTSVNorth.add(lbDiemTD3);
		jtDiemTD3 = new JTextField();
		jpTTSVNorth.add(jtDiemTD3);
		lbDiemTD3.setBounds(580,80,160,30);
		jtDiemTD3.setBounds(700,80,100,30);
		jtDiemTD3.setEditable(false);

		lbDiemTD4 = new JLabel("Điểm thẩm định 4:");
		jpTTSVNorth.add(lbDiemTD4);
		jtDiemTD4 = new JTextField();
		jpTTSVNorth.add(jtDiemTD4);
		lbDiemTD4.setBounds(880,80,160,30);
		jtDiemTD4.setBounds(1000,80,100,30);
		jtDiemTD4.setEditable(false);

		lbDiemTD5 = new JLabel("Điểm thẩm định 5:");
		jpTTSVNorth.add(lbDiemTD5);
		jtDiemTD5 = new JTextField();
		jpTTSVNorth.add(jtDiemTD5);
		lbDiemTD5.setBounds(1120,80,160,30);
		jtDiemTD5.setBounds(1240,80,100,30);
		jtDiemTD5.setEditable(false);

		lbDiemPB1 = new JLabel("Điểm Phản biện 1:");
		jpTTSVNorth.add(lbDiemPB1);
		jtDiemPB1 = new JTextField();
		jpTTSVNorth.add(jtDiemPB1);
		lbDiemPB1.setBounds(20,130,160,30);
		jtDiemPB1.setBounds(140,130,100,30);

		lbDiemPB2 = new JLabel("Điểm Phản biện 2:");
		jpTTSVNorth.add(lbDiemPB2);
		jtDiemPB2 = new JTextField();
		jpTTSVNorth.add(jtDiemPB2);
		lbDiemPB2.setBounds(300,130,160,30);
		jtDiemPB2.setBounds(420,130,100,30);

		lbDiemPB3 = new JLabel("Điểm Phản biện 3:");
		jpTTSVNorth.add(lbDiemPB3);
		jtDiemPB3 = new JTextField();
		jpTTSVNorth.add(jtDiemPB3);
		lbDiemPB3.setBounds(580,130,160,30);
		jtDiemPB3.setBounds(700,130,100,30);

		lbDiemPB4 = new JLabel("Điểm Phản biện 4:");
		jpTTSVNorth.add(lbDiemPB4);
		jtDiemPB4 = new JTextField();
		jpTTSVNorth.add(jtDiemPB4);
		lbDiemPB4.setBounds(880,130,160,30);
		jtDiemPB4.setBounds(1000,130,100,30);

		lbDiemPB5 = new JLabel("Điểm Phản biện 5:");
		jpTTSVNorth.add(lbDiemPB5);
		jtDiemPB5 = new JTextField();
		jpTTSVNorth.add(jtDiemPB5);
		lbDiemPB5.setBounds(1120,130,160,30);
		jtDiemPB5.setBounds(1240,130,100,30);

		jpCenter.add(jpTTSVNorth);

		JPanel jpBangDiemSinhVien = new JPanel();
		JScrollPane scrollhd;
		String [] Header = {"MSSV","Tên sinh viên","Khoa","Điểm TD1","Điểm TD2","Điểm TD3","Điểm TD4","Điểm TD5","Điểm PB1","Điểm PB2","Điểm PB3","Điểm PB4","Điểm PB5"};
		modelDiemSinhVien = new DefaultTableModel(Header,0);
		jtTableDiemSinhVien = new JTable(modelDiemSinhVien);
		jp.add(scrollhd = new JScrollPane(jtTableDiemSinhVien,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH); 
		scrollhd.setBorder(BorderFactory.createTitledBorder("Danh sách điểm sinh viên"));
		scrollhd.setPreferredSize(new Dimension(1380,400));
		jpCenter.add(scrollhd,BorderLayout.CENTER);

		for(int i = 0; i<listSV.size(); i++)
		{
			DiemVong dvtd = new DiemVong();
			dvtd = dvDAO.getDiemVongThamDinh(listSV.get(i).getMssv(), "TD");
			if(dvtd.getDiem().size()==0) {
				float a = 0;
				float b = 0;
				float c = 0;
				float d = 0;
				float e = 0;
				dvtd.getDiem().add(a);
				dvtd.getDiem().add(b);
				dvtd.getDiem().add(c);
				dvtd.getDiem().add(d);
				dvtd.getDiem().add(e);
			}
			listDiemVongTD.add(dvtd);
		}

		listDiemVongPB = new ArrayList<DiemVong>();
		for(int i = 0; i<listSV.size(); i++) {
			DiemVong dvpb = new DiemVong();
			dvpb = dvDAO.getDiemVongThamDinh(listSV.get(i).getMssv(), "PB");
			if(dvpb.getDiem().size()==0) {
				float a = 0;
				float b = 0;
				float c = 0;
				float d = 0;
				float e = 0;
				dvpb.getDiem().add(a);
				dvpb.getDiem().add(b);
				dvpb.getDiem().add(c);
				dvpb.getDiem().add(d);
				dvpb.getDiem().add(e);
			}
			listDiemVongPB.add(dvpb);
		}

		LoadLuanVan();

		JPanel jpSouth = new JPanel();
		jpSouth.setPreferredSize(new Dimension(1380,100));
		jpSouth.setLayout(null);
		jpCenter.add(jpSouth,BorderLayout.SOUTH);
		btnLuu = new Button("Lưu điểm");
		jpSouth.add(btnLuu);
		btnLuu.setBounds(1250,30,100,30);
		add(jp);

		jtTableDiemSinhVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = jtTableDiemSinhVien.getSelectedRow();
				fillForm(row);
			}
		});

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
		btnLuu.addActionListener(this);
		jtMSSV.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if(e.getSource().equals(jtMSSV)) {
			int i = jtMSSV.getSelectedIndex();
			jtTableDiemSinhVien.requestFocus();
			jtTableDiemSinhVien.changeSelection(i, 1, false, false);
		}

		if(e.getSource().equals(btnLuu)) {
			int i = jtTableDiemSinhVien.getSelectedRow();
			if(i==-1)
			{
				JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên trên bảng");
				return ;
			}
			
			if(jtDiemTD1.getText().toString().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Sinh viên chưa có điểm không thể cập nhậ");
				return;
			}
			
			if(!jtDiemPB1.getText().toString().equalsIgnoreCase("") && !jtDiemPB2.getText().toString().equalsIgnoreCase("") && !jtDiemPB3.getText().toString().equalsIgnoreCase("") && !jtDiemPB4.getText().toString().equalsIgnoreCase("") && !jtDiemPB5.getText().toString().equalsIgnoreCase(""))
			{
				if(KiemTraSo()==true) {
					if(KiemTraSoAm()==true) {
						float td1 = Float.parseFloat(jtDiemTD1.getText().toString());
						float td2 = Float.parseFloat(jtDiemTD2.getText().toString());
						float td3 = Float.parseFloat(jtDiemTD3.getText().toString());
						float td4 = Float.parseFloat(jtDiemTD4.getText().toString());
						float td5 = Float.parseFloat(jtDiemTD5.getText().toString());
						float tong = (td1+td2+td3+td4+td5)/5;
						if(tong<5) {
							JOptionPane.showMessageDialog(null, "Sinh viên này đã rớt không thể chỉnh sửa điểm");
							return;
						}else
						{
								String s = jtMSSV.getSelectedItem()+"";
								List<String> list = new ArrayList<String>();
								float pb1 = Float.parseFloat(jtDiemPB1.getText().toString());
								float pb2 = Float.parseFloat(jtDiemPB2.getText().toString());
								float pb3 = Float.parseFloat(jtDiemPB3.getText().toString());
								float pb4 = Float.parseFloat(jtDiemPB4.getText().toString());
								float pb5 = Float.parseFloat(jtDiemPB5.getText().toString());
								if(pb1==0)
								{
									JOptionPane.showMessageDialog(null, "Vui lòng chấm điểm trước khi cập nhật");
									return;
								}else {
									List<Float> diemPB = new ArrayList<Float>();
									diemPB.add(pb1);
									diemPB.add(pb2);
									diemPB.add(pb3);
									diemPB.add(pb4);
									diemPB.add(pb5);
									list = dvDAO.getAllMaGV(s, "PB");
									for(int k= 0; k<5;k++)
										dvDAO.UpdateDiemSinhVien(diemPB.get(k),list.get(k), s, "PB");
									int dongDaChon = jtTableDiemSinhVien.getSelectedRow();
									jtTableDiemSinhVien.setValueAt(pb1+"", dongDaChon, 8);
									jtTableDiemSinhVien.setValueAt(pb2+"", dongDaChon, 9);
									jtTableDiemSinhVien.setValueAt(pb3+"", dongDaChon, 10);
									jtTableDiemSinhVien.setValueAt(pb4+"", dongDaChon, 11);
									jtTableDiemSinhVien.setValueAt(pb5+"", dongDaChon, 12);
									JOptionPane.showMessageDialog(null, "Update thành công");
								}
								
						}

					}else {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập điểm >= 0 và điểm <= 10");
						return;
					}

				}else
				{
					JOptionPane.showMessageDialog(null, "Vui lòng nhập điểm là số");
				}
			}else
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ điểm vòng phản biện");
		}
		
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
		
		if(e.getSource().equals(menuIDoiMatKhauGV)) {
			GIaoDienCapNhatMatKhauGiangVien gddmkgv = new GIaoDienCapNhatMatKhauGiangVien();
			gddmkgv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIXemThongTinSV)) {
			GiaoDienTTSV gdttsv = new GiaoDienTTSV();
			gdttsv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIXemThongTinGV)) {
			GIaoDienCapNhatMatKhauGiangVien ttgv = new GIaoDienCapNhatMatKhauGiangVien();
			ttgv.setVisible(true);
			dispose();
		}

	}

	public void LoadLuanVan() {
		for(int i = 0; i<listSV.size(); i++)
			LoadLuanVanVaoBang(listSV.get(i),listDiemVongTD.get(i),listDiemVongPB.get(i));
	}

	public void LoadLuanVanVaoBang(SinhVien sv,DiemVong dv,DiemVong dv1) {

		if(dv.getDiem().get(0)==0) {
			String diem1 = "";
			String diem2 = "";
			String diem3 = "";
			String diem4 = "";
			String diem5 = "";
			if(dv1.getDiem().get(0)==0) {
				String row[] = {
						sv.getMssv()+"",
						sv.getHoten(),
						sv.getKhoaSV().getTenKhoa(),
						diem1,
						diem2,
						diem3,
						diem4,
						diem5,
						"",
						"",
						"",
						"",
						""
				};
				modelDiemSinhVien.addRow(row);
			}

		}else {
			String row [] = {
					sv.getMssv(),
					sv.getHoten(),
					sv.getKhoaSV().getTenKhoa(),
					dv.getDiem().get(0)+"",
					dv.getDiem().get(1)+"",
					dv.getDiem().get(2)+"",
					dv.getDiem().get(3)+"",
					dv.getDiem().get(4)+"",
					dv1.getDiem().get(0)+"",
					dv1.getDiem().get(1)+"",
					dv1.getDiem().get(2)+"",
					dv1.getDiem().get(3)+"",
					dv1.getDiem().get(4)+""
			};
			modelDiemSinhVien.addRow(row);
		}


	}

	public boolean KiemTraSo() {
		try {
			float diem = Float.parseFloat(jtDiemPB1.getText().toString());
			float diem1 = Float.parseFloat(jtDiemPB2.getText().toString());
			float diem2 = Float.parseFloat(jtDiemPB3.getText().toString());
			float diem3 = Float.parseFloat(jtDiemPB4.getText().toString());
			float diem4 = Float.parseFloat(jtDiemPB5.getText().toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean KiemTraSoAm() {
		float diem = Float.parseFloat(jtDiemPB1.getText().toString());
		float diem1 = Float.parseFloat(jtDiemPB2.getText().toString());
		float diem2 = Float.parseFloat(jtDiemPB3.getText().toString());
		float diem3 = Float.parseFloat(jtDiemPB4.getText().toString());
		float diem4 = Float.parseFloat(jtDiemPB5.getText().toString());
		if((diem<=10 && diem>=0 ) && (diem1<=10 && diem1>=0 ) && (diem2<=10 && diem2>=0 ) && (diem3<=10 && diem3>=0) && (diem4<=10 && diem4>=0 ))
			return true;
		return false;
	}

	public void fillForm(int row) {
		if(row!=-1) {
			jtMSSV.setSelectedItem(jtTableDiemSinhVien.getValueAt(row, 0)+"");
		jtTenSinhVien.setText(jtTableDiemSinhVien.getValueAt(row, 1)+"");
		jtKhoa.setText(jtTableDiemSinhVien.getValueAt(row, 2)+"");
		jtDiemTD1.setText(jtTableDiemSinhVien.getValueAt(row, 3)+"");
		jtDiemTD2.setText(jtTableDiemSinhVien.getValueAt(row, 4)+"");
		jtDiemTD3.setText(jtTableDiemSinhVien.getValueAt(row, 5)+"");
		jtDiemTD4.setText(jtTableDiemSinhVien.getValueAt(row, 6)+"");
		jtDiemTD5.setText(jtTableDiemSinhVien.getValueAt(row, 7)+"");
		jtDiemPB1.setText(jtTableDiemSinhVien.getValueAt(row, 8)+"");
		jtDiemPB2.setText(jtTableDiemSinhVien.getValueAt(row, 9)+"");
		jtDiemPB3.setText(jtTableDiemSinhVien.getValueAt(row, 10)+"");
		jtDiemPB4.setText(jtTableDiemSinhVien.getValueAt(row, 11)+"");
		jtDiemPB5.setText(jtTableDiemSinhVien.getValueAt(row, 12)+"");
	}
	}
}
