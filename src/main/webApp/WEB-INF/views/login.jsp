<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Добро пожаловать!</h1>


<div id="login-box">

    <h2>Вход: введите логин и пароль</h2>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <c:url value="/j_spring_security_check" var="loginUrl"/>

    <form action="${loginUrl}" method='POST'>
        Логин:<label><input type='text' name='j_username'></label><br/>
        Пароль:<label><input type='password' name='j_password'/></label><br/>
        <input name="submit" type="submit" value="Войти"/>
    </form>
</div>

<sec:authorize access="hasRole('USER')">
    <!-- For login user -->
    <c:url value="/j_spring_security_logout" var="logoutUrl"/>
    <form action="${logoutUrl}" method="post" id="logoutForm">
    </form>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Пользователь : ${pageContext.request.userPrincipal.name} | <a
                href="javascript:formSubmit()"> Logout</a>
        </h2>
    </c:if>
</sec:authorize>

<label><a href="<c:url value="/register"/>">Регистрация</a></label>

</body>
</html>
