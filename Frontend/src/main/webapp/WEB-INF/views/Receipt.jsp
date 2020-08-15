<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Receipt</title>
	</head>
	<body>
	<div class="container">

    <div class="row">
        <div class="col-xs-10">
    		<div class="invoice-title" align="center">
    			<h3><b>Invoice - Order # ${order.orderId}</b></h3>
    		</div>
    		<hr>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    				<strong><h4><b>Billed To: </b></h4></strong>
    					<h4><b>${address}</b></h4>
    				</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
        			<h4><b>Total Shopping Amount: </b></h4>
    					<h4><b>&#8377;${total_Amount}/-</b></h4>
    				</address>
    			</div>
    		</div>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    					<strong><h4><b>Payment Method: </b></h4></strong>
    					<h4><b>${order.paymentMode}</b></h4>
    				</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
    					<h4><b>Order Date:</b></h4> 
    					<h4><b>${order.orderDate}</b></h4>
    				</address>
    			</div>
    		</div>
    	</div>
    </div>
    
    <div class="row">
    	<div class="col-md-10">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Order summary</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td><strong>Item</strong></td>
        							<td class="text-center"><strong>Price</strong></td>
        							<td class="text-center"><strong>Quantity</strong></td>
        							<td class="text-right"><strong>Total</strong></td>
                                </tr>
    						</thead>
    						<tbody>
    							<c:forEach items="${listCartItems}" var="cartItem">
    							<tr>
    								<td>${cartItem.productName }</td>
    								<td class="text-center">${cartItem.price}</td>
    								<td class="text-center">${cartItem.quantity}</td>
    								<td class="text-right">${cartItem.price * cartItem.quantity}</td>
    							</tr>
    							</c:forEach>
    							<tr>
    							<td></td>
    							<td></td>
    							<td class="text-center"><b>Shipping Charge :</b></td>
    							<td class="text-right">${total_Amount/10}</td>
    							</tr>
    						</tbody>
    					</table>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
</div>
	</body>
</html>