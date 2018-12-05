<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
@CHARSET "ISO-8859-1";
body{margin:0;}
#wrapper{margin:0 auto; padding:10px; backgroung-color:black; position: relative;}
.header{width:100%; height:auto;}
.headerpart{width:1024px; margin:0 auto;}
.headerpart a img{width:1024px; margin:0 auto; display:bolck; background-image:url("D:\prog\Android Kit\Android Workspace\Online_Housing_Management_System\WebContent\images\Banner1.jpg" alt="Banner1" title="Banner1");}
.nav{margin:0 auto; width:1080px;}
.nav ul{padding: 0;}
.nav ul li{float:left; marging:2px; position:relative; background-color:#3399CC; border-radius:5px; list-style-type:none;}
.nav ul li a{text-decoration:none; color:white; padding:8px; display:block; font-weight:bolder; width:200px; text-align:center;  }
.nav ul li ul{position:absolute; visibility:hidden;}
.nav ul li:hover ul{visibility:visible;}
.nav ul li a:hover{color:blue;}
.nav ul li:hover{background-color:white;}
body{background:#3399CC;}
body{background-image:url("1.jpg"); background-repeat:no-repeat;}


#header
{
margin:0 auto;
background:#000 url(images/globe_03.gif) 0 0 no-repeat;
width:897px;
height:282px;
background-image:url("Banner1.jpg");background-repeat:no-repeat;
}
#header h1
{
font:bold 44px/18px Arial, Helvetica, sans-serif;
color:#FFFFFF;
padding:100px 0 0 380px;
}
#header h2
{
font:bold italic 24px/18px Arial, Helvetica, sans-serif;
color:#FFFFFF;
padding:20px 0 0 380px;
}

#content1
{
width:897px; 
margin:0 auto; 
}
#content1 h1
{
font:bold italic 22px/79px Arial, Helvetica, sans-serif;
color:#FFFFFF;
padding-left:30px;
}
#content1 p
{
font:normal 12px/18px Arial, Helvetica, sans-serif;
color:#FFFFFF;
padding:5px 15px 0 15px;
}
.con
{
background:#3399CC 0 0 repeat-y;
width:290px;
}
#heade1
{
width:167px;
height:79px;
padding-left:90px;
}
#heade2
{
width:167px;
height:79px;
padding-left:90px;
}
#heade3
{
width:167px;
height:79px;
padding-left:90px;
}

#welcome
{
width:287px;
padding:10px;

}
#welcome h1
{
font:bold italic 20px/25px Arial, Helvetica, sans-serif;
color:#333333;
}
#welcome p
{
font:normal 12px/18px Arial, Helvetica, sans-serif;
color:#7f7f7f;
}

#footer_navigation
{
width:500px;
height:30px;
margin:0 auto;
}
#footer_navigation ul li
{
width:80px;
font: normal 12px/30px Arial, Helvetica, sans-serif;
color:#7d9942;
float:left;
}
#footer_navigation ul li a
{
text-decoration:none;
color:#7f7f7f;
height:30px;
}
#footer_navigation ul li a:hover
{
text-decoration:none;
color:#ffffff;
height:49px;
}
#footer_copyright
{
color: #FFFFFF;
font: normal 11px/30px Arial, Helvetica, sans-serif;
margin:0 auto;
text-align:center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointments List</title>
</head>


<body>   
 <div class="header" >
      <div class="headerpart">
      <a href="#">
      <img src="banner OHMS home.jpg"/>
      </a>
      </div>
      </div>
      <div class="nav">
      <ul>
      <li><a href="index.html"> Home</a></li>
      <li><a href=""> Properties</a>
          <ul>
              <li><a href="AddNewProp.html" >Add</a></li>
          </ul>
      </li>
      <li><a href="Appointments.html"> Appointments</a></li>
      <li><a href="Finance.jsp">Finance</a></li>
      <li><a href="index.html" > Logout</a></li>
      </ul>
      </div>
      <div id="main">
      <a href="1.jpg"></a>
      </div>
      <div id="wrapper">     
      </div>
      <div id="main">
      <a href="1.jpg"></a>
      </div><br><br>
      <br>
      <br>
      <br>
      
            
<table style="width:897px; background:#FFFFFF; margin:0 auto;">
<tr align="justify">
	<td width="299" valign="top" style="border-right:#666666 1px dotted;">

<% 
%>   	
<table><%

final String DB_URL="jdbc:mysql://localhost:3306/htech";
final String JDBC_DRIVER="com.mysql.jdbc.Driver";
String USER="root";
String PASS="hopefor2015";
Connection conn=null;
Statement statement=null;

/*String num = request.getParameter("idpropeties");*/
/*int idproperties = Integer.parseInt(num);*/
		try {
			 conn= DriverManager.getConnection(DB_URL, USER,PASS);
			 Class.forName(JDBC_DRIVER);
			 statement = conn.createStatement();
			 
			//PreparedStatement statement=conn.prepareStatement("Select * from porperties");
            //statement.setInt(1,idproperties);
            
            String sql = "SELECT idAppointments, ClientName, Purpose, Date, Time FROM appointments";
			ResultSet rs=statement.executeQuery(sql);
			
			out.print("<table align='left' cellspacing='1' cellpadding='1' border='5' bgcolor='#3399CC'>");
			out.print("<tr><th>IdAppointments</th><th>ClientName</th><th>Purpose</th><th>Date</th><th>Time</th><tr>");
			while(rs.next()){
			    //int idproperties1=rs.getInt(1);
				//session.setAttribute("idproperties",idproperties1);
				 int id  = rs.getInt("idAppointments");      
		         String name = rs.getString("ClientName");
		         String purpose = rs.getString("Purpose");
		         String date = rs.getString("Date");
		         String time = rs.getString("Time");
				
				//System.out.print(idproperties);
				
				out.print("<tr>");
				out.print("<td>" + id + "</td>");
				out.print("<td>" + name + "</td>");
				out.print("<td>" + purpose + "</td>");
				out.print("<td>" + date + "</td>");
				out.print("<td>" + time + "</td>");
				out.print("</tr>");
			
			}
	      rs.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception se){
	      //Handle errors for Class.forName
	      se.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(statement!=null)
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
			out.print("</table>");
			
		
			%></table><%
%>
   </td>
   </tr>
   </table>
   <table style="width:897px; background:#FFFFFF; margin:0 auto;">
    <tr align="justify">
    <td width="299" valign="top" style="border-right:#666666 1px dotted;">
    	<div id="welcome" style="border-right:#666666 1px dotted;"><h1>Welcome Admin</h1><br>
    	    <center><img src="Htech logo.jpg" alt="Logo" width="196" height="106"></center><br>
		    <p> The Online Housing Management System brings houses to you<br>
         Through the web site you are able to find a house easier and faster<br>
         All you have to do is trust us and we will do the rest...<br>
         Welcome to  Home Technology Htech!!!</p>
	    	
	    </div>  
	</td>    
   </tr>
   </table>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*"%>
<%@ page import="htechohms.*" %>
<%@ page import="java.util.Date.*"%>
<%@ page import="java.text.DateFormat.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
</body>
</html>