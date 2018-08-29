package Frm;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JMonthChooser;
//import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Connection.ConnectDB;
import Control.KhachHang_control;
import Control.LoaiHang_control;
import Model.KhachHang_M;
import Model.LoaiHang_M;
import Model.NhaCungCap_M;

public class KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtmakh;
	private JTextField txttenkh;
	private JTextField txtdiachi;
	private JTextField txtsdt;
	private JTable tablekhachhang;
	private JComboBox cbogioitinh;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private JTextField txttimkiem;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					KhachHang frame = new KhachHang();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public KhachHang()
	{
		Framecomponent();
		try {
		   con=ConnectDB.Connect();	
		}catch(Exception e) {
			
		}
		Load();
	}
	public ArrayList<KhachHang_M> ArrayKhachhang()
	{
		ArrayList<KhachHang_M> arr=new ArrayList<>();
		con=ConnectDB.Connect();
		String sql="select * from khachhang";
		try {
		st=con.createStatement();
		rs=st.executeQuery(sql);
		KhachHang_M kh;
		while(rs.next())
		{
			kh=new KhachHang_M(rs.getString("makh"),rs.getString("tenkh"),rs.getString("gioitinh"),rs.getString("ngaysinh"),rs.getString("diachi"),rs.getInt("sdt"));
		    arr.add(kh);
		}
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		return arr;
	}
	
	public void Load()
	{
		ArrayList<KhachHang_M> list= ArrayKhachhang();
		DefaultTableModel table=(DefaultTableModel)tablekhachhang.getModel();
		Object[] row=new Object[6];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getMakh();
			row[1]=list.get(i).getTenkh();
			row[2]=list.get(i).getGioitinh();
			row[3]=list.get(i).getNgaysinh();
			row[4]=list.get(i).getDiachi();
			row[5]=list.get(i).getSdt();
			
			table.addRow(row);
		}
	}
	
	public void Set()
	{
		txtmakh.setText("");
		txttenkh.setText("");
		txtdiachi.setText("");
		txtsdt.setText("");
		cbogioitinh.setSelectedIndex(0);
		
	}
	public ArrayList<KhachHang_M> SearchArr(String chuoi)
	{
		ArrayList<KhachHang_M> arr=new ArrayList<>();
		String sql="select *from khachhang where CONCAT(makh, tenkh, gioitinh, ngaysinh, diachi, sdt)like '%"+chuoi+"%'";
		con=ConnectDB.Connect();
		try {
		st=con.createStatement();
		rs=st.executeQuery(sql);
		KhachHang_M kh;
		while(rs.next())
		{
			kh=new KhachHang_M(rs.getString("makh"),rs.getString("tenkh"),rs.getString("gioitinh"),rs.getString("ngaysinh"),rs.getString("diachi"),rs.getInt("sdt"));
		    arr.add(kh);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return arr;
	}
	
	public void Loads()
	{
		ArrayList<KhachHang_M> list=SearchArr(txttimkiem.getText());
		DefaultTableModel model=(DefaultTableModel)tablekhachhang.getModel();
		Object[] row=new Object[6];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getMakh();
			row[1]=list.get(i).getTenkh();	
			row[2]=list.get(i).getGioitinh();
			row[3]=list.get(i).getNgaysinh();
			row[4]=list.get(i).getDiachi();
			row[5]=list.get(i).getSdt();
			model.addRow(row);
		}
		
				
	}
	
	public boolean KiemtraSDT(String number)
	{
		Pattern patter=Pattern.compile("^[0-9]*$");
		Matcher matcher=patter.matcher(number);
		if(!matcher.matches())
		{
		//	return "Chuỗi nhập vào không phải là số!";
			JOptionPane.showMessageDialog(null,"Số điện thoại không phải là số vui lòng nhập lại!");
			return false;
		}
		else {
			if(number.length()==10 || number.length()==11)
			{
				if(number.length()==10) {
					if(number.substring(0, 2).equals("09"))
				{
			//		return "So dien thoai hop le";
						return true;
				}else
				{
					//return "So dien thoai khong hop le";
					JOptionPane.showMessageDialog(null,"So dien thoai khong hop le!");
					return false;
				}}
					else
						if(number.substring(0, 2).equals("01"))
						{
							//return "So dien thoai hop le";
							return true;
						}
						else
						{
						//	return "So dien thoai khong hop le";
							JOptionPane.showMessageDialog(null,"So dien thoai khong hop le!");
							return false;
						}
					
					}
			else
					{
				JOptionPane.showMessageDialog(null,"Do dai so dien thoai khong hop le");
					//	return"Do dai so dien thoai khong hop le" ;
				return false;
					}
			}
		
			
		}
	public void Framecomponent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(32, 10, 1290, 717);
		setTitle("Khách Hàng");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KHÁCH HÀNG");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(576, 11, 245, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblThngTinKhch = new JLabel("Thông tin khách hàng");
		lblThngTinKhch.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\khachhang.png"));
		lblThngTinKhch.setForeground(new Color(128, 0, 0));
		lblThngTinKhch.setFont(new Font("Tahoma", Font.ITALIC, 19));
		lblThngTinKhch.setBounds(74, 44, 286, 44);
		contentPane.add(lblThngTinKhch);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(73, 94, 1130, 220);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMKhchHng = new JLabel("Mã khách hàng");
		lblMKhchHng.setForeground(new Color(0, 0, 139));
		lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMKhchHng.setBounds(92, 34, 119, 31);
		panel.add(lblMKhchHng);
		
		JLabel lblTnKhchHng = new JLabel("Họ và tên");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnKhchHng.setForeground(new Color(0, 0, 139));
		lblTnKhchHng.setBounds(92, 91, 90, 31);
		panel.add(lblTnKhchHng);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setForeground(new Color(0, 0, 139));
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiiTnh.setBounds(92, 157, 78, 22);
		panel.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setForeground(new Color(0, 0, 139));
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgySinh.setBounds(569, 31, 103, 37);
		panel.add(lblNgySinh);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setForeground(new Color(0, 0, 139));
		lblaCh.setBounds(569, 91, 90, 31);
		panel.add(lblaCh);
		
		JLabel lblNewLabel_1 = new JLabel("Số điện thoại");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(569, 153, 119, 31);
		panel.add(lblNewLabel_1);
		
		txtmakh = new JTextField();
		txtmakh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmakh.setBounds(223, 31, 276, 33);
		panel.add(txtmakh);
		txtmakh.setColumns(10);
		
		txttenkh = new JTextField();
		txttenkh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txttenkh.setBounds(219, 88, 280, 33);
		panel.add(txttenkh);
		txttenkh.setColumns(10);
		
		cbogioitinh = new JComboBox();
		cbogioitinh.addItem("Nam");
		cbogioitinh.addItem("Nu");
		cbogioitinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbogioitinh.setBounds(219, 150, 280, 33);
		panel.add(cbogioitinh);
		
		txtdiachi = new JTextField();
		txtdiachi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtdiachi.setBounds(726, 88, 280, 33);
		panel.add(txtdiachi);
		txtdiachi.setColumns(10);
		
		txtsdt = new JTextField();
		txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtsdt.setBounds(726, 150, 280, 33);
		panel.add(txtsdt);
		txtsdt.setColumns(10);
		
		JDateChooser datengaysinh = new JDateChooser();
		datengaysinh.setBounds(726, 34, 283, 33);
		panel.add(datengaysinh);
		
	//	JDateChooser dateChooser = new JDateChooser();
	//	dateChooser.setBounds(818, 42, 356, 39);
	//	panel.add(dateChooser);
		
		JButton btnThem = new JButton();
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtmakh.getText().length()==0)
				{
					
					JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin ","Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				else {
				
				KhachHang_M kh=new KhachHang_M();
				kh.setMakh(txtmakh.getText());;
				kh.setTenkh(txttenkh.getText());
				kh.setGioitinh(cbogioitinh.getSelectedItem().toString());
				SimpleDateFormat da=new SimpleDateFormat("yyyy-MM-dd");
				String date=da.format(datengaysinh.getDate());
				kh.setNgaysinh(date);
				kh.setDiachi(txtdiachi.getText());
				 if(KiemtraSDT(txtsdt.getText())==true)
				   {
					 
				kh.setSdt(Integer.parseInt(txtsdt.getText()));
				KhachHang_control khct=new KhachHang_control();
				khct.Themkh(kh);
				DefaultTableModel model=(DefaultTableModel)tablekhachhang.getModel();
				model.setRowCount(0);
				Load();
				Set();
				   }
				 else
				 {
					 JOptionPane.showMessageDialog(null,"Vui long nhap lai so dien thoai hop le!");
					   txtsdt.setForeground(Color.RED);
					   txtsdt.requestFocus();
				 }
				}
			}
		});
		btnThem.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\nhan.png"));
		btnThem.setText("THÊM");
		btnThem.setForeground(Color.RED);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnThem.setBounds(213, 325, 138, 49);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton(" XÓA");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(i==0)
				{
				KhachHang_M kh=new KhachHang_M();
				kh.setMakh(txtmakh.getText());
				
				KhachHang_control khct=new KhachHang_control();
				khct.Xoakh(kh);
				DefaultTableModel model=(DefaultTableModel)tablekhachhang.getModel();
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
		btnXoa.setBounds(445, 325, 138, 49);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("SỬA");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHang_M kh=new KhachHang_M();
				kh.setMakh(txtmakh.getText());
				kh.setTenkh(txttenkh.getText());
				kh.setGioitinh(cbogioitinh.getSelectedItem().toString());
			//	kh.setNgaysinh();
				SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
				String dateng=sp.format(datengaysinh.getDate());
				kh.setNgaysinh(dateng);
				kh.setDiachi(txtdiachi.getText());
				
				kh.setSdt(Integer.parseInt(txtsdt.getText()));
				KhachHang_control khct=new KhachHang_control();
				khct.Suakh(kh);
				DefaultTableModel model=(DefaultTableModel)tablekhachhang.getModel();
				model.setRowCount(0);
				Load();
				
				 
			}
		});
		btnSua.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\edit2.png"));
		btnSua.setForeground(Color.RED);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSua.setBounds(688, 325, 130, 49);
		contentPane.add(btnSua);
		
		JButton btnHuy = new JButton(" HỦY");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmakh.setText("");
				txttenkh.setText("");
				txtdiachi.setText("");
				txtsdt.setText("");
			    cbogioitinh.setSelectedIndex(0);
			    
			}
		});
		btnHuy.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\cancel.png"));
		btnHuy.setForeground(Color.RED);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHuy.setBounds(935, 325, 130, 49);
		contentPane.add(btnHuy);
		
		JLabel lblDanhSchKhch = new JLabel("Danh sách khách hàng");
		lblDanhSchKhch.setForeground(new Color(128, 0, 0));
		lblDanhSchKhch.setFont(new Font("Tahoma", Font.ITALIC, 19));
		lblDanhSchKhch.setBounds(73, 385, 226, 44);
		contentPane.add(lblDanhSchKhch);
		
		JButton button_5 = new JButton("THOÁT");
		button_5.setForeground(new Color(255, 0, 0));
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button_5.setBounds(1412, 899, 130, 51);
		contentPane.add(button_5);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(73, 425, 1124, 208);
		contentPane.add(scroll);
		
		
		tablekhachhang = new JTable();
		tablekhachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model=(DefaultTableModel)tablekhachhang.getModel();
				int luachon=tablekhachhang.getSelectedRow();
				txtmakh.setText(model.getValueAt(luachon, 0).toString());
				txttenkh.setText(model.getValueAt(luachon, 1).toString());
				cbogioitinh.setSelectedItem(model.getValueAt(luachon, 2));
				try {
			Date ngays=new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(luachon,3));
			datengaysinh.setDate(ngays);
			
			
				}catch(Exception e)
				{
					
				}
				txtdiachi.setText(model.getValueAt(luachon, 4).toString());
				txtsdt.setText(model.getValueAt(luachon, 5).toString());
			}
			
		});
		tablekhachhang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã khách hàng","Tên khách hàng","Giới tính","Ngày sinh","Địa chỉ","Số điện thoại"
			}
		));
		scroll.setViewportView(tablekhachhang);
		
		JPanel panel_1 = new JPanel();
		scroll.setColumnHeaderView(panel_1);
		panel_1.setLayout(null);
		
		JButton btnThoat = new JButton("THOÁT");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setForeground(Color.RED);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoat.setBounds(1105, 640, 91, 27);
		contentPane.add(btnThoat);
		
		txttimkiem = new JTextField();
		txttimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttimkiem.setColumns(10);
		txttimkiem.setBounds(830, 385, 262, 29);
		contentPane.add(txttimkiem);
		
		JButton btntimkiem = new JButton("Tim kiem");
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model=(DefaultTableModel)tablekhachhang.getModel();
				model.setRowCount(0);
				Loads();
			}
		});
		btntimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btntimkiem.setBounds(1094, 385, 91, 29);
		contentPane.add(btntimkiem);
	}
}
