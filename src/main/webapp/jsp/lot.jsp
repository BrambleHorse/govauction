<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>${lot.description}</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Lot description:</h2>
<p>${lot.description}</p>
<br/>
<h2>Lot date: </h2>
<p>
    <fmt:formatDate pattern="yyyy-MM-dd" value="${lot.lotDate}" />
</p>
</br>
<h2>Lot owner:</h2>
<p>${owner.lotOwnerName}</p>
</br>
<h2>Lot orders:</h2>
<c:set var="ordersLength" value="${fn:length(orders)}"/>
<c:choose>
  <c:when test="${ordersLength > 0}">
    <c:forEach items="${orders}" var="order">
      <p>Lot order id:&nbsp;${order.lotOrderId}</p>
      <p>Participant name:&nbsp;${order.participantName}</p>
   </c:forEach>
  </c:when>
  <c:otherwise>
    <p>There are no orders for this lot</p>
  </c:otherwise>
</c:choose>
<hr/>
</body>
</html>
