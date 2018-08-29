package Model;

public class TaiKhoan_M {
     private String tenhienthi;
 	private String pass;
    private int loai;
    private String username;
    public TaiKhoan_M() {
		
	}
    public TaiKhoan_M(String username,String pass)
    {
    	this.username=username;
    	this.pass=pass;
    }
     public String getTenhienthi() {
		return tenhienthi;
	}
	public void setTenhienthi(String tenhienthi) {
		this.tenhienthi = tenhienthi;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getLoai() {
		return loai;
	}
	public void setLoai(int loai) {
		this.loai = loai;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    public TaiKhoan_M(String tenhienthi,String pass,int loai,String username)
    {
    	this.tenhienthi=tenhienthi;
    	this.pass=pass;
    	this.loai=loai;
    	this.username=username;
    	
    }
    
}
