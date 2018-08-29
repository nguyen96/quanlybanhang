package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Connection.ConnectDB;
import Model.LoaiHang_M;

public class LoaiHang_control {
     
	private Connection con;
	private PreparedStatement st;
	private ResultSet rs;
	
	public void Themlh(LoaiHang_M lh)
	{
		con=ConnectDB.Connect();
		String sql="insert loaihang(malh,tenlh) values(?,?)";
		try {
		st=con.prepareStatement(sql);
		st.setString(1,lh.getMalh());
		st.setString(2,lh.getTenlh());
		st.executeUpdate();
		JOptionPane.showMessageDialog(null,"Thêm thành công");
		
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Thêm loại hàng không thành công");
		//JOptionPane.showMessageDialog(null,e);
		}
	}
	
	public void Xoalh(LoaiHang_M lh)
	{
		con=ConnectDB.Connect();
		String sql="delete from loaihang where malh=?";
		try {
		st=con.prepareStatement(sql);
		
		
		st.setString(1,lh.getMalh());
		st.executeUpdate();
		JOptionPane.showMessageDialog(null,"Xóa thành công");
		
		}catch(SQLException e)
		{
		//	JOptionPane.showMessageDialog(null,"Xóa loại hàng không thành công");
			JOptionPane.showMessageDialog(null,e);
		}
	}
	
	public void Sua(LoaiHang_M lh)
	{
		con=ConnectDB.Connect();
		String sql="update loaihang set tenlh=? where malh=?";
		try {
		st=con.prepareStatement(sql);
		  st.setString(1,lh.getTenlh());
          st.setString(2,lh.getMalh());
		st.executeUpdate();
		JOptionPane.showMessageDialog(null,"Sửa thành công");
		
		}catch(SQLException e)
		{
		//	JOptionPane.showMessageDialog(null,"Xóa loại hàng không thành công");
			JOptionPane.showMessageDialog(null,e);
		}
	}
}

