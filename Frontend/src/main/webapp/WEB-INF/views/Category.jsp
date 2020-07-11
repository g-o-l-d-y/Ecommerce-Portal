<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Category</title>
	</head>
	<body>
	<div class="container">
		<form action="addCategory" method="POST">
			<div class="form-group row">
    			<label for="Category" class="col-sm-2 col-form-label">Category Name</label>
    			<div class="col-sm-2">
    				<input type="text" class="form-control" name="categoryName">
    			</div>
    			<label for="Description" class="col-sm-2 col-form-label">Category Description</label>
    			<div class="col-sm-4">
    				<input type="text" class="form-control" name="categoryDesc">
    			</div>
  				<button type="submit" class="btn btn-primary">Add</button>
  			</div>
		</form>
		<div class="table-responsive">
			<table class="table table-bordered">
				<tr class="success">
					<td>ID</td>
					<td>Name</td>
					<td>Description</td>
					<td>Operation</td>
				</tr>
				<c:forEach items="${categoryList}" var="category"> 
					<tr>
						<td>${category.categoryId}</td>
						<td>${category.categoryName}</td>
						<td>${category.categoryDesc}</td>
						<td>
							<a href="<c:url value="/editCategory/${category.categoryId}"/>" class="btn btn-info">EDIT</a>
							<a href="<c:url value="/deleteCategory/${category.categoryId}"/>" class="btn btn-danger">DELETE</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</body>
</html>
