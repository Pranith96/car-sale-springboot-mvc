<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>
textarea {
	width: 100%;
	padding: 20px;
	border: 1px solid #ccc;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}
</style>
<title>Contact Us</title>
</head>
<body bgcolor="#87ceff">
	<script>
		function validateform() {
			var fullName = document.myform.fullName.value;
			var emailId = document.myform.emailId.value;

			if (fullName == "") {
				alert("fullName is Mandatory");
				return false;
			}

			if (emailId == "") {
				alert("emailId is Mandatory");
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
	<h2 style="text-align: left;">Contact Us</h2>
	<table align="left">
		<form:form modelAttribute="contact" name="myform"
			action="../../home/contact-us/check" method="post">
			<tr>
				<td><label>Full Name:</label></td>
				<td><form:input path="fullName"></form:input></td>
			</tr>

			<tr>
				<td><label>Email:</label></td>
				<td><form:input path="emailId"></form:input></td>
			</tr>

			<tr>
				<td><label>Description:</label></td>
				<td><textarea id="description" name="description"
						placeholder="Write something.." style="height: 170px"></textarea></td>
			</tr>

			<tr>
				<td><input type="submit" style="float: left"></input></td>
			</tr>
		</form:form>
	</table>


</body>
</html>