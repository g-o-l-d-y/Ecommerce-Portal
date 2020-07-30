<%@ page language="java"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Manage Product</title>
	</head>
	<body>
	<div class="container">
		<div class="table-condensed">
		<form action="<c:url value="/updateProduct"/>" method="post" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tr>
					<td>Product Id</td>
					<td><input type="text" name="productId" class="form-control" value="${product.productId}" readonly/></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="productName" class="form-control" value="${product.productName}"/></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea cols="40" rows="5" name="productDesc" class="form-control" value="">${product.productDesc}</textarea></td>
				</tr>
				<tr>
					<td>Supplier ID</td>
					<td><input type="number" name="supplierId" class="form-control" value="${product.supplierId}"/></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="number" name="price" class="form-control" value="${product.price}"/></td>
				</tr>
				<tr>
					<td>Stock</td>
					<td><input type="number" name="stock" class="form-control" value="${product.stock}"/></td>
				</tr>
				<tr>
					<td>Product Image</td>
					<td><input type="file" name="productImage" class="form-control" value="${product.productImage}"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Update Product" class="btn btn-primary"/>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	</body>
</html>