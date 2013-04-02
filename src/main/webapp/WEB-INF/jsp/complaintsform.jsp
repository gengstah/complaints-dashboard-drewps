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
		<table border="1" class="altrowstable" width="1080">
			<%-- <tr>
				<td><%@ include file="include/banner.jsp" %></td>
			</tr> --%>
			<tr>
				<td><%@ include file="include/menu.jsp" %></td>
			</tr>
			<tr>
				<td>
					<form:form method="POST" commandName="complaint">
						<form:hidden path="id" autocomplete="off" maxlength="15" />
						<form:hidden path="finalStatus" autocomplete="off" maxlength="15" />
						<table class="altrowstable">
							<tbody>
								<tr>
									<td colspan="2" align="left">
										<form:errors path="*" />
									</td>
								</tr>
								<tr>
									<td align="left"><fmt:message key="ticketNo" />:</td>
									<td align="left"><form:input path="ticketNo" autocomplete="off" maxlength="50" /></td>
								</tr>
								<tr>
									<td align="left"><fmt:message key="client" />:</td>
									<td align="left"><form:input path="client" autocomplete="off" maxlength="50" /></td>
								</tr>
								<tr>
									<td align="left"><fmt:message key="date" />:</td>
									<td align="left"><form:input path="date" readonly="true" /></td>
								</tr>
								<tr>
									<td align="left"><fmt:message key="remarksAndAnalysis" />:</td>
									<td align="left"><form:textarea path="remarksAndAnalysis" rows="10" cols="30" /></td>
								</tr>
								<tr>
									<td align="left"><fmt:message key="responsibleTeam" />:</td>
									<td align="left"><form:input path="responsibleTeam" autocomplete="off" maxlength="50" /></td>
								</tr>
								<tr>
									<td align="left"><fmt:message key="status" />:</td>
									<td align="left"><form:input path="status" autocomplete="off" maxlength="50" /></td>
								</tr>
								<tr>
									<td align="left"><fmt:message key="rsagOwner" />:</td>
									<td align="left"><form:input path="rsagOwner" autocomplete="off" maxlength="50" /></td>
								</tr>
								<tr><td colspan="2">&nbsp;</td></tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="2" align="left">
										<c:if test="${ not empty complaint.id }">
											<c:if test="${ complaint.finalStatus == 'OPEN' }">
												<input id="deleteComplaintButton" type="button" value="<fmt:message key="delete" />" onclick="window.location = '<c:url value='/webapp/secured/admin/complaint/remove/${ complaint.id }' />';" />
												<input id="submitComplaintButton" type="button" value="<fmt:message key="submit" />" />
											</c:if>
											<c:if test="${ complaint.finalStatus == 'CLOSED' }">
												<input id="reopenComplaintButton" type="button" value="<fmt:message key="reopen" />" onclick="window.location = '<c:url value='/webapp/secured/admin/complaint/reopen/${ complaint.id }' />';" />
												<input id="removeComplaintPermanentlyButton" type="button" value="<fmt:message key="delete" />" onclick="window.location = '<c:url value='/webapp/secured/admin/complaint/remove-permanent/${ complaint.id }' />';" />
											</c:if>
										</c:if>
										<c:if test="${ empty complaint.id }">
											<input id="submitComplaintButton" type="button" value="<fmt:message key="submit" />" />
										</c:if>
										<input id="cancelComplaintButton" type="button" value="<fmt:message key="cancel" />" onclick="window.location = '<c:url value='/webapp/secured/complaints' />';" />
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