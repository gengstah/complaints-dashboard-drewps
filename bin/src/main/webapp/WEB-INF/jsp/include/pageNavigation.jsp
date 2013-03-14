<%@ include file="headers.jsp" %>
<td>
	<c:if test="${ not (page <= 1) }">
		<a id="backButton" href="#">&lt;&lt; <fmt:message key="backLink" /></a>
	</c:if>
	<select id="page" name="page">
		<c:forEach var="p" begin="1" end="${ pages }" >
			<c:choose>
				<c:when test="${ p == page }">
					<option value="${ p }" selected>${ p }</option>
				</c:when>
				<c:otherwise>
					<option value="${ p }">${ p }</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
	<c:if test="${ page != pages && pages > 0 }">
		<a id="nextButton" href="#"><fmt:message key="nextLink" /> &gt;&gt;</a>
	</c:if>
</td>