<%@ page language="java" 
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product Display</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style>
		#price a{
		text-decoration: none;
		}
		.checked {
		  color: orange;
		}
	</style>
	</head>
	<body>
	<div class="container">
	<div class="row text-center text-lg-left">
	<div class="col-sm-12">
	<c:forEach items="${productList}" var="product">
		<div class="col-md-4 col-sm-3 col-xs-12">
			<a href="<c:url value="/totalProductDisplay/${product.productId}"/>" class="d-block mb-4 h-100">
			<img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="2000" height="2000"/>
			<div id="price">
			<a style="color:#000000;"  id="price"><b>${product.productName}</b></a>
			<br>
			<a style="color:#000000;"  id="price"><b>Price : ${product.price} INR</b></a>
			<br>
			<c:choose>
			<c:when test="${product.productId%5==0}">
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star"></span>
			<span class="fa fa-star"></span>
			</c:when>
			<c:when test="${product.productId%2!=0}">
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star"></span>
			</c:when>
			<c:otherwise>
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star checked"></span>
			</c:otherwise>
			</c:choose>
			</div>
			</a>
			<br>
		</div>
	</c:forEach>
	</div>
	</div>
	</div>
	</body>
</html>