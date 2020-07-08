<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product</title>
	</head>
	<body>
	<div class="container">
		<form action="addProduct" method="POST">
			<div class="form-group row">
				<label for="Category" class="col-sm-1 col-form-label">Category Id</label>
    			<div class="col-sm-1">
    				<input type="number" class="form-control" name="categoryId">
    			</div>
    			<label for="Product" class="col-sm-1 col-form-label">Product Name</label>
    			<div class="col-sm-2">
    				<input type="text" class="form-control" name="productName">
    			</div>
    			<label for="Description" class="col-sm-1 col-form-label">Description</label>
    			<div class="col-sm-2">
    				<input type="text" class="form-control" name="productDesc">
    			</div>
    			<label for="Price" class="col-sm-1 col-form-label">Price</label>
    			<div class="col-sm-1">
    				<input type="number" class="form-control" name="price">
    			</div>
    			<label for="Stock" class="col-sm-1 col-form-label">Stock</label>
    			<div class="col-sm-1">
    				<input type="number" class="form-control" name="stock">
    			</div>
    		</div>
  			<button type="submit" class="btn btn-primary">Add</button>
		</form>
		<form action="deleteProduct" method="POST">
			<br>
			<div class="form-group row">
    			<label for="ProductId" class="col-sm-1 col-form-label">Product Id (To delete)</label>
    			<div class="col-sm-1">
    				<input type="number" class="form-control" name="productId">
    			</div>
    		</div>
    		<button type="submit" class="btn btn-primary">Delete</button>
    	</form>
    	<form action="displayProducts" method="POST">
    		<br>
    		<button type="submit" class="btn btn-primary">Display Products</button>
    	</form>
    </div>
	</body>
</html>