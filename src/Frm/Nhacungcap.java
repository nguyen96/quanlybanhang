package Frm;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabableView;

import Connection.ConnectDB;
import Control.Nhacungcap_control;
import Model.NhaCungCap_M;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Nhacungcap extends JFrame {

	private JPanel contentPane;
	private JTextField txtmancc;
	private JTextField txttenncc;
	private JTextField txtsdt;
	private JTextField txtdiachi;
	private JTextField txtemail;
	private JTable tablencc;

	private Connection con;
	private Statement st;
	private ResultSet rs;
	private JTextField txttimkiem;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nhacungcap frame = new Nhacungcap();
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
	public Nhacungcap()
	{
		NhaccFrame();
		try {
		con=ConnectDB.Connect();
		}catch(Exception e)
		{
			
		}
		Load();
	}
	public ArrayList<NhaCungCap_M> ArrNhacc()
	{
		ArrayList<NhaCungCap_M> arr=new ArrayList<>();
		String sql="select *from nhacungcap";
		con=ConnectDB.Connect();
		try {
		st=con.createStatement();
		rs=st.executeQuery(sql);
		NhaCungCap_M ncc;
		while(rs.next())
		{
			ncc=new NhaCungCap_M(rs.getString("mancc"), rs.getString("tenncc"),rs.getString("diachi"),rs.getString("email"),rs.getInt("sdt"));
		    arr.add(ncc);
		}
		}
		catch(SQLException e)
		{
			
		}
		return arr ;
	}
	
	public void Load()
	{
		ArrayList<NhaCungCap_M> list=ArrNhacc();
		DefaultTableModel model=(DefaultTableModel)tablencc.getModel();
		Object[] row=new Object[5];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getMancc();
			row[1]=list.get(i).getTenncc();	
			row[2]=list.get(i).getDiachi();
			row[3]=list.get(i).getEmail();
			row[4]=list.get(i).getSdt();
			model.addRow(row);
		}
		
				
	}
	
	public ArrayList<NhaCungCap_M> SearchArr(String chuoi)
	{
		ArrayList<NhaCungCap_M> arr=new ArrayList<>();
		String sql="select *from nhacungcap where CONCAT(mancc, tenncc, diachi)like '%"+chuoi+"%'";
		con=ConnectDB.Connect();
		try {
		st=con.createStatement();
		rs=st.executeQuery(sql);
		NhaCungCap_M ncc;
		while(rs.next())
		{
			ncc=new NhaCungCap_M(rs.getString("mancc"), rs.getString("tenncc"),rs.getString("diachi"),rs.getString("email"),rs.getInt("sdt"));
		    arr.add(ncc);
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
		ArrayList<NhaCungCap_M> list=SearchArr(txttimkiem.getText());
		DefaultTableModel model=(DefaultTableModel)tablencc.getModel();
		Object[] row=new Object[5];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getMancc();
			row[1]=list.get(i).getTenncc();	
			row[2]=list.get(i).getDiachi();
			row[3]=list.get(i).getEmail();
			row[4]=list.get(i).getSdt();
			model.addRow(row);
		}
		
				
	}
	
	
	public void Set()
	{
		txtmancc.setText("");
		txttenncc.setText("");
		txtdiachi.setText("");
		txtemail.setText("");
		txtsdt.setText("");
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
					JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ!");
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
							JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ!");
							return false;
						}
					
					}
			else
					{
				JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ");
					//	return"Do dai so dien thoai khong hop le" ;
				return false;
					}
			}
		
			
		}
		
	
	public void NhaccFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 1340, 714);
		getContentPane().setLayout(null);
		setTitle("Nhà cung cấp");
		
		JLabel lblNewLabel = new JLabel("NHÀ CUNG CẤP");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(545, 23, 262, 44);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin nhà cung cấp");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\thongtinncc.png"));
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 19));
		lblNewLabel_1.setBounds(129, 63, 302, 44);
		getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(128, 107, 1127, 228);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhà cung cấp");
		lblNewLabel_2.setForeground(new Color(0, 0, 139));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(60, 41, 166, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblTnNhCung = new JLabel("Tên nhà cung cấp");
		lblTnNhCung.setForeground(new Color(0, 0, 139));
		lblTnNhCung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnNhCung.setBounds(60, 101, 166, 30);
		panel.add(lblTnNhCung);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setForeground(new Color(0, 0, 139));
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSinThoi.setBounds(60, 159, 149, 30);
		panel.add(lblSinThoi);
		
		JLabel lblNewLabel_3 = new JLabel("Địa chỉ");
		lblNewLabel_3.setForeground(new Color(0, 0, 139));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(633, 41, 68, 30);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setForeground(new Color(0, 0, 139));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(640, 101, 74, 30);
		panel.add(lblNewLabel_4);
		
		txtmancc = new JTextField();
		txtmancc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtmancc.setBounds(241, 37, 228, 33);
		panel.add(txtmancc);
		txtmancc.setColumns(10);
		
		txttenncc = new JTextField();
		txttenncc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttenncc.setBounds(240, 101, 228, 33);
		panel.add(txttenncc);
		txttenncc.setColumns(10);
		
		txtsdt = new JTextField();
		txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtsdt.setBounds(241, 166, 228, 33);
		panel.add(txtsdt);
		txtsdt.setColumns(10);
		
		txtdiachi = new JTextField();
		txtdiachi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdiachi.setBounds(730, 40, 228, 33);
		panel.add(txtdiachi);
		txtdiachi.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtemail.setBounds(730, 101, 228, 33);
		panel.add(txtemail);
		txtemail.setColumns(10);
		
		JButton btnThem = new JButton();
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NhaCungCap_M ncc=new NhaCungCap_M();
				ncc.setMancc(txtmancc.getText());
				ncc.setTenncc(txttenncc.getText());
				ncc.setDiachi(txtdiachi.getText());
				ncc.setEmail(txtemail.getText());
			   if(KiemtraSDT(txtsdt.getText())==true)
			   {
				   ncc.setSdt(Integer.parseInt(txtsdt.getText()));
					DefaultTableModel model=(DefaultTableModel)tablencc.getModel();
					
					Nhacungcap_control ncctr=new Nhacungcap_control();
					ncctr.Themncc(ncc);
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
		});
		btnThem.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\nhacungcap.png"));
		btnThem.setText("THÊM ");
		btnThem.setForeground(Color.RED);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnThem.setBounds(226, 346, 169, 49);
		getContentPane().add(btnThem);
		
		JButton btnXoa = new JButton("XÓA");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(i==0)
				{
				DefaultTableModel model=(DefaultTableModel)tablencc.getModel();
				NhaCungCap_M ncc=new NhaCungCap_M();
				ncc.setMancc(txtmancc.getText());
				Nhacungcap_control ncctr=new Nhacungcap_control();
				ncctr.Xoancc(ncc);
				model.setRowCount(0);
	            Load();		
	            Set();}
				else
				{
					return;
				}
			}
		});
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\delete.png"));
		btnXoa.setForeground(Color.RED);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnXoa.setBounds(479, 346, 169, 49);
		getContentPane().add(btnXoa);
		
		JButton btnSua = new JButton("SỬA");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(txtmancc.getText().length()==0 || txttenncc.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần sửa", "Thông báo",JFrame.EXIT_ON_CLOSE);
		}
				NhaCungCap_M ncc=new NhaCungCap_M();
				ncc.setMancc(txtmancc.getText());
				ncc.setTenncc(txttenncc.getText());
				ncc.setDiachi(txtdiachi.getText());
				ncc.setEmail(txtemail.getText());
				if(KiemtraSDT(txtsdt.getText())==true)
				{
				ncc.setSdt(Integer.parseInt(txtsdt.getText()));
				Nhacungcap_control ncctr=new Nhacungcap_control();
				ncctr.Suancc(ncc);
				DefaultTableModel model=(DefaultTableModel)tablencc.getModel();
				model.setRowCount(0);
				Load();
				Set();}
				else
				{
					 JOptionPane.showMessageDialog(null,"Vui long nhap lai so dien thoai hop le!");
					   txtsdt.setForeground(Color.RED);
					   txtsdt.requestFocus();
				}
			}catch(Exception exception)
			{
				
			}}
		});
		btnSua.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\edit2.png"));
		btnSua.setForeground(Color.RED);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSua.setBounds(750, 346, 169, 49);
		getContentPane().add(btnSua);
		
		JButton btnHuy = new JButton("HỦY");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Set();
			}
		});
		btnHuy.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\cancel.png"));
		btnHuy.setForeground(Color.RED);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnHuy.setBounds(1009, 346, 169, 49);
		getContentPane().add(btnHuy);
		
		JLabel lblDanhSchNh = new JLabel("Danh sách mã nhà cung cấp");
		lblDanhSchNh.setForeground(new Color(128, 0, 0));
		lblDanhSchNh.setFont(new Font("Tahoma", Font.ITALIC, 19));
		lblDanhSchNh.setBounds(119, 434, 291, 44);
		getContentPane().add(lblDanhSchNh);
		
		JButton button_5 = new JButton("THOÁT");
		button_5.setForeground(new Color(255, 0, 0));
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button_5.setBounds(1309, 870, 130, 49);
		getContentPane().add(button_5);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(121, 473, 1138, 163);
		getContentPane().add(scroll);
		
		tablencc = new JTable();
		tablencc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model=(DefaultTableModel)tablencc.getModel();
				int luachon=tablencc.getSelectedRow();
				txtmancc.setText(model.getValueAt(luachon,0).toString());
				txttenncc.setText(model.getValueAt(luachon, 1).toString());
				txtdiachi.setText(model.getValueAt(luachon, 2).toString());
				txtemail.setText(model.getValueAt(luachon,3).toString());
				txtsdt.setText(model.getValueAt(luachon, 4).toString());
				
				
				
			}
		});
		tablencc.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Email", "Số điện thoại"
			}
		));
		tablencc.getColumnModel().getColumn(0).setPreferredWidth(141);
		tablencc.getColumnModel().getColumn(1).setPreferredWidth(192);
		tablencc.getColumnModel().getColumn(2).setPreferredWidth(164);
		tablencc.getColumnModel().getColumn(3).setPreferredWidth(164);
		tablencc.getColumnModel().getColumn(4).setPreferredWidth(135);
		scroll.setViewportView(tablencc);
		
		JPanel panel_1 = new JPanel();
		scroll.setColumnHeaderView(panel_1);
		panel_1.setLayout(null);
		
		JButton btnThoat = new JButton("THOÁT");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	System.exit(0);
				dispose();
			}
		});
		btnThoat.setForeground(Color.RED);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoat.setBounds(1171, 637, 91, 27);
		getContentPane().add(btnThoat);
		
		txttimkiem = new JTextField();
		txttimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttimkiem.setBounds(901, 434, 262, 29);
		getContentPane().add(txttimkiem);
		txttimkiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tim kiem");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)tablencc.getModel();
				model.setRowCount(0);
				Loads();
			}
		});
		btnTimKiem.setBounds(1166, 434, 89, 29);
		getContentPane().add(btnTimKiem);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(
		//contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
	}
}
