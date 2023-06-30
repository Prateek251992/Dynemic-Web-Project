<%@page import="in.co.rays.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

         <%@ include file="Header.jsp"%>
	<form action="">
		<%
			List list = (List) request.getAttribute("List");
			Iterator it = list.iterator();
		%>
		<br><br><br>
		<hr>
		<table border="1">
		<br><br>
			<tr>
			    <th>Id</th>
				<th>First_Name</th>
				<th>Last_Name</th>
				<th>Login_Id</th>
				<th>Password</th>
				<th>Address</th>
				<th>edit</th>
			</tr>
			
			<%
			while (it.hasNext()) {
				UserBean bean = (UserBean) it.next();
			%>
			
			<tr>
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getAddress()%></td>
				<td><a href="UserCtl.do?id=<%=bean.getId()%>">edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
        <%@ include file="Footer.jsp"%>
</body>
</html>