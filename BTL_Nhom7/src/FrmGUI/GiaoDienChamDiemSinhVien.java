package FrmGUI;

import java.awt.BorderLayout;
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

import DAO.SinhVienDAO;
import Entites.GiangVien;
import Entites.HoiDong;
import Entites.SinhVien;
import Entites.ChiTietHoiDong;
import Entites.DiemVong;
import DAO.ChiTietHoiDongDAO;
import DAO.DiemVongDAO;
import DAO.HoiDongDAO;
public class GiaoDienChamDiemSinhVien extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbLogo, lbMSSV, lbTenSinhVien, lbKhoa,lbDiemHienCo1,lbDiemHienCo2,lbDiemHienCo3,lbDiemHienCo4,lbDiemHienCo5,lbDiem1,lbDiem2,lbDiem3,lbDiem4,lbDiem5, lbMaHD;
	private JTextField jtMSSV, jtTenSinhVien, jtKhoa,jtDiem1,jtDiem2,jtDiem3,jtDiem4,jtDiem5,jtDiemHienCo1,jtDiemHienCo2,jtDiemHienCo3,jtDiemHienCo4,jtDiemHienCo5;
	private JMenuItem menuIQLSV , menuIDangXuat, menuIThoat, menuIQLGV, menuIThongKe, menuIThemHoiDong,MenuIDiem, menuQLDSV, menuIXemThongTinSV,menuIDoiMatKhauSV,menuIXemKQHT, menuIDKLV,menuIGDAdmin,menuIThemLV,menuIXemThongTinGV,menuIDoiMatKhauGV, menuIHome;
	private JMenu menu1,menu2,menuThongKe,menuSinhVien,menuGiangVien; 
	private JMenuBar menuBar;
	private JPanel jp;
	private JTable jtTableSinhVien, jtTableHoiDong;
	private DefaultTableModel modelSinhVien, modelHoiDong;
	private SinhVienDAO svDAO;
	private DiemVongDAO dvDAO;
	private HoiDongDAO hdDAO;
	private ChiTietHoiDongDAO chiTietHoiDongDAO;
	private JComboBox cboHoiDong;
	private List<SinhVien> dssv;
	private List<DiemVong> dsdv;
	private ArrayList<HoiDong> dshd;
	private List<GiangVien> lGV;
	private JButton btnLuuDiem;
	private int stt = 0;
	private JLabel lbTenHoiDong;
	private JTextField jtTenHoiDong;
	private int k=1;
	public GiaoDienChamDiemSinhVien() {
		// TODO Auto-generated constructor stub
		setTitle("Giao Diện Chấm Điểm Sinh Viên");
		setSize(1250, 750);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GiaoDienChamDiem();
	}

	public void GiaoDienChamDiem() {
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
		ImageIcon imgSave = new ImageIcon("Images/save.png");

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
		jpTTSVNorth.setPreferredSize(new Dimension(900,100));
		jpTTSVNorth.setBackground(Color.WHITE);
		jpTTSVNorth.setBorder(BorderFactory.createTitledBorder("Thao Tác"));
		jpTTSVNorth.setLayout(null);

		hdDAO = new HoiDongDAO();
		dshd = new ArrayList<HoiDong>();
		dshd = hdDAO.getAllHoiDong();

		lbMaHD = new JLabel("Mã Hội Đồng:");
		jpTTSVNorth.add(lbMaHD);
		lbMaHD.setBounds(20,50,100,20);
		lbTenHoiDong = new JLabel("Tên hội đồng");
		jpTTSVNorth.add(lbTenHoiDong);
		lbTenHoiDong.setBounds(250,50,130,20);
		jtTenHoiDong = new JTextField();
		jpTTSVNorth.add(jtTenHoiDong);
		jtTenHoiDong.setBounds(380,50,130,20);
		jtTenHoiDong.setEditable(false);
		int n = dshd.size();
		String [] combo = new String [n];
		for(int i=0; i<n; i++)
			combo[i] = dshd.get(i).getMaHD()+"";
		cboHoiDong = new JComboBox<String>();
		cboHoiDong.setModel(new DefaultComboBoxModel<String>(combo));
		jpTTSVNorth.add(cboHoiDong);

		cboHoiDong.setBounds(120,50,100,20);

		//		


		jpCenter.add(jpTTSVNorth,BorderLayout.NORTH);

		JPanel jpBangSinhVien = new JPanel();
		JScrollPane scrollhd;
		String [] Header = {"Mã số sinh viên","Tên sinh viên","Tên Khoa","Điểm 1","Điểm 2","Điểm 3","Điểm 4","Điểm 5"};
		modelSinhVien = new DefaultTableModel(Header,0);
		jtTableSinhVien = new JTable(modelSinhVien);
		jp.add(scrollhd = new JScrollPane(jtTableSinhVien,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd.setBorder(BorderFactory.createTitledBorder("Danh Sách Sinh Viên"));
		scrollhd.setPreferredSize(new Dimension(900,300));
		jpBangSinhVien.add(scrollhd);
		svDAO = new SinhVienDAO();
		dssv = new ArrayList<SinhVien>();
		dssv = svDAO.getAllSVDTD("TD", 5);
		dsdv = new ArrayList<DiemVong>();
		dvDAO = new DiemVongDAO();
		for(int i=0;i<dssv.size(); i++) {
			DiemVong dv = new DiemVong();			
			dv = dvDAO.getDiemVongPhanBien(dssv.get(i).getMssv(),"PB");
			if(dv.getDiem().size()==0) {
				float a = 0;
				float b = 0;
				float c = 0;
				float d = 0;
				float e = 0;
				dv.getDiem().add(a);
				dv.getDiem().add(b);
				dv.getDiem().add(c);
				dv.getDiem().add(d);
				dv.getDiem().add(e);
			}
			dsdv.add(dv);
		}
		NapDanhSachSinhVien();
		jpCenter.add(scrollhd,BorderLayout.CENTER);

		JPanel jpBangHoiDong = new JPanel();
		JScrollPane scrollhd1;
		String [] Header1 = {"STT","Mã giảng viên","Tên giảng viên","Tên Khoa"};
		modelHoiDong = new DefaultTableModel(Header1,0);
		jtTableHoiDong = new JTable(modelHoiDong);
		jp.add(scrollhd1 = new JScrollPane(jtTableHoiDong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd1.setBorder(BorderFactory.createTitledBorder("Danh Sách Hội Đồng"));
		scrollhd1.setPreferredSize(new Dimension(900,200));
		jpBangHoiDong.add(scrollhd1);

		jpCenter.add(jpBangHoiDong,BorderLayout.CENTER);

		JPanel jpEast = new JPanel();
		jpEast.setPreferredSize(new Dimension(300,700));
		jp.add(jpEast,BorderLayout.EAST);

		JPanel jpEast_ChamDiem = new JPanel();
		jpEast_ChamDiem.setPreferredSize(new Dimension(300,615));
		jpEast_ChamDiem.setBackground(Color.LIGHT_GRAY);
		jpEast_ChamDiem.setBorder(BorderFactory.createTitledBorder("Chấm Điểm Sinh Viên"));
		jpEast_ChamDiem.setLayout(null);

		lbMSSV = new JLabel("Mã sinh viên:");
		jpEast_ChamDiem.add(lbMSSV);
		jtMSSV = new JTextField(10);
		jpEast_ChamDiem.add(jtMSSV);
		lbMSSV.setBounds(20,40,100,30);
		jtMSSV.setBounds(140,40,150,30);
		jtMSSV.setEditable(false);

		lbTenSinhVien = new JLabel("Tên sinh viên:");
		jpEast_ChamDiem.add(lbTenSinhVien);
		jtTenSinhVien = new JTextField(10);
		jpEast_ChamDiem.add(jtTenSinhVien);
		lbTenSinhVien.setBounds(20,80,100,30);
		jtTenSinhVien.setBounds(140,80,150,30);
		jtTenSinhVien.setEditable(false);
		
		lbKhoa = new JLabel("Khoa:");
		jpEast_ChamDiem.add(lbKhoa);
		jtKhoa = new JTextField(10);
		jpEast_ChamDiem.add(jtKhoa);
		lbKhoa.setBounds(20,120,100,30);
		jtKhoa.setBounds(140,120,150,30);
		jtKhoa.setEditable(false);

		lbDiemHienCo1 = new JLabel("Điểm hiện có 1:");
		jpEast_ChamDiem.add(lbDiemHienCo1);
		jtDiemHienCo1 = new JTextField(10);
		jpEast_ChamDiem.add(jtDiemHienCo1);
		lbDiemHienCo1.setBounds(20,160,100,30);
		jtDiemHienCo1.setBounds(140,160,150,30);
		jtDiemHienCo1.setEditable(false);

		lbDiemHienCo2 = new JLabel("Điểm hiện có 2:");
		jpEast_ChamDiem.add(lbDiemHienCo2);
		jtDiemHienCo2 = new JTextField(10);
		jpEast_ChamDiem.add(jtDiemHienCo2);
		lbDiemHienCo2.setBounds(20,200,100,30);
		jtDiemHienCo2.setBounds(140,200,150,30);
		jtDiemHienCo2.setEditable(false);

		lbDiemHienCo3 = new JLabel("Điểm hiện có 3:");
		jpEast_ChamDiem.add(lbDiemHienCo3);
		jtDiemHienCo3 = new JTextField(10);
		jpEast_ChamDiem.add(jtDiemHienCo3);
		lbDiemHienCo3.setBounds(20,240,100,30);
		jtDiemHienCo3.setBounds(140,240,150,30);
		jtDiemHienCo3.setEditable(false);

		lbDiemHienCo4 = new JLabel("Điểm hiện có 4:");
		jpEast_ChamDiem.add(lbDiemHienCo4);
		jtDiemHienCo4 = new JTextField(10);
		jpEast_ChamDiem.add(jtDiemHienCo4);
		lbDiemHienCo4.setBounds(20,280,100,30);
		jtDiemHienCo4.setBounds(140,280,150,30);
		jtDiemHienCo4.setEditable(false);

		lbDiemHienCo5 = new JLabel("Điểm hiện có 5:");
		jpEast_ChamDiem.add(lbDiemHienCo5);
		jtDiemHienCo5 = new JTextField(10);
		jpEast_ChamDiem.add(jtDiemHienCo5);
		lbDiemHienCo5.setBounds(20,320,100,30);
		jtDiemHienCo5.setBounds(140,320,150,30);
		jtDiemHienCo5.setEditable(false);

		lbDiem1 = new JLabel("Điểm giáo viên 1:");
		jpEast_ChamDiem.add(lbDiem1);
		jtDiem1 = new JTextField(10);
		jpEast_ChamDiem.add(jtDiem1);
		lbDiem1.setBounds(20,360,120,30);
		jtDiem1.setBounds(140,360,150,30);


		lbDiem2 = new JLabel("Điểm giáo viên 2:");
		jpEast_ChamDiem.add(lbDiem2);
		jtDiem2 = new JTextField(10);
		jpEast_ChamDiem.add(jtDiem2);
		lbDiem2.setBounds(20,400,120,30);
		jtDiem2.setBounds(140,400,150,30);


		lbDiem3 = new JLabel("Điểm giáo viên 3:");
		jpEast_ChamDiem.add(lbDiem3);
		jtDiem3 = new JTextField(10);
		jpEast_ChamDiem.add(jtDiem3);
		lbDiem3.setBounds(20,440,120,30);
		jtDiem3.setBounds(140,440,150,30);

		lbDiem4 = new JLabel("Điểm giáo viên 4:");
		jpEast_ChamDiem.add(lbDiem4);
		jtDiem4 = new JTextField(10);
		jpEast_ChamDiem.add(jtDiem4);
		lbDiem4.setBounds(20,480,120,30);
		jtDiem4.setBounds(140,480,150,30);

		lbDiem5 = new JLabel("Điểm giáo viên 5:");
		jpEast_ChamDiem.add(lbDiem5);
		jtDiem5 = new JTextField(10);
		jpEast_ChamDiem.add(jtDiem5);
		lbDiem5.setBounds(20,520,120,30);
		jtDiem5.setBounds(140,520,150,30);

		btnLuuDiem = new JButton();
		jpEast_ChamDiem.add(btnLuuDiem);
		btnLuuDiem.setIcon(imgSave);
		btnLuuDiem.setBounds(20,560,80,50);
		btnLuuDiem.setToolTipText("Lưu điểm");
		jpEast.add(jpEast_ChamDiem,BorderLayout.NORTH);

		add(jp);
		jtTableSinhVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = jtTableSinhVien.getSelectedRow();
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
		menuIHome.addActionListener(this);
		cboHoiDong.addActionListener(this);
		btnLuuDiem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(menuIXemThongTinSV)) {
			GiaoDienTTSV gdttsv = new GiaoDienTTSV();
			gdttsv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIXemThongTinGV)) {
			GiaoDienTTGV gdttgv = new GiaoDienTTGV();
			gdttgv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIDoiMatKhauSV)) {
			GiaoDienCapNhatMatKhau gddmksv = new GiaoDienCapNhatMatKhau();
			gddmksv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIDoiMatKhauGV)) {
			GIaoDienCapNhatMatKhauGiangVien gddmkgv1 = new GIaoDienCapNhatMatKhauGiangVien();
			gddmkgv1.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIHome)) {
			GiaoDienAdmin1 gda1 = new GiaoDienAdmin1();
			gda1.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIThoat))
		{
			int click = JOptionPane.showConfirmDialog(null,"Bạn có muốn thoát hệ thống không?","Thoát hệ thống",JOptionPane.YES_NO_OPTION);
			if(click == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		
		if(e.getSource().equals(menuIDangXuat)) {
			GiaoDienDangNhap gddn = new GiaoDienDangNhap();
			gddn.setVisible(true);
			dispose();
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
		
		if(e.getSource().equals(cboHoiDong)) {
			int ma = Integer.parseInt(cboHoiDong.getItemAt(cboHoiDong.getSelectedIndex())+"");
			int s = cboHoiDong.getSelectedIndex();
			jtTenHoiDong.setText(dshd.get(s).getTenHD());
			lGV = new ArrayList<GiangVien>();
			chiTietHoiDongDAO = new ChiTietHoiDongDAO();
			int soDong = jtTableHoiDong.getRowCount();
			if(soDong==0) {
				lGV = chiTietHoiDongDAO.danhSachChiTietHoiDong(ma);
				NapDanhSachGiangVien();
			}else {
				for(int i = 0 ;i<soDong;i++)
					modelHoiDong.removeRow(modelHoiDong.getRowCount() - 1);
				lGV = chiTietHoiDongDAO.danhSachChiTietHoiDong(ma);
				NapDanhSachGiangVien();
			}
		}

		if(e.getSource().equals(btnLuuDiem)) {
			
			int soDongDaChon = jtTableSinhVien.getSelectedRow();
			if(soDongDaChon==-1) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên");
				return;
			}
			int soDong = jtTableHoiDong.getRowCount();
			if(soDong==0)
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn mã hội đồng");
					return;
				}
			String tenKhoa = jtTableHoiDong.getValueAt(1,3)+"";
			int maHD = Integer.parseInt(cboHoiDong.getItemAt(cboHoiDong.getSelectedIndex())+"");
			if(!jtDiemHienCo1.getText().toString().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Sinh viên đã có điểm không thể chấm điểm");
				return;
			}
			if(KiemTraSo()) {
				if(KiemTraSoAm()) {
					if(!jtKhoa.getText().toString().equalsIgnoreCase(tenKhoa))
					{
						JOptionPane.showMessageDialog(null,"Vui lòng chọn hội đồng cùng khoa với sinh viên");
						return;
					}
					else if(hdDAO.soLanCham(maHD)>=3) {
						JOptionPane.showMessageDialog(null, "Hội đồng không thể chấm quá 3 lần");
						return;
					}
					else {
						String maSV = jtMSSV.getText().toString();
						float diem = Float.parseFloat(jtDiem1.getText().toString());
						float diem1 = Float.parseFloat(jtDiem2.getText().toString());
						float diem2 = Float.parseFloat(jtDiem3.getText().toString());
						float diem3 = Float.parseFloat(jtDiem4.getText().toString());
						float diem4 = Float.parseFloat(jtDiem5.getText().toString());
						String maVong = "PB";
						String maGV = jtTableHoiDong.getValueAt(0, 1)+"";
						String maGV1 = jtTableHoiDong.getValueAt(1, 1)+"";
						String maGV2 = jtTableHoiDong.getValueAt(2, 1)+"";
						String maGV3 = jtTableHoiDong.getValueAt(3, 1)+"";
						String maGV4 = jtTableHoiDong.getValueAt(4, 1)+"";
						List<Float> dsDiem = new ArrayList<Float>();
						dsDiem.add(diem);
						dsDiem.add(diem1);
						dsDiem.add(diem2);
						dsDiem.add(diem3);
						dsDiem.add(diem4);
						List<String> dsMaGV = new ArrayList<String>();
						dsMaGV.add(maGV);
						dsMaGV.add(maGV1);
						dsMaGV.add(maGV2);
						dsMaGV.add(maGV3);
						dsMaGV.add(maGV4);
						for(int i=0; i<dsDiem.size(); i++) {
							dvDAO.themDiemGiangVien(maSV, dsMaGV.get(i), maVong, dsDiem.get(i));
						}
						int maHD1 = Integer.parseInt(cboHoiDong.getItemAt(cboHoiDong.getSelectedIndex())+"");
						hdDAO.CapNhatSoLanChamHoiDong(maHD1);
						int viTri = TimKiemViTriTrenDong(maSV);
						jtTableSinhVien.setValueAt(dsDiem.get(0)+"", viTri, 3);
						jtTableSinhVien.setValueAt(dsDiem.get(1)+"", viTri, 4);
						jtTableSinhVien.setValueAt(dsDiem.get(2)+"", viTri, 5);
						jtTableSinhVien.setValueAt(dsDiem.get(3)+"", viTri, 6);
						jtTableSinhVien.setValueAt(dsDiem.get(4)+"", viTri, 7);
						jtDiem1.setText(dsDiem.get(0)+"");
						jtDiem2.setText(dsDiem.get(1)+"");
						jtDiem3.setText(dsDiem.get(2)+"");
						jtDiem4.setText(dsDiem.get(3)+"");
						jtDiem5.setText(dsDiem.get(4)+"");
						XoaTrang();
						return;
					}
				}else
					JOptionPane.showMessageDialog(null, "Vui Lòng Nhập điểm > 0 và điểm < 10");
			}else
				JOptionPane.showMessageDialog(null, "Vui lòng nhập điểm và điểm là số");
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
		
		if(e.getSource().equals(menuQLDSV)) {
			GiaoDienQuanLiDiemSinhVien gdqldsv = new GiaoDienQuanLiDiemSinhVien();
			gdqldsv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIThemLV)) {
			GiaoDienThemLuanVan gdtlv = new GiaoDienThemLuanVan();
			gdtlv.setVisible(true);
			dispose();
		}

	}

	public void NapDanhSachSinhVien() {
		for(int i=0;i<dssv.size(); i++) {
			{
				NapDanhSachSinhVienVaoBang(dssv.get(i),dsdv.get(i));
			}
		}
	}

	public void NapDanhSachSinhVienVaoBang(SinhVien sv,DiemVong diem) {
		if(diem.getDiem().get(0)==0) {
			String diem1 = "";
			String diem2 = "";
			String diem3 = "";
			String diem4 = "";
			String diem5 = "";
			String row[] = {
					sv.getMssv(),
					sv.getHoten(),
					sv.getKhoaSV().getTenKhoa(),
					diem1,
					diem2,
					diem3,
					diem4,
					diem5,
			};
			modelSinhVien.addRow(row);
		}else
		{

			String row[] = {
					sv.getMssv(),
					sv.getHoten(),
					sv.getKhoaSV().getTenKhoa(),
					diem.getDiem().get(0)+"",
					diem.getDiem().get(1)+"",
					diem.getDiem().get(2)+"",
					diem.getDiem().get(3)+"",
					diem.getDiem().get(4)+"",
			};
			modelSinhVien.addRow(row);
		}
	}

	public void fillForm(int row) {
		if(row!=-1) {
			jtMSSV.setText(jtTableSinhVien.getValueAt(row, 0)+"");
			jtTenSinhVien.setText(jtTableSinhVien.getValueAt(row,1)+"");
			jtKhoa.setText(jtTableSinhVien.getValueAt(row, 2)+"");
			jtDiemHienCo1.setText(jtTableSinhVien.getValueAt(row, 3)+"");
			jtDiemHienCo2.setText(jtTableSinhVien.getValueAt(row, 4)+"");
			jtDiemHienCo3.setText(jtTableSinhVien.getValueAt(row, 5)+"");
			jtDiemHienCo4.setText(jtTableSinhVien.getValueAt(row, 6)+"");
			jtDiemHienCo5.setText(jtTableSinhVien.getValueAt(row, 7)+"");

		}
	}

	public void NapDanhSachGiangVien() {
		for(int i=0;i<5; i++) {
			{
				NapDanhSachGiangVienVaoBang(lGV.get(i));
			}
		}
	}

	public void NapDanhSachGiangVienVaoBang(GiangVien gv) {

		String row[] = {
				k+"",
				gv.getMaGiangVien(),
				gv.getTenGiangVien(),
				gv.getKhoa().getTenKhoa()
		};
		k++;
		modelHoiDong.addRow(row);
	}

	public boolean KiemTraSo() {
		try {
			float diem = Float.parseFloat(jtDiem1.getText().toString());
			float diem1 = Float.parseFloat(jtDiem2.getText().toString());
			float diem2 = Float.parseFloat(jtDiem3.getText().toString());
			float diem3 = Float.parseFloat(jtDiem4.getText().toString());
			float diem4 = Float.parseFloat(jtDiem5.getText().toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean KiemTraSoAm() {
		float diem = Float.parseFloat(jtDiem1.getText().toString());
		float diem1 = Float.parseFloat(jtDiem2.getText().toString());
		float diem2 = Float.parseFloat(jtDiem3.getText().toString());
		float diem3 = Float.parseFloat(jtDiem4.getText().toString());
		float diem4 = Float.parseFloat(jtDiem5.getText().toString());
		if((diem<=10 && diem>=0 ) && (diem1<=10 && diem1>=0 ) && (diem2<=10 && diem2>=0 ) && (diem3<=10 && diem3>=0) && (diem4<=10 && diem4>=0 ))
			return true;
		return false;
	}

	public int TimKiemViTriTrenDong(String maSV) {
		int n = 0;
		int soDong1 = jtTableSinhVien.getRowCount();
		String ma ="";
		for(int i=0; i<soDong1; i++) {
			ma = jtTableSinhVien.getValueAt(i, 0)+"";
			if(ma.equalsIgnoreCase(maSV))
				return i;
		}
		return 0;
	}
	
	public void XoaTrang() {
		jtMSSV.setText("");
		jtTenSinhVien.setText("");
		jtKhoa.setText("");
		jtDiem1.setText("");
		jtDiem2.setText("");
		jtDiem3.setText("");
		jtDiem4.setText("");
		jtDiem5.setText("");
		jtDiemHienCo1.setText("");
		jtDiemHienCo2.setText("");
		jtDiemHienCo3.setText("");
		jtDiemHienCo4.setText("");
		jtDiemHienCo5.setText("");
		jtTableSinhVien.clearSelection();
	}
	
}

