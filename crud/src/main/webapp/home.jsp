<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@ page session="false" %>
 --%>
 <html>
<head>
<spring:url value="/Admin" var="Admin"></spring:url>
<c:url var="home" value="/" scope="request"></c:url>
<link rel="stylesheet" href="${home}/resources/css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<body>
	<h1>CRUD Demo using Spring-Hibernate-JSon</h1>
	<div class="container">
		<a href="${Admin }">Admin</a>
	</div>
</body>
</html>
