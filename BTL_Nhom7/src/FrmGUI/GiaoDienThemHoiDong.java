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
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.AdminDAO;
import DAO.ChiTietHoiDongDAO;
import DAO.HoiDongDAO;
import DAO.KhoaDAO;
import Entites.GiangVien;
import Entites.HoiDong;
import Entites.Khoa;

public class GiaoDienThemHoiDong extends JFrame implements ActionListener{

	private JLabel lbTenHoiDong;
	private JPanel jp, jpWest;
	private String tk;
	private JLabel lbLoc;
	private JMenuItem menuIQLSV , menuIDangXuat, menuIThoat, menuIQLGV, menuIThongKe, menuIThemHoiDong,MenuIDiem, menuQLDSV, menuIXemThongTinSV,menuIDoiMatKhauSV,menuIXemKQHT, menuIDKLV,menuIGDAdmin,menuIThemLV,menuIXemThongTinGV,menuIDoiMatKhauGV, menuIHome;
	private JMenu menu1,menu2,menuThongKe,menuSinhVien,menuGiangVien; 
	private JMenuBar menuBar;
	private JTextField jtTenHoiDong;
	private JComboBox cboKhoa;
	private JTable jtbSV,jtbSV1;
	private JButton btnLuuHoiDong, btnThemVaoHoiDong, btnBoChon;
	private DefaultTableModel modelsv,modelsv1;
	private AdminDAO admindao;
	private List<GiangVien> dsgv = new ArrayList<GiangVien>();
	private HoiDongDAO hdDAO;
	private KhoaDAO kDAO;
	private ChiTietHoiDongDAO cthdDAO;
	public GiaoDienThemHoiDong() {
		setTitle("Giao Diện Tạo Hội Đồng");
		setSize(1250,750);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GiaoDien();
	}

