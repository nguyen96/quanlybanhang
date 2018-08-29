package Frm;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ConnectDB;
import Control.LoaiHang_control;
import Model.KhachHang_M;
import Model.LoaiHang_M;

import javax.swing.JScrollPane;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoaiHang extends JFrame {
	private JTextField txtmalh;
	private JTextField txttenlh;
	private JTable tableloaihang;

	private Connection con;
	private Statement st;
	private ResultSet rs;
	private JTextField txttimkiem;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoaiHang frame = new LoaiHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoaiHang()
	{
		FrameLoaihang();
		con=ConnectDB.Connect();
		Load();
	}
	
	public ArrayList<LoaiHang_M> ArrLoaiHang()
	{
		ArrayList<LoaiHang_M> arr=new ArrayList<>();
		String sql="select *from loaihang";
		con=ConnectDB.Connect();
		
		try {
		st=con.createStatement();
		rs=st.executeQuery(sql);
		LoaiHang_M lh;
		while(rs.next())
		{
			lh=new LoaiHang_M(rs.getString("malh"), rs.getString("tenlh"));
			arr.add(lh);
		}
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		return arr;
	}
	
	public void Load()
	{
		ArrayList<LoaiHang_M> list=ArrLoaiHang();
		DefaultTableModel table=(DefaultTableModel)tableloaihang.getModel();
		Object[] row=new Object[2];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getMalh();
			row[1]=list.get(i).getTenlh();
			table.addRow(row);
		}
	}
	
	public ArrayList<LoaiHang_M> ArrLoaihangtk(String chuoi)
	{
		ArrayList<LoaiHang_M> arr=new ArrayList<>();
		String sql="select *from loaihang where CONCAT(malh, tenlh)like '%"+chuoi+"%'";
		con=ConnectDB.Connect();
		try
		{
			st=con.createStatement();
			rs=st.executeQuery(sql);
			LoaiHang_M lh;
			while(rs.next())
			{
				lh=new LoaiHang_M(rs.getString("malh"), rs.getString("tenlh"));
				arr.add(lh);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public void Loaddltimkiem()
	{
		ArrayList<LoaiHang_M> list=ArrLoaihangtk(txttimkiem.getText());
		DefaultTableModel model=(DefaultTableModel)tableloaihang.getModel();
		Object[] row=new Object[2];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getMalh();
			row[1]=list.get(i).getTenlh();
			model.addRow(row);
		}
		
	}
	public void FrameLoaihang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Loại Hàng");
		setBounds(32, 10, 1282, 690);
		getContentPane().setLayout(null);
		
		JLabel lblLoiHng = new JLabel("LOẠI HÀNG");
		lblLoiHng.setForeground(new Color(0, 0, 128));
		lblLoiHng.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblLoiHng.setBounds(545, 24, 193, 45);
		getContentPane().add(lblLoiHng);
		
		JLabel lblNewLabel = new JLabel("Thông tin loại hàng");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 19));
		lblNewLabel.setBounds(78, 73, 193, 28);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách loại hàng");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 19));
		lblNewLabel_2.setBounds(78, 337, 249, 37);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnThem = new JButton();
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtmalh.getText().length()==0)
				{
					
					JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin ","Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				else {
			
				LoaiHang_M lh=new LoaiHang_M();
				lh.setMalh(txtmalh.getText());	
				lh.setTenlh(txttenlh.getText());
				LoaiHang_control lhcontrol=new LoaiHang_control();
				lhcontrol.Themlh(lh);
				 DefaultTableModel model=(DefaultTableModel)tableloaihang.getModel();
				  model.setRowCount(0);//reset lai
				   
				   Load();	}
				
				
			}
		});
		btnThem.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\plus.png"));
		btnThem.setText(" THÊM");
		btnThem.setForeground(Color.RED);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnThem.setBounds(216, 241,  143, 49);
		getContentPane().add(btnThem);
		
		JButton btnXoa = new JButton(" XÓA");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(i==0)
				{
				LoaiHang_M lh=new LoaiHang_M();
				lh.setMalh(txtmalh.getText());
				lh.setTenlh(txttenlh.getText());
				LoaiHang_control lhct=new LoaiHang_control();
				lhct.Xoalh(lh);
				DefaultTableModel model=(DefaultTableModel)tableloaihang.getModel();
				model.setRowCount(0);
				Load();}
				else {
					return;
				}
			}
		});
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\delete.png"));
		btnXoa.setForeground(Color.RED);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnXoa.setBounds(462, 241,  143, 49);
		getContentPane().add(btnXoa);
		
		JButton btnSua = new JButton("SỬA");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaiHang_M lh=new LoaiHang_M();
				lh.setMalh(txtmalh.getText());
				lh.setTenlh(txttenlh.getText());
				LoaiHang_control lhct=new LoaiHang_control();
				lhct.Sua(lh);
				DefaultTableModel model=(DefaultTableModel)tableloaihang.getModel();
				model.setRowCount(0);
				Load();
			}
		});
		btnSua.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\edit2.png"));
		btnSua.setForeground(Color.RED);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSua.setBounds(690, 241,  143, 49);
		getContentPane().add(btnSua);
		
		JButton btnHuy = new JButton(" HỦY");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmalh.setText("");
				txttenlh.setText("");
			}
			
		});
		btnHuy.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\cancel.png"));
		btnHuy.setForeground(Color.RED);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHuy.setBounds(988, 241,  143, 49);
		getContentPane().add(btnHuy);
		
		JButton btnThoat = new JButton("THOÃT");
		btnThoat.setForeground(new Color(255, 0, 0));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnThoat.setBounds(1218, 835, 130, 55);
		getContentPane().add(btnThoat);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(78, 112, 1121, 118);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã loại hàng");
		lblNewLabel_1.setBounds(72, 46, 122, 34);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		
		txtmalh = new JTextField();
		txtmalh.setBounds(204, 40, 279, 39);
		panel.add(txtmalh);
		txtmalh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtmalh.setColumns(10);
		
		JLabel lblTnLoiHng = new JLabel("Tên loại hàng");
		lblTnLoiHng.setBounds(576, 46, 137, 34);
		panel.add(lblTnLoiHng);
		lblTnLoiHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnLoiHng.setForeground(new Color(0, 0, 139));
		
		txttenlh = new JTextField();
		txttenlh.setBounds(723, 42, 279, 39);
		panel.add(txttenlh);
		txttenlh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txttenlh.setColumns(10);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 385, 1125, 214);
		getContentPane().add(scrollPane);
		
		tableloaihang = new JTable();
		tableloaihang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model=(DefaultTableModel)tableloaihang.getModel();
				int luachon=tableloaihang.getSelectedRow();
				txtmalh.setText(model.getValueAt(luachon, 0).toString());
				txttenlh.setText(model.getValueAt(luachon, 1).toString());
				
			}
		});
		tableloaihang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã hàng hóa","Tên hàng hóa"
			}
		));
		tableloaihang.getColumnModel().getColumn(0).setPreferredWidth(192);
		tableloaihang.getColumnModel().getColumn(1).setPreferredWidth(281);
		scrollPane.setViewportView(tableloaihang);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setColumnHeaderView(panel_1);
		panel_1.setLayout(null);
		
		JButton btnthoat = new JButton("THOÁT");
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnthoat.setForeground(Color.RED);
		btnthoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnthoat.setBounds(1108, 610, 91, 27);
		getContentPane().add(btnthoat);
		
		txttimkiem = new JTextField();
		txttimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttimkiem.setColumns(10);
		txttimkiem.setBounds(825, 348, 262, 29);
		getContentPane().add(txttimkiem);
		
		JButton btntimkiem = new JButton("Tim kiem");
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model=(DefaultTableModel)tableloaihang.getModel();
				model.setRowCount(0);
				Loaddltimkiem();
			}
		});
		btntimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btntimkiem.setBounds(1097, 348, 89, 29);
		getContentPane().add(btntimkiem);
	}
}

