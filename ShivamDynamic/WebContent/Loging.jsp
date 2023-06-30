<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<center>

		<%@ include file="Header.jsp"%>
		<%
			String msg = (String) request.getAttribute("msg");
			String uri = (String) request.getAttribute("uri");
		%>
		<%
			if (msg != null) {
		%>
		<font color="red"><%=msg%></font>
		<%
			}
		%>

		<form action="LoginCtl" method="post">

			<table>


				<tr>


					<th>Login Id :</th>
					<td><input type="text" name="loginId"></td>
				</tr>

				<tr>
					<th>Password :</th>
					<td><input type="password" name="password"></td>

				</tr>

				<tr>
					<th></th>
					<td><input style="margin-left: 50px" type="submit"
						name="Operation" value="Registration"></td>
				</tr>

			</table>
			<td><input type="hidden" name="uri" value=<%=uri%>></td> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br>

			<hr>
			<h1>Contact Us...</h1>
		</form>
	</center>

</body>
</html>