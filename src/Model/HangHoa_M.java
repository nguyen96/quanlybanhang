package Model;

public class HangHoa_M {
    private String mahh;
    private String tenhh;
    private String malh;
    private int sl;
    private String mancc;
    private int giaban;
    private String donvitinh;
    
   
	public String getDonvitinh() {
		return donvitinh;
	}
	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}
	public HangHoa_M()
    {
    	
    }
    public HangHoa_M(String mahh,String tenhh,String malh,int sl,String donvitinh,String mancc,int giaban)
    {
    	this.mahh=mahh;
    	this.tenhh=tenhh;
    	this.malh=malh;
    	this.sl=sl;
    	this.mancc=mancc;
    	this.giaban=giaban;
    	this.donvitinh=donvitinh;
    }
	public String getMahh() {
		return mahh;
	}
	public void setMahh(String mahh) {
		this.mahh = mahh;
	}
	public String getTenhh() {
		return tenhh;
	}
	public void setTenhh(String tenhh) {
		this.tenhh = tenhh;
	}
	public String getMalh() {
		return malh;
	}
	public void setMalh(String malh) {
		this.malh = malh;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public String getMancc() {
		return mancc;
	}
	public void setMancc(String mancc) {
		this.mancc = mancc;
	}
	public int getGiaban() {
		return giaban;
	}
	public void setGiaban(int giaban) {
		this.giaban = giaban;
	}
    
}
