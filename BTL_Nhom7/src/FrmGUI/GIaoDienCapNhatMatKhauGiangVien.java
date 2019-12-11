package FrmGUI;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import DAO.SinhVienDAO;

public class GIaoDienCapNhatMatKhauGiangVien extends JFrame implements ActionListener{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JLabel lbMatKhauHienTai,lbMatKhauMoi,lbMatKhauMoi1;
		private JPasswordField jtMatKhauHienTai,jtMatKhauMoi,jtMatKhauMoi1;
		private Button btnCancle, btnCapNhat;
		private String taiKhoan="";
		public GIaoDienCapNhatMatKhauGiangVien() {
			setTitle("Cập nhật mật khẩu!");
			setSize(400, 240);
			setLocationRelativeTo(null);
			CapNhat();
		}

		public void CapNhat() {
			taiKhoan = "120";
			JPanel jpCapNhat = new JPanel();
			jpCapNhat.setPreferredSize(new Dimension(250,250));
			jpCapNhat.setLayout(null);
			lbMatKhauHienTai = new JLabel("Mật khẩu hiện tại:");
			jtMatKhauHienTai = new JPasswordField(10);
			jpCapNhat.add(lbMatKhauHienTai);
			jpCapNhat.add(jtMatKhauHienTai);
			lbMatKhauMoi = new JLabel("Mật khẩu mới:");
			jtMatKhauMoi = new JPasswordField(10);
			jpCapNhat.add(lbMatKhauMoi);
			jpCapNhat.add(jtMatKhauMoi);
			lbMatKhauMoi1 = new JLabel("Nhập lại mật khẩu: ");
			jtMatKhauMoi1 = new JPasswordField(10);
			jpCapNhat.add(lbMatKhauMoi1);
			jpCapNhat.add(jtMatKhauMoi1);
			btnCancle = new Button("Cancel");
			btnCapNhat = new Button("Save");
			jpCapNhat.add(btnCancle);
			jpCapNhat.add(btnCapNhat);

			lbMatKhauHienTai.setBounds(50,15,150,25);
			jtMatKhauHienTai.setBounds(180,15,150,25);
			lbMatKhauMoi.setBounds(50,55,150,25);
			jtMatKhauMoi.setBounds(180,55,150,25);
			lbMatKhauMoi1.setBounds(50,95,150,25);
			jtMatKhauMoi1.setBounds(180,95,150,25);
			btnCancle.setBounds(75,155,100,20);
			btnCapNhat.setBounds(205,155,100,20);
			add(jpCapNhat);
			btnCancle.addActionListener(this);
			btnCapNhat.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(btnCancle)) {
				dispose();
			}
			if(e.getSource().equals(btnCapNhat)) {
				String tenTK2 = taiKhoan;
				String matKhauHienTai = jtMatKhauHienTai.getText().toString();
				String matKhauMoi = jtMatKhauMoi.getText().toString();
				String matKhauMoi1 = jtMatKhauMoi.getText().toString();
				SinhVienDAO svdao = new SinhVienDAO();
				if(!matKhauHienTai.equalsIgnoreCase("") || !matKhauMoi.equalsIgnoreCase("") || !matKhauMoi1.equalsIgnoreCase("")) {
					if(matKhauHienTai.equalsIgnoreCase("") || matKhauMoi.equalsIgnoreCase("") || matKhauMoi1.equalsIgnoreCase(""))
						JOptionPane.showMessageDialog(null, "Vui Long nhap thong tin");
					else
						if(jtMatKhauMoi.getText().equalsIgnoreCase(jtMatKhauMoi1.getText())) {
							if(svdao.CapNhatMatKhau(tenTK2, jtMatKhauHienTai.getText())==true) {
								svdao.CapNhatMatKhau1(tenTK2,matKhauMoi);
								JOptionPane.showMessageDialog(null, "Ban da cap nhat thanh cong");
							}
							else
								JOptionPane.showMessageDialog(null, "Mat khau hien tai khong trung khop");
						}
						else
							JOptionPane.showMessageDialog(null, "Mật khẩu mới phải giống nhau");
				}else
					JOptionPane.showMessageDialog(null, "Vui long nhap thong tin");
			}
		}
	}

