<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register</title>
	</head>
	<body>
	<div class="container">
		<form:form action="registerUser" method="POST" modelAttribute="user">
			<div class="form-group row">
    			<label for="customerName" class="col-sm-2 col-form-label">Name</label>
    			<div class="col-sm-5">
    			<input type="text" class="form-control" name="customerName">
    			</div>
    		</div>
    		<div class="form-group row">
    			<label for="userName" class="col-sm-2 col-form-label">User Name</label>
    			<div class="col-sm-5">
    				<!-- <input type="text" class="form-control" name="userName"> -->
    				<form:input path="userName" class="form-control" name="userName"/>
    			</div>
    			<div class="col-sm-2">
    				<form:errors path="userName" cssClass="error"/>
    			</div>
    		</div>
    		<div class="form-group row">
    			<label for="password" class="col-sm-2 col-form-label">Password</label>
    			<div class="col-sm-5">
    				<input type="text" class="form-control" name="password">
    			</div>
    		</div>
    		<div class="form-group row">
    			<label for="EmailId" class="col-sm-2 col-form-label">Email Id</label>
    			<div class="col-sm-5">
    				<!-- <input type="text" class="form-control" name="emailId"> -->
    				<form:input path="emailId" class="form-control" name="emailId"/>
    			</div>
    			<div class="col-sm-2">
    				<form:errors path="emailId" cssClass="error"/>
    			</div>
    		</div>
    		<div class="form-group row">
    			<label for="MobileNo" class="col-sm-2 col-form-label">Mobile No.</label>
    			<div class="col-sm-5">
    				<input type="text" class="form-control" name="mobileNo">
    			</div>
    		</div>
    		<div class="form-group row">
    			<label for="Address" class="col-sm-2 col-form-label">Address</label>
    			<div class="col-sm-5">
    				<input type="text" class="form-control" name="address">
    			</div>
    		</div>
    		<button type="submit" class="btn btn-primary">Register</button>
		</form:form>
	</div>
	</body>
</html>