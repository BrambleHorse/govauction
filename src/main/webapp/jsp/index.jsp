<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<jsp:include page="header.jsp"/>
<table width="100%">
    <tr>
        <td width="70%" valign="top">
            <h2><c:out value="${test}"/></h2>

            <%--<c:forEach items="${allLots}" var="lot">--%>
                <%--<h1>${lot.description}</h1>--%>
                <%--<hr/>--%>
            <%--</c:forEach>--%>
        </td>
    </tr>
</table>
</body>
</html>