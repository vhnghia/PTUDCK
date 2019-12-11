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
import javax.swing.table.DefaultTableModel;

import DAO.AdminDAO;
import Entites.GiangVien;
import Entites.SinhVien;

public class GiaoDienQuanLiGiangVien extends JFrame implements ActionListener{
	private JButton btnTimKiemMSGV;
	private JPanel jp, jpWest;
	private String tk;
	private JLabel lbLoc;
	private JMenuItem menuIQLSV , menuIDangXuat, menuIThoat, menuIQLGV, menuIThongKe,menuHome, menuIDiem, menuIThemHoiDong;
	private JMenu menu1,menu2,menuThongKe; 
	private JMenuBar menuBar;
	private JTextField jtMSGV;
	private JComboBox cboKhoa;
	private JTable jtbSV;
	private DefaultTableModel modelsv;
	private AdminDAO admindao;
	private List<GiangVien> dsgv = new ArrayList<GiangVien>();
	
	public GiaoDienQuanLiGiangVien() {
		setTitle("Quản lí giảng viên");
		setSize(1250, 750);
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
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menuThongKe);
		//Menu Con chức năng 
		menuIQLSV = new JMenuItem("Quản lý sinh viên");
		menuIQLGV = new JMenuItem("Quản lý giảng viên");
		menuIThongKe = new JMenuItem("Thống kê luận văn");
		menuIDiem = new JMenuItem("Chấm điểm sinh viên");

		menuIDangXuat = new JMenuItem("Đăng xuất");
		menuIThoat = new JMenuItem("Thoát hệ thống");
		menuHome = new JMenuItem("Trang chủ");
		menuIThemHoiDong = new JMenuItem("Tạo hội đồng");
		menu1.add(menuIQLGV);
		menu1.add(menuIQLSV);
		menu2.add(menuIDangXuat);
		menu2.add(menuIThoat);
		menu2.add(menuHome);
		menu1.add(menuIThemHoiDong);
		menu1.add(menuIDiem);
		menuThongKe.add(menuIThongKe);
		
		ImageIcon img9 = new ImageIcon("Images/home.png");
		ImageIcon img2 = new ImageIcon("Images/ql.png");
		ImageIcon img4 = new ImageIcon("Images/dx.png");
		ImageIcon img5 = new ImageIcon("Images/ht.png");
		ImageIcon img6 = new ImageIcon("Images/thoat.png");
		ImageIcon img1 = new ImageIcon("Images/st.png");
		ImageIcon img3 = new ImageIcon("Images/gv.png");
		ImageIcon img7 = new ImageIcon("Images/tk.png");		
		ImageIcon img8 = new ImageIcon("Images/kqtk.png");
		ImageIcon imgDiem = new ImageIcon("Images/diem.png");
		ImageIcon imgHoiDong = new ImageIcon("Images/hd.png");
		menu1.setIcon(img2);
		menu2.setIcon(img5);
		menuIDangXuat.setIcon(img4);
		menuIQLSV.setIcon(img2);
		menuIThoat.setIcon(img6);
		menuIQLGV.setIcon(img3);
		menuIQLSV.setIcon(img1);
		menuIThongKe.setIcon(img8);
		menuThongKe.setIcon(img7);
		menuHome.setIcon(img9);
		menuIDiem.setIcon(imgDiem);
		menuIThemHoiDong.setIcon(imgHoiDong);
		jp.add(menuBar,BorderLayout.NORTH);
		
		JPanel jpCenter = new JPanel();
		
		jpCenter.setPreferredSize(new Dimension(1120,680));
		jp.add(jpCenter,BorderLayout.CENTER);

		JPanel jpTTSVNorth = new JPanel();
		jpTTSVNorth.setPreferredSize(new Dimension(1120,100));
		jpTTSVNorth.setBackground(Color.WHITE);
		jpTTSVNorth.setBorder(BorderFactory.createTitledBorder("Thao Tác"));
		jpTTSVNorth.setLayout(null);
		btnTimKiemMSGV = new JButton("Tìm Kiếm:");
		jpTTSVNorth.add(btnTimKiemMSGV);
		btnTimKiemMSGV.setBounds(20,45,150,20);
		jtMSGV = new JTextField(10);
		jpTTSVNorth.add(jtMSGV);
		jtMSGV.setBounds(190,45,100,20);
		lbLoc = new JLabel("Lọc:");
		jpTTSVNorth.add(lbLoc);
		lbLoc.setBounds(340,45,100,20);
		String [] combo = {"All","CNTT","XD","QTKD"};
		cboKhoa = new JComboBox<String>();
		cboKhoa.setModel(new DefaultComboBoxModel<String>(combo));
		jpTTSVNorth.add(cboKhoa);
		cboKhoa.setBounds(370,45,100,20);
		//
		jpCenter.add(jpTTSVNorth,BorderLayout.NORTH);

		JPanel jpBang = new JPanel();
		
		JScrollPane scrollhd;
		String [] Header = {"Mã số giảng viên","Tên giảng viên","Tên Khoa","Chức danh","Lĩnh vực","Đơn vị công tác"};
		modelsv = new DefaultTableModel(Header,0);
		jtbSV = new JTable(modelsv);
		jp.add(scrollhd = new JScrollPane(jtbSV,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd.setBorder(BorderFactory.createTitledBorder("Danh Sách Giảng Viên"));
		scrollhd.setPreferredSize(new Dimension(1120,400));
		NapDanhSachGiangVien();
		jpBang.add(scrollhd);
		jpCenter.add(scrollhd,BorderLayout.CENTER);
		
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
		btnTimKiemMSGV.addActionListener(this);
		cboKhoa.addActionListener(this);
		menuIDangXuat.addActionListener(this);
		menuIThoat.addActionListener(this);
		menuHome.addActionListener(this);
		menuIQLSV.addActionListener(this);
		menuIThongKe.addActionListener(this);
		menuIDiem.addActionListener(this);
		menuIThemHoiDong.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
		if(e.getSource().equals(btnTimKiemMSGV)) {
			AdminDAO adminDAO = new AdminDAO();
			String msgv = jtMSGV.getText().toString();
			if(admindao.ViTri1(msgv)==-1) {
				JOptionPane.showMessageDialog(null, "Không Tìm Thấy");
			}
			else {
				jtbSV.requestFocus();
				jtbSV.changeSelection(adminDAO.ViTri1(msgv), 1, false,false);

			}
		}
		
		if(e.getSource().equals(menuIQLGV)) {
			GiaoDienQuanLiGiangVien gdqlgv = new GiaoDienQuanLiGiangVien();
			gdqlgv.setVisible(true);
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
		
		if(e.getSource().equals(menuHome)) {
			GiaoDienAdmin gda = new  GiaoDienAdmin();
			gda.setVisible(true);
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
		
		if(e.getSource().equals(menuIDiem)) {
			GiaoDienChamDiemSinhVien gdcdsv = new GiaoDienChamDiemSinhVien();
			gdcdsv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIThemHoiDong)) {
			GiaoDienThemHoiDong gdthd = new GiaoDienThemHoiDong();
			gdthd.setVisible(true);
			dispose();
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

}
