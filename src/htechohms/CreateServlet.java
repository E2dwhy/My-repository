package htechohms;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
import htechohms.InsertProperty;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 res.setContentType("text/html");  
	        PrintWriter out = res.getWriter(); 
	        //String connectionURL = "jdbc:mysql://127.0.0.1:3306/newData";// newData is the database  
	        //Connection connection;  
	        //Connection conn=null;
	        //String url="jdbc:mysql://localhost:3306/htech";
	        //String dbName="htech";
	        //String driver="com.mysql.jdbc.Driver";
	    //String dbUserName="root";
	    //String dbPassword="root";
	        
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
			//String pic=req.getParameter("photos");
			
			out.println("<html>" + "<body>" + req.getParameter("Ownername") + "<br/>" + req.getParameter("PropertyName") + "<br/>" + req.getParameter("PropertyType") + "<br/>" + req.getParameter("BHK") + "<br/>" + req.getParameter("Bathrooms") + "<br/>" + req.getParameter("Location") + "<br/>" + req.getParameter("ExpectedRent") + "<br/>" + req.getParameter("ExpectedDeposit") + "<br/>" + req.getParameter("AvailableFrom") + "<br/>" + "<br/>");
		    int status=InsertProperty.insert(owname, pname, ptype, BHK, Bathrooms, locat, ExpectedRent, ExpectedDeposit, avail);			
		    if(status!=0){
				out.print("DONE! NEW PROPERTY HAS BEEN ADDDED");
				RequestDispatcher rd=req.getRequestDispatcher("Admin.html");
				rd.include(req, res);
			            }
			else{
				out.print("Sorry,Insertion failed. please try later");
				//RequestDispatcher rd=request.getRequestDispatcher("index.html");
				//rd.include(request, response);
			}
		out.close();	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   
	 }
	}
