package Model;

public class KhachHang_M {
     private String makh;
     private String tenkh;
     private String gioitinh;
     private String ngaysinh;
     private String diachi;
     private int sdt;
     
     public  KhachHang_M() {
		// TODO Auto-generated constructor stub
	}
     public KhachHang_M(String makh,String tenkh,String gioitinh,String ngaysinh,String diachi,int sdt)
     {
    	 this.makh=makh;
    	 this.tenkh=tenkh;
    	 this.gioitinh=gioitinh;
    	 this.ngaysinh=ngaysinh;
    	 this.diachi=diachi;
    	 this.sdt=sdt;
     }
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
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
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
     
   
}
