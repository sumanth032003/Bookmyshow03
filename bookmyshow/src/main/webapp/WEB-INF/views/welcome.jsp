<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>Welcome - BookMyShow</title>
</head>
<body><h2>${message}</h2>
  <p><a href="${pageContext.request.contextPath}/user/login">Login</a> | <a href="${pageContext.request.contextPath}/user/signup">Sign Up</a></p>

</body>
</html>