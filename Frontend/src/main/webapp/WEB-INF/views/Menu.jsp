<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width,initial-scale"/>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

		<style type="text/css">
		
		#home {
		  top: 80px;
		  background-color: #555;
		}
		
		#manageProduct {
		  top: 140px;
		  background-color: #555;
		}
		#products {
		  top: 140px;
		  background-color: #555;
		}
		
		#manageCategory {
		  top: 200px;
		  background-color: #555; 
		}
		
		#cart {
		  top: 200px;
		  background-color: #555; 
		}
		
		#ord
		{
			top: 260px;
			 background-color: #555; 
		}
		
		#about {
		  top: 260px;
		  background-color: #555;
		}
		
		#contact {
		  top: 320px;
		  background-color: #555 /* Light Black */
		}
		
		#sign
		{
			top: 140px;
		   	background-color: #555;
		}
		
		#login
		{
			top: 200px;
		  	background-color: #555 /* Light Black */
		}
		
		#logoutuser 
		{
			top: 320px;
		  	background-color: #555 /* Light Black */
		}
		
		#logoutadmin
		{
			top: 260px;
		  	background-color: #555 /* Light Black */
		}
		
		#myRSidenav a {
		  position: absolute; /* Position them relative to the browser window */
		  right: -114px; /* Position them outside of the screen */
		  transition: 0.3s; /* Add transition on hover */
		  padding: 15px; /* 15px padding */
		  width: 155px; /* Set a specific width */
		  text-decoration: none; /* Remove underline */
		  font-size: 20px; /* Increase font size */
		  color: white; /* White text color */
		  border-radius: 0 5px 5px 0; /* Rounded corners on the top right and bottom right side */
		}
		
		#myRSidenav a:hover {
		  right: 0; /* On mouse-over, make the elements appear as they should */
		}

		</style>
	</head>
	<body  background="<c:url value="/resources/images/HP1.jpg"/>">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#" style="color:#000000;"><b>Titicaca</b></a>
	    </div>
	    <ul class="nav navbar-nav navbar-right">
	    <c:if test="${sessionScope.loggedIn}">
			<div class="navbar-header">
				<a class="navbar-brand" href="#" style="color:#000000;"><span class="glyphicon glyphicon-user"></span> <b>${sessionScope.username}</b> </a>
			</div>
		</c:if>
		</ul>
	    <div id="myRSidenav" class="sidenav">
		    <c:if test="${!sessionScope.loggedIn}">	
		    		<a href="<c:url value="/Home"/>" id="home"><span class="glyphicon glyphicon-home"></span> Home</a>
		    		<a href="<c:url value="AboutUs"/>" id="about"><span class="glyphicon glyphicon-hand-right"></span> About Us</a>
		      		<a href="<c:url value="ContactUs"/>" id="contact"><span class="glyphicon glyphicon-envelope"></span> Contact Us</a>
		    </c:if>
		    <c:if test="${sessionScope.loggedIn}">
		    	<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
		    		<a href="<c:url value="/AdminHome"/>" id="home"><span class="glyphicon glyphicon-home"></span> Home</a>
		      		<a href="<c:url value="/Category"/>" id="manageCategory"><span class="glyphicon glyphicon-th-list"></span> Categories</a>
		      		<a href="<c:url value="/Product"/>" id="manageProduct"><span class="glyphicon glyphicon-th-large"></span> Products</a>
		      		<a href="<c:url value="/perform_logout"/>" id="logoutadmin"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
		      	</c:if>
		    </c:if>
		    <c:if test="${sessionScope.loggedIn}">
		    	<c:if test="${sessionScope.role=='ROLE_USER'}">
		    		<a href="<c:url value="/UserHome"/>" id="home"><span class="glyphicon glyphicon-home"></span> Home</a>
		      		<a href="<c:url value="/productDisplay"/>" id="products"><span class="glyphicon glyphicon-th"></span> Products </a>
		      		<a href="<c:url value="/Cart"/>" id="cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a>
		      		<a href="<c:url value="/myOrders"/>" id="ord"><span class="glyphicon glyphicon-list-alt"></span> My Orders</a>
		      		<a href="<c:url value="/perform_logout"/>" id="logoutuser"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
		      	</c:if>
		    </c:if>
			<c:if test="${!sessionScope.loggedIn}">
				<a href="<c:url value="/Register"/>" id="sign"><span class="glyphicon glyphicon-user"></span> Sign Up</a>
				<a href="<c:url value="/Login"/>" id="login"><span	class="glyphicon glyphicon-log-in"></span> Login</a>
			</c:if>
		</div>
	  </div>
	</body>
</html>