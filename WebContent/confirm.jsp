<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm</title>
</head>
<body>
<%
float si= Float.parseFloat(request.getAttribute("si").toString());
out.println("The Simple Interest is "+ si);%>
<form action="InsertServlet" method="get">
<Table width="100%">
<Tr>
<TD> Name: </TD><TD>ggfd${name}</TD> 
</Tr>
<Tr>
<TD> Email: </TD><TD>${email}</TD> 
</Tr>
<Tr>
<TD> Principal: </TD><TD>${principal}</TD> 
</Tr>
<Tr>
<TD>Tenure: </TD><TD>${tenure}</TD>
</Tr>
<Tr>
<TD>Interest: </TD><TD>${si}</TD>
</Tr>

</Table>
<input type="submit">
</form>
</body>
</html>