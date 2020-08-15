<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Category</title>
		<h1 align="center"><b>Categories</b></h1>
		<br>
		<br>
	</head>
	<body>
	<div class="container-fluid">
		<form action="addCategory" method="POST">
			<div class="form-group row">
    			<label for="Category" class="col-sm-2 col-form-label"><h4><b>Category Name</b></h4></label>
    			<div class="col-sm-2">
    				<input type="text" class="form-control" name="categoryName">
    			</div>
    			<label for="Description" class="col-sm-2 col-form-label"><h4><b>Category Description</b></h4></label>
    			<div class="col-sm-4">
    				<input type="text" class="form-control" name="categoryDesc">
    			</div>
  				<button type="submit" class="btn btn-primary">Add</button>
  			</div>
		</form>
		<br>
		<br>
		<div class="table-responsive">
			<table class="table table-bordered">
				<tr class="success">
					<td><b>ID</b></td>
					<td><b>Name</b></td>
					<td><b>Description</b></td>
					<td><b>Operation</b></td>
				</tr>
				<c:forEach items="${categoryList}" var="category"> 
					<tr>
						<td><b>${category.categoryId}</b></td>
						<td><b>${category.categoryName}</b></td>
						<td><b>${category.categoryDesc}</b></td>
						<td>
							<a href="<c:url value="/editCategory/${category.categoryId}"/>" class="btn btn-info"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="<c:url value="/deleteCategory/${category.categoryId}"/>" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</body>
</html>
