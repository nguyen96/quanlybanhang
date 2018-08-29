package Model;

public class NhaCungCap_M {
    private String mancc;
    private String tenncc;
  
    private String diachi;
    private String email;
    private int sdt;
    public NhaCungCap_M()
    {
    	
    }
    public NhaCungCap_M(String mancc,String tenncc,String diachi,String email,int sdt)
    {
    	this.mancc=mancc;
    	this.tenncc=tenncc;
    	this.diachi=diachi;
    	this.email=email;
    	this.sdt=sdt;
    	
    }
	public String getMancc() {
		return mancc;
	}
	public void setMancc(String mancc) {
		this.mancc = mancc;
	}
	public String getTenncc() {
		return tenncc;
	}
	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
