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

	<h3 align="center">All Biding List</h3>

	<table align="center" border="1" width="50%">
		<tr>
			<th>Biding Id</th>
			<th>Car Number</th>
			<th>Car Model</th>
			<th>Car Biding price</th>
			<th>userName</th>
			<th>Test Drive date</th>
			<th>Biding Status</th>
			<th>Accept Biding</th>
			
		</tr>

		<c:forEach var="x" items="${response}">
			<tr>
				<td><c:out value="${x.getBidingId()}" /></td>
				<td><c:out value="${x.getCarNumber()}" /></td>
				<td><c:out value="${x.getCarModel()}" /></td>
				<td><c:out value="${x.getCarBidingPrice()}" /></td>
				<td><c:out value="${x.getUserName()}" /></td>
				<td><c:out value="${x.getDate()}" /></td>
				<td><a
					href="<c:url value='http://localhost:8081/car/biding/deactive/${x.getCarNumber()}'/>">Currently
						status ACTIVE. Click here to Deactivate</a></td>
				<td><a
					href="<c:url value='http://localhost:8081/car/biding/transaction/${x.getCarNumber()}/${x.getCarModel()}/${x.getCarBidingPrice()}/${x.getUserName()}'/>">Click to accept the Biding</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

