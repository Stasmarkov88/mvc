<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<sf:form method="POST" commandName="user">

    <label for="login">Логин:</label>
    <sf:input path="login" id="login"/>
    <sf:errors path="login" style="color: red; font-style: italic"/> <br/>

    <label for="email">Электронная почта:</label>
    <sf:input path="email" type="email" id="email"/>
    <sf:errors path="email" style="color: red; font-style: italic"/> <br/>

    <label for="age">Возраст:</label>
    <sf:input path="age" id="age" type="number"/>
    <sf:errors path="age" style="color: red; font-style: italic"/> <br/>

    <label for="password">Пароль:</label>
    <sf:password path="password" id="password"/>
    <sf:errors path="password" style="color: red; font-style: italic"/> <br/>

    <input type="submit" value="Register"/>
</sf:form>
</body>
</html>
