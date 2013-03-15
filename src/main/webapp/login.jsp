<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include/headers.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="loginPageTitle" /></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/menu.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery-ui-1.8.16.custom.css" />">
<script type="text/javascript" src="<c:url value="/js/jquery-1.6.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.8.16.custom.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/loginpage.js" />"></script>
</head>
<body class="standard">
<div align="center">
	<table border="1" class="altrowstable">
		<c:if test="${ not empty sessionScope.user }">
		<tr>
			<td><%@ include file="/WEB-INF/jsp/include/menu.jsp" %></td>
		</tr>
		</c:if>
	</table>
</div>

	<div id="loginDialog" title="Login">
		<form id="loginForm" action="j_security_check" method="POST">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="j_username" value="${username}" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="j_password" value="${password}" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>