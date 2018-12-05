package htechohms;

import java.io.IOException;
import htechohms.Takeapp;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TakeAppointment
 */
public class TakeAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("ClientName");
		String purpose=request.getParameter("Purpose");
		//String date=request.getParameter("Date");
		//String time=request.getParameter("Time");
		
		//double mname=Double.parseDouble(num);
		//String country=request.getParameter("country");
		out.println("<html>" + "<body>" +   request.getParameter("ClientName")  +"<br/>" +request.getParameter("Purpose") + "<br/>" + request.getParameter("Date") +"<br/>" + request.getParameter("Time") +  "</body>" +"</html>");
	    int status=Takeapp.take(name,purpose/*,date,time*/);
		if(status!=0){
			out.print("DONE! YOUR APPOINTMENT HAS BEEN SAVED");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		            }
		else{
			out.print("Sorry,Registration for Appointment failed. please try later");
			RequestDispatcher rd=request.getRequestDispatcher("Appointments.html");
			rd.include(request, response);
		}
	out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
