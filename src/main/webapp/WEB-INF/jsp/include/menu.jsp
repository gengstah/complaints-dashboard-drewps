<%@ include file="headers.jsp" %>
<div class="menu-container">
	<ul class="memu">
		<li class="memu-root">
			<a href="<c:url value="/" />"><fmt:message key="home" /></a>
		</li>
		<%-- <li class="memu-root">
			<a href="<c:url value="#" />"><fmt:message key="clients" /></a>
			<ul>
				<li><a href="<c:url value="/secured/admin/companies/list.html" />"><fmt:message key="clientsListview" /></a></li>
				<li><a href="<c:url value="/secured/admin/companies/addcompany.html" />"><fmt:message key="newClient" /></a></li>
			</ul>
		</li>
		<li class="memu-root">
			<a href="<c:url value="#" />"><fmt:message key="projects" /></a>
			<ul>
				<li><a href="<c:url value="/secured/admin/projects/list.html" />"><fmt:message key="projectsListview" /></a></li>
				<li><a href="<c:url value="/secured/admin/projects/addproject.html" />"><fmt:message key="newProject" /></a></li>
			</ul>
		</li>
		<li class="memu-root">
			<a href="<c:url value="#" />"><fmt:message key="purchaseOrders" /></a>
			<ul>
				<li><a href="<c:url value="/secured/purchaseorders/list.html" />"><fmt:message key="purchaseOrdersListview" /></a></li>
				<li><a href="<c:url value="/secured/purchaseorders/addpurchaseorder.html" />"><fmt:message key="newPurchaseOrder" /></a></li>
			</ul>
		</li>
		<li class="memu-root">
			<a href="<c:url value="#" />"><fmt:message key="weeklyPayrolls" /></a>
			<ul>
				<li><a href="<c:url value="/secured/weeklypayrolls/list.html" />"><fmt:message key="weeklyPayrollsListview" /></a></li>
				<li><a href="<c:url value="/secured/weeklypayrolls/addweeklypayroll.html" />"><fmt:message key="newWeeklyPayroll" /></a></li>
			</ul>
		</li>
		<li class="memu-root">
			<a href="<c:url value="#" />"><fmt:message key="miscellaneousExpenses" /></a>
			<ul>
				<li><a href="<c:url value="/secured/miscellaneousexpenses/list.html" />"><fmt:message key="miscellaneousExpensesListview" /></a></li>
				<li><a href="<c:url value="/secured/miscellaneousexpenses/addmiscellaneousexpense.html" />"><fmt:message key="newMiscellaneousExpense" /></a></li>
			</ul>
		</li> --%>
		<li class="memu-root">
			<a href="<c:url value="/webapp/secured/logout" />"><fmt:message key="logout" /></a>
		</li>
	</ul>
</div>