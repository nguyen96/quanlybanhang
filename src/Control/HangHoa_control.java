package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Connection.ConnectDB;
import Model.HangHoa_M;
import Model.KhachHang_M;

public class HangHoa_control {

	 private Connection con;
     private PreparedStatement st;
     private ResultSet rs;
     
     public void Themhh(HangHoa_M kh)
     {
   	  con=ConnectDB.Connect();
   	  String sql="insert into hanghoa(mahh,tenhh,malh,sl,donvitinh,mancc,giaban) values(?,?,?,?,?,?,?)";
   	  try {
   	  st=con.prepareStatement(sql);
   	  st.setString(1, kh.getMahh());
   	  st.setString(2, kh.getTenhh());
   	  st.setString(3,kh.getMalh());
   	  st.setInt(4,kh.getSl());
   	  st.setString(5, kh.getDonvitinh());
   	  st.setString(6,kh.getMancc());
   	  st.setInt(7,kh.getGiaban());
   	  st.executeUpdate();
   			  JOptionPane.showMessageDialog(null,"Thêm hàng thành công!");
   	  }catch(SQLException e)
   	  {
   		 JOptionPane.showMessageDialog(null,"Thêm hàng không thành công!");
   	//  JOptionPane.showMessageDialog(null,e);
   		//  e.printStackTrace();
   	  }
     }
     public void Xoahh(HangHoa_M hh)
     {
    	 con=ConnectDB.Connect();
    	 String sql="delete from hanghoa where mahh=?";
    	 try {
    	 st=con.prepareStatement(sql);
    	 st.setString(1,hh.getMahh());
    	 st.executeUpdate();
    	 JOptionPane.showMessageDialog(null,"Xóa thành công!");
    	 }catch(Exception e)
    	 {
    		 JOptionPane.showMessageDialog(null,"Xóa không thành công!");
    	 }
     }
     
     public void Suahanghoa(HangHoa_M hh)
     {
    	 con=ConnectDB.Connect();
    	 String sql="update hanghoa set tenhh=?, malh=?, sl=?, donvitinh=? ,mancc=?, giaban=? where mahh=?";
    	 try {
    	 st=con.prepareStatement(sql);
    	 st.setString(1, hh.getTenhh());
    	 st.setString(2, hh.getMalh());
    	 st.setInt(3, hh.getSl());
    	 st.setString(4, hh.getDonvitinh());
    	 st.setString(5, hh.getMancc());
    	 st.setInt(6, hh.getGiaban());
    	 st.setString(7,hh.getMahh());
    	 st.executeUpdate();
    	 JOptionPane.showMessageDialog(null,"Sửa thành công!");
    	 }catch(Exception e)
    	 {
    		 JOptionPane.showMessageDialog(null,"Sửa không thành công!");
    	 }
     }
}
