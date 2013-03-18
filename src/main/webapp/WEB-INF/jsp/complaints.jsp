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
<script type="text/javascript" src="<c:url value="/js/complaint.js" />"></script>
</head>
<body class = "standard">
<div align="center">
<form id="complaintForm" name="complaintForm" method="POST" action="<c:url value = "/webapp/secured/complaints"/>">
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
							<th><font color="#FFFFFF"><fmt:message key="id" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="ticketNo" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="client" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="date" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="remarksAndAnalysis" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="responsibleTeam" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="status" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="rsagOwner" /></font></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ openComplaints }" var = "openComplaint" varStatus="status">
							<tr onMouseOver="this.className='highlight'" onMouseOut="this.className=''" onclick="window.location = '<c:url value='/webapp/secured/admin/complaint/update/${ openComplaint.id }' />';">
								<td>${ status.count }</td>
								<td>${ openComplaint.ticketNo }</td>
								<td>${ openComplaint.client }</td>
								<td><fmt:formatDate type="date" dateStyle="short" value="${ openComplaint.date }" /></td>
								<td>${ openComplaint.remarksAndAnalysis }</td>
								<td>${ openComplaint.responsibleTeam }</td>
								<td>${ openComplaint.status }</td>
								<td>${ openComplaint.rsagOwner }</td>
							</tr>
						</c:forEach>
						<tr><td colspan="8">&nbsp;</td></tr>
					</tbody>
					<tfoot>
						<%-- <tr>
							<c:import url="include/pageNavigation.jsp" />
						</tr> --%>
						<tr>
							<td colspan="8" align="left">
								<input id="addComplaintButton" type="button" value="<fmt:message key="addComplaintButton" />" onclick="window.location = '<c:url value='/webapp/secured/admin/complaint/new' />';" />
							</td>
						</tr>
					</tfoot>
				</table>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>
				<table width="1080">
					<thead>
						<tr class="evenrowcolor">
							<th><font color="#FFFFFF"><fmt:message key="id" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="ticketNo" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="client" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="date" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="remarksAndAnalysis" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="responsibleTeam" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="status" /></font></th>
							<th><font color="#FFFFFF"><fmt:message key="rsagOwner" /></font></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ closedComplaints }" var = "closedComplaint" varStatus="status">
							<tr onMouseOver="this.className='highlight'" onMouseOut="this.className=''" onclick="window.location = '<c:url value='/webapp/secured/admin/complaint/update/${ closedComplaint.id }' />';">
								<td>${ status.count }</td>
								<td>${ closedComplaint.ticketNo }</td>
								<td>${ closedComplaint.client }</td>
								<td><fmt:formatDate type="date" dateStyle="short" value="${ closedComplaint.date }" /></td>
								<td>${ closedComplaint.remarksAndAnalysis }</td>
								<td>${ closedComplaint.responsibleTeam }</td>
								<td>${ closedComplaint.status }</td>
								<td>${ closedComplaint.rsagOwner }</td>
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