package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Connection.ConnectDB;
import Model.NhanVien_M;

public class NhanVien_control {
     
	private Connection con;
	private PreparedStatement st;
	private ResultSet rs;
	public void themnv(NhanVien_M nv)
	{
		con=ConnectDB.Connect();
		String sql="insert into nhanvien(manv,tennv,gioitinh,luong,ngaysinh,ngaylv,diachi,sdt) values(?,?,?,?,?,?,?,?)";
		try {
		st=con.prepareStatement(sql);
		st.setString(1, nv.getManv());
		st.setString(2, nv.getTennv());
		st.setString(3,nv.getGioitinh());
		st.setInt(4, nv.getLuong());
		st.setString(5, nv.getNgaysinh());
		st.setString(6, nv.getNgaylv());
		st.setString(7, nv.getDiachi());
		st.setInt(8, nv.getSdt());
		
		st.executeUpdate();
	//	JOptionPane.showMessageDialog(null,"them thanh cong");
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Thêm không thành công!");
		//e.printStackTrace();
		}
	}
	
	public void Xoa(NhanVien_M nv)
	{
		con=ConnectDB.Connect();
		String sql="delete nhanvien where manv=?";
		try {
		st=con.prepareStatement(sql);
		st.setString(1, nv.getManv());
		st.executeUpdate();
		 JOptionPane.showMessageDialog(null,"Xóa thành công!");
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Xóa không thành công!");
		}
	}
	
	public void Sua(NhanVien_M nv)
	{
		con=ConnectDB.Connect();
		String sql="update nhanvien set tennv=?, gioitinh=?, luong=?, ngaysinh=?, ngaylv=?, diachi=?, sdt=? where manv=?";
	
		try {
			st=con.prepareStatement(sql);
			
			st.setString(1, nv.getTennv());
			st.setString(2,nv.getGioitinh());
			st.setInt(3, nv.getLuong());
			st.setString(4, nv.getNgaysinh());
			st.setString(5, nv.getNgaylv());
			st.setString(6, nv.getDiachi());
			st.setInt(7, nv.getSdt());
			st.setString(8, nv.getManv());
			
			st.executeUpdate();
			JOptionPane.showMessageDialog(null,"Sửa thành công");
			}catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null,"Sửa không thành công");
			//e.printStackTrace();
			}
	}
}
