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
		margin: 5px 0;
	}
</style>
</head>
<body>
	<h2>login.jsp</h2>
	<form action="login" method="post">
		아이디: <input type="text" name="m_id">
		비밀번호: <input type="password" name="m_password">
		<input type="submit" value="로그인">
	</form>
</body>
</html>