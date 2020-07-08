<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<div class="container">
			<form action="loginUser" method="POST">
				<div class="form-group row">
    			<label for="userName" class="col-sm-2 col-form-label">User Name</label>
    			<div class="col-sm-5">
    				<input type="text" class="form-control" name="userName">
    				<%-- <form:input path="userName" class="form-control" name="userName"/> --%>
    			</div>
    			<%-- <div class="col-sm-2">
    				<form:errors path="userName" cssClass="error"/>
    			</div> --%>
	    		</div>
	    		<div class="form-group row">
	    			<label for="password" class="col-sm-2 col-form-label">Password</label>
	    			<div class="col-sm-5">
	    				<input type="text" class="form-control" name="password">
	    			</div>
    			</div>
    			<button type="submit" class="btn btn-primary">Login</button>
    		</form>
		</div>
	</body>
</html>