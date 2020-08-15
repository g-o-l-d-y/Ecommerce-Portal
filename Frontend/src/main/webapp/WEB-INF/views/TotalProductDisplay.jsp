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
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container">	
			<div class="row">
				<div class="col-md-4 col-lg-4 col-sm-4 col-xs-6">
					<div class="product col-md-3 service-image-left">
						<img id="item-display" src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="300" height="300" alt=""></img>
					</div>
				</div>
				<form action="<c:url value="/addToCart/${product.productId}"/>" method="get">
				<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
					<div class="product-title"><b>${product.productName}</b></div>
					<div class="product-desc"><b>${product.productDesc}</b></div>
					<hr>
					<div class="product-price"><b>INR ${product.price}/-</b></div>
					<div class="product-stock"><b>In Stock</b></div>
					<div class="product-price"><b>Quantity</b>
							<select name="quantity">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
					</div>
					<hr>
					<div class="btn-group cart">
						<input type="submit" value="Add to Cart" class="btn btn-warning">
					</div>
					<div class="btn-group wishlist">
						<input type="submit" value="Buy Now" class="btn btn-success" formaction="<c:url value="/buyNow/${product.productId}"/>">
					</div>
				</div>
				</form>
			 </div> 	
			 </div> 
		</div>
	</div>
	</div>
</body>
</html>