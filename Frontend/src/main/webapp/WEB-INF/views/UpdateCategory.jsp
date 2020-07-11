<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Manage Category</title>
	</head>
	<body>
	<div class="container">
		<div class="table-condensed">
		<form action="<c:url value="/updateCategory"/>" method="post">
			<table class="table table-bordered">
				<tr>
					<td>Id</td>
					<td><input type="text" name="categoryId" class="form-control" value="${category.categoryId}" readonly/></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="categoryName" class="form-control" value="${category.categoryName}"/></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea cols="40" rows="5" name="categoryDesc" class="form-control" value="">${category.categoryDesc}</textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Update Category" class="btn btn-primary"/>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	</body>
</html>