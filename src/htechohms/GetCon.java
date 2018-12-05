package htechohms;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCon {
	
	public  static Connection con;
	static
	 {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(DBInitializer.CON_STRING,DBInitializer.USERNAME,DBInitializer.PASSWORD);
		    } 
		catch (ClassNotFoundException e)
		     {
			
			e.printStackTrace();
		     } 
		catch (SQLException e) 
		              {
		
			           System.out.println("Exception in GetCon");
		               }
		
	  }
	public static Connection getCon(){
		                              return con;
	                                 }

	public static int  getPrimaryKey()
	 {
		
		int nextvalue=0;
		Connection con=GetCon.getCon();
		PreparedStatement ps2;
		try {
		ps2=con.prepareStatement("select IdProperty from properties");
	    ResultSet rs=ps2.executeQuery();
	   // ps2.executeUpdate();
	    rs.next();
		nextvalue=rs.getInt(1);
	         }
		      catch (SQLException e) 
		      {
			   e.printStackTrace();
		      }
	return nextvalue;

	 }

}
