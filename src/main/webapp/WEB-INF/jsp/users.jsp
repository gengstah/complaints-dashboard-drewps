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
	<table border="1" class="altrowstable">
		<%-- <tr>
			<td><%@ include file="include/banner.jsp" %></td>
		</tr> --%>
		<tr>
			<td><%@ include file="include/menu.jsp" %></td>
		</tr>
		<%-- <tr>
			<td>
				<table>
					<tbody>
						<tr>
							<td align="left"><fmt:message key="companyName" />:</td>
							<td align="left"><input id="searchCompanyName" name="searchCompanyName" type="text" value="${ searchCompanyName }" /></td>
						</tr>
						<tr>
							<td align="left"><fmt:message key="accountNo" />:</td>
							<td align="left"><input id="searchAccountNo" name="searchAccountNo" type="text" value="${ searchAccountNo }" /></td>
						</tr>
						<tr>
							<c:import url="include/itemPerPage.jsp" />
						</tr>
						<tr>
							<td colspan="2" align="right">
								<input id="searchButton" name="searchButton" type="button" value="<fmt:message key="filterButton" />" />
								<input id="clearButton" name="clearButton" type="button" value="<fmt:message key="clearButton" />" />
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr> --%>
		<tr>
			<td>
				<table width="1080">
					<thead>
						<tr class="evenrowcolor">
							<th><font color="#FFFFFF"><fmt:message key="username" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="name" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="description" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="roles" /></font></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ users }" var = "user" varStatus="status">
							<tr onMouseOver="this.className='highlight'" onMouseOut="this.className=''" onclick="window.location = '<c:url value='/webapp/secured/admin/user/update/${ user.username }' />';">
								<td>${ user.username }</td>
								<td>${ user.name }</td>
								<td>${ user.description }</td>
								<td>${ user.roles }</td>
							</tr>
						</c:forEach>
						<tr><td colspan="4">&nbsp;</td></tr>
					</tbody>
					<tfoot>
						<%-- <tr>
							<c:import url="include/pageNavigation.jsp" />
						</tr> --%>
						<tr>
							<td colspan="4" align="left">
								<input id="addUserButton" type="button" value="<fmt:message key="addUserButton" />" onclick="window.location = '<c:url value='/webapp/secured/admin/user/new' />';" />
							</td>
						</tr>
					</tfoot>
				</table>
			</td>
		</tr>
	</table>
</div>
</body>
</html>