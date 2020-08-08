<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Supplier</title>
	</head>
	<body>
	<div class="container">
		<form action="<c:url value="addSupplier"/>" method="POST">
			<div class="form-group row">
    			<label for="Supplier" class="col-sm-2 col-form-label">Supplier Name</label>
    			<div class="col-sm-5">
    				<input type="text" class="form-control" name="supplierName">
    			</div>
    		</div>
    		<div class="form-group row">
    			<label for="Description" class="col-sm-2 col-form-label">Description</label>
    			<div class="col-sm-5">
    				<input type="text" class="form-control" name="supplierDesc">
    			</div>
    		</div>
  			<button type="submit" class="btn btn-primary">Add</button>
		</form>
		<form action="<c:url value="deleteDisplay"/>" method="POST">
			<br>
			<div class="form-group row">
    			<label for="SupplierId" class="col-sm-2 col-form-label">Supplier Id (To delete)</label>
    			<div class="col-sm-3">
    				<input type="number" class="form-control" name="supplierId">
    			</div>
    		</div>
    		<button type="submit" class="btn btn-primary">Delete</button>
    	</form>
    	<form action="<c:url value="editSupplier"/>" method="POST">
    		<br>
    		<div class="form-group row">
    			<label for="SupplierId" class="col-sm-2 col-form-label">Supplier Id (To edit)</label>
    			<div class="col-sm-3">
    				<input type="number" class="form-control" name="supplierId">
    			</div>
    			<label for="SupplierName" class="col-sm-2 col-form-label">Supplier Name (Enter the new Supplier Name to edit or update)</label>
    			<div class="col-sm-3">
    				<input type="text" class="form-control" name="supplierName">
    			</div>
    		</div>
    		<button type="submit" class="btn btn-primary">Update/Edit</button>
    	</form>
		<form action="<c:url value="listSuppliers"/>" method="GET">
			<br>
			<button type="submit" class="btn btn-primary">Display Suppliers</button>
		</form>
	</div>
	</body>
</html>