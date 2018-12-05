package htechohms;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
//		if(req.getParameter("un").equals("admin")&& req.getParameter("pw").equals("htech")){
//			res.sendRedirect("/Online_Housing_Management_System/WebContent/Admin");
//			}
//		out.print("<html>"+ "<body bgcolor= green>"+ "<h1> Login to the application Failed </h1>" + "</body>"+ "</html>");
//		}
		final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
		final String  DB_URL= "jdbc:mysql://localhost:3306/htech";
		final String USER= "root";
		final String PASS= "hopefor2015";
		String userid= req.getParameter("un");
		String  pass = req.getParameter("pw");
		Statement stmt= null;
		Connection conn= null;
		
		try{
			Class.forName(JDBC_DRIVER);
			conn= DriverManager.getConnection(DB_URL, USER,PASS);
		stmt= conn.createStatement();
		ResultSet rs;
		rs= stmt.executeQuery("select UserName from login where UserName='" + userid + "' and PassWord='" + pass + "'");
		if(rs.next())
		{
		    String n=rs.getString("UserName");
		    out.println(n);
		    ServletContext context=getServletContext();
		    RequestDispatcher rd=context.getRequestDispatcher("/Admin.html");
		    rd.forward(req, res);
			//pass= rs.getString("password");
			
		}
		else
		{
			out.print("Wrong Name or Password");
		}
		//if(req.getParameter("pw").equals(pass))
		//{
			//res.sendRedirect("/Online_Housing_Management_System/");
			//RequestDispatcher rd = req.getRequestDispatcher("Admin.html");
			//rd.forward(req, res);
		//}
		//out.print("<html>"+ "<body bgcolor= green>"+ "<h1> Login to the application failed </h1>" + "</body>"+ "</html>");
		}
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		                      } 
		catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		                  } 
		 finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		         }
		      catch(SQLException se){
		                            }
		      // do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		         }
		      catch(SQLException se){
		         se.printStackTrace();
		                            }
		      //end finally try
	  }
		 //end try
		   System.out.println("Goodbye!");
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
