<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
<c:url var="home" value="/" scope="request"></c:url>
<link rel="stylesheet" href="${home}resources/css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${home}/resources/js/123abc.js"></script>
<title>View or Update Records</title>
    
<script type="text/javascript">
</script>
</head>
<body>
	<center><h1>Crud : View or Update Records</h1></center>
	<c:import url="common.jsp"></c:import>
	<div class="container-fluid">
	
		<div class="form-body form-mod">
			<div><h4>Search Using</h4></div>
			<form id="form-search" action="search" method="GET">
			<div  class="row">
			<div class="col-lg-4">
				<label class="radio-inline"><input type="radio" name="searchtype" value="id">Employee Id :</label>
				<label class="radio-inline"><input type="radio" checked="checked" name="searchtype" value="name">First Name</label>
				<label class="radio-inline"><input type="radio" name="searchtype" value="email">Email</label>
				<label class="radio-inline"><input type="radio" name="searchtype" value="contact">Contact</label>
			</div>				
				<div class="col-lg-4"><input class="form-control" type="text" name="searchParam">
				
				</div>
				</div>
			</form>
	</div>
	
		<div class="row view-row">
			<div class="col-sm-1 demo">ID</div>
			<div class="col-sm-1 demo">First Name</div>
			<div class="col-sm-1 demo">Last Name</div>
			<div class="col-sm-1 demo">Contact</div>
			<div class="col-sm-1 demo">Email</div>
			<div class="col-sm-1 demo">D.O.B</div>
			<div class="col-lg-1 demo">Username</div>
			<div class="col-sm-1 demo">Salary</div>
			<div class="col-sm-1 demo">Gender</div>
			<div class="col-sm-1 demo">Status</div>
			<div class="col-sm-1 demo">Role</div>			
		</div>
<%-- 								${user } --%>
		<div class="form-body form-mod">
				<c:forEach items="${employeelist}" var="val" varStatus="i">
		
				<form:form id="form-${i.index}" action="Update" method="post" modelAttribute="user">

                    <div id="${i.index}" class="row view-row">
					
					<div class="debug col-sm-1 input-col">
						<form:label path="employee.ID">${val.ID}</form:label>
						<form:hidden path="employee.ID" value="${val.ID}"/>
					</div>

					<div class="col-sm-1 input-col">
						<form:input id="emp-first-name-${i.index}" disabled="true" path="employee.firstName" value="${val.firstName}"/>
						<div class="wall" style="position:absolute; left:0; right:0; top:0; bottom:0;"></div>
					</div>

					<div class="col-sm-1 input-col">
						<form:input id="emp-last-name-${i.index}" disabled="true" path="employee.lastName" value="${val.lastName}"/>
						<div class="wall" style="position:absolute; left:0; right:0; top:0; bottom:0;"></div>
					</div>

					<div class="col-sm-1 input-col">
						<form:input id="emp-contact-${i.index}" disabled="true" path="employee.Contact" value="${val.contact}"/>
						<div class="wall"  style="position:absolute; left:0; right:0; top:0; bottom:0;"></div>
					</div>

					<div class="col-sm-1 input-col">
						<form:input id="emp-email-${i.index}" disabled="true" path="employee.Email" value="${val.email}"/>
						<div class="wall"  style="position:absolute; left:0; right:0; top:0; bottom:0;"></div>
					</div>

					<div class="col-sm-1 input-col">
						<form:input id="emp-dob-${i.index}" disabled="true" path="employee.DateOfBirth" value="${val.dateOfBirth}"/>
						<div class="wall"  style="position:absolute; left:0; right:0; top:0; bottom:0;"></div>
					</div>

					<div class="col-sm-1 input-col">
						<form:input id="emp-username-${i.index}" disabled="true" path="user.username" value="${val.user.username}"/>
						<div class="wall"  style="position:absolute; left:0; right:0; top:0; bottom:0;"></div>
					</div>

					<div class="col-sm-1 input-col">
						<form:input id="emp-sal-${i.index}" disabled="true" path="" value=""/>
						<div class="wall"  style="position:absolute; left:0; right:0; top:0; bottom:0;"></div>
					</div>

					<div class="col-sm-1 input-col">
						<form:input id="emp-username-${i.index}" disabled="true" path="employee.gender" value="${val.gender}"/>
						<div class="wall"  style="position:absolute; left:0; right:0; top:0; bottom:0;"></div>
					</div>
					<div class="col-sm-1 input-col">
						<form:input path="status.statusName" disabled="true" value="${val.user.statusId.statusName}"/>
						<div class="wall"  style="position:absolute; left:0; right:0; top:0; bottom:0;"></div>
					</div>

					<div class="col-sm-1 input-col">
						<input type="text" >
					</div>
					<div class="col-sm-1 update-btn">		
						<input id="submit-${i.index }" type="submit" name="submit" value="submit" class="btn btn-info btn-xs up">
						<button id="btn-${i.index}" class="btn btn-info btn-xs up" type="button"  name="Edit">Edit</button>
					</div>
					<div class="col-sm-1 cancel-btn">	
						<button id="Cancelbtn-${i.index}" class="btn btn-info btn-xs cnc" type="button"  name="Cancel">X</button>
					</div>
					
					</div>
					
				</form:form>
				</c:forEach>
		</div>
	</div>
	${_csrf.token}
</body>
</html>
