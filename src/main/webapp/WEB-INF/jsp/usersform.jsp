<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/headers.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="complaintsDashboardTitle" /></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/menu.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery-ui-1.8.16.custom.css" />">
<script type="text/javascript" src="<c:url value="/js/jquery-1.6.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.8.16.custom.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/user.js" />"></script>
</head>
<body class = "standard">
	<div align="center">
		<table border="1" class="altrowstable" width="1080">
			<%-- <tr>
				<td><%@ include file="include/banner.jsp" %></td>
			</tr> --%>
			<tr>
				<td><%@ include file="include/menu.jsp" %></td>
			</tr>
			<tr>
				<td>
					<form:form method="POST" commandName="user">
						<form:hidden path="username" autocomplete="off" maxlength="15" />
						<table class="altrowstable">
							<tbody>
								<tr>
									<td colspan="2" align="left">
										<form:errors path="*" />
									</td>
								</tr>
								<tr>
									<td align="left"><fmt:message key="username" />:</td>
									<c:if test="${ not empty user.username }">
										<td align="left">${ user.username }</td>
									</c:if>
									<c:if test="${ empty user.username }">
										<td align="left"><form:input path="username" autocomplete="off" maxlength="50" /></td>
									</c:if>
								</tr>
								<tr>
									<td align="left"><fmt:message key="name" />:</td>
									<td align="left"><form:input path="name" autocomplete="off" maxlength="50" /></td>
								</tr>
								<tr>
									<td align="left"><fmt:message key="description" />:</td>
									<td align="left"><form:input path="description" autocomplete="off" maxlength="50" /></td>
								</tr>
								<tr>
									<td align="left"><fmt:message key="roles" />:</td>
									<td align="left">
										<form:checkboxes items="${ roleList }" path="roles" itemLabel="description" itemValue="roleName" />
										
										<%-- <c:forEach items="${ roleList }" var="role">
											<form:label path="roles" />
											<form:checkbox path="roles" value="${ role.roleName }" label="${ role.description }" />
										</c:forEach> --%>
									</td>
								</tr>
								<tr><td colspan="2">&nbsp;</td></tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="2" align="left">
										<input id="deleteUserButton" type="button" value="<fmt:message key="delete" />" onclick="window.location = '<c:url value='/webapp/secured/admin/user/remove/${ user.username }' />';" />
										<input id="submitUserButton" type="button" value="<fmt:message key="submit" />" />
										<input id="cancelUserButton" type="button" value="<fmt:message key="cancel" />" onclick="window.location = '<c:url value='/webapp/secured/admin/users' />';" />
									</td>
								</tr>
							</tfoot>
						</table>
					</form:form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>