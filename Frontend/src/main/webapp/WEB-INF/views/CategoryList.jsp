<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Category List</title>
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
					<td><b>Operations</b></td>
				</tr>
			</thead>
			<c:forEach items="${categoryList}" var="list">
				<tr>
					<td><c:out value="${list.categoryId}"/></td>
					<td><c:out value="${list.categoryName}"/></td>
					<td><c:out value="${list.categoryDesc}"/></td>
					<td>
						<a href="deleteCategory/${list.categoryId}" class="btn btn-danger">Delete</a>
						<a href="editCategory/${list.categoryId}" class="btn btn-info">Edit</a>
					</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	</body>
</html>