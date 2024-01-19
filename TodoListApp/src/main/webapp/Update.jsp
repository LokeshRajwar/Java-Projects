<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TODO APP - Update</title>
<%@ include file="WEB-INF/static/header.jsp" %>
</head>
<body style="background-image: url('images/update.jpg'); background-size: cover;">
	<h2 class="text-center bg-primary"> Update Your Tasks </h2>
	<div class="container mt-5">
		<div class="row p-4">
		<div class="col-md-6 offset-md-3">
			<div class="card">
			<div class="card-body">
				<form action="AddTodo" method="post">
					<div class="form-group">
						<label for="name">User Name</label> 
						<input type="text" name="username" class="form-control" id="name" placeholder="Enter User Name: ">
					</div>
					<div class="form-group">
						<label for="text">Add Task</label> 
						<input type="text" name="task" class="form-control" id="text" placeholder="Enter Task: ">
					</div>
					<div class="form-group">
						<label for="inputstate">Status</label> 
						<select id="inputState" name="status" class="form-control">
							<option selected>--Select--</option>
							<option value="Pending"> Pending </option>
							<option value="Complete"> Complete</option>
						</select>
					</div><hr>
					<div class="text-center">
						<button type="submit" class="btn btn-primary"> Update </button>
					</div>
				</form>
			</div>
		</div>
		</div>		
		</div>		
	</div>
<%@ include file="WEB-INF/static/footer.jsp" %>
</body>
</html>