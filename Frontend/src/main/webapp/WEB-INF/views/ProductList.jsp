<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product List</title>
	</head>
	<body>
	<div class="container">
		<div class="table-condensed">
			<table class="table">
			<thead>
				<tr>
					<td><b>Category Id</b></td>
					<td><b>Product Id</b></td>
					<td><b>Product</b></td>
					<td><b>Description</b></td>
					<td><b>Price</b></td>
					<td><b>Stock</b></td>
				</tr>
			</thead>
			<c:forEach items="${productList}" var="list">
				<tr>
					<td><c:out value="${list.categoryId}"/></td>
					<td><c:out value="${list.productId}"/></td>
					<td><c:out value="${list.productName}"/></td>
					<td><c:out value="${list.productDesc}"/></td>
					<td><c:out value="${list.price}"/></td>
					<td><c:out value="${list.stock}"/></td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	</body>
</html>