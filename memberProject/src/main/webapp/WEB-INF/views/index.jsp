<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>index.jsp</h2>
	<a href="saveform">회원가입</a>
	<br>
	<a href="loginform">로그인</a>
	<br>
	
	세션갑: ${sessionScope.logionId}

</body>
</html>