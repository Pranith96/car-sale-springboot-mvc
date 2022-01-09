<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<html>

<head>
<title>Car Sale Website</title>

<style>
* {
	margin: 0;
	padding: 0;
}

.navbar {
	display: flex;
	align-items: center;
	justify-content: center;
	position: sticky;
	top: 0;
	cursor: pointer;
}

.background {
	background: black;
	background-blend-mode: darken;
	background-size: cover;
}

.nav-list {
	width: 70%;
	display: flex;
	align-items: center;
}

.nav-list li {
	list-style: none;
	padding: 26px 30px;
}

.nav-list li a {
	text-decoration: none;
	color: white;
}

.nav-list li a:hover {
	color: grey;
}

.rightnav {
	width: 30%;
	text-align: right;
}

#search {
	padding: 5px;
	font-size: 17px;
	border: 2px solid grey;
	border-radius: 9px;
}

.box-main {
	display: flex;
	justify-content: center;
	align-items: center;
	color: black;
	max-width: 80%;
	margin: auto;
	height: 605px;
}

.firsthalf {
	width: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.heading-mission {
	font-family: 'Piazzolla', serif;
	font-weight: bold;
	font-size: 35px;
}

.text-mission {
	font-size: 18px;
	padding-bottom: 100px;
}

.heading-vission {
	font-family: 'Piazzolla', serif;
	font-weight: bold;
	font-size: 35px;
}

.text-vision {
	font-size: 18px;
}

.btn {
	padding: 8px 20px;
	margin: 7px 0;
	border: 2px solid white;
	border-radius: 8px;
	background: none;
	color: white;
	cursor: pointer;
}

.btn-sm {
	padding: 6px 10px;
	vertical-align: middle;
}

.text-footer {
	text-align: center;
	padding: 30px 0;
	font-family: 'Ubuntu', sans-serif;
	display: flex;
	justify-content: center;
	color: white;
}
</style>
</head>
<body>
	<nav class="navbar background">
		<ul class="nav-list">
			 <li><a href="http://localhost:8081/home/about-us">
					About Us</a></li>
			<%-- <li><a
				href="http://localhost:8080/communityportal/user/get/profile/${userId}">Profile</a></li> --%>
			
			<sec:authorize access="hasAnyRole('ADMIN')">
			<li><a
				href="http://localhost:8081/user/get/allUsers">Get
					All Users List</a></li>
			</sec:authorize>	
			<li><a
				href="http://localhost:8081/user/update/page">Update
					Profile</a></li>
			<sec:authorize access="hasAnyRole('ADMIN')">
			<li><a
				href="http://localhost:8081/car/fetch-details">View Car Sales
					</a></li>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('USER')">
			<li><a
				href="http://localhost:8081/car/details-save/page">Car sale</a></li>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('USER')">
			<li><a
				href="http://localhost:8081/car/get-details/${userName}">View My Car Posts</a></li>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('USER')">
			<li><a
				href="http://localhost:8081/car/get/user/biding-detials/${userName}">View My Biding Posts</a></li>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('ADMIN')">
			<li><a
				href="http://localhost:8081/car/fetch/biding-details">View All Bidings
					</a></li>
			</sec:authorize>
			<li><a href="http://localhost:8081/home/contact-us/page">
					Contact Us</a></li>
					
			<li><a href="http://localhost:8081/user/logout">Logout</a></li>
		</ul>
		<div class="rightNav">
			<form:form modelAttribute="car" action="../../car/search"
				method="get">
				<input type="text" name="searchValue" placeholder = "Car Model or Registration Year">
				<button class="btn btn-sm">Search</button>
			</form:form>
		</div>
	</nav>
	<h3>${greeting}</h3>
	<div class="box-main">
		<div class="firstHalf">
			<h1 class="heading-mission">Mission:</h1>
			<p class="text-mission">ABC Car Sale pvt ltd Portal is an award-winning and
				leading provider of software in the industry. Our solutions boost
				productivity, lower costs and help users to communicate grow their
				businesses. We respect and value our team, and we look to bring the
				best talent together to make our future even stronger. our Company's
				culture encourages employees to create, think and challenge each
				other in a fast-paced environment. We are determined to shape, not
				follow, the rapidly changing in industry by transforming our
				products and services and identifying new ways to add value for our
				customers.</p>
			<h1 class="heading-vission">Vision:</h1>
			<p class="text-vision">ABC Car Sale pvt ltd Portal is about relationships,
				technology, communication, sales and services should make those relationships
				stronger. That's why, at this company, it's our mission to transform
				the way the industry operates by putting people at the heart of
				latest technology. By focusing on our customers, demanding
				operational excellence, and delivering results that make a
				difference, we provide the level of trust and security that every
				thing will be end to end encryption.</p>
		</div>
	</div>
	<footer class="background">
		<p class="text-footer">Copyright ©-All rights are reserved</p>
	</footer>
</body>
</html>

