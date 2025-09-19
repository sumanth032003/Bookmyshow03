<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login</h2>
  <c:if test="${not empty error}">
    <div style="color:red">${error}</div>
  </c:if>
  <form action="${pageContext.request.contextPath}/user/login" method="post">
    Email: <input type="email" name="email" value="${loginRequest.email}" required/><br/>
    Password: <input type="password" name="password" required/><br/>
    <button type="submit">Login</button>
  </form>
  <p>Not registered? <a href="${pageContext.request.contextPath}/user/signup">Sign up</a></p>

</body>
</html>