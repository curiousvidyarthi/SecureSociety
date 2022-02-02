<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Secure Society</title>

<link rel="stylesheet" href="resources/css/angoor.css">
<link rel="stylesheet" href="resources/tp/css/fa-all.min.css">
<link rel="stylesheet" href="resources/tp/css/bootstrap.min.css">

<script src="resources/tp/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<div class="container-fluid row shadow-sm p-2">
		<div class="col-3">
			<a href="/securesociety">
				<img class="rounded" src="resources/tp/images/VivaCity.jfif"
					style="height: 70px;"></img>
			</a>
		</div>
		<div class="col d-flex align-items-center justify-content-center">
			<ul class="nav nav-pills" role="tablist">
				<li class="nav-item angr-nav-item">
					<a class="nav-link d-flex flex-column align-items-center"
						data-bs-toggle="pill" href="#forum">
						<i class="fas fa-blog"></i>
						Forum
					</a>
				</li>
				<li class="nav-item angr-nav-item">
					<a class="nav-link d-flex flex-column align-items-center"
						data-bs-toggle="pill" href="#dwellings">
						<i class="fas fa-home"></i>
						Dwellings
					</a>
				</li>
				<li class="nav-item angr-nav-item">
					<a class="nav-link d-flex flex-column align-items-center"
						data-bs-toggle="pill" href="#owners">
						<i class="fas fa-house-user"></i>
						Owners
					</a>
				</li>
				<li class="nav-item angr-nav-item">
					<a class="nav-link d-flex flex-column align-items-center"
						data-bs-toggle="pill" href="#payments">
						<i class="fas fa-file-invoice-dollar"></i>
						Payments
					</a>
				</li>
			</ul>
		</div>
		<div class="col-3 d-flex justify-content-end align-items-center pe-0">
			<div class="angr-search d-flex align-items-center">
				<input class="angr-search-input h-100" type="text" name=""
					placeholder="Search...">
				<a href="#" class="angr-search-icon">
					<i class="fa fa-search"></i>
				</a>
			</div>

			<div
				class="rounded-circle border ms-3 me-2 d-flex justify-content-center align-items-center"
				style="width: 50px; height: 50px">
				<i class="fas fa-user-tie fa-2x text-secondary"></i>
			</div>
		</div>
	</div>

	<!-- Tab panes -->
	<div class="tab-content">
		<div id="forum" class="container tab-pane active">
			<br>
			<h3>Forum</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		</div>
		<div id="dwellings" class="container tab-pane fade">
			<br>
			<h3>Dwellings</h3>
			<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
				laboris nisi ut aliquip ex ea commodo consequat.</p>
		</div>
		<div id="owners" class="container tab-pane fade">
			<br>
			<h3>Owners</h3>
			<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem
				accusantium doloremque laudantium, totam rem aperiam.</p>
		</div>
		<div id="payments" class="container tab-pane fade">
			<br>
			<h3>Payments</h3>
			<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem
				accusantium doloremque laudantium, totam rem aperiam.</p>
		</div>
	</div>
	<script>
		function myFunction(a, b) {
			alert(a + b);
		}
	</script>
</body>
</html>