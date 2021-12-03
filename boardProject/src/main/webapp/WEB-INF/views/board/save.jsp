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
	<h2>save.jsp</h2>
	<form action="/board/save" method="post">
		작성자: <input type="text" name="b_writer">
		비밀번호: <input type="password" name="b_password">
		제목: <input type="text" name="b_title">
		내용:<br> <textarea name="b_contents" rows="5"></textarea><br>
		<input type="submit" value="작성">
	</form>
</body>
</html>