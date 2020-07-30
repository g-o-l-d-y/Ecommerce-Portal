<%@ page language="java" 
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
		<form:form action="addProduct" method="post" modelAttribute="product" enctype="multipart/form-data" >
			<div class="form-group row">
				<label for="Category" class="col-sm-1 col-form-label">Category Id</label>
    			<div class="col-sm-1">
    				<form:select path="categoryId">
					<form:option value="0" label="--Select List--"/>
					<form:options items="${categoryList}"/>
					</form:select>
    			</div>
    		</div>
    		<div class="form-group row">
    			<label for="Product" class="col-sm-1 col-form-label">Product Name</label>
    			<div class="col-sm-2">
    				<form:input class="form-control" path="productName"/>
    			</div>
    			<label for="Description" class="col-sm-1 col-form-label">Description</label>
    			<div class="col-sm-2">
    				<form:input class="form-control" path="productDesc"/>
    			</div>
    			<label for="Image" class="col-sm-1 col-form-label">Image</label>
    			<div class="col-sm-4">
    				<form:input type="file" class="form-control" path="productImage"/>
    			</div>
    		</div>
    		<div class="form-group row">
    			<label for="Supplier" class="col-sm-1 col-form-label">Supplier Id</label>
    			<div class="col-sm-2">
    				<form:input class="form-control" path="supplierId"/>
    			</div>
    			<label for="Price" class="col-sm-1 col-form-label">Price</label>
    			<div class="col-sm-2">
    				<form:input class="form-control" path="price"/>
    			</div>
    			<label for="Stock" class="col-sm-1 col-form-label">Stock</label>
    			<div class="col-sm-2">
    				<form:input class="form-control" path="stock"/>
    			</div>
    		</div>
  			<input type="submit" class="btn btn-primary" value="Add / Update"/>
		</form:form>
		<!-- <form action="deleteProduct" method="POST">
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
    	</form> -->
    	<br>
    	<table class="table table-bordered">
			<tr>
				<td>Product ID</td>
				<td>Product Name</td>
				<td>Product Description</td>
				<td>Category</td>
				<td>Price</td>
				<td>Supplier ID</td>
				<td>Stock</td>
				<td>Operation</td>
			</tr>
			<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.productId}</td>
				<td>${product.productName}</td>
				<td>${product.productDesc}</td>
				<td>${product.categoryId}</td>
				<td>${product.price}</td>
				<td>${product.supplierId}</td>
				<td>${product.stock}</td>
				<td>
					<a href="<c:url value="/editProduct/${product.productId}"/>" class="btn btn-info">EDIT</a>
					<a href="<c:url value="/deleteProduct/${product.productId}"/>" class="btn btn-danger">DELETE</a>
				</td>
			</tr>
			</c:forEach>
		</table>
    </div>
	</body>
</html>