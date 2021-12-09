<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
	<form action="/board/save" method="post" enctype="multipart/form-data">
		작성자: <input type="text" name="b_writer" value="${sessionScope.loginId}" readonly="readonly">
		제목: <input type="text" name="b_title">
		내용:<br> <textarea name="b_contents" rows="5"></textarea><br>
		파일: <input type="file" name="b_file">
		<input type="submit" value="작성">
	</form>
</body>
</html>