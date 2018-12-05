package htechohms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retrieveprop {
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/htech";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "hopefor2015";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();

	      String sql = "SELECT idProperties, OwnerName, PropertyName, PropertyType, BHK, Bathrooms, Location, ExpectedRent, ExpectedDeposit, AvailableFrom FROM properties";
	      ResultSet rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("idProperties");      
	         String oname = rs.getString("OwnerName");
	         String pname = rs.getString("PropertyName");
	         String ptype = rs.getString("PropertyType");
	         int bhk = rs.getInt("BHK");
	         int bathrooms = rs.getInt("Bathrooms");
	         String loc = rs.getString("Location");
	         double rent = rs.getDouble("ExpectedRent");
	         double depo = rs.getDouble("ExpectedDeposit");
	         String avail = rs.getString("AvailableFrom");
	         

	         //Display values
	         System.out.println("IdProperties: " + id);
	         System.out.println(", OwnerName: " + oname);
	         System.out.println(", PropertyName: " + pname);
	         System.out.println(", PropertyType: " + ptype);
	         System.out.println(", BHK: " + bhk);
	         System.out.println(", Bathrooms: " + bathrooms);
	         System.out.println(", Location: " + loc);
	         System.out.println(", ExpectedRent: " + rent);
	         System.out.println(", ExpectedDeposit: " + depo);
	         System.out.println(", AvailableFrom: " + avail);
	      }
	      rs.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main

}
