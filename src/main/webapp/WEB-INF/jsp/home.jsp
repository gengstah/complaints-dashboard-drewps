<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/headers.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="complaintsDashboardHeader" /></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/menu.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery-ui-1.8.16.custom.css" />">
<script type="text/javascript" src="<c:url value="/js/jquery-1.6.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.8.16.custom.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/companypage.js" />"></script>
</head>
<body class = "standard">
<div align="center">
<form id=""complaintForm"" name="complaintForm" method="POST" action="<c:url value = "/secured/admin/companies/list.html"/>">
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
				<table width="790">
					<thead>
						<tr class="evenrowcolor">
							<th><font color="#FFFFFF"><fmt:message key="number" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="ticketNo" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="client" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="date" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="remarksAnalysis" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="responsibleTeam" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="status" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="rsagOwner" /></font></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ complaints }" var = "complaint" varStatus="status">
							<tr onMouseOver="this.className='highlight'" onMouseOut="this.className=''" onclick="window.location = '<c:url value='/secured/admin/companies/companyinfo.html?companyAccountNo=${ company.accountNo }' />';">
								<td>${ complaint.id }</td>
								<td>${ complaint.ticketNo }</td>
								<td>${ complaint.client }</td>
								<td><fmt:formatDate type="date" dateStyle="short" value="${ complaint.date }" /></td>
								<td>${ complaint.remarksAndAnalysis }</td>
								<td>${ complaint.responsibleTeam }</td>
								<td>${ complaint.status }</td>
								<td>${ complaint.rsagOwner }</td>
							</tr>
						</c:forEach>
						<tr><td colspan="8">&nbsp;</td></tr>
					</tbody>
					<%-- <tfoot>
						<tr>
							<c:import url="include/pageNavigation.jsp" />
						</tr>
						<tr>
							<td colspan="6" align="left">
								<input id="addCompanyButton" type="button" value="<fmt:message key="addCompanyButton" />" onclick="window.location = '<c:url value='/secured/admin/companies/addcompany.html' />';" />
							</td>
						</tr>
					</tfoot> --%>
				</table>
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>