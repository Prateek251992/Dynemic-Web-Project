
<%@page import="in.co.rays.bean.UserBean"%>
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
	<%
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<form action="UserCtl.do" method="post">

		<td><input type="hidden" name="id" value="<%=bean.getId()%>"></td>
		<table>

			<tr>
				<th>First Name :</th>
				<td><input type="text" name="firstName"
					value="<%=bean.getFirstName()%>"></td>
			</tr>

			<tr>
				<th>Last Name :</th>
				<td><input type="text" name="LastName"
					value="<%=bean.getLastName()%>"></td>
			</tr>

			<tr>
				<th>Login Id :</th>
				<td><input type="text" name="loginId"
					value="<%=bean.getLoginId()%>"></td>
			</tr>

			<tr>
				<th>Password :</th>
				<td><input type="password" name="password"
					value="<%=bean.getPassword()%>"></td>
			</tr>

			<tr>
				<th>Address :</th>
				<td><input type="text" name="Address"
					value="<%=bean.getLastName()%>"></td>
			</tr>


			<tr>
				<th></th>
				<td><input style="margin-left: 60px" type="submit"
					name="Operation" value="Update"></td>
			</tr>


		</table>
	</form>
</body>
</html>