<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Payment</title>
	</head>
	<body>
	<div class="container">

	<div class="col-sm-10">
	<h2 align="center"> <b>Payment Details</b></h2>
	</div>

	<form action="<c:url value="/receipt"/>" method="post">
	<div class="col-sm-10">
	<table  class="table border">
		<tr>
			<td><h4><b>Total Payment</b></h4></td>
			<td><h4><b> ${total_Amount+(total_Amount/10)}/-</b></h4></td>
		</tr>
		<tr>
			<td><h4><b>Payment Type</b></h4></td>

			<td><input type="radio" name="paymentMode" value="COD" /><b>Cash on Delivery</b>
			<input type="radio" name="paymentMode" value="CC"/><b>Credit Card</b></td>
		</tr>
		<tr>
			<td><h4><b>Name</b></h4></td>
			<td><input type="text" name="uname" class="form-control" value="Mandatory if you choose Credit Card"/></td>
		</tr>
		<tr>
			<td><h4><b>Card No.</b></h4> </td>
			<td><input type="text" name="cardNo" class="form-control" value="Mandatory if you choose Credit Card"/></td>
		</tr>
		<tr>
			<td><h4><b>Valid Upto</b></h4></td>
			<td><input type="text" name="valid" class="form-control" value="Mandatory if you choose Credit Card"/></td>
		</tr>
		<tr>
			<td><h4><b>CVV</b></h4></td>
			<td><input type="text" name="cvv" class="form-control" value="Mandatory if you choose Credit Card"/></td>
		</tr>
		<tr>
			<td colspan="colspan=2"><input type="submit" value="Pay" class="btn btn-primary"/></td>
		</tr>
	</table>
	</div>
	</form>

	<div class="col-sm-4" >
	<h4><b>Shipping Address : ${address}</b></h4>
	</div>
	</div>

	</body>
</html>