package Frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ConnectDB;
import Control.TaiKhoan_control;
import Model.NhaCungCap_M;
import Model.NhanVien_M;
import Model.TaiKhoan_M;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TaiKhoan extends JFrame {

	private JPanel contentPane;
	private JTextField txttenhienthi;
	private JTextField txtpass;
	private JTextField txtloaitk;
	private JTextField txtusername;
	private JTable tabletaikhoan;

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
					TaiKhoan frame = new TaiKhoan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TaiKhoan()
	{
		FrameTaikhoan();
		try {
			con=ConnectDB.Connect();
		}catch (Exception e) {
			// TODO: handle exception
		}
		Load();
	}
	 public ArrayList<TaiKhoan_M> ArrTaiKhoan()
	   {
		   ArrayList<TaiKhoan_M> array=new ArrayList<>();
		   String sql="select *from taikhoan";
		   try {
		   st=con.createStatement();
		   rs=st.executeQuery(sql);
		   TaiKhoan_M tk;
		  while(rs.next())
		  {
			  tk=new TaiKhoan_M(rs.getString("tenhienthi"),rs.getString("pass"), rs.getInt("loai"), rs.getString("username"));
	          array.add(tk);
	          
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
		   ArrayList<TaiKhoan_M> list= ArrTaiKhoan();
		   DefaultTableModel model= (DefaultTableModel)tabletaikhoan.getModel();
		   Object[] row=new Object[4];
		   for(int i=0;i<list.size();i++)
		   {
			   row[0]=list.get(i).getTenhienthi();//get de gan du lieu len jtable
			   row[1]=list.get(i).getPass();
			   row[2]=list.get(i).getLoai();
			   row[3]=list.get(i).getUsername();
			   
			   
			   model.addRow(row);
		   }
		
	   }
	 
	 public ArrayList<TaiKhoan_M> SearchArr(String chuoi)
		{
			ArrayList<TaiKhoan_M> arr=new ArrayList<>();
			String sql="select *from taikhoan where CONCAT(tenhienthi, pass, loai, username)like '%"+chuoi+"%'";
			con=ConnectDB.Connect();
			try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			TaiKhoan_M tk;
			while(rs.next())
			{
				 tk=new TaiKhoan_M(rs.getString("tenhienthi"),rs.getString("pass"), rs.getInt("loai"), rs.getString("username"));
		          arr.add(tk);
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
			ArrayList<TaiKhoan_M> list=SearchArr(txttimkiem.getText());
			DefaultTableModel model=(DefaultTableModel)tabletaikhoan.getModel();
			Object[] row=new Object[4];
			for(int i=0;i<list.size();i++)
			{
				 row[0]=list.get(i).getTenhienthi();//get de gan du lieu len jtable
				   row[1]=list.get(i).getPass();
				   row[2]=list.get(i).getLoai();
				   row[3]=list.get(i).getUsername();
				   
				   
				   model.addRow(row);
			}
			
					
		}
		
	 public boolean Loaitk(int tk)
	 {
		 if(tk==1 || tk==2)
		 {
			 
			 return true;
		 }
		 else
		 {
			 JOptionPane.showMessageDialog(null,"Lỗi tài khoản 1 dành cho admin,tài khoản 2 dành cho nhân viên");
			 return false;
		 }
		 
	 }
	 public void Reset()
	 {
		 txttenhienthi.setText("");
		 txtpass.setText("");
		 txtloaitk.setText("");
		 txtusername.setText("");
	 }
	/**
	 * Create the frame.
	 */
	public void FrameTaikhoan() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 746, 609);
		setTitle("Tài khoản");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TÀI KHOẢN");
		lblNewLabel.setBounds(330, 11, 154, 50);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(42, 59, 664, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTnHinTh = new JLabel("Tên hiển thị");
		lblTnHinTh.setForeground(new Color(25, 25, 112));
		lblTnHinTh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnHinTh.setBounds(33, 24, 89, 29);
		panel.add(lblTnHinTh);
		
		txttenhienthi = new JTextField();
		txttenhienthi.setBounds(153, 26, 173, 29);
		panel.add(txttenhienthi);
		txttenhienthi.setColumns(10);
		
		JLabel lblPassWord = new JLabel("Pass word");
		lblPassWord.setForeground(new Color(25, 25, 112));
		lblPassWord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassWord.setBounds(33, 90, 77, 29);
		panel.add(lblPassWord);
		
		txtpass = new JTextField();
		txtpass.setColumns(10);
		txtpass.setBounds(153, 92, 173, 29);
		panel.add(txtpass);
		
		txtloaitk = new JTextField();
		txtloaitk.setColumns(10);
		txtloaitk.setBounds(464, 24, 173, 29);
		panel.add(txtloaitk);
		
		txtusername = new JTextField();
		txtusername.setColumns(10);
		txtusername.setBounds(464, 92, 173, 29);
		panel.add(txtusername);
		
		JLabel lblNewLabel_1 = new JLabel("Loại tài khoản");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(349, 24, 105, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(25, 25, 112));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(353, 92, 89, 29);
		panel.add(lblUsername);
		
		JButton btnThem = new JButton();
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TaiKhoan_M tk=new TaiKhoan_M();
				tk.setTenhienthi(txttenhienthi.getText());
				tk.setPass(txtpass.getText());
				if(Loaitk(Integer.parseInt(txtloaitk.getText()))==true)
				{
					tk.setLoai(Integer.parseInt(txtloaitk.getText()));
					tk.setUsername(txtusername.getText());
					
					TaiKhoan_control tkctr=new TaiKhoan_control();
					tkctr.Themtaikhoan(tk);
				    DefaultTableModel model=(DefaultTableModel)tabletaikhoan.getModel();
				    model.setRowCount(0);
				    Load();
				    Reset();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng tài khoản");
					 txtloaitk.requestFocus();
				}
				
				
			   
			}
		});
		btnThem.setBounds(101, 225, 138, 49);
		btnThem.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\edit1.png"));
		btnThem.setText("THÊM");
		btnThem.setForeground(Color.RED);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton(" XÓA");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TaiKhoan_M tk=new TaiKhoan_M();
				tk.setUsername(txtusername.getText());
				TaiKhoan_control tkctr=new TaiKhoan_control();
				tkctr.Xoataikhoan(tk);
				DefaultTableModel model=(DefaultTableModel)tabletaikhoan.getModel();
				model.setRowCount(0);
				Load();
			}
		});
		btnXoa.setBounds(282, 225, 138, 49);
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\delete.png"));
		btnXoa.setForeground(Color.RED);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("SỬA");
		btnSua.setIcon(new ImageIcon("C:\\Users\\Le Phu Trong Ngan\\eclipse-workspace\\QL\\hinhanhjava\\edit2.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 TaiKhoan_M tk=new TaiKhoan_M();
				 tk.setTenhienthi(txttenhienthi.getText());
				 tk.setPass(txtpass.getText());
				 if(Loaitk(Integer.parseInt(txtloaitk.getText()))==true)
						 {
					 tk.setLoai(Integer.parseInt(txtloaitk.getText()));
					 tk.setUsername(txtusername.getText());
					 TaiKhoan_control tkctr=new TaiKhoan_control();
					 tkctr.Suataikhoan(tk);
					 DefaultTableModel model=(DefaultTableModel)tabletaikhoan.getModel();
						model.setRowCount(0);
						Load();
					//	 Reset();
						 }
				 else
				 {
					 JOptionPane.showMessageDialog(null,"Thong bao sua khong thanh cong!");
				 }
				
				 
			}
		});
		btnSua.setBounds(473, 225, 130, 49);
		btnSua.setForeground(Color.RED);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(btnSua);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(56, 328, 664, 185);
		contentPane.add(scrollPane_1);
		
		tabletaikhoan = new JTable();
		tabletaikhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model=(DefaultTableModel)tabletaikhoan.getModel();
				int luachon=tabletaikhoan.getSelectedRow();
				txttenhienthi.setText(model.getValueAt(luachon, 0).toString());
				txtpass.setText(model.getValueAt(luachon, 1).toString());
				txtloaitk.setText(model.getValueAt(luachon, 2).toString());
				txtusername.setText(model.getValueAt(luachon, 3).toString());
				
			
				
				
			}
		});
		tabletaikhoan.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên hiển thị","Password","Loại tài khoản","Username"
			}
		));
		tabletaikhoan.getColumnModel().getColumn(0).setPreferredWidth(154);
		tabletaikhoan.getColumnModel().getColumn(1).setPreferredWidth(132);
		tabletaikhoan.getColumnModel().getColumn(2).setPreferredWidth(154);
		tabletaikhoan.getColumnModel().getColumn(3).setPreferredWidth(152);
		scrollPane_1.setViewportView(tabletaikhoan);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setColumnHeaderView(panel_1);
		
		JButton btnthoat = new JButton("THOÁT");
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnthoat.setForeground(Color.RED);
		btnthoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnthoat.setBounds(615, 524, 91, 33);
		contentPane.add(btnthoat);
		
		JButton btnresset = new JButton("RESET");
		btnresset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reset();
			}
		});
		btnresset.setForeground(Color.RED);
		btnresset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnresset.setBounds(497, 524, 91, 33);
		contentPane.add(btnresset);
		
		txttimkiem = new JTextField();
		txttimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttimkiem.setColumns(10);
		txttimkiem.setBounds(368, 288, 262, 29);
		contentPane.add(txttimkiem);
		
		JButton btntimkiem = new JButton("Tim kiem");
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)tabletaikhoan.getModel();
				model.setRowCount(0);
				Loads();
			}
			
		});
		btntimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btntimkiem.setBounds(631, 288, 89, 29);
		contentPane.add(btntimkiem);
	}
}
