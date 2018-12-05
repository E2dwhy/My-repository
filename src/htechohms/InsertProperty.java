package htechohms;

import java.sql.*;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import htechohms.GetCon;

public class InsertProperty
{
	static int status=1;

public static int insert(String owname, String pname, String ptype, int BHK, int Bathrooms, String locat, double ExpectedRent, double ExpectedDeposit, String avail/*, String pic*/)
{
	 Connection con=null;
	 con = GetCon.getCon();
	 PreparedStatement statement=null;
     //String url="jdbc:mysql://localhost:3306/htech";
     //String dbName="htech";
     //String driver="com.mysql.jdbc.Driver";
     //String dbUserName="root";
     //String dbPassword="root";
    try{

        Class.forName("com.mysql.jdbc.Driver");//.newInstance();  
        //conn = DriverManager.getConnection(url+dbName,"root", "hopefor2015");
        //String sql="insert into properties(OwnerName,PropertyName,PropertyType,BHK,Bathrooms,Location,ExpectedRent, ExpectedDeposit, AvailableFrom) values(?,?,?,?,?,?,?,?,?)";
        //ResultSet rs=statement.executeQuery(sql);
        statement=con.prepareStatement("insert into properties(OwnerName,PropertyName,PropertyType,BHK,Bathrooms,Location,ExpectedRent, ExpectedDeposit, AvailableFrom) values(?,?,?,?,?,?,?,?,?)");//try2 is the name of the table  
        statement.execute("insert into properties values (?,?,?,?,?,?,?,?,?,?)");
        statement.setString(1, owname);
    	statement.setString(2, pname);
    	statement.setString(3, ptype);
    	statement.setInt(4, BHK);
    	statement.setInt(5, Bathrooms);
    	statement.setString(6, locat);
    	statement.setDouble(7, ExpectedRent);
    	statement.setDouble(8, ExpectedDeposit);
    	statement.setString(9, avail);
    	//status=statement.executeUpdate(sql);
    	//statement.setString(10, pic);
        //int i=Integer.parseInt(BHK);
    	status=statement.executeUpdate();
    	statement.close();
    }
    catch (SQLException e)
    {
	
	   e.printStackTrace();
     }
    catch(Exception e)
    {
        //Handle errors for Class.forName
        e.printStackTrace();
    }
     System.out.println("Goodbye!");
  //end main
    return  status;
   	
    }
}
