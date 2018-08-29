package Frm;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Connection.ConnectDB;
import Control.HangHoa_control;
import Control.KhachHang_control;
import Model.HangHoa_M;
import Model.KhachHang_M;
import Model.LoaiHang_M;
import Model.NhaCungCap_M;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HangHoa extends JFrame {
	private JTextField txtmahh;
	private JTextField txttenhh;
	private JTextField txtdongia;
	private JTextField txtDvt;
	JButton btnThem;
	private JTable tablehang;
	private JComboBox cbotenlh;
    private JComboBox cbomancc;
    private JSpinner spnsoluong;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private JTextField txttimkiem;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangHoa frame = new HangHoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HangHoa()
	{
		FrameHanghoa();
		try {
		con=ConnectDB.Connect();
		}catch(Exception e)
		{
			
		}
		Load();
		loadcomboboxlh();
	    loadcomboboxncc();
		
		
	}
	
	public ArrayList<HangHoa_M> ArrHangHoa()
	{
		ArrayList<HangHoa_M> arr=new ArrayList<>();
		String sql="select *from hanghoa";
		con=ConnectDB.Connect();
		
		try {
		st=con.createStatement();
		rs=st.executeQuery(sql);
		HangHoa_M hh;
		while(rs.next())
		{
			hh=new HangHoa_M(rs.getString("mahh"), rs.getString("tenhh"), rs.getString("malh"), rs.getInt("sl"),rs.getString("donvitinh"),rs.getString("mancc"),rs.getInt("giaban"));
			arr.add(hh);
		}
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		return arr;
	}
	
	public void Load()
	{
		ArrayList<HangHoa_M> list=ArrHangHoa();
	
       DefaultTableModel table=(DefaultTableModel)tablehang.getModel();
	
	   Object[] row=new Object[7];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getMahh();
			row[1]=list.get(i).getTenhh();
			row[2]=list.get(i).getMalh();
			row[3]=list.get(i).getSl();
			row[4]=list.get(i).getDonvitinh();
			row[5]=list.get(i).getMancc();
			row[6]=list.get(i).getGiaban();
			
			table.addRow(row);
			
		}
		
		
	}
	
	public ArrayList<HangHoa_M> SearchArr(String chuoi)
	{
		ArrayList<HangHoa_M> arr=new ArrayList<>();
		String sql="select *from hanghoa where CONCAT(mahh, tenhh, malh, sl, donvitinh, mancc, giaban)like '%"+chuoi+"%'";
		con=ConnectDB.Connect();
		try {
		st=con.createStatement();
		rs=st.executeQuery(sql);
	    HangHoa_M hh;
		while(rs.next())
		{
			hh=new HangHoa_M(rs.getString("mahh"), rs.getString("tenhh"), rs.getString("malh"), rs.getInt("sl"),rs.getString("donvitinh"),rs.getString("mancc"),rs.getInt("giaban"));
			arr.add(hh);
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
		ArrayList<HangHoa_M> list=SearchArr(txttimkiem.getText());
		DefaultTableModel model=(DefaultTableModel)tablehang.getModel();
		Object[] row=new Object[7];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getMahh();
			row[1]=list.get(i).getTenhh();
			row[2]=list.get(i).getMalh();
			row[3]=list.get(i).getSl();
			row[4]=list.get(i).getDonvitinh();
			row[5]=list.get(i).getMancc();
			row[6]=list.get(i).getGiaban();
			
			model.addRow(row);
			
		}
		
				
	}

	public void loadcomboboxlh()
	{
		con=ConnectDB.Connect();
		String sql="select *from loaihang";
		
		
		try {
		st=con.createStatement();
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			cbotenlh.addItem(rs.getString("malh"));
			
			
		}
		
		}catch(Exception e)
		{
			
		}
	}
   public void loadcomboboxncc()
	{
		con=ConnectDB.Connect();
		String sql="select *from nhacungcap";
		
		
		
		try {
		st=con.createStatement();
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			cbomancc.addItem(rs.getString("mancc"));
		}
		
		}catch(Exception e)
		{
			
		}
	}
	
   public void Reset()
   {
	   txtmahh.setText("");
		txttenhh.setText("");
		txtDvt.setText("");
		txtdongia.setText("");
		spnsoluong.setValue(0);
		cbomancc.setSelectedIndex(0);
		cbotenlh.setSelectedIndex(0);
   }
	public void FrameHanghoa() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(3, 10, 1340, 714);
		setTitle("Hàng Hóa");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(46, 94, 1225, 192);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã hàng hóa");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(26, 26, 117, 32);
		panel.add(lblNewLabel);
		
		JLabel lblTenHang = new JLabel("Tên hàng hóa");
		lblTenHang.setForeground(new Color(0, 0, 128));
		lblTenHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenHang.setBounds(436, 79, 117, 32);
		panel.add(lblTenHang);
		
		JLabel lblnGia = new JLabel("Đơn giá");
		lblnGia.setForeground(new Color(0, 0, 128));
		lblnGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnGia.setBounds(855, 122, 81, 38);
		panel.add(lblnGia);
		
		JLabel lblTlh = new JLabel("Mã loại hàng");
		lblTlh.setForeground(new Color(0, 0, 128));
		lblTlh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTlh.setBounds(26, 79, 140, 32);
		panel.add(lblTlh);
		
		JLabel lblSL = new JLabel("Số lượng");
		lblSL.setForeground(new Color(0, 0, 128));
		lblSL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSL.setBounds(855, 79, 81, 32);
		panel.add(lblSL);
		
		txtmahh = new JTextField();
		txtmahh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtmahh.setBounds(153, 24, 228, 33);
		
		panel.add(txtmahh);
		txtmahh.setColumns(10);
		
		 cbotenlh = new JComboBox();
		cbotenlh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbotenlh.setBounds(153, 77, 228, 33);
		panel.add(cbotenlh);
		
	
		txttenhh = new JTextField();
		txttenhh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttenhh.setBounds(573, 62, 228, 33);
		panel.add(txttenhh);
		txttenhh.setColumns(10);
		
		txtdongia = new JTextField();
		txtdongia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdongia.setBounds(946, 127, 228, 33);
		panel.add(txtdongia);
		txtdongia.setColumns(10);
		
		txtDvt = new JTextField();
		txtDvt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDvt.setBounds(153, 127, 228, 33);
		panel.add(txtDvt);
		txtDvt.setColumns(10);
		
		spnsoluong = new JSpinner();
		spnsoluong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnsoluong.setBounds(946, 81, 228, 33);
		panel.add(spnsoluong);
		
		JLabel lblMNhCung = new JLabel("Mã nhà cung cấp");
		lblMNhCung.setForeground(new Color(0, 0, 128));
		lblMNhCung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhCung.setBounds(436, 127, 130, 37);
		panel.add(lblMNhCung);
		
		 cbomancc = new JComboBox();
		cbomancc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbomancc.setBounds(573, 127, 228, 33);
		panel.add(cbomancc);
		
	
		JLabel lblnVTnh = new JLabel("Đợn vi tính");
		lblnVTnh.setForeground(new Color(0, 0, 128));
		lblnVTnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnVTnh.setBounds(26, 134, 117, 22);
		panel.add(lblnVTnh);
		

		
		JLabel lblHanghoa = new JLabel("HÀNG HÓA");
		lblHanghoa.setForeground(new Color(0, 0, 128));
		lblHanghoa.setBounds(591, 11, 200, 49);
		lblHanghoa.setFont(new Font("Tahoma", Font.PLAIN, 28));
		getContentPane().add(lblHanghoa);
		
		JLabel lblThngTinHng = new JLabel("Thông tin hàng hóa");
		lblThngTinHng.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\product.png"));
		lblThngTinHng.setForeground(new Color(128, 0, 0));
		lblThngTinHng.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblThngTinHng.setBounds(46, 54, 276, 42);
		getContentPane().add(lblThngTinHng);
		
	
		btnThem = new JButton(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\plus.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtmahh.getText().length()==0)
				{
					
					JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin ","Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				else {
				
				HangHoa_M hh=new HangHoa_M();
				hh.setMahh(txtmahh.getText());;
				hh.setTenhh(txttenhh.getText());
				hh.setMalh(cbotenlh.getSelectedItem().toString());
				hh.setSl(Integer.parseInt(spnsoluong.getValue().toString()));
				hh.setDonvitinh(txtDvt.getText()); 
     			hh.setMancc(cbomancc.getSelectedItem().toString());
				hh.setGiaban(Integer.parseInt(txtdongia.getText()));
				HangHoa_control hhct=new HangHoa_control();
				hhct.Themhh(hh);
				
				DefaultTableModel model=(DefaultTableModel)tablehang.getModel();
				model.setRowCount(0);
				Load();
				}
			}
		});
		
	
		btnThem.setLocation(20, 20);
	
		btnThem.setText(" THÊM");
        btnThem.setForeground(new Color(255, 0, 0));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnThem.setBounds(179, 297,  143, 49);
        getContentPane().add(btnThem);
		// load(btnThem, "write.png");
		
		JButton btnXoa = new JButton(" XÓA");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=JOptionPane.showConfirmDialog(null, "Ban có chắc muốn xóa không?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(i==0)
				{
					HangHoa_M hh=new HangHoa_M();
					hh.setMahh(txtmahh.getText());
					HangHoa_control hhctr=new HangHoa_control();
					hhctr.Xoahh(hh);
					DefaultTableModel model=(DefaultTableModel)tablehang.getModel();
					model.setRowCount(0);
					Load();
					Reset();
				}else
				{
					return;
				}
				
				
				
			}
		});
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\delete.png"));
		btnXoa.setForeground(new Color(255, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnXoa.setBounds(444, 297,  143, 49);
		getContentPane().add(btnXoa);
		
		JButton btnSua = new JButton(" SỬA");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(txtmahh.getText().length()==0)
				{
					
					JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin ","Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				else {
				
				HangHoa_M hh=new HangHoa_M();
				hh.setMahh(txtmahh.getText());;
				hh.setTenhh(txttenhh.getText());
				hh.setMalh(cbotenlh.getSelectedItem().toString());
				hh.setSl(Integer.parseInt(spnsoluong.getValue().toString()));
				hh.setDonvitinh(txtDvt.getText()); 
     			hh.setMancc(cbomancc.getSelectedItem().toString());
				hh.setGiaban(Integer.parseInt(txtdongia.getText()));
				HangHoa_control hhct=new HangHoa_control();
				hhct.Suahanghoa(hh);;
				
				DefaultTableModel model=(DefaultTableModel)tablehang.getModel();
				model.setRowCount(0);
				Load();
				
				}
				}
		});
		btnSua.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\edit2.png"));
		btnSua.setForeground(new Color(255, 0, 0));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSua.setBounds(714, 297,  143, 49);
		getContentPane().add(btnSua);
		
		JButton btnHuy = new JButton(" HỦY");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            Reset();
	            
			}
		});
		btnHuy.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\cancel.png"));
		btnHuy.setForeground(new Color(255, 0, 0));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHuy.setBounds(977, 297,  143, 49);
		getContentPane().add(btnHuy);
		setLocationRelativeTo(null);
		
		JLabel lblDanhSchHng = new JLabel("Danh sách hàng hóa");
		lblDanhSchHng.setForeground(new Color(128, 0, 0));
		lblDanhSchHng.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblDanhSchHng.setBounds(40, 373, 234, 27);
		getContentPane().add(lblDanhSchHng);
		
		JButton button = new JButton("THOÃT");
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button.setBounds(1447, 909, 130, 51);
		getContentPane().add(button);
		
	
		tablehang=new JTable();
		tablehang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model=(DefaultTableModel)tablehang.getModel();
				int luachon=tablehang.getSelectedRow();
				txtmahh.setText(model.getValueAt(luachon, 0).toString());
				txttenhh.setText(model.getValueAt(luachon, 1).toString());
             	cbotenlh.setSelectedItem(model.getValueAt(luachon, 2));
			    spnsoluong.setValue(model.getValueAt(luachon, 3));
				txtDvt.setText(model.getValueAt(luachon, 4).toString());
				cbomancc.setSelectedItem(model.getValueAt(luachon, 5));
				txtdongia.setText(model.getValueAt(luachon, 6).toString());
			
			}
		});
		tablehang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã hàng hóa","Tên hàng hóa","Mã loại hàng","Số lượng","Đơn vị tính","Mã nhà cung cấp","Giá bán"}
		));
		JScrollPane scroll=new JScrollPane(tablehang);
		getContentPane().add(scroll);
		scroll.setPreferredSize(new Dimension(1465, 342));
		scroll.setBounds(46, 411, 1225, 217);
		
		JPanel panel_1 = new JPanel();
		scroll.setColumnHeaderView(panel_1);
		
		JButton button_1 = new JButton("THOÁT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.setBounds(1183, 637, 91, 27);
		getContentPane().add(button_1);
		
		txttimkiem = new JTextField();
		txttimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttimkiem.setColumns(10);
		txttimkiem.setBounds(907, 371, 262, 29);
		getContentPane().add(txttimkiem);
		
		JButton btntimkiem = new JButton("Tim kiem");
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)tablehang.getModel();
				model.setRowCount(0);
				Loads();
			}
		});
		btntimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btntimkiem.setBounds(1171, 371, 89, 29);
		getContentPane().add(btntimkiem);
		
		
		
		
	}
	}

