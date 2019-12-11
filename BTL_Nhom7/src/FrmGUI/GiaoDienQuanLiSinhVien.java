package FrmGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import Entites.SinhVien;

import DAO.AdminDAO;
import Entites.SinhVien;

public class GiaoDienQuanLiSinhVien extends JFrame implements ActionListener{
	private JButton btnTimKiemMSSV;
	private JPanel jp, jpWest;
	private String tk;
	private JLabel lbLoc;
	private JMenuItem menuIQLSV , menuIDangXuat, menuIThoat, menuIQLGV, menuIThongKe,menuHome,menuIThemHoiDong,menuIDiem;
	private JMenu menu1,menu2,menuThongKe; 
	private JMenuBar menuBar;
	private JTextField jtMSSV;
	private JComboBox cboKhoa;
	private JTable jtbSV;
	private DefaultTableModel modelsv;
	private AdminDAO admindao;
	private ArrayList<SinhVien> dssv = new ArrayList<SinhVien>();
	public GiaoDienQuanLiSinhVien() {
	// TODO Auto-generated constructor stub
		setTitle("Quan Li Sinh Vien");
		setSize(1250, 750);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GiaoDien();
	}
	public void GiaoDien() {
		admindao = new AdminDAO();
		dssv = new ArrayList<SinhVien>();
	    dssv = admindao.GetAllSinhVien();
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
		menuIThemHoiDong = new JMenuItem("Tạo hội đồng");
		menuIDiem = new JMenuItem("Chấm điểm sinh viên");
		
		menuIDangXuat = new JMenuItem("Đăng xuất");
		menuIThoat = new JMenuItem("Thoát hệ thống");
		menuHome = new JMenuItem("Trang chủ");
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
		btnTimKiemMSSV = new JButton("Tìm Kiếm:");
		jpTTSVNorth.add(btnTimKiemMSSV);
		btnTimKiemMSSV.setBounds(20,45,150,20);
		jtMSSV = new JTextField(10);
		jpTTSVNorth.add(jtMSSV);
		jtMSSV.setBounds(190,45,100,20);
		lbLoc = new JLabel("Lọc:");
		jpTTSVNorth.add(lbLoc);
		lbLoc.setBounds(340,45,100,20);
		String [] combo = {"All","CNTT"};
		cboKhoa = new JComboBox<String>();
		cboKhoa.setModel(new DefaultComboBoxModel<String>(combo));
		jpTTSVNorth.add(cboKhoa);
		cboKhoa.setBounds(370,45,100,20);
		//
		jpCenter.add(jpTTSVNorth,BorderLayout.NORTH);

		JPanel jpBang = new JPanel();
		
		JScrollPane scrollhd;
		String [] Header = {"Mã số sinh viên","Tên sinh viên","Ngày sinh","Tên Khoa"};
		modelsv = new DefaultTableModel(Header,0);
		jtbSV = new JTable(modelsv);
		jp.add(scrollhd = new JScrollPane(jtbSV,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd.setBorder(BorderFactory.createTitledBorder("Danh Sách Sinh Viên"));
		scrollhd.setPreferredSize(new Dimension(1120,400));
		NapDanhSachSinhVien();
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
		btnTimKiemMSSV.addActionListener(this);
		cboKhoa.addActionListener(this);
		menuIDangXuat.addActionListener(this);
		menuIThoat.addActionListener(this);
		menuHome.addActionListener(this);
		menuIThemHoiDong.addActionListener(this);
		menuIDiem.addActionListener(this);
		menuIThongKe.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(cboKhoa)) {
			AdminDAO admindao = new AdminDAO();
			ArrayList<SinhVien> sv = admindao.LocTheoKhoa(cboKhoa.getItemAt(cboKhoa.getSelectedIndex())+"");
			int n = modelsv.getRowCount();
			for(int i = 0 ;i<n;i++)
				modelsv.removeRow(modelsv.getRowCount() - 1);
			if(cboKhoa.getItemAt(cboKhoa.getSelectedIndex()).equals("All")) {
				NapDanhSachSinhVien();
			}else if(cboKhoa.getItemAt(cboKhoa.getSelectedIndex()).equals(cboKhoa.getItemAt(cboKhoa.getSelectedIndex())))
			{
				for(int i=0;i<sv.size();i++) {
					String row []= {
							sv.get(i).getMssv(),
							sv.get(i).getHoten(),
							sv.get(i).getNgaySinh()+"",
							sv.get(i).getKhoaSV().getTenKhoa()
					};
					modelsv.addRow(row);
				}
			}
		}
		if(e.getSource().equals(btnTimKiemMSSV)) {
			AdminDAO adminDAO = new AdminDAO();
			String mssv = jtMSSV.getText().toString();
			if(admindao.ViTri(mssv)==-1) {
				JOptionPane.showMessageDialog(null, "Không Tìm Thấy");
			}
			else {
				jtbSV.requestFocus();
				jtbSV.changeSelection(adminDAO.ViTri(mssv), 1, false,false);

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
		
		if(e.getSource().equals(menuIThemHoiDong)) {
			GiaoDienThemHoiDong gdthd = new GiaoDienThemHoiDong();
			gdthd.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIDiem)) {
			GiaoDienChamDiemSinhVien gdcdsv = new GiaoDienChamDiemSinhVien();
			gdcdsv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuIThongKe)) {
			GiaoDienThongKe gdtk = new GiaoDienThongKe();
			gdtk.setVisible(true);
		}
		
		if(e.getSource().equals(menuIThongKe)) {
			GiaoDienThongKe gdtk = new GiaoDienThongKe();
			gdtk.setVisible(true);
		}
		
	}
	public void NapDanhSachSinhVien() {
		for(int i=0;i<dssv.size(); i++) {
			NapDanhSachSinhVienVaoBang(dssv.get(i));
		}
	}
	
	public void NapDanhSachSinhVienVaoBang(SinhVien sv) {
		String row[] = {
				sv.getMssv(),
				sv.getHoten(),
				sv.getNgaySinh()+"",
				sv.getKhoaSV().getTenKhoa(),
		};
		modelsv.addRow(row);
	}

}
