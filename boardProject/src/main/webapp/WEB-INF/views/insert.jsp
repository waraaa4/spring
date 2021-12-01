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
	<h2>insert.jsp</h2>
	<form action="insert" method="post">
		작성자: <input type="text" name="b_writer">
		글비밀번호: <input type="password" name="b_password">
		제목: <input type="text" name="b_title">
		내용: <input type="text" name="b_contentsl">
		작성시간: <input type="date" name="b_date">
		<input type="submit" value="글작성">
	</form>
</body>
</html>