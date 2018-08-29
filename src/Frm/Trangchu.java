package Frm;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

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

import Control.Nhacungcap_control;
import Model.NhaCungCap_M;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.border.MatteBorder;

public class Trangchu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trangchu frame = new Trangchu();
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
	public Trangchu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(185, 30, 951, 668);
		setTitle("Trang chủ");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1652, 26);
		contentPane.add(menuBar);
		
		JMenu mnThngTiC = new JMenu("");
		menuBar.add(mnThngTiC);
		
		JMenu mnTrGip = new JMenu("Trợ giúp");
		mnTrGip.setForeground(new Color(0, 0, 128));
		mnTrGip.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnTrGip);
		
		JMenuItem mntmHngDnBn = new JMenuItem("Hướng dẫn sử dụng phần mềm");
		mntmHngDnBn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnTrGip.add(mntmHngDnBn);
		
		JMenu menucaidat = new JMenu("Cài đặt");
		menucaidat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Chức năng đang được nâng cấp.");
			}
		});
		menucaidat.setForeground(new Color(0, 0, 128));
		menucaidat.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menucaidat);
		
		JButton btnNewButton = new JButton("XEM HÃ“A ÄÆ N");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(265, 849, 192, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("THOÃT");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(469, 849, 144, 49);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTngTin = new JLabel("Thông tin");
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
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ CỦA HÀNG");
		lblNewLabel.setForeground(new Color(51, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(361, 88, 236, 32);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 102)));
		panel.setBounds(171, 131, 588, 380);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnTiKhon = new JButton(" Tài khoản");
		btnTiKhon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoan tk=new TaiKhoan();
				tk.setVisible(true);
			}
			
		});
		btnTiKhon.setBounds(298, 26, 221, 105);
		btnTiKhon.setHorizontalAlignment(SwingConstants.LEFT);
		btnTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTiKhon.setBackground(new Color(153, 204, 204));
		btnTiKhon.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\tk2.png"));
		panel.add(btnTiKhon);
		
		JButton btnHngHa = new JButton("  Hàng hóa");
		btnHngHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HangHoa hh=new HangHoa();
				hh.setVisible(true);
			}
		});
		btnHngHa.setBounds(67, 142, 236, 99);
		btnHngHa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHngHa.setHorizontalAlignment(SwingConstants.LEFT);
		btnHngHa.setBackground(new Color(153, 204, 204));
		btnHngHa.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\123.png"));
		panel.add(btnHngHa);
		
		JButton btnKhchHng = new JButton(" Khách hàng");
		btnKhchHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHang kh=new KhachHang();
				kh.setVisible(true);
			}
		});
		btnKhchHng.setBounds(308, 142, 213, 99);
		btnKhchHng.setBackground(new Color(153, 204, 204));
		btnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKhchHng.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\ncc.png"));
		panel.add(btnKhchHng);
		
		JButton btnNhnVin = new JButton("  Nhân viên");
		btnNhnVin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv=new NhanVien();
				nv.setVisible(true);
			}
		});
		btnNhnVin.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\nhanvien12.png"));
		btnNhnVin.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNhnVin.setBackground(new Color(153, 204, 204));
		btnNhnVin.setBounds(67, 24, 221, 108);
		panel.add(btnNhnVin);
		
		JButton btnNewButton_2 = new JButton("Loại hàng");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoaiHang lh=new LoaiHang();
				lh.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(153, 204, 204));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\569.png"));
		btnNewButton_2.setBounds(67, 246, 195, 99);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("  Nhà cung cấp");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nhacungcap ncc=new Nhacungcap();
				ncc.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(153, 204, 204));
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\tk.png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(272, 246, 247, 99);
		panel.add(btnNewButton_3);
		
		JButton btnThot = new JButton("THOÁT");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThot.setBounds(673, 537, 89, 32);
		contentPane.add(btnThot);
	    
	}
}

