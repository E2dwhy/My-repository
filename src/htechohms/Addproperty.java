package htechohms;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addproperty
 */
public class Addproperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addproperty() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

        res.setContentType("text/html");  
        PrintWriter pw = res.getWriter(); 
        //String connectionURL = "jdbc:mysql://127.0.0.1:3306/newData";// newData is the database  
        //Connection connection;  
        Connection conn=null;
        String url="jdbc:mysql://localhost:3306/htech";
        String dbName="htech";
        String driver="com.mysql.jdbc.Driver";
    //String dbUserName="root";
    //String dbPassword="root";

    try{  
    	String owname=req.getParameter("OwnerName");
		String pname=req.getParameter("PropertyName");
		String ptype=req.getParameter("PropertyType");
		String bhk=req.getParameter("BHK");
		int BHK=Integer.parseInt("bhk");
		String bath=req.getParameter("Bathrooms");
		int Bathrooms=Integer.parseInt("bath");
		String locat=req.getParameter("Location");
		String rent=req.getParameter("ExpectedRent");
		double ExpectedRent=Double.parseDouble("rent");
		String depo=req.getParameter("ExpectedDeposit");
		double ExpectedDeposit=Double.parseDouble("depo");
		String avail=req.getParameter("AvailableFrom");
		

      Class.forName(driver).newInstance();  
      conn = DriverManager.getConnection(url+dbName,"root", "hopefor2015");
      PreparedStatement statement =(PreparedStatement) conn.prepareStatement("insert into properties(OwnerName,PropertyName,PropertyType,BHK,Bathrooms,Location,ExpectedRent, ExpectedDeposit, AvailableFrom) values(?,?,?,?,?,?,?,?,?)");//try2 is the name of the table  
    statement.setString(1, owname);
  	statement.setString(2, pname);
  	statement.setString(3, ptype);
  	statement.setInt(4, BHK);
  	statement.setInt(5, Bathrooms);
  	statement.setString(6, locat);
  	statement.setDouble(7, ExpectedRent);
  	statement.setDouble(8, ExpectedDeposit);
  	statement.setString(9, avail);
  	

      int i = statement.executeUpdate();
      String msg=" ";
      if(i!=0){  
        msg="Record has been inserted";
        pw.println("<font size='6' color=blue>" + msg + "</font>");  


      }  
      else{  
        msg="failed to insert the data";
        pw.println("<font size='6' color=blue>" + msg + "</font>");
       }  
      statement.close();
    }  
    catch (Exception e){  
      pw.println(e);  
    }  

 }

}
