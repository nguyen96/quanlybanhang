package Connection;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.RunnableScheduledFuture;

import javax.swing.JOptionPane;

public class ConnectDB {

	// String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  "databaseName=bh;integratedSecurity=True;";
	private  static Connection conn;
	// private String table="";
	 public static Connection Connect()
	 {
		 try
		 {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	         conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +  
	    	         "databaseName=quanlybhang;integratedSecurity=True;");  
	         System.out.println("thanhcong");
	       //  JOptionPane.showMessageDialog(null,"thanhcong" );
		 }catch(Exception e)
		 {
			 System.out.println("Ket noi khong thanh cong!");
			// e.printStackTrace();
		 }
		 return conn;
	 }
	
	 
//	 public void Disconnect()
//	 {
//		 try {
//		 this.conn.isClosed();
//		 }catch(Exception e)
//		 {
//			 
//		 }
//	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    //  ConnectDB kn=new ConnectDB();
    //  kn.Connect();
	}
	

}
