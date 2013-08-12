<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<body>
<jsp:include page="header.jsp"/>
<table width="100%">
    <tr>
        <td width="70%" valign="top">
            <h1>Available lots: </h1>
            <c:set var="lotsLength" value="${fn:length(allLots)}"/>
            <c:choose>
                <c:when test="${lotsLength > 0}">
                    <c:forEach items="${allLots}" var="lot">
                        <h2>${lot.description}</h2>
                        <a href="${pageContext.request.contextPath}/auction?lot=${lot.lotId}">Get all information about this lot</a>
                        <hr/>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h2>There are no lots at all.&nbsp;Please visit us later.</h2>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>
</body>
</html>