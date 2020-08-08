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

	<div style="background-color:orange">
	Total Payment : ${total_Amount}/-
	</div>

	<form action="<c:url value="/receipt"/>" method="post">
	<table  class="table border">
		<tr>
			<td colspan="colspan=2">Payment Detail</td>
		</tr>
		<tr>
			<td> Payment Type </td>
			<td>
				<input type="radio" name="paymentMode" value="COD"/>Cash on Delivery
				<input type="radio" name="paymentMode" value="CC"/>Credit Card
			</td>
		</tr>
		<tr>
			<td> Card No </td>
			<td><input type="text" name="cardNo"/></td>
		</tr>
		<tr>
			<td colspan="2"> Valid Upto<td><input type="text" name="valid"/>
			CVV<td><input type="text" name="cvv"/></td>
		</tr>
		<tr>
			<td> Name </td>
			<td><input type="text" name="uname"/></td>
		</tr>
		<tr>
			<td colspan="colspan=2"><input type="submit" value="Pay" class="btn btn-primary"/></td>
		</tr>
	</table>
	</form>

	<div style="background-color:orange">
	Shipping Address : ${address}
	</div>


	</div>

	</body>
</html>