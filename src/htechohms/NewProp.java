package htechohms;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Homeservlet
 */
public class NewProp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public NewProp(){
	     super();
	        // TODO Auto-generated constructor stub
	}
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String owname=req.getParameter("OwnerName");
		String pname=req.getParameter("PropertyName");
		String ptype=req.getParameter("PropertyType");
		String bhk=req.getParameter("BHK");
		String bath=req.getParameter("Bathrooms");
		String locat=req.getParameter("Location");
		String rent=req.getParameter("ExpectedRent");
		String depo=req.getParameter("ExpectedDeposit");
		String avail=req.getParameter("AvailableFrom");
		try{
			InitialContext context= new InitialContext();
			DataSource ds=(DataSource) context.lookup("java/env/jdbc/jndiname");
			java.sql.Connection conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement("insert into properties values(?,?)");
			statement.setString(1, owname);
			statement.setString(2, pname);
			statement.setString(3, ptype);
			statement.setString(4, bhk);
			statement.setString(5, bath);
			statement.setString(6, locat);
			statement.setString(7, rent);
			statement.setString(8, depo);
			statement.setString(9, avail);
			statement.executeUpdate();
			conn.close();
			statement.close();
		}catch(Exception e){
		}
	}

}
