<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Supplier List</title>
	</head>
	<body>
	<div class="container">
		<div class="table-condensed">
			<table class="table">
			<thead>
				<tr>
					<td><b>Id</b></td>
					<td><b>Name</b></td>
					<td><b>Description</b></td>
				</tr>
			</thead>
			<c:forEach items="${supplierList}" var="list">
				<tr>
					<td><c:out value="${list.supplierId}"/></td>
					<td><c:out value="${list.supplierName}"/></td>
					<td><c:out value="${list.supplierDesc}"/></td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	</body>
</html>