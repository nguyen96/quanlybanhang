package Frm;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.ParseConversionEvent;

import com.toedter.calendar.JDateChooser;

import Connection.ConnectDB;
import Control.NhanVien_control;
import Model.NhaCungCap_M;
import Model.NhanVien_M;

public class NhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtmanv;
	private JTextField txttennv;
	private JTextField txtdiachi;
	private JTextField txtsdt;
	private JTextField txtluong;
	private JComboBox cbogioitinh;
	private JDateChooser datengaysinh;
	private JDateChooser datengaylv;
	private JTable tablenhanvien;
	private Boolean them;
	private JTextField txttimkiem;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien frame = new NhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	   private Connection con;
	   private Statement st;
	   private ResultSet rs;
   public NhanVien()
   {
	   Components();
	   try {
 con=ConnectDB.Connect();
 
	   }catch (Exception e) {
		// TODO: handle exception
	}
//	 Khoadethem();
	  Load();
	 
	  
   }
  
   
 
   public ArrayList<NhanVien_M> ArrNhanVien()
   {
	   ArrayList<NhanVien_M> array=new ArrayList<>();
	   String sql="select *from nhanvien";
	   try {
	   st=con.createStatement();
	   rs=st.executeQuery(sql);
	   NhanVien_M nv;
	  while(rs.next())
	  {
		  nv=new NhanVien_M(rs.getString("manv"),rs.getString("tennv"),rs.getString("gioitinh"),rs.getInt("luong"),rs.getString("ngaysinh"),rs.getString("ngaylv"),rs.getString("diachi"),rs.getInt("sdt"));
          array.add(nv);
          
	  }
	   }catch(SQLException e)
	   {
		  // e.printStackTrace();
		   JOptionPane.showMessageDialog(null, e);
	   }
	   return array;
   }
   
   public void Load()
   {
	   ArrayList<NhanVien_M> list= ArrNhanVien();
	   DefaultTableModel model= (DefaultTableModel)tablenhanvien.getModel();
	   Object[] row=new Object[8];
	   for(int i=0;i<list.size();i++)
	   {
		   row[0]=list.get(i).getManv();//get de gan du lieu len jtable
		   row[1]=list.get(i).getTennv();
		   row[2]=list.get(i).getGioitinh();
		   row[3]=list.get(i).getLuong();
		   row[4]=list.get(i).getNgaysinh();
		   row[5]=list.get(i).getNgaylv();
		   row[6]=list.get(i).getDiachi();
		   row[7]=list.get(i).getSdt();
		   
		   model.addRow(row);
	   }
	
   }
   
   public ArrayList<NhanVien_M> SearchArr(String chuoi)
	{
		ArrayList<NhanVien_M> arr=new ArrayList<>();
		String sql="select *from nhanvien where CONCAT(manv, tennv, gioitinh, luong, ngaysinh, ngaylv, diachi, sdt)like '%"+chuoi+"%'";
		con=ConnectDB.Connect();
		try {
		st=con.createStatement();
		rs=st.executeQuery(sql);
		NhanVien_M nv;
		while(rs.next())
		{
			 nv=new NhanVien_M(rs.getString("manv"),rs.getString("tennv"),rs.getString("gioitinh"),rs.getInt("luong"),rs.getString("ngaysinh"),rs.getString("ngaylv"),rs.getString("diachi"),rs.getInt("sdt"));
	          arr.add(nv);
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
		ArrayList<NhanVien_M> list=SearchArr(txttimkiem.getText());
		DefaultTableModel model=(DefaultTableModel)tablenhanvien.getModel();
		Object[] row=new Object[8];
		for(int i=0;i<list.size();i++)
		{
			 row[0]=list.get(i).getManv();//get de gan du lieu len jtable
			   row[1]=list.get(i).getTennv();
			   row[2]=list.get(i).getGioitinh();
			   row[3]=list.get(i).getLuong();
			   row[4]=list.get(i).getNgaysinh();
			   row[5]=list.get(i).getNgaylv();
			   row[6]=list.get(i).getDiachi();
			   row[7]=list.get(i).getSdt();
			   
			   model.addRow(row);
		}
		
				
	}
	
 
  public void Set()
  {
	  txtmanv.setText("");
	  txttennv.setText("");
	  txtluong.setText("");
	  txtdiachi.setText("");
	  txtsdt.setText("");
	  cbogioitinh.setSelectedIndex(0);
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
	
	public void Components() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(3, 10, 1356, 738);
		setTitle("Nhân viên");
		getContentPane().setLayout(null);
		
		JLabel lblNhnVin = new JLabel("NHÂN VIÊN");
		lblNhnVin.setForeground(new Color(0, 0, 128));
		lblNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNhnVin.setBounds(556, 11, 166, 56);
		getContentPane().add(lblNhnVin);
		
		JLabel lblDanhSchNhn = new JLabel("Thông tin nhân viên");
		lblDanhSchNhn.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\thongtinncc.png"));
		lblDanhSchNhn.setForeground(new Color(139, 0, 0));
		lblDanhSchNhn.setFont(new Font("Tahoma", Font.ITALIC, 19));
		lblDanhSchNhn.setBounds(26, 62, 311, 40);
		getContentPane().add(lblDanhSchNhn);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(26, 109, 1275, 219);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(41, 25, 134, 33);
		panel.add(lblNewLabel);
		
		txtmanv = new JTextField();
		txtmanv.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtmanv.setBounds(185, 25, 228, 33);
		panel.add(txtmanv);
		txtmanv.setColumns(10);
		
		JLabel lblTnNhnVin = new JLabel("Họ và tên");
		lblTnNhnVin.setForeground(new Color(0, 0, 139));
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnNhnVin.setBounds(41, 84, 109, 33);
		panel.add(lblTnNhnVin);
		
		txttennv = new JTextField();
		txttennv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txttennv.setBounds(185, 84, 228, 33);
		panel.add(txttennv);
		txttennv.setColumns(10);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setForeground(new Color(0, 0, 139));
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiiTnh.setBounds(41, 140, 103, 38);
		panel.add(lblGiiTnh);
		
		JComboBox cbogioitinh = new JComboBox();
		
		cbogioitinh.addItem("Nam");
        cbogioitinh.addItem("Nu");
        
		cbogioitinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cbogioitinh.setBounds(185, 143, 228, 33);
		panel.add(cbogioitinh);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgySinh.setForeground(new Color(0, 0, 139));
		lblNgySinh.setBounds(463, 25, 103, 33);
		panel.add(lblNgySinh);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setForeground(new Color(0, 0, 139));
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setBounds(463, 143, 78, 33);
		panel.add(lblaCh);
		
		txtdiachi = new JTextField();
		txtdiachi.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtdiachi.setBounds(572, 143, 228, 33);
		panel.add(txtdiachi);
		txtdiachi.setColumns(10);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSinThoi.setForeground(new Color(0, 0, 139));
		lblSinThoi.setBounds(866, 25, 123, 33);
		panel.add(lblSinThoi);
		
		JLabel lblLng = new JLabel("Lương");
		lblLng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLng.setForeground(new Color(0, 0, 139));
		lblLng.setBounds(870, 84, 78, 33);
		panel.add(lblLng);
		
		JLabel lblNgyLmVic = new JLabel("Ngày làm việc");
		lblNgyLmVic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgyLmVic.setForeground(new Color(0, 0, 139));
		lblNgyLmVic.setBounds(870, 140, 141, 38);
		panel.add(lblNgyLmVic);
		
		txtsdt = new JTextField();
		txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtsdt.setBounds(1013, 25, 228, 33);
		panel.add(txtsdt);
		txtsdt.setColumns(10);
		
		txtluong = new JTextField();
		txtluong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtluong.setBounds(1013, 84, 231, 33);
		panel.add(txtluong);
		txtluong.setColumns(10);
		
		JDateChooser datengaysinh = new JDateChooser();
	
	datengaysinh.setDateFormatString("yyyy-MM-dd");
		datengaysinh.setBounds(570, 25, 230, 33);
		panel.add(datengaysinh);
		
		JDateChooser datengaylv = new JDateChooser();
		datengaylv.setDateFormatString("yyyy-MM-dd");
		datengaylv.setBounds(1013, 140, 228, 33);
		panel.add(datengaylv);
		
	
		JButton btnThem = new JButton();
		btnThem.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\nhan.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NhanVien_M nv=new NhanVien_M();
				
				
				if(txtmanv.getText().length()==0)
				{
					
					JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin ","Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				else {
			
				
				nv.setManv(txtmanv.getText());
				nv.setTennv(txttennv.getText());
				nv.setGioitinh((String)cbogioitinh.getSelectedItem());
				
		
			    SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
			    String date=sp.format(datengaysinh.getDate());
			    nv.setNgaysinh(date);
			    String date1=sp.format(datengaylv.getDate());
			    nv.setNgaylv(date1);
			    nv.setDiachi(txtdiachi.getText());
			    
			//  String textsdt=txtsdt.getText();
			if(KiemtraSDT(txtsdt.getText())==true) {
				  nv.setSdt(Integer.parseInt(txtsdt.getText()));
			     nv.setLuong(Integer.parseInt(txtluong.getText()));
			    
			   
			    
			    NhanVien_control nvct=new NhanVien_control();
			    
			   nvct.themnv(nv);
			   DefaultTableModel model=(DefaultTableModel)tablenhanvien.getModel();
			   model.setRowCount(0);//reset lai
			   
			   Load();
			   JOptionPane.showMessageDialog(null,"Thêm thành công");
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
		btnThem.setText("THÊM");
		btnThem.setForeground(Color.RED);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnThem.setBounds(263, 339, 143, 49);
		getContentPane().add(btnThem);
		
		JButton btnXoa = new JButton("XÓA");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int i=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(i==0)
				{
					NhanVien_M nv=new NhanVien_M();
					nv.setManv(txtmanv.getText());
					NhanVien_control nvcontrol=new NhanVien_control();
					nvcontrol.Xoa(nv);
					DefaultTableModel model=(DefaultTableModel)tablenhanvien.getModel();
					model.setRowCount(0);
					Load();
				}
				else {
					return;
				}
			}
		});
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\delete.png"));
		btnXoa.setForeground(Color.RED);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnXoa.setBounds(516, 339, 137, 49);
		getContentPane().add(btnXoa);
		
		
		JButton btnSua = new JButton(" SỬA");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if(txtmanv.getText().length()==0 || txttennv.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần sửa", "Thông báo",JFrame.EXIT_ON_CLOSE);
			}
					else {
				NhanVien_M nv=new NhanVien_M();
				
				nv.setManv(txtmanv.getText());
				nv.setTennv(txttennv.getText());
				nv.setGioitinh((String)cbogioitinh.getSelectedItem());
				nv.setLuong(Integer.parseInt(txtluong.getText()));
				
				SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
				
				String da=sp.format(datengaysinh.getDate());
				nv.setNgaysinh(da);
				String datengaylv1=sp.format(datengaylv.getDate());
				nv.setNgaylv(datengaylv1);
				
				nv.setDiachi(txtdiachi.getText());
				if(KiemtraSDT(txtsdt.getText())==true)
				{
				nv.setSdt(Integer.parseInt(txtsdt.getText()));
				
				NhanVien_control nvcontrol=new NhanVien_control();
				nvcontrol.Sua(nv);
				
				DefaultTableModel model=(DefaultTableModel)tablenhanvien.getModel();
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
					}catch (Exception e) {
						
					}
			
			}
				
		});
		btnSua.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\edit1.png"));
		btnSua.setForeground(Color.RED);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSua.setBounds(757, 339, 143, 49);
		getContentPane().add(btnSua);
		
		JButton btnHuy = new JButton(" HỦY");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
			   Set();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnHuy.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\cancel.png"));
		btnHuy.setForeground(Color.RED);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHuy.setBounds(1039, 339, 143, 49);
		getContentPane().add(btnHuy);
		
		JLabel lblDanhSchNhn_1 = new JLabel("Danh sách nhân viên");
		lblDanhSchNhn_1.setForeground(new Color(139, 0, 0));
		lblDanhSchNhn_1.setFont(new Font("Tahoma", Font.ITALIC, 21));
		lblDanhSchNhn_1.setBounds(26, 411, 244, 30);
		getContentPane().add(lblDanhSchNhn_1);
		
		JButton button_5 = new JButton("THOÁT");
		button_5.setForeground(Color.RED);
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button_5.setBounds(1473, 957, 130, 40);
		getContentPane().add(button_5);
		
		JScrollPane scroll = new JScrollPane();
		
		scroll.setBounds(26, 452, 1275, 192);
		getContentPane().add(scroll);
		
		tablenhanvien = new JTable();
		tablenhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model=(DefaultTableModel)tablenhanvien.getModel();
				int luachon=tablenhanvien.getSelectedRow();
				
				txtmanv.setText(model.getValueAt(luachon, 0).toString());
				txttennv.setText(model.getValueAt(luachon, 1).toString());
				cbogioitinh.setSelectedItem(model.getValueAt(luachon, 2));
				txtluong.setText(model.getValueAt(luachon,3).toString());
				try {
				Date date=new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(luachon, 4));
		        datengaysinh.setDate(date);
		        Date datenlv=new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(luachon, 5));
		        datengaylv.setDate(datenlv);
				}catch(Exception exception)
				{
					exception.printStackTrace();
				}
                txtdiachi.setText(model.getValueAt(luachon, 6).toString());
                
				txtsdt.setText(model.getValueAt(luachon, 7).toString());
				
			
			}
		});
		tablenhanvien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã nhân viên", "Tên nhân viên", "Giới tính", "Lương", "Ngày sinh", "Ngay làm việc", "Địa chỉ", "Số điện thoại"
			}
		));
		tablenhanvien.getColumnModel().getColumn(0).setPreferredWidth(153);
		tablenhanvien.getColumnModel().getColumn(1).setPreferredWidth(170);
		tablenhanvien.getColumnModel().getColumn(2).setPreferredWidth(133);
		scroll.setViewportView(tablenhanvien);
		
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
		btnThoat.setBounds(1210, 655, 91, 27);
		getContentPane().add(btnThoat);
		
		txttimkiem = new JTextField();
		txttimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttimkiem.setColumns(10);
		txttimkiem.setBounds(944, 415, 262, 29);
		getContentPane().add(txttimkiem);
		
		JButton button = new JButton("Tim kiem");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)tablenhanvien.getModel();
				model.setRowCount(0);
				Loads();
			}
			
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(1210, 415, 89, 29);
		getContentPane().add(button);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
	}
}



