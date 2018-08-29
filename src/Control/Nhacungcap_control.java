package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Connection.ConnectDB;
import Model.NhaCungCap_M;

public class Nhacungcap_control {

	 private Connection con;
	 private PreparedStatement st;
	 private ResultSet rs;
	 
	 public void Themncc(NhaCungCap_M ncc)
	 {
		 con=ConnectDB.Connect();
		 String sql="insert nhacungcap(mancc,tenncc,diachi,email,sdt) values(?,?,?,?,?)";
		 try {
			 st=con.prepareStatement(sql);
			 st.setString(1,ncc.getMancc());
			 st.setString(2,ncc.getTenncc());
			 st.setString(3, ncc.getDiachi());
			 st.setString(4, ncc.getEmail());
			 st.setInt(5, ncc.getSdt());
			 st.executeUpdate();
			 JOptionPane.showMessageDialog(null,"Thêm thành công!");
		 }catch(SQLException e)
		 {
			 JOptionPane.showMessageDialog(null,"Thêm không thành công");
		 }
	 }
	 
	 public void Xoancc(NhaCungCap_M ncc)
	 {
		 con=ConnectDB.Connect();
		
		 String sql="delete nhacungcap where mancc=?";
		 try {
			 st=con.prepareStatement(sql);
			// st.setString(1,ncc.getTenncc());
			st.setString(1,ncc.getMancc());
			 st.executeUpdate();
			 JOptionPane.showMessageDialog(null,"Xóa thành công!");
		 }catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"Xóa không thành công!");
		}
	 }
	 
	 public void Suancc(NhaCungCap_M ncc)
	 {
		 con=ConnectDB.Connect();
		 String sql="update nhacungcap set tenncc=?, diachi=?, email=?, sdt=? where mancc=?";
		 try {
			 st=con.prepareStatement(sql);
			 st.setString(1, ncc.getTenncc());
			 st.setString(2, ncc.getDiachi());
			 st.setString(3, ncc.getEmail());
			 st.setInt(4, ncc.getSdt());
			 st.setString(5, ncc.getMancc());
			 st.executeUpdate();
			 JOptionPane.showMessageDialog(null,"Sửa thành công!");
		 }catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"Sửa không thành công!");
		}
	 }
}
