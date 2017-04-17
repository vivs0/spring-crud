<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
<c:url var="home" value="/" scope="request"></c:url>
<link rel="stylesheet" href="${home}/resources/css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	});
</script>
<title>Home</title>
</head>
<body>
	<h1>CRUD Demo using Spring-Hibernate-JSon</h1>
	${form}
	<div class="container">
		<div class="form-body form-mod">
			<form:form method="post" action="Register" modelAttribute="form">
				<div class="form-group row">
					<div class="col-md-2"><label for="employee.firstName">First Name :</label></div>
					<div class="col-md-3"><form:input path="employee.firstName" class="form-control" placeholder="First Name"/>
					<form:errors path="employee.firstName" cssClass="errors"></form:errors>
					</div>
				</div>	
				<div class="form-group row">
					<div class="col-md-2"><label for="employee.lastName">Last Name :</label></div>
					<div class="col-md-3"><form:input path="employee.lastName" class="form-control" placeholder="Last Name"/></div>
				</div>	
				<div class="form-group row">
					<div class="col-md-2"><label for="employee.gender">Gender :</label></div>
					<div class="col-md-3">
					<c:forEach items="${gen}" var="g">
						<form:radiobutton path="employee.gender" value="${g}" />${g.name}
					</c:forEach>
					<form:errors path="employee.gender" cssClass="errors"></form:errors>
					</div>
				</div>	
				<div class="form-group row">
					<div class="col-md-2"><label for="employee.Contact">Contact No. :</label></div>
					<div class="col-md-3"><form:input  path="employee.Contact" id="contact" class="form-control" placeholder="Contact"/>
					<form:errors path="employee.Contact" cssClass="errors"></form:errors>
					</div>
				</div>	
				<div class="form-group row">
					<div class="col-md-2"><label for="employee.Contact">Email :</label></div>
					<div class="col-md-3"><form:input  path="employee.Email" id="contact" class="form-control" placeholder="Contact"/>
					<form:errors path="employee.Email" cssClass="errors"></form:errors>
					</div>
				</div>	
				<div class="form-group row">
					<div class="col-md-2"><label for="employee.DateOfBirth">Date of Birth</label></div>
					<div class="col-md-3">
					<form:input path="employee.DateOfBirth" class="form-control" placeholder="DD-MM-YYYY" ></form:input>
					<form:errors path="employee.DateOfBirth" cssClass="errors"></form:errors>
					</div>
				</div>	
				<div class="form-group row">
					<div class="col-md-2"><label for="user.username">Username</label></div>
					<div class="col-md-3">
						<form:password path="user.username" class="form-control" placeholder="Username"/>
						<form:errors path="user.username" cssClass="errors"></form:errors>
					</div>
				</div>	 
				<div class="form-group row">
					<div class="col-md-2"><label for="user.Password">Password</label></div>
					<div class="col-md-3">
						<form:password path="user.Password" class="form-control" placeholder="Password"/>
						<form:errors path="user.Password" cssClass="errors"></form:errors>
					</div>
				</div>	 
				<div class="form-group row">
					<div class="col-md-2"><label for="">Password</label></div>
					<div class="col-md-3">
						<form:password path="" class="form-control" placeholder="Re-Password"/>
						<form:errors path="" cssClass="errors"></form:errors>
					</div>
				</div>	 
				<div class="form-group row">
					<div class="col-md-2"><input type="submit" class="btn btn-primary"></div>
				</div>	
			</form:form>	
				
			<div><h1>${status}</h1></div>
		</div>
	</div>
</body>
</html>
