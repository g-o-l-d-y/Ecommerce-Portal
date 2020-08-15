<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>My Orders</title>
	</head>
	<body>
	<div class="container">
	<div class="row">
	<div class="col-sm-10 col-md-10 col-md-offset-1">
	<h1 align="center"><b>My Orders</b></h1>
	<table class="table table-hover">
		<c:forEach items="${OrdersList}" var="order"> 
			<c:set var="sum" scope="application" value="${0}"/>
			<tr>
				<td class="col-sm-6"><h3><b> ${order.getValue()}  Order # ${order.getKey()}</b></h3></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td class="col-sm-8 col-md-6"><h4><b>Product </b></h4></td>
				<td></td>
	            <td class="col-sm-1 col-md-1 text-center"><h4><b> Quantity</b></h4> </td>
	            <td class="col-sm-1 col-md-1 text-center"><h4><b>Price</b></h4></td>
	            <td class="col-sm-1 col-md-1 text-center"><h4><b>Total</b></h4></td>
			</tr>
			<c:forEach items="${Orders}" var="ord">
			<tr>
				<c:if test="${ord.orderId==order.getKey()}"> 
					<td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="<c:url value="/resources/images/${ord.productId}.jpg"/>" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><span href="#"><b>${ord.productName}</b></span></h4>
                                <!-- <h5 class="media-heading"> by <a href="#">Brand name</a></h5> -->
                            </div>
                        </div>
                        </td>
                        <td></td>
                        <td class="col-sm-1 col-md-1 text-center"> ${ord.quantity}</td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${ord.price}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${ord.price * ord.quantity}</strong></td>
                        <article class=hidden>${sum=sum+ord.price * ord.quantity}</article>
				</c:if>
			</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td class="col-sm-1 col-md-1 text-center"><h4><b>Shipping Charge : </b></h4></td>
				<td class="col-sm-1 col-md-1 text-center"><b>${sum/10}</b></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td class="col-sm-1 col-md-1 text-center"><h3><b>Total : </b></h3></td>
				<td class="col-sm-1 col-md-1 text-center"><h3><b>&#8377;${sum+(sum/10)}/-</b></h3></td>
			</tr>
		</c:forEach>
		</table>
		</div>
		</div>
		</div>
	</body>
</html>