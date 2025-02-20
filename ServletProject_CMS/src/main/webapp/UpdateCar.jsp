<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ResultSet rs2= (ResultSet)request.getAttribute("carObject");
rs2.next();
%>

<h1>Enter the updated values</h1>

<form action="save-updated-car" method="post">

<input type = "number" value="<%=rs2.getInt(1)%>" name = "carId" readonly="readonly"><br>
<input type="text" value="<%=rs2.getString(2)%>" name ="model"><br>
<input type="text" value="<%=rs2.getString(3)%>" name ="brand"><br>
<input type="text" value="<%=rs2.getString(4)%>" name ="color"><br>
<input type="number" value="<%=rs2.getInt(5) %>" name ="price"><br>
<input type="submit" value="UPDATE">
</form>

</body>
</html>