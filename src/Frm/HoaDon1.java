package Frm;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;

public class HoaDon1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtmahd;
	private JTextField txtmanv;
	private JTextField txtmakh;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDon1 frame = new HoaDon1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HoaDon1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(65, 5, 1223, 738);
		setTitle("Trang chủ");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHan = new JLabel("HÓA ĐƠN");
		lblHan.setForeground(new Color(0, 0, 128));
		lblHan.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblHan.setBounds(512, 21, 150, 44);
		contentPane.add(lblHan);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(80, 85, 1045, 161);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMHan = new JLabel("Mã hóa đơn");
		lblMHan.setForeground(new Color(0, 0, 139));
		lblMHan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMHan.setBounds(54, 21, 107, 36);
		panel.add(lblMHan);
		
		JLabel lblNewLabel = new JLabel("Ngày bán");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(54, 68, 86, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(54, 115, 113, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setForeground(new Color(0, 0, 139));
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnKhchHng.setBounds(556, 68, 124, 36);
		panel.add(lblTnKhchHng);
		
		JLabel lblMKhchHng = new JLabel("Mã khách hàng");
		lblMKhchHng.setForeground(new Color(0, 0, 139));
		lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMKhchHng.setBounds(556, 21, 131, 36);
		panel.add(lblMKhchHng);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên");
		lblMNhnVin.setForeground(new Color(0, 0, 139));
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhnVin.setBounds(556, 115, 113, 31);
		panel.add(lblMNhnVin);
		
		txtmahd = new JTextField();
		txtmahd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmahd.setBounds(184, 22, 260, 31);
		panel.add(txtmahd);
		txtmahd.setColumns(10);
		
		txtmanv = new JTextField();
		txtmanv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmanv.setBounds(710, 115, 260, 31);
		panel.add(txtmanv);
		txtmanv.setColumns(10);
		
		JComboBox cbotenkh = new JComboBox();
		cbotenkh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbotenkh.setBounds(710, 22, 260, 31);
		panel.add(cbotenkh);
		
		txtmakh = new JTextField();
		txtmakh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmakh.setBounds(710, 69, 260, 31);
		panel.add(txtmakh);
		txtmakh.setColumns(10);
		
		JComboBox cbotennv = new JComboBox();
		cbotennv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbotennv.setBounds(184, 115, 260, 31);
		panel.add(cbotennv);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(185, 68, 259, 31);
		panel.add(dateChooser);
		
	//	JDateChooser datengayban = new JDateChooser();
	//	datengayban.setBounds(278, 119, 338, 39);
	//	panel.add(datengayban);
		
		JLabel lblThngTin = new JLabel("Thông tin");
		lblThngTin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTin.setBounds(80, 55, 127, 26);
		contentPane.add(lblThngTin);
		
		JButton btnThm = new JButton();
		btnThm.setText("THÊM");
		btnThm.setForeground(Color.RED);
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnThm.setBounds(203, 393, 169, 49);
		contentPane.add(btnThm);
		
		JButton btnXa = new JButton("XÓA");
		btnXa.setForeground(Color.RED);
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnXa.setBounds(662, 393, 169, 49);
		contentPane.add(btnXa);
		
		JButton btnInHan = new JButton("IN HÓA ĐƠN");
		btnInHan.setForeground(Color.RED);
		btnInHan.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnInHan.setBounds(892, 393, 169, 49);
		contentPane.add(btnInHan);
		
		JButton btnLu = new JButton("LƯU");
		btnLu.setForeground(Color.RED);
		btnLu.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnLu.setBounds(431, 393, 169, 49);
		contentPane.add(btnLu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(79, 453, 1054, 134);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 13, 1050, 110);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 h\u00E0ng h\u00F3a", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(144);
		table.getColumnModel().getColumn(1).setPreferredWidth(157);
		table.getColumnModel().getColumn(2).setPreferredWidth(141);
		table.getColumnModel().getColumn(3).setPreferredWidth(194);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("XEM HÃ“A ÄÆ N");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(265, 849, 192, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("THOÃT");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(469, 849, 144, 49);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTngTin = new JLabel("Tá»”NG TIá»€N");
		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTngTin.setBounds(1214, 849, 104, 32);
		contentPane.add(lblTngTin);
		
		textField = new JTextField();
		textField.setBounds(1330, 849, 158, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Ä");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(1494, 858, 56, 16);
		contentPane.add(label);
		
		JLabel lblTngTin_1 = new JLabel("TỔNG TIỀN");
		lblTngTin_1.setBounds(932, 598, 75, 26);
		contentPane.add(lblTngTin_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(1005, 598, 98, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblVnd = new JLabel("VND");
		lblVnd.setBounds(1114, 604, 46, 14);
		contentPane.add(lblVnd);
		
		JButton btnXemCthd = new JButton("XEM CTHD");
		btnXemCthd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXemCthd.setForeground(new Color(25, 25, 112));
		btnXemCthd.setBounds(155, 598, 127, 44);
		contentPane.add(btnXemCthd);
		
		JLabel lblNhnVo = new JLabel("(*) Nhấn vào XEMCTHD để xem chi tiết hóa đơn");
		lblNhnVo.setForeground(new Color(165, 42, 42));
		lblNhnVo.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNhnVo.setBounds(102, 653, 342, 30);
		contentPane.add(lblNhnVo);
		
		JButton btnNewButton_2 = new JButton("THOÁT");
		btnNewButton_2.setForeground(new Color(25, 25, 112));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(328, 598, 104, 42);
		contentPane.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(155, 257, 829, 125);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã hàng hóa");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(66, 29, 103, 25);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblTnHngHa = new JLabel("Tên hàng hóa");
		lblTnHngHa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnHngHa.setBounds(424, 29, 103, 25);
		panel_2.add(lblTnHngHa);
		
		textField_2 = new JTextField();
		textField_2.setBounds(562, 23, 179, 31);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(179, 23, 179, 31);
		panel_2.add(comboBox);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSLng.setBounds(65, 70, 73, 25);
		panel_2.add(lblSLng);
		
		JLabel lblNewLabel_3 = new JLabel("Đơn giá");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(424, 70, 103, 25);
		panel_2.add(lblNewLabel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(179, 67, 180, 34);
		panel_2.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(562, 67, 180, 34);
		panel_2.add(spinner_1);
		
		JButton btnThanhTon = new JButton("THANH TOÁN");
		btnThanhTon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThanhTon.setBounds(716, 598, 144, 38);
		contentPane.add(btnThanhTon);
	}
}

