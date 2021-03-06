<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.carsale.application.entity.User"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body bgcolor="#FFF8DC">
	<form align='center' action='http://localhost:8081/home/page'>
		<div align='center'>
			<input type='submit' value='Home' />
		</div>
	</form>
	
	<form align='center' action='http://localhost:8081/user/logout'>
		<div align='center'>
			<input type='submit' value='Logout' />
		</div>
	</form>

	<h3 align="center">Users Car Posts List</h3>

	<table align="center" border="1" width="50%">
		<tr>
			<th>Id</th>
			<th>Car Number</th>
			<th>Car Model</th>
			<th>Car Estimated Price</th>
			<th>Registration Year</th>
			<th>Upload Photo</th>
			<th>Car Status</th>
		</tr>

		<c:forEach var="x" items="${cars}">
			<tr>
				<td><c:out value="${x.getCarId()}" /></td>
				<td><c:out value="${x.getCarNumber()}" /></td>
				<td><c:out value="${x.getCarModel()}" /></td>
				<td><c:out value="${x.getPrice()}" /></td>
				<td><c:out value="${x.getRegistrationYear()}" /></td>
				<td><img
					src="/imagedata/<c:out value="${x.getfile()}" />"
					height="200px" width="200px" /></td>
				<td><a
					href="<c:url value='http://localhost:8081/car/status/update/${x.getCarNumber()}'/>">Currently
						status ACTIVE. Click here to Deactivate</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

