<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<title>Car sale</title>
</head>
<body bgcolor="#87ceff">
	<script>
		function validateform() {
			var carNumber = document.myform.carNumber.value;
			var carModel = document.myform.carModel.value;
			var price = document.myform.price.value;
			var userName = document.myform.userName.value;
			var userName = document.myform.userName.value;
			var registrationYear = document.myform.registrationYear.value;
			var file = document.myform.file.value;

			if (carNumber == "") {
				alert("carNumber is Mandatory");
				return false;
			}

			if (carModel == "") {
				alert("carModel is Mandatory");
				return false;
			}

			if (price == "") {
				alert("price is Mandatory");
				return false;
			}

			if (userName == "") {
				alert("userName is Mandatory");
				return false;
			}

			if (registrationYear == "") {
				alert("registrationYear is Mandatory");
				return false;
			}

			if (file == "") {
				alert("file is Mandatory");
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
	<h2 style="text-align: left;">Add Car Details Form</h2>
	<table align="left">
		<form:form modelAttribute="car" name="myform"
			action="../../car/save/check" method="post"
			enctype="multipart/form-data" onsubmit="return validateform()">

			<tr>
				<td><label>Car Number:</label></td>
				<td><form:input path="carNumber" name="carNumber"></form:input></td>
			</tr>

			<tr>
				<td><label>Car Model:</label></td>
				<td><form:input path="carModel" name="carModel"></form:input></td>
			</tr>

			<tr>
				<td><label>Estimated price:</label></td>
				<td><form:input path="price" name="price"></form:input></td>
			</tr>

			<tr>
				<td><label>User Name:</label></td>
				<td><form:input path="userName" name="userName"></form:input></td>
			</tr>

			<tr>
				<td><label>Registration Year:</label></td>
				<td><form:input path="registrationYear" name="registrationYear"></form:input></td>
			</tr>

			<tr>
				<td><label>Upload Photo:</label></td>
				<td><form:input type="file" path="file"></form:input></td>
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