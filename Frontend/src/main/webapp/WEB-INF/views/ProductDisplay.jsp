<%@ page language="java" 
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product Display</title>
	</head>
	<body>
	<div class="container">
	<div  class="row text-center text-lg-left">
	
	<c:forEach items="${productList}" var="product">
		<div class="col-md-3 col-sm-4 col-xs-12">
			<a href="<c:url value="/totalProductDisplay/${product.productId}"/>" class="d-block mb-4 h-100">
			<img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productId}.png"/>" width="1000" height="1000"/>
			<p>Price :${product.price}</p>
			<p>Stock :${product.stock}</p>
			</a>
		</div>
	</c:forEach>
	</div>
	</div>
	</body>
</html>