package Model;

import java.sql.Date;

public class NhanVien_M {

	private String manv;
	private String tennv;
	private String gioitinh;
	private String ngaysinh;
	private String ngaylv;
	private String diachi;
	private int luong;
	private int sdt;
	
   public NhanVien_M()
   {
	   
   }
	
	public int getSdt() {
		return sdt;
	}



	public void setSdt(int sdt) {
		this.sdt = sdt;
	}



	public NhanVien_M(String manv ,String tennv,String gioitinh,int luong,String ngaysinh,String ngaylv,String diachi,int sdt)
	{
		this.manv=manv;
		this.tennv=tennv;
		this.gioitinh=gioitinh;
		this.ngaysinh=ngaysinh;
		this.ngaylv=ngaylv;
		this.diachi=diachi;
		this.sdt=sdt;
		this.luong=luong;
		
	}



	public String getManv() {
		return manv;
	}



	public void setManv(String manv) {
		this.manv = manv;
	}



	public String getTennv() {
		return tennv;
	}



	public void setTennv(String tennv) {
		this.tennv = tennv;
	}



	public String getGioitinh() {
		return gioitinh;
	}



	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}



	public String getNgaysinh() {
		return ngaysinh;
	}



	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}



	public String getNgaylv() {
		return ngaylv;
	}



	public void setNgaylv(String ngaylv) {
		this.ngaylv = ngaylv;
	}



	public String getDiachi() {
		return diachi;
	}



	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}



	public int getLuong() {
		return luong;
	}



	public void setLuong(int luong) {
		this.luong = luong;
	}
	
	


	
}
