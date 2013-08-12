<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<body>
<jsp:include page="header.jsp"/>
<h1>Choose what do you want:</h1></br>
<p><a href="${pageContext.request.contextPath}/admin?mode=lots">Edit lots</a></p>
<p><a href="${pageContext.request.contextPath}/admin?mode=orders">Edit lot orders</a></p>
<p><a href="${pageContext.request.contextPath}/admin?mode=owners">Edit lot owners</a></p>
<p><a href="${pageContext.request.contextPath}/admin?mode=participants">Edit participants</a></p>
</body>
</html>