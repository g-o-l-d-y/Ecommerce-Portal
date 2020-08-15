<%@ page language="java" 
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product</title>
		<h1 align="center"><b>Products</b></h1>
	</head>
	<body>
	<div class="container-fluid">
		<form:form action="addProduct" method="post" modelAttribute="product" enctype="multipart/form-data" >
			<div class="form-group row">
				<label for="Category" class="col-sm-1 col-form-label"><h4><b>Category Id</b></h4></label>
    			<div class="col-sm-1">
    				<form:select path="categoryId">
					<form:option value="0" label="--Select List--"/>
					<form:options items="${categoryList}"/>
					</form:select>
    			</div>
    		</div>
    		<div class="form-group row">
    			<label for="Product" class="col-sm-1 col-form-label"><h4><b>Product Name</b></h4></label>
    			<div class="col-sm-2">
    				<form:input class="form-control" path="productName"/>
    			</div>
    			<label for="Description" class="col-sm-1 col-form-label"><h4><b>Description</b></h4></label>
    			<div class="col-sm-2">
    				<form:input class="form-control" path="productDesc"/>
    			</div>
    			<label for="Image" class="col-sm-1 col-form-label"><h4><b>Image</b></h4></label>
    			<div class="col-sm-3">
    				<form:input type="file" class="form-control" path="productImage"/>
    			</div>
    		</div>
    		<div class="form-group row">
    			<label for="Supplier" class="col-sm-1 col-form-label"><h4><b>Supplier Id</b></h4></label>
    			<div class="col-sm-2">
    				<form:input class="form-control" path="supplierId"/>
    			</div>
    			<label for="Price" class="col-sm-1 col-form-label"><h4><b>Price</b></h4></label>
    			<div class="col-sm-2">
    				<form:input class="form-control" path="price"/>
    			</div>
    			<label for="Stock" class="col-sm-1 col-form-label"><h4><b>Stock</b></h4></label>
    			<div class="col-sm-2">
    				<form:input class="form-control" path="stock"/>
    			</div>
    		</div>
  			<input type="submit" class="btn btn-primary" value="Add"/>
  			<input type="submit" value="Update" class="btn btn-info" formaction="<c:url value="/updateProduct"/>">
		</form:form>
    	<br>
    	<br>
    	<table class="table table-bordered">
			<tr class="success">
				<td><b>Product ID</b></td>
				<td><b>Product Name</b></td>
				<td><b>Product Description</b></td>
				<td><b>Category</b></td>
				<td><b>Price</b></td>
				<td><b>Supplier ID</b></td>
				<td><b>Stock</b></td>
				<td><b>Operation</b></td>
			</tr>
			<c:forEach items="${productList}" var="product">
			<tr>
				<td><b>${product.productId}</b></td>
				<td><b>${product.productName}</b></td>
				<td><b>${product.productDesc}</b></td>
				<td><b>${product.categoryId}</b></td>
				<td><b>${product.price}</b></td>
				<td><b>${product.supplierId}</b></td>
				<td><b>${product.stock}</b></td>
				<td>
					<a href="<c:url value="/editProduct/${product.productId}"/>" class="btn btn-info"><span class="glyphicon glyphicon-pencil"></span></a>
					<a href="<c:url value="/deleteProduct/${product.productId}"/>" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a>
				</td>
			</tr>
			</c:forEach>
		</table>
    </div>
	</body>
</html>