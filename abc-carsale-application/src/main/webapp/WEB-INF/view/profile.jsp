<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.carsale.application.entity.User"%>

<html>
<marquee width="100%" behavior="scroll" bgcolor="#00ffff">
	Car Sale Portal Website </marquee>
<head>

<title>Profile</title>
</head>
<body bgcolor="#87ceff">
	<form align='center'
		action='http://localhost:8081/home/page'>
		<div align='center'>
			<input type='submit' value='Home' />
		</div>
	</form>

	<form align='center'
		action='http://localhost:8081/user/logout'>
		<div align='center'>
			<input type='submit' value='Logout' />
		</div>
	</form>
	<h3 style="text-align: center;">User Profile</h3>
	<table align="center">
		<tr>
			<th width="30%">User Id</th>
			<td width="2%">:</td>
			<td><c:out value="${user.getUserId()}" /></td>
		</tr>

		<tr>
			<th width="30%">Name</th>
			<td width="2%">:</td>
			<td><c:out value="${user.getName()}" /></td>
		</tr>

		<tr>
			<th width="30%">Mobile Number</th>
			<td width="2%">:</td>
			<td><c:out value="${user.getMobileNumber()}" /></td>
		</tr>

		<tr>
			<th width="30%">Email</th>
			<td width="2%">:</td>
			<td>${user.emailId}</td>
		</tr>

		<tr>
			<th width="30%">User Name</th>
			<td width="2%">:</td>
			<td>${user.userName}</td>
		</tr>

		<tr>
			<th width="30%">User Status</th>
			<td width="2%">:</td>
			<td>${user.status}</td>
		</tr>
	</table>



</body>
</html>