<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cart</title>
	</head>
	<body>
	<div class="container">
	
	<div>
		<h2 align="center"><b>Your Cart</b></h2>
	</div>
	
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th><h4><b>Product</b></h4></th>
                        <th><h4><b>Quantity</b></h4></th>
                        <th class="text-center"><h4><b>Price</b></h4></th>
                        <th class="text-center"><h4><b>Total</b></h4></th>
                        <th> </th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${listCartItems}" var="cartItem">
                	<form action="<c:url value="/updateCartItem/${cartItem.cartId}"/>" method="get">
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>" style="width: 72px; height: 72px;"> </a>
                            <div>
                            	<br>
                                <h4><span style="color:#000000;" href="#"><b> ${cartItem.productName}</b></span></h4>
                                <!-- <h5 class="media-heading"> by <a href="#">Brand name</a></h5> -->
                                <span><b>Status:</b> </span><span style="color:#006400;"><strong>In Stock</strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="text" class="form-control" name="quantity" id="quantity" value="${cartItem.quantity}">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${cartItem.price}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${cartItem.price * cartItem.quantity}</strong></td>
                        <td class="col-sm-1 col-md-1">
                        <button type="submit" class="btn btn-primary">
                            <span class="glyphicon glyphicon-ok"></span> Update Quantity
                        </button>
                        </td>
                        <td>
                        <a href="<c:url value="/deleteCartItem/${cartItem.cartId}"/>" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </a>
                        </td>
                     </tr>
                     </form>
                	</c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h4><b>Subtotal</b></h4></td>
                        <td class="text-right"><h5><strong>${total_Amount}</strong></h5></td>
                        <td>   </td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h4><b>Estimated shipping</b></h4></td>
                        <td class="text-right"><h5><strong>${total_Amount /10}</strong></h5></td>
                        <td>   </td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3><b>Total</b></h3></td>
                        <td  class="text-right" ><h3><strong>&#8377;${total_Amount+ (total_Amount/10)}/-</strong></h3></td>
                        <td>   </td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="<c:url value="/productDisplay"/>" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </a></td>
                        <td>
                         <a href="<c:url value="/confirmOrder"/>" class="btn btn-default">
                            Order Confirm <span class="glyphicon glyphicon-play"></span>
                          </a>
                        </td>
                        <td><b><h4>${errorMessage}</h4></b></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
	</body>
</html>