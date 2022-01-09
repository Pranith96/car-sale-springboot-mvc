<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.carsale.application.entity.User"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body bgcolor="#FFF8DC">
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

	<h3 align="center">Users Detail List</h3>

	<table align="center" border="1" width="50%">
		<tr>
			<th>USER Profile View</th>
			<th>NAME</th>
			<th>EMAIL ID</th>
		</tr>

		<c:forEach var="x" items="${users}">
			<tr>
				<td><a
					href="<c:url value='http://localhost:8081/user/get/profile/${x.getUserId()}'/>">View
						Profile</a></td>
				<td><c:out value="${x.getName()}" /></td>
				<td><c:out value="${x.getEmailId()}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

