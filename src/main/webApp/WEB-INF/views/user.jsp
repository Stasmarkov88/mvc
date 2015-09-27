<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User</title>
</head>
<body>
  <h1>Мои данные</h1>
  <div>Возраст:<c:out value="${user.age}"/></div>
  <div>Логин:<c:out value="${user.login}"/></div>
  <div>Электронная почта:<c:out value="${user.email}"/></div>
</body>
</html>