	public void GiaoDien() {
		admindao = new AdminDAO();
		dsgv = new ArrayList<GiangVien>();
		dsgv = admindao.getAllGiangVien();
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

		JPanel jpCenter = new JPanel();

		jpCenter.setPreferredSize(new Dimension(1120,680));
		jp.add(jpCenter,BorderLayout.CENTER);

		JPanel jpTTSVNorth = new JPanel();
		jpTTSVNorth.setPreferredSize(new Dimension(1120,100));
		jpTTSVNorth.setBackground(Color.WHITE);
		jpTTSVNorth.setBorder(BorderFactory.createTitledBorder("Thao Tác"));
		jpTTSVNorth.setLayout(null);
		lbTenHoiDong = new JLabel("Tên hội đồng:");
		jpTTSVNorth.add(lbTenHoiDong);
		lbTenHoiDong.setBounds(40,45,150,20);
		jtTenHoiDong = new JTextField(10);
		jpTTSVNorth.add(jtTenHoiDong);
		jtTenHoiDong.setBounds(170,45,140,20);
		lbLoc = new JLabel("Lọc:");
		jpTTSVNorth.add(lbLoc);
		lbLoc.setBounds(340,45,100,20);
		String [] combo = {"All","CNTT","XD","QTKD"};
		cboKhoa = new JComboBox<String>();
		cboKhoa.setModel(new DefaultComboBoxModel<String>(combo));
		jpTTSVNorth.add(cboKhoa);
		cboKhoa.setBounds(370,45,100,20);
		btnThemVaoHoiDong = new JButton("Thêm vào hội đồng");
		jpTTSVNorth.add(btnThemVaoHoiDong);
		btnThemVaoHoiDong.setBounds(500,45,150,20);
		btnBoChon = new JButton("Bỏ chọn");
		jpTTSVNorth.add(btnBoChon);
		btnBoChon.setBounds(680,45,150,20);
		btnLuuHoiDong = new JButton ("Lưu hội đồng");
		jpTTSVNorth.add(btnLuuHoiDong);
		btnLuuHoiDong.setBounds(860,45,150,20);
		//
		jpCenter.add(jpTTSVNorth,BorderLayout.NORTH);

		JPanel jpBang = new JPanel();

		JScrollPane scrollhd;
		String [] Header = {"Mã số giảng viên","Tên giảng viên","Tên Khoa","Chức danh","Lĩnh vực","Đơn vị công tác"};
		modelsv = new DefaultTableModel(Header,0);
		jtbSV = new JTable(modelsv);
		jp.add(scrollhd = new JScrollPane(jtbSV,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd.setBorder(BorderFactory.createTitledBorder("Danh Sách Giảng Viên"));
		scrollhd.setPreferredSize(new Dimension(1120,250));
		NapDanhSachGiangVien();
		jpBang.add(scrollhd);
		jpCenter.add(scrollhd,BorderLayout.CENTER);

		JPanel jpBang1 = new JPanel();

		JScrollPane scrollhd1;
		String [] Header1 = {"Mã số giảng viên","Tên giảng viên","Tên Khoa","Chức danh","Lĩnh vực","Đơn vị công tác"};
		modelsv1 = new DefaultTableModel(Header1,0);
		jtbSV1 = new JTable(modelsv1);
		jp.add(scrollhd1 = new JScrollPane(jtbSV1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd1.setBorder(BorderFactory.createTitledBorder("Tạo Hội Đồng"));
		scrollhd1.setPreferredSize(new Dimension(1120,250));
		jpBang1.add(scrollhd1);
		jpCenter.add(scrollhd1,BorderLayout.CENTER);

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
		//		jtbSV1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		//			@Override
		//			public void valueChanged(ListSelectionEvent e) {
		//				// TODO Auto-generated method stub
		//				if(e.getValueIsAdjusting()) {
		//					return;
		//				}
		//				JOptionPane.showMessageDialog(null,"asdasd");
		//			}
		//		});
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
		cboKhoa.addActionListener(this);
		btnBoChon.addActionListener(this);
		btnThemVaoHoiDong.addActionListener(this);
		btnLuuHoiDong.addActionListener(this);
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

		
		if(e.getSource().equals(cboKhoa)) {
			AdminDAO admindao = new AdminDAO();
			ArrayList<GiangVien> gv = admindao.LocTheoKhoa1(cboKhoa.getItemAt(cboKhoa.getSelectedIndex())+"");
			int n = modelsv.getRowCount();
			for(int i = 0 ;i<n;i++)
				modelsv.removeRow(modelsv.getRowCount() - 1);
			if(cboKhoa.getItemAt(cboKhoa.getSelectedIndex()).equals("All")) {
				NapDanhSachGiangVien();
			}else if(cboKhoa.getItemAt(cboKhoa.getSelectedIndex()).equals(cboKhoa.getItemAt(cboKhoa.getSelectedIndex())))
			{
				for(int i=0;i<gv.size();i++) {
					String row []= {
							gv.get(i).getMaGiangVien(),
							gv.get(i).getTenGiangVien(),
							gv.get(i).getKhoa().getTenKhoa(),
							gv.get(i).getChucDanh(),
							gv.get(i).getLinhVuc(),
							gv.get(i).getDonViCongtac()
					};
					modelsv.addRow(row);
				}
			}
		}

		if(e.getSource().equals(btnBoChon)) {
			int dong = jtbSV1.getRowCount();
			int dong1 = jtbSV1.getSelectedRow();
			if(dong==0)
				JOptionPane.showMessageDialog(null, "Chưa có dòng!!!");
			else if(dong1==-1) 
				JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng để xoá");
			else {
				modelsv1.removeRow(dong1);
			}
		}

		if(e.getSource().equals(btnThemVaoHoiDong)) {
			int dongChon = jtbSV.getSelectedRow();
			int dong = jtbSV1.getRowCount();

			if(dongChon==-1) {
				JOptionPane.showMessageDialog(null,"Vui lòng chọn giảng viên để thêm");
			}else if(dong==5) {
				JOptionPane.showMessageDialog(null, "Đã đủ số lượng trong hội đồng không thể thêm");
			}else {
				String mGV = jtbSV.getValueAt(dongChon, 0)+"";
				String tenGV = jtbSV.getValueAt(dongChon, 1)+"";
				String tenKhoa = jtbSV.getValueAt(dongChon, 2)+"";
				String chucDanh = jtbSV.getValueAt(dongChon, 3)+"";
				String linhVuc = jtbSV.getValueAt(dongChon, 4)+"";
				String dvct = jtbSV.getValueAt(dongChon, 5)+"";
				String rowData[] = {
						mGV,tenGV,tenKhoa,chucDanh,linhVuc,dvct
				};
				modelsv1.addRow(rowData);
			}
			jtbSV.clearSelection();
		}

		if(e.getSource().equals(btnLuuHoiDong)) {
			int soDong = jtbSV1.getRowCount();
			if(jtTenHoiDong.getText().toString().equalsIgnoreCase(""))
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên hội đồng");
			else if(soDong==0)
				JOptionPane.showMessageDialog(null, "Chưa có giảng viên trong danh sách hội đồng!");
			else if(soDong<5) {
				JOptionPane.showMessageDialog(null,"Chưa đủ số lượng giảng viên");
			}else if(KiemTraTraTrungGiangVien(soDong)==false) {
				JOptionPane.showMessageDialog(null,"Trùng giảng viên trong danh sách hội đồng ");
			}else if(KiemTraKhoa(soDong)==false) {
				JOptionPane.showMessageDialog(null, "Lỗi! Tất cả giảng viên phải cùng một khoa");
			}
			else {
				if(KiemTraTenHoiDong()==false)
					JOptionPane.showMessageDialog(null, "Vui long nhap dung theo mau hdcntt..");
				else
					{
							ThemHoiDong();
							JOptionPane.showMessageDialog(null, "Tạo hội đồng thành công");
					}
			}
		}
		
		
	}



	public void NapDanhSachGiangVien() {
		for(int i=0;i<dsgv.size(); i++) {
			NapDanhSachGiangVienVaoBang(dsgv.get(i));
		}
	}

	public void NapDanhSachGiangVienVaoBang(GiangVien gv) {
		String row[] = {
				gv.getMaGiangVien(),
				gv.getTenGiangVien(),
				gv.getKhoa().getTenKhoa(),
				gv.getChucDanh(),
				gv.getLinhVuc(),
				gv.getDonViCongtac()
		};
		modelsv.addRow(row);
	}
	
	public boolean KiemTraTraTrungGiangVien(int soDong) {
		int n = soDong;

		int i,j,aLength=n;
		String ma1 = jtbSV1.getValueAt(0,0)+"";
		String ma2 = jtbSV1.getValueAt(1,0)+"";
		String ma3 = jtbSV1.getValueAt(2,0)+"";
		String ma4 = jtbSV1.getValueAt(3,0)+"";
		String ma5 = jtbSV1.getValueAt(4,0)+"";
		String [] ar = {ma1,ma2,ma3,ma4,ma5};
		boolean ok=true;
		for(i=0;i<aLength-1;i++)
		{
			for(j=i+1;j<aLength;j++)
			{
				if(ar[i].equals(ar[j]))
				{
					ok=false;
					break;
				}
				if(!ok)break;
			}
		}
		return ok;
	}

	public boolean KiemTraKhoa(int soDong) {
		int n = soDong;

		int i,j,aLength=n;
		String ma1 = jtbSV1.getValueAt(0,2)+"";
		String ma2 = jtbSV1.getValueAt(1,2)+"";
		String ma3 = jtbSV1.getValueAt(2,2)+"";
		String ma4 = jtbSV1.getValueAt(3,2)+"";
		String ma5 = jtbSV1.getValueAt(4,2)+"";
		String [] ar = {ma1,ma2,ma3,ma4,ma5};
		boolean ok=true;
		for(i=0;i<aLength-1;i++)
		{
			for(j=i+1;j<aLength;j++)
			{
				if(!ar[i].equals(ar[j]))
				{
					ok=false;
					break;
				}
				if(ok)break;
			}
		}
		return ok;	
	}
	
	public boolean KiemTraTenHoiDong() {
		if(!jtTenHoiDong.getText().toString().matches("^(hdcntt)[0-9]{0,}$") && !jtTenHoiDong.getText().toString().matches("^(hdqtkd)[0-9]{0,}$") && !jtTenHoiDong.getText().toString().matches("^(hdxd)[0-9]{0,}$") )
				return false;
		return true;
	}
	
	public void ThemHoiDong() {
		String tenHD = jtTenHoiDong.getText().toString();
		String tenKhoa = jtbSV1.getValueAt(0, 2)+"";
		String maKhoa = "";
		if(tenKhoa.equalsIgnoreCase("Cong Nghe Thong Tin")) {
			 maKhoa = "CNTT";
		}else if(tenKhoa.equalsIgnoreCase("Xay Dung")) {
			 maKhoa = "XD";
		}else {
			 maKhoa = "QTKD";
		}
		HoiDongDAO hdDAO = new HoiDongDAO();
		HoiDong hd = new HoiDong();
		kDAO = new KhoaDAO();
		Khoa k = new Khoa();
		k = kDAO.TimKhoa(maKhoa);
		hd.setMaVong("PB");
		hd.setKhoa(k);
		hd.setTenHD(tenHD);
		hd.setSoLanCham(0);
		hdDAO.addHoiDong(hd);
		ArrayList<HoiDong> arrayListHD = new ArrayList<HoiDong>();
		arrayListHD = hdDAO.getAllHoiDong();
		int a = arrayListHD.size();
		int mahd1 = arrayListHD.get(a-1).getMaHD();
		cthdDAO = new ChiTietHoiDongDAO();
		String ma1 = jtbSV1.getValueAt(0, 0)+"";
		String ma2 = jtbSV1.getValueAt(1, 0)+"";
		String ma3 = jtbSV1.getValueAt(2, 0)+"";
		String ma4 = jtbSV1.getValueAt(3, 0)+"";
		String ma5 = jtbSV1.getValueAt(4, 0)+"";

		List<String> dsl = new ArrayList<String>();
		dsl.add(ma1);
		dsl.add(ma2);
		dsl.add(ma3);
		dsl.add(ma4);
		dsl.add(ma5);
		for(int i=0; i<dsl.size();i++)
			cthdDAO.addChiTietHoiDong(dsl.get(i),mahd1);
		for(int i = 0 ;i<5;i++)
			modelsv1.removeRow(modelsv1.getRowCount() - 1);
	}
	
}
