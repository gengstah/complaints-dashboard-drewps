<%@ include file="headers.jsp" %>
<div class="menu-container">
	<ul class="memu">
		<li class="memu-root">
			<a href="<c:url value="/" />"><fmt:message key="home" /></a>
		</li>
		<li class="memu-root">
			<a href="<c:url value="/secured/admin/projects/list.html" />"><fmt:message key="login" /></a>
		</li>
	</ul>
</div>