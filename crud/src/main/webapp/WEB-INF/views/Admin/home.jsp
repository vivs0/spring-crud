<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>
<html>
<head>
<c:url var="home" value="/" scope="request"></c:url>
<link rel="stylesheet" href="${home}resources/css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Title</title>
	<script>
		function Submit() {
			document.getElementById("form").submit();
		}
	</script>
</head>
<body>
	<h1>User Panel</h1>
	<div class="row">
		<c:import url="common.jsp"></c:import>
		<form action="<c:url value="ViewUpdate"></c:url>" id="form" method="post">
		<div class="col-md-2"><a href="<c:url value="javascript:Submit()"></c:url>">View / Edit</a></div>
		<div class="col-md-2"><a href="">Add New</a></div>
	  <input type="hidden"
		name="${_csrf.parameterName}"
		value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>
