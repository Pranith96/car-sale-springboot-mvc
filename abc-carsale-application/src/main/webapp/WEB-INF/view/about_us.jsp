<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>About Us</title>

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

.firstsection {
	background-color: #FFF8DC;
	height: 605px;
}

.box-main {
	display: flex;
	justify-content: center;
	align-items: center;
	color: black;
	max-width: 80%;
	margin: auto;
	height: 80%;
}

.firsthalf {
	width: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.text-big {
	font-family: 'Piazzolla', serif;
	font-weight: bold;
	font-size: 35px;
}

.text-small {
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

.section {
	height: 400px;
	display: flex;
	align-items: center;
	justify-content: center;
	max-width: 90%;
	margin: auto;
}

.center {
	text-align: center;
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
			<li><a
				href="http://localhost:8081/home/page">Home</a></li>
			<li><a href="http://localhost:8081/user/logout">Logout</a></li>
		</ul>
	</nav>

	<section class="firstsection">
		<div class="box-main">
			<div class="firstHalf">
				<h1 class="text-big" id="vision">About Us:</h1>
				<p class="text-small">Our Culture in company, we are constantly
					iterating, solving problems and working together to connect people
					all over the world. ABC Cars Private Ltd was incorporated in the year 2022, under the many dynamic leaderships.
					Its Head quaters located in India.
					The company assembled about 2000 Leyland vehicles at its Kurla Works.
					In addition to marketing, the company was also engaged in CKD assembly of Leyland vehicles.
					The company thereafter took up marketing of products manufactured by Ashok Leyland in the states of Maharashtra, Andhra Pradesh,Tamil Nadu and Gujarat, Mahindra in Andhra Pradesh and Gujarat.
					Kobelco, a giant in the construction equipment sector has been added.</p>
			</div>
		</div>
	</section>

	<footer class="background">
		<p class="text-footer">Copyright ©-All rights are reserved</p>
	</footer>
</body>
</html>