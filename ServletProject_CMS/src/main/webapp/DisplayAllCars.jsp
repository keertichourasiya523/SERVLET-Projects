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
	ResultSet rs2 = (ResultSet) request.getAttribute("carList");
	%>

	<table border="">
		<tr>
			<th>CarId</th>
			<th>Model</th>
			<th>Brand</th>
			<th>Color</th>
			<th>Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<%
		while (rs2.next()) {
		%>
		<tr>
			<td><%=rs2.getInt(1)%></td>
			<td><%=rs2.getString(2)%></td>
			<td><%=rs2.getString(3)%></td>
			<td><%=rs2.getString(4)%></td>
			<td><%=rs2.getInt(5)%></td>
			<td><a href="find-by-id?carId=<%= rs2.getInt(1) %>">UPDATE</a></td>
			<td><a href="delete-by-id?carId=<%= rs2.getInt(1) %>">DELETE</a></td>
			
		</tr>


		<%
		}
		%>

	</table>
	<h1>
		<a href="index.jsp">Go Back to DashBoard</a>
	</h1>

</body>
</html>