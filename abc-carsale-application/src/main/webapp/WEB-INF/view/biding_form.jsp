<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<title>Biding details</title>
</head>
<body bgcolor="#87ceff">
	<script>
		function validateform() {
			var carBidingPrice = document.myform.carBidingPrice.value;
			var userName = document.myform.userName.value;
			var date = document.myform.date.value;

			if (carBidingPrice == "") {
				alert("carBidingPrice is Mandatory");
				return false;
			}

			if (userName == "") {
				alert("userName is Mandatory");
				return false;
			}

			if (date == "") {
				alert("date is Mandatory");
				return false;
			}
		}
	</script>

	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //HTTP1.1 browser
	response.setHeader("Pragma", "no-cache"); //HTTP1.0 browser
	response.setHeader("Expires", "0"); //proxies
	%>
	<form align='left' action='http://localhost:8081/home/page'>
		<div align='left'>
			<input type='submit' value='Home' />
		</div>
	</form>
	<form align='left' action='http://localhost:8081/user/logout'>
		<div align='left'>
			<input type='submit' value='Logout' />
		</div>
	</form>

	<h1 style="text-align: left;">Biding Details Form</h1>
	<table align="left">
		<form:form modelAttribute="bidingDetails" name="myform"
			action="../../check/${carNumber}/${carModel}" method="post"
			onsubmit="return validateform()">

			<tr>
				<td><label>Car Number:</label></td>
				<td>${carNumber}</td>
			</tr>

			<tr>
				<td><label>Car Model:</label></td>
				<td>${carModel}</td>
			</tr>

			<tr>
				<td><label>Car Biding Price:</label></td>
				<td><form:input path="carBidingPrice"></form:input></td>
			</tr>

			<tr>
				<td><label>User Name:</label></td>
				<td><form:input path="userName"></form:input></td>
			</tr>

			<tr>
				<td><label>Book an Appointment Date:</label></td>
				<td><form:input path="date"
						placeholder="Enter YYYY/MM/DD format"></form:input></td>
			</tr>
			<tr>
				<td><input type="submit" style="float: right"></input></td>
			</tr>
			<tr>
				<td><input type="reset" style="float: right"></input></td>
			</tr>
		</form:form>
	</table>


</body>
</html>