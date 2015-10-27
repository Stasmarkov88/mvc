<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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

  <sec:authorize access="hasRole('ROLE_USER')">
      <!-- For login user -->
      <c:url value="/j_spring_security_logout" var="logoutUrl" />
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
</body>
</html>
