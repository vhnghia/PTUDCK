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

import DAO.LuanVanDAO;
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

public class GiaoDienGiangVien extends JFrame implements ActionListener,MouseListener{
	private JButton btnTimKiem, btnClear;
	private JPanel jp;
	private JLabel lbMSVV, lbtenSV, lbTenDeTai, lbTomTat, lbGVHD, lbTTLV,lbLogo,lbKhoa;
	private JTextField jtMSVV, jttenSV, jtTenDeTai, jtTomTat, jtGVHD,jtKhoa, jtMSSV1;
	private JMenuItem menuIQLSV , menuIDangXuat, menuIThoat, menuIQLGV, menuIThongKe, menuIThemHoiDong,MenuIDiem, menuQLDSV, menuIXemThongTinSV,menuIDoiMatKhauSV,menuIXemKQHT, menuIXemThongTinGV,menuIDoiMatKhauGV;
	private JMenu menu1,menu2,menuThongKe,menuSinhVien,menuGiangVien; 
	private JMenuBar menuBar;
	private DefaultTableModel modelLuanVan;
	private JTable jtTable;
	private LuanVanDAO lvDAO;
	private ArrayList<String> items = new ArrayList<String>();
	public GiaoDienGiangVien() {
		setTitle("Giao Diện Admin");
		setSize(1250, 750);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GiaoDienAdmin();
	}
	
	public void GiaoDienAdmin() {
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
		ImageIcon logo= new ImageIcon("Images/logoIUH.png");
		lbLogo = new JLabel();
		lbLogo.setIcon(logo);
		jpTTSVNorth.add(lbLogo);
		
		lbLogo.setBounds(700,8,400,400);
		
		lbMSVV = new JLabel("Mã luận văn: ");
		jtMSVV = new JTextField(10);
		jpTTSVNorth.add(lbMSVV);		
		jpTTSVNorth.add(jtMSVV);
		
		lbtenSV = new JLabel("Tên luận văn: ");
		jttenSV = new JTextField(10);
		jpTTSVNorth.add(lbtenSV);
		jpTTSVNorth.add(jttenSV);
		
		lbTenDeTai = new JLabel("Tóm tắt: ");
		jtTenDeTai = new JTextField(10);
		jpTTSVNorth.add(lbTenDeTai);
		jpTTSVNorth.add(jtTenDeTai);

		lbKhoa = new JLabel("Nội dung:");
		jtKhoa = new JTextField(10);
		jpTTSVNorth.add(lbKhoa);
		jpTTSVNorth.add(jtKhoa);
		
		lbTomTat = new JLabel("Khoa: ");
		jtTomTat = new JTextField(10);
		jpTTSVNorth.add(lbTomTat);
		jpTTSVNorth.add(jtTomTat);

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
		
		lbTTLV.setBounds(350,20,500,30);
		
		lbMSVV.setBounds(60,100,150,20);
		jtMSVV.setBounds(210,100,300,20);
		
		lbtenSV.setBounds(60,135,150,20);
		jttenSV.setBounds(210,135,300,20);
		
		lbTenDeTai.setBounds(60,165,150,20);
		jtTenDeTai.setBounds(210,165,300,20);
		
		lbKhoa.setBounds(60,195,150,20);
		jtKhoa.setBounds(210,195,300,20);
		
		lbTomTat.setBounds(60,225,150,20);
		jtTomTat.setBounds(210,225,300,20);
		
		lbGVHD.setBounds(60,255,150,20);
		jtGVHD.setBounds(210,255,300,20);
		
		btnTimKiem.setBounds(60, 310, 150,20);
		jtMSSV1.setBounds(220,310,150,20);
		
		btnClear.setBounds(380,310,150,20);
		
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
		List<LuanVan> lv = new ArrayList<LuanVan>();
		lv = lvDAO.getAllLuanVan();
		NapVaoBang(lv);
		
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
		jtTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = jtTable.getSelectedRow();
				fillForm(row);
			}
		});
		
		for (int i = 0; i < jtTable.getRowCount(); i++)
			items.add(jtTable.getValueAt(i, 0).toString());
		setupAutoComplete(jtMSSV1, items);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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
		
		if(e.getSource().equals(btnClear)) {
			jtMSVV.setText("");
			jttenSV.setText("");
			jtTenDeTai.setText("");
			jtKhoa.setText("");
			jtTomTat.setText("");
			jtGVHD.setText("");
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
			jtMSVV.setText(jtTable.getValueAt(row, 0)+"");
			jttenSV.setText(jtTable.getValueAt(row, 1)+"");
			jtTenDeTai.setText(jtTable.getValueAt(row, 2)+"");
			jtKhoa.setText(jtTable.getValueAt(row, 3)+"");
			jtTomTat.setText(jtTable.getValueAt(row, 4)+"");
			jtGVHD.setText(jtTable.getValueAt(row, 5)+"");
			if(jtKhoa.getText().toString().length()>40)
				JOptionPane.showMessageDialog(null, "Nội dung đề tài: "+jtKhoa.getText().toString());
		}
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
