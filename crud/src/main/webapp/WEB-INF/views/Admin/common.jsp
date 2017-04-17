<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<spring:message code="user.logged"/>:<sec:authentication property="name" var="user"/>${user}<sec:authentication property="authorities"/>
<br/>
<br/>
<c:set value="${user}" var="userpage" scope="application"></c:set>
	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
	  <input type="hidden"
		name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	</form>
<a href="javascript:logout()"><spring:message code="user.logout"/></a>
	<script>
		function logout() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	