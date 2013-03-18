<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@ include file="/WEB-INF/jsp/include/headers.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="errorPageTitle" /></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery-ui-1.8.16.custom.css" />">
<script type="text/javascript" src="<c:url value="/js/jquery-1.6.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.8.16.custom.min.js" />"></script>
</head>
<body class="standard">
	<h2>Unauthorized access</h2>
	<hr color="#51A51C" />
	<p title="Unauthorized Access">
		You are not authorized to access the resource you requested. You might need to have a
		higher level of access for you to be able to access this resource. <br />Please contact the
		administrator of the system.
	</p>
</body>
</html>