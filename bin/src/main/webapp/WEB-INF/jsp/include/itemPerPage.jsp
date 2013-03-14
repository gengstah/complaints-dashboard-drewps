<%@ include file="headers.jsp" %>
<td align="left"><fmt:message key="itemPerPage" />:</td>
<td align="left">
	<select id="itemPerPage" name = "itemPerPage">
		<c:forEach var="i" begin="${ initParam.itemPerPageBegin }" end="${ initParam.itemPerPageEnd }" step="${ initParam.itemPerPageStep }">
			<c:choose>
				<c:when test="${ i == itemPerPage }">
					<option value="${ i }" selected="selected">${ i }</option>
				</c:when>
				<c:otherwise>
					<option value="${ i }">${ i }</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
</td>