<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width,initial-scale"/>
		<title>Menu</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
	<!-- <body>
	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="Home">Home</a>
					<li><a href="Login">Login</a></li>
					<li><a href="Category">Category</a></li>
					<li><a href="Product">Product</a></li>
					<li><a href="Supplier">Supplier</a></li>
					<li><a href="Register">Register</a></li>
					<li><a href="ContactUs">Contact Us</a></li>
				</ul>
			</div>
		</nav>
	</div>
	</body>
</html> -->


<body>
<div class="container">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Titicaca</a>
    </div>
    <ul class="nav navbar-nav">
    <li class="active"><a href="Home">Home</a></li>
    <c:if test="${!sessionScope.loggedIn}">	
      		<li><a href="ContactUs">Contact Us</a></li>
    </c:if>
    <c:if test="${sessionScope.loggedIn}">
    	<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
      		<li><a href="Category">Manage Category</a></li>
      		<li><a href="Product">Manage Product</a></li>
      	</c:if>
    </c:if>
    <c:if test="${sessionScope.loggedIn}">
    	<c:if test="${sessionScope.role=='ROLE_USER'}">
      		<li><a href="productDisplay">Product </a></li>
      		<li><a href="Cart">Cart</a></li>
      	</c:if>
    </c:if>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
		<c:if test="${!sessionScope.loggedIn}">
			<li><a href="<c:url value="/Register"/>"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="<c:url value="/Login"/>"><span	class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</c:if>
		<c:if test="${sessionScope.loggedIn}">
			<li><a href="#"><span class="glyphicon glyphicon-user">${sessionScope.username}</span></a></li>
			<li><a href="<c:url value="/perform_logout"/>"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
		</c:if>
	</ul>
    
  </div>
</nav>
</div>
</body>
</html>