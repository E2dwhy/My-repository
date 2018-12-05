<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP List Users Records</title>
</head>
<body>
    <sql:setDataSource
        var="jdbc/jndiname"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/htech"
        user="root" password="hopefor2015"
    />
     
    <sql:query var="listProperites"   dataSource="${jdbc/jndiname}">
        SELECT * FROM htech.properties;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Available Properties</h2></caption>
            <tr>
                <th>IDProperties</th>
                <th>OwnerName</th>
                <th>PopertyName</th>
                <th>PropertyType</th>
                 <th>BHKs</th>
                <th>Bathrooms</th>
                <th>Location</th>
                <th>ExpectedRent</th>
                 <th>ExpectedDeposit</th>
                <th>ExpectedDeposit</th>
                <th>AvailableFrom</th>
                
            </tr>
            <c:forEach var="properties" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${properties.id}" /></td>
                    <td><c:out value="${properties.ownername}" /></td>
                    <td><c:out value="${properties.propname}" /></td>
                    <td><c:out value="${properties.proptype}" /></td>
                    <td><c:out value="${properties.bhk}" /></td>
                    <td><c:out value="${properties.bathrooms}" /></td>
                    <td><c:out value="${properties.rent}" /></td>
                    <td><c:out value="${properties.deposit}" /></td>
                    <td><c:out value="${properties.availability}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>