<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<body>
<jsp:include page="admin_header.jsp"/>
<h1>Choose what do you want:</h1></br>
<p><a href="/admin?manage=lots">Manage lots</a></p>
<p><a href="/admin?manage=orders">Manage lot orders</a></p>
<p><a href="/admin?manage=owners">Manage lot owners</a></p>
<p><a href="/admin?manage=participants">Manage participants</a></p>
</body>
</html>