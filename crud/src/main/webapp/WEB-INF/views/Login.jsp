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
<title>Title</title>
</head>
<body>
	<h1>CRUD Demo using Spring-Hibernate-JSon</h1>
	<div class="container">
		<div class="form-body form-login">
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty message}">
			<div class="msg">${message}</div>
		</c:if>
			<form action="login" method="post">
				<input type="text" name="username"/>
				<input type="password" name="password"/>
				<input type="submit" value="Login">
		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			</form>
		</div>
	</div>
</body>
</html>
