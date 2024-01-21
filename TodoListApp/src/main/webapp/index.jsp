<%@page import="com.Entity.Add_todo"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.TodoDao"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="com.DbConnect.DbConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
<%@ include file="WEB-INF/static/header.jsp" %>
</head>
<body style="background-image: url('images/TODO.jpg'); background-size: 500px;">
	<h1 class="text-center bg-success text-white"> Welcome to Todo App </h1>
	<%
		String msg1 = (String)session.getAttribute("SuccessMessage");
		if(msg1 != null) {
	%>
		<div class="alert alert-success" role="alert"> <%=msg1%> </div>
	<% 
		session.removeAttribute("SuccessMessage");
		}
	%>
	<%
		String msg2 = (String)session.getAttribute("FailedMessage");
		if(msg2 != null) {
	%>
		<div class="alert alert-success" role="alert"> <%=msg2%> </div>
	<% 
		session.removeAttribute("FailedMessage");
		}
	%>

	<div class="container mt-5 card p-6 d-flex flex-coloumn">
		<table class="table table-hover table-striped" border="1">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Task</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
			<%
				TodoDao todo = new TodoDao(DbConnect.getConn());
				List<Add_todo> list = todo.getTodo();
				for(Add_todo it: list) {
			%>
				<tr>
					<th scope="row"><%=it.getId()%></th>
					<th scope="row"><%=it.getName()%></th>
					<td><%=it.getTask()%></td>
					<td><%=it.getStatus()%></td>
					<td>
						<a href="Update.jsp?id=<%=it.getId()%>" class="btn btn-sm btn-success">Edit</a>
						<a href="Delete?id=<%=it.getId()%>" class="btn btn-sm btn-danger">Delete</a>
					</td>
				</tr>
				<%
				}
				%>
			 </tbody>
		</table>
	</div>

<%@ include file="WEB-INF/static/footer.jsp" %>
</body>
</html>