<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>HTTP Status 403 - Access is denied</h1>

<c:choose>
    <c:when test="${empty user}">
        <h2>У Вас нет прав для просмотра этой страницы!</h2>
    </c:when>
    <c:otherwise>
        <h2>Пользователь : ${user.login} <br/>
            У Вас нет прав для просмотра этой страницы!</h2>
    </c:otherwise>
</c:choose>

</body>
</html>
