<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html"%>

<html>
<marquee width="100%" behavior="scroll" bgcolor="#00ffff">
	Car Sale Website </marquee>
<head>

<title>Update Profile</title>
</head>
<body bgcolor="#87ceff">
	<!-- <script>
		function validateform() {
			var firstName = document.myform.firstName.value;
			var lastName = document.myform.lastName.value;
			var mobileNumber = document.myform.mobileNumber.value;
			var email = document.myform.emailId.value;

			if (firstName == "") {
				alert("First Name is Mandatory");
				return false;
			}

			if (lastName == "") {
				alert("Last Name is Mandatory");
				return false;
			}

			if (mobileNumber == "") {
				alert("Mobile Number is Mandatory");
				return false;
			}

			if (email == "") {
				alert("Email is Mandatory");
				return false;
			}
		}
	</script> -->

	<form align='center'
		action='http://localhost:8081/home/page'>
		<div align='center'>
			<input type='submit' value='Home' />
		</div>
	</form>

	<%-- <form align='center'
		action='http://localhost:8080/communityportal/user/get/profile/${userId}'>
		<div align='center'>
			<input type='submit' value='Profile' />
		</div>
	</form> --%>

	<form align='center'
		action='http://localhost:8081/user/logout'>
		<div align='center'>
			<input type='submit' value='Logout' />
		</div>
	</form>

	<h3 style="text-align: center">User Details Update Form</h3>

	<table align="center">

		<form:form modelAttribute="user" name="myform"
			action="../../user/update/check" method="post"
			onsubmit="return validateform()">

			<tr>
				<td><label>Name:</label></td>
				<td><form:input path="name"></form:input></td>
			</tr>

			<tr>
				<td><label>Mobile Number:</label></td>
				<td><form:input path="mobileNumber"></form:input></td>
			</tr>

			<tr>
				<td><label>Email:</label></td>
				<td><form:input path="emailId"></form:input></td>
			</tr>

			<tr>
				<td><label>User Name:</label></td>
				<td><form:input path="userName" placeholder = "Mandetory and cant update"></form:input></td>
			</tr>

			<tr>
				<td><label>Password:</label></td>
				<td><form:input type="password" path="password"></form:input></td>
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