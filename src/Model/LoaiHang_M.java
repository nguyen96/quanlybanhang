package Model;

public class LoaiHang_M {
   private String malh;
   private String tenlh;
   
   public LoaiHang_M()
   {}
   public LoaiHang_M(String tenlh)
   {
	   this.tenlh=tenlh;
   }
   public String getMalh() {
	return malh;
    }
public void setMalh(String malh) {
	this.malh = malh;
}
public String getTenlh() {
	return tenlh;
}
public void setTenlh(String tenlh) {
	this.tenlh = tenlh;
}

  public LoaiHang_M(String malh,String tenlh)
  {
	  this.malh=malh;
	  this.tenlh=tenlh;
  }

   
}
