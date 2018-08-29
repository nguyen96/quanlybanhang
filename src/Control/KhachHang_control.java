package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Connection.ConnectDB;
import Model.KhachHang_M;
import Model.LoaiHang_M;

public class KhachHang_control {
      private Connection con;
      private PreparedStatement st;
      private ResultSet rs;
      
      public void Themkh(KhachHang_M kh)
      {
    	  con=ConnectDB.Connect();
    	  String sql="insert into khachhang(makh,tenkh,gioitinh,ngaysinh,diachi,sdt) values(?,?,?,?,?,?)";
    	  try {
    	  st=con.prepareStatement(sql);
    	  st.setString(1, kh.getMakh());
    	  st.setString(2, kh.getTenkh());
    	  st.setString(3,kh.getGioitinh());
    	  st.setString(4,kh.getNgaysinh());
    	  st.setString(5, kh.getDiachi());
    	  st.setInt(6,kh.getSdt());
    	  st.executeUpdate();
    			  JOptionPane.showMessageDialog(null,"Thêm khách hàng thành công!");
    	  }catch(SQLException e)
    	  {
    		  JOptionPane.showMessageDialog(null,e);
    	  }
      }
      public void Xoakh(KhachHang_M lh)
  	{
  		con=ConnectDB.Connect();
  		String sql="delete from khachhang where makh=?";
  		try {
  		st=con.prepareStatement(sql);
  		
  		
  		st.setString(1,lh.getMakh());
  		st.executeUpdate();
  		JOptionPane.showMessageDialog(null,"Xóa thành công");
  		
  		}catch(SQLException e)
  		{
  			JOptionPane.showMessageDialog(null,"Xóa loại hàng không thành công");
  			//JOptionPane.showMessageDialog(null,e);
  		}
  	}
      public void Suakh(KhachHang_M lh)
  	{
  		con=ConnectDB.Connect();
  		String sql="update khachhang set tenkh=?, gioitinh=?, ngaysinh=?, diachi=?, sdt=? where makh=?";
  		try {
  		st=con.prepareStatement(sql);
  		  st.setString(1,lh.getTenkh());
            st.setString(2,lh.getGioitinh());
            st.setString(3,lh.getNgaysinh());
            st.setString(4,lh.getDiachi());
            st.setInt(5,lh.getSdt());
            st.setString(6,lh.getMakh());
            
  		st.executeUpdate();
  		JOptionPane.showMessageDialog(null,"Sửa thành công");
  		
  		}catch(SQLException e)
  		{
  			JOptionPane.showMessageDialog(null,"Xóa loại hàng không thành công");
  			//JOptionPane.showMessageDialog(null,e);
  		}
  	}
}
