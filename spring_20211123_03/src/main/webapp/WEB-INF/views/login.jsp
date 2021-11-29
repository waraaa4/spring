<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input {
		display: block;
	}
</style>
</head>
<body>
	<h2>login.jsp</h2>
	<form action="login" method="post">
		아이디:<input type="text" name="id">
		비밀번호:<input type="text" name="password">
		<input type="submit" value="로그인">
	</form>
</body>
</html>