<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Sign Up</h2>
  <c:if test="${not empty error}">
    <div style="color:red">${error}</div>
  </c:if>
  <form action="${pageContext.request.contextPath}/user/signup" method="post">
    Name: <input type="text" name="name" value="${signupRequest.name}" required/><br/>
    Email: <input type="email" name="email" value="${signupRequest.email}" required/><br/>
    Password: <input type="password" name="password" required/><br/>
    <button type="submit">Sign Up</button>
  </form>
  <p>Already registered? <a href="${pageContext.request.contextPath}/user/login">Login</a></p>

</body>
</html>