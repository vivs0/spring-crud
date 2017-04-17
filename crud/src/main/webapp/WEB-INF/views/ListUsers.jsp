<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
<c:url var="home" value="/" scope="request"></c:url>
<link rel="stylesheet" href="home/resources/css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	.col-md-6{
		background-color: blue;
		width:12%;
		margin-left:5px; 
	}
	.container{
	background-color: Red;
	width:100%;
	}
</style>
<title>Title</title>
</head>
<body>
	<div class="container">
	<h1>CRUD Demo using Spring-Hibernate-JSon</h1>
	<c:if test="${!empty list}">
		<div class="row">
			<div class="col-md-6">First Name</div>
			<div class="col-md-6">Last Name</div>
			<div class="col-md-6">Contact</div>
			<div class="col-md-6">Email </div>
			<div class="col-md-6">Date of Birth</div>
			<div class="col-md-6">Date of Joining</div>
			<div class="col-md-6">Salary</div>
		</div>
		<c:forEach items="${list}" var="user">
		<div class="row">
			<div class="col-md-6">${user.first_Name}</div>
			<div class="col-md-6">${user.last_Name}</div>
			<div class="col-md-6">${user.contact}</div>
			<div class="col-md-6">${user.email}</div>
			<div class="col-md-6">${user.dateOfBirth}</div>
			<div class="col-md-6">${user.dateOfJoining}</div>
			<div class="col-md-6">${user.salary}</div>		
		</div>
		</c:forEach>
		</c:if>
	</div>
</body>
</html>
