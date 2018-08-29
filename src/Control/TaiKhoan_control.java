package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Connection.ConnectDB;
import Model.TaiKhoan_M;

public class TaiKhoan_control {
    private  Connection con;
    private PreparedStatement st;
    private ResultSet rs;
       
   
 
    public void Capnhattaikhoan(TaiKhoan_M tk)
    {
    	con=ConnectDB.Connect();
    	String sql="update taikhoan set tenhienthi=?, pass=? where username=?";
    	try {
    	st=con.prepareStatement(sql);
    	st.setString(1, tk.getTenhienthi());
    	st.setString(2, tk.getPass());
    	st.setString(3, tk.getUsername());
    	st.executeUpdate();
    	JOptionPane.showMessageDialog(null,"Cập nhật thanh cong");
    	}catch(SQLException e)
    	{
    		JOptionPane.showMessageDialog(null,e);
    	}
    }
    public void Themtaikhoan(TaiKhoan_M tk)
    {
    	con=ConnectDB.Connect();
    	String sql="insert taikhoan(tenhienthi,pass,loai,username) values(?,?,?,?)";
    	try {
    	st=con.prepareStatement(sql);
    	
    	st.setString(1,tk.getTenhienthi());
    	st.setString(2, tk.getPass());
    	st.setInt(3, tk.getLoai());
    	st.setString(4, tk.getUsername());
    	st.executeUpdate();
    	JOptionPane.showMessageDialog(null,"them thanh cong");
    	}catch(SQLException e)
    	{
    		JOptionPane.showMessageDialog(null,"them khong thanh cong");
    	}
    	
    }
    
    public void Xoataikhoan(TaiKhoan_M tk)
    {
    	con=ConnectDB.Connect();
    	String sql="delete taikhoan where username=?";
    	try {
    	st=con.prepareStatement(sql);
    	st.setString(1, tk.getUsername());
    	st.executeUpdate();
    	JOptionPane.showMessageDialog(null,"Xóa không thành công");
    	}catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null,"Xóa không thành công");
    	}
    }
    
    public void Suataikhoan(TaiKhoan_M tk)
    {
    	con=ConnectDB.Connect();
    	String sql="update taikhoan set tenhienthi=?, pass=?, loai=? where username=?";
    	try {
    	st=con.prepareStatement(sql);
    	
    	st.setString(1,tk.getTenhienthi());
    	st.setString(2, tk.getPass());
    	st.setInt(3, tk.getLoai());
    	st.setString(4, tk.getUsername());
    	st.executeUpdate();
    	JOptionPane.showMessageDialog(null,"sửa thanh cong");
    	}catch(SQLException e)
    	{
    		JOptionPane.showMessageDialog(null,"sửa khong thanh cong");
    	}
    }
    
      
}
