package htechohms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Takeapp {
	static int status=1;

public static int take(String name, String purpose/*,String date,String time*/)
{
	//public static int register(String email,String password,String gender,String country,String name)

	   Connection 	con=null;
		  con = GetCon.getCon();
	   //Statement stmt=null;
		  //PreparedStatement ps=null;
		 
		  
	try {
		 Class.forName("com.mysql.jdbc.Driver");
		 PreparedStatement ps =  con.prepareStatement("insert into appointments(ClientName, Purpose, Date, Time) values(?,?,?,?)");
		//int nextvalue1=GetCon.getPrimaryKey();
		//ps.setInt(1, nextvalue1);
		
		ps.setString(1,name);
		ps.setString(2,purpose);
		//ps.setString(3,date);
		//ps.setString(4,time);
		status=ps.executeUpdate();
	     }
	      catch (SQLException se)
	      {
		
		   se.printStackTrace();
	       }
	      catch(Exception se)
	      {
	          //Handle errors for Class.forName
	          se.printStackTrace();
	      }
	       System.out.println("Goodbye!");
	    //end main
	    return  status;
	}
 }
