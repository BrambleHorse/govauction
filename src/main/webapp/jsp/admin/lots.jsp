<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<body>
<jsp:include page="header.jsp"/>
<h1>Available lots: </h1>
<a href="${pageContext.request.contextPath}/admin?mode=lots&action=create">Create new lot</a>
<table width="70%">
    <c:set var="lotsLength" value="${fn:length(allLots)}"/>
    <c:choose>
       <c:when test="${lotsLength > 0}">
           <c:forEach items="${allLots}" var="lot">
               <tr>
                   <td width="50%" valign="top">
                       <h2>Lot ID: &nbsp;&nbsp; ${lot.lotId}</h2>
                       <h2>Lot description: &nbsp;&nbsp; ${lot.description}</h2>
                       <h2>Lot date: &nbsp;&nbsp; <fmt:formatDate pattern="yyyy-MM-dd" value="${lot.lotDate}" /></h2>
                   </td>
                   <td>
                      <a href="${pageContext.request.contextPath}/admin?mode=lots&action=edit&lot=${lot.lotId}">Edit</a>
                   </td>
                   <td>
                       <a href="${pageContext.request.contextPath}/admin?mode=lots&action=delete&lot=${lot.lotId}">Delete</a>
                   </td>
               </tr>
           </c:forEach>
       </c:when>
    </c:choose>
</table>
</body>
</html>