package Frm;


import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.ConnectDB;
import Control.TaiKhoan_control;
import Model.TaiKhoan_M;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DangNhap extends JFrame {
	private JTextField txtusername;
	private JTextField txtpassword;
	
	  private  Connection con;
	    private PreparedStatement st;
	    private ResultSet rs;

//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				DangNhap frame = new DangNhap();
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
	
	public DangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,353);
		setLocation(400, 180);
	    getContentPane().setLayout(null);
	    setTitle("Đăng nhập");
	    
	    JLabel lblUsername = new JLabel("Username");
	    lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblUsername.setBounds(96, 94, 105, 30);
	    getContentPane().add(lblUsername);
	    
	  
	    
	    JLabel lblPassword = new JLabel("Password");
	    lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblPassword.setBounds(96, 163, 105, 30);
	    getContentPane().add(lblPassword);
	    
	    txtusername = new JTextField();
	    txtusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txtusername.setBounds(223, 97, 227, 30);
	    getContentPane().add(txtusername);
	    txtusername.setColumns(10);
	    
	    txtpassword = new JTextField();
	    txtpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txtpassword.setBounds(223, 166, 227, 30);
	    getContentPane().add(txtpassword);
	    txtpassword.setColumns(10);
	    
	    JLabel lblDangnhap = new JLabel("ĐĂNG NHẬP");
        lblDangnhap.setForeground(Color.BLUE);
        lblDangnhap.setFont(new Font("Tohama", Font.PLAIN, 22));
	    lblDangnhap.setBounds(238, 24, 150, 30);
	    getContentPane().add(lblDangnhap);
	    
	    JButton btnDangnhap = new JButton("ĐĂNG NHẬP");
	    btnDangnhap.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		TaiKhoan_M tk=new TaiKhoan_M();
	    	       
				if (txtusername.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Username không được bỏ trống!");
				}
				if(txtpassword.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Password không được bỏ trống!");
				}
				else {
                 String user=txtusername.getText();
                 String passw=txtpassword.getText();

				con=ConnectDB.Connect();
		    	String sql="select *from taikhoan where username=? and pass=?";
		    	try {
		    	st=con.prepareStatement(sql);
		    	st.setString(1, user);
		    	st.setString(2, passw);
		    	rs=st.executeQuery();
		    	
		    	  if(rs.next())
		    	  {
		    		
		    		  JOptionPane.showMessageDialog(null,"Đăng nhập thành công");
		    		  Trangchu tc=new Trangchu();
		    		  tc.setVisible(true);
		    	  }
		    	  else
		    	  {
		    		  JOptionPane.showMessageDialog(null,"Đăng nhập không thành công");
		    	  }
		    	}catch(SQLException e)
		    	{
		    		
		    	}
		    	}
	    	
	    	}
	    });
	    btnDangnhap.setForeground(new Color(0, 0, 128));
	    btnDangnhap.setBackground(SystemColor.activeCaption);
	    btnDangnhap.setFont(new Font("Tohama", Font.PLAIN, 18));
	    btnDangnhap.setBounds(392, 233, 161, 49);
	    getContentPane().add(btnDangnhap);
	    
	    JButton btnHuy = new JButton("RESET");
	    btnHuy.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		txtpassword.setText("");
	    		txtusername.setText("");
	    	}
	    });
	    btnHuy.setForeground(new Color(0, 0, 128));
	    btnHuy.setBackground(SystemColor.activeCaption);
	    btnHuy.setFont(new Font("Tohama", Font.PLAIN, 18));
	    btnHuy.setBounds(238, 233, 146, 49);
	    getContentPane().add(btnHuy);
	    
	   
	
	}
}

