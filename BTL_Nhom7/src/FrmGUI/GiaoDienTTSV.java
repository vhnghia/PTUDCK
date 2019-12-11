package FrmGUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import Entites.LuanVan;
import Entites.SinhVien;
import DAO.SinhVienDAO;
import DAO.ChiTietLuanVanDAO;
import DAO.LuanVanDAO;
public class GiaoDienTTSV extends JFrame implements ActionListener{
	private JButton btnCapNhatTTSV,btnChinhSuaThongTin;
	private JPanel jp;
	private JLabel lbHoTen, lbNamVaoTruong, lbNamTotNghiep, lbMaSoSinhVien, lbKhoa,lbKhoaHoc;
	private JTextField jtHoTen, jtNamVaoTruong, jtNamTotNghiep, jtMaSoSinhVien, jtKhoa, jtKhoaHoc;
	private String tenTK="100";
	private JTable jtTable;
	private DefaultTableModel modelLuanVan;
	private JMenuItem menuI1 ,menuIMatKhau, menuDangXuat, menuThoat,menuHome,menuKQHT,menuIDKLV;
	private JMenu menu1,menu2,menu3,menu4; 
	private JMenuBar menuBar;
	private LuanVan lv;
	private ArrayList<LuanVan> dslv = new ArrayList<LuanVan>();
	public GiaoDienTTSV() {
		setTitle("THONG TIN SINH VIEN");
		setSize(1250, 750);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GiaoDienTTSV();
	}
	public void GiaoDienTTSV() {
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
		menuIDKLV = new JMenuItem("Đăng ký luận văn");
		menu1.add(menuI1);
		menu1.add(menuIMatKhau);
		menu1.add(menuKQHT);
		menu2.add(menuDangXuat);
		menu2.add(menuThoat);
		menu2.add(menuHome);
		menu1.add(menuIDKLV);
		
		ImageIcon imgDKLV = new ImageIcon("Images/dklv.png");
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
		menuIDKLV.setIcon(imgDKLV);
		jp.add(menuBar,BorderLayout.NORTH);

		//Jpanel Center
		JPanel jpCenter = new JPanel();
		jpCenter.setPreferredSize(new Dimension(1120,680));
		jp.add(jpCenter,BorderLayout.CENTER);
		
		

		//JPanel Thong Tin Sinh Vien
		JPanel jpTTSVNorth = new JPanel();
		JPanel jps = new JPanel();
		JLabel lb = new JLabel();
		ImageIcon img = new ImageIcon("Images/wst.png");
		lb.setIcon(img);
		jps.add(lb);
		jpTTSVNorth.setPreferredSize(new Dimension(1140,160));
		jpTTSVNorth.setBackground(Color.WHITE);
		jpTTSVNorth.setBorder(BorderFactory.createTitledBorder("Thông Tin Sinh Viên"));
		jpTTSVNorth.setLayout(null);
		btnChinhSuaThongTin = new JButton("Chỉnh Sửa Thông Tin");
		jpTTSVNorth.add(btnChinhSuaThongTin);
		btnCapNhatTTSV = new JButton("Cập Nhật Thông Tin");
		btnCapNhatTTSV.setEnabled(false);
		jpTTSVNorth.add(btnCapNhatTTSV);
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
		btnChinhSuaThongTin.setBounds(20,20,150,20);
		btnCapNhatTTSV.setBounds(180,20,150,20);
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
		jpCenter.add(jps,BorderLayout.SOUTH);
		jpCenter.add(jpTTSVNorth,BorderLayout.CENTER);
		//Lay thong tin 1 sinh vien
		SinhVien sv = new SinhVien();
		sv = ThongTinMotSinhVien(tenTK);
		//gan thong tin mot sinh vien
		GanThongTin(sv);

		// Bang dang ki luan van sinh vien

		JPanel jpBangDangKyLV = new JPanel();
		jpBangDangKyLV.setPreferredSize(new Dimension(1130,180));
		jpBangDangKyLV.setBackground(Color.white);
		JScrollPane scrollhd;
		String Header [] = {"MSSV","Tên Sinh Viên","Tên Luận Văn","Giáo Viên Hướng Dẫn","Tóm Tắt","Nội Dung","Ngày đăng ký"};
		modelLuanVan = new DefaultTableModel(Header,0);
		jtTable = new JTable(modelLuanVan);
		jp.add(scrollhd = new JScrollPane(jtTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scrollhd.setBorder(BorderFactory.createTitledBorder("Thông Tin Luận Văn Sinh Viên"));
		scrollhd.setPreferredSize(new Dimension(1120,180));
		jpBangDangKyLV.add(scrollhd);		
		jpCenter.add(jpBangDangKyLV);
		//add vao bang du lieu 
		jtTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jtTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtTable.getColumnModel().getColumn(1).setPreferredWidth(130);
		jtTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		jtTable.getColumnModel().getColumn(3).setPreferredWidth(130);
		jtTable.getColumnModel().getColumn(4).setPreferredWidth(300);
		jtTable.getColumnModel().getColumn(5).setPreferredWidth(300);
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
		//
		ChiTietLuanVanDAO ctDAO = new ChiTietLuanVanDAO();
		int maLuanVan = ctDAO.TimMa("100");
		if(maLuanVan==0) {
			NapVaoBang1();
		}
		else {
			LuanVanDAO lvDAO = new LuanVanDAO();
			lv = new LuanVan();
			lv = lvDAO.TimLuanVan(maLuanVan+"");
			NapVaoBang(lv);
		}
		// Cai Dat Su Kien Click

		btnCapNhatTTSV.addActionListener(this);
		btnChinhSuaThongTin.addActionListener(this);
		menuI1.addActionListener(this);
		menuDangXuat.addActionListener(this);
		menuThoat.addActionListener(this);
		menuHome.addActionListener(this);
		menuIMatKhau.addActionListener(this);
		menuKQHT.addActionListener(this);
		menuIDKLV.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource().equals(menuIDKLV)) {
			GiaoDienDangKyLuanVan gddklv = new GiaoDienDangKyLuanVan();
			gddklv.setVisible(true);
			dispose();
		}
		
		if(e.getSource().equals(menuHome)) {
			dispose();
			GiaoDienAdmin1 gdql = new GiaoDienAdmin1();
			gdql.setVisible(true);
			dispose();
		}
		if(e.getSource().equals(btnCapNhatTTSV)) {
			String tenTk2 = tenTK;
			String tenSV = jtHoTen.getText();
			SinhVienDAO svdao = new SinhVienDAO();
			if(KiemTraTenReg(tenSV)==true)
			{
				svdao.CapNhatThongTinSinhVien(tenSV, tenTk2);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
				btnCapNhatTTSV.setEnabled(false);
				jtTable.setValueAt(jtHoTen.getText().toString(), 0, 1);
			}
			else {
				JOptionPane.showMessageDialog(null, "Sai định dạng");
			}
		}
		if(e.getSource().equals(btnChinhSuaThongTin)) {
			btnCapNhatTTSV.setEnabled(true);
			jtHoTen.setEditable(true);
		}
		
		if(e.getSource().equals(menuDangXuat)) {
			GiaoDienDangNhap gddn = new GiaoDienDangNhap();
			gddn.setVisible(true);
			dispose();
		}

		if(e.getSource().equals(menuThoat)) {
			int click = JOptionPane.showConfirmDialog(null,"Ban co muon thoat he thong","Thoat he thong",JOptionPane.YES_NO_OPTION);
			if(click == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		
		if(e.getSource().equals(menuIMatKhau)) {
			GiaoDienCapNhatMatKhau gdmk = new GiaoDienCapNhatMatKhau();
			gdmk.setVisible(true);
		}
		
		if(e.getSource().equals(menuKQHT)) {
			GiaoDienKetQuaHocTap gdkqht = new GiaoDienKetQuaHocTap();
			gdkqht.setVisible(true);
			dispose();
		}
		
	}
	public SinhVien ThongTinMotSinhVien(String tenTK) {
		SinhVien sv = new SinhVien();
		SinhVienDAO svDAO = new SinhVienDAO(); 
		sv = svDAO.TimTheoMaSinhVien(tenTK);
		return sv;
	}
	public boolean KiemTraTenReg(String ten) {
		if(ten.matches("^[A-Z][a-z]{1,5}(\\s[A-Z][a-z]{1,5}){1,3}")) {
			return true;
		}
		return false;
	}
	public void GanThongTin(SinhVien sv) {
		jtMaSoSinhVien.setText(sv.getMssv());
		jtHoTen.setText(sv.getHoten());
		jtKhoa.setText(sv.getKhoaSV().getTenKhoa());
		jtNamVaoTruong.setText(sv.getNgayVaoTruong()+"");
		jtNamTotNghiep.setText(sv.getNgayRaTruong()+"");
		jtKhoaHoc.setText(sv.getNgayVaoTruong() +"-"+ (sv.getNgayVaoTruong()+1) +"");
	}

	public void NapVaoBang (LuanVan lv) {
		String row[] = {
				jtMaSoSinhVien.getText().toString(),
				jtHoTen.getText(),
				lv.getTenLuanVan(),
				lv.getGiangVien().getTenGiangVien(),
				lv.getTomTatLuanVan(),
				lv.getNoiDung()
		};
		modelLuanVan.addRow(row);

	}
	
	public void NapVaoBang1() {
		String row[] = {
				"",
				"",
				"",
				"",
				"",
				""
		};
		modelLuanVan.addRow(row);

	}
	
}
