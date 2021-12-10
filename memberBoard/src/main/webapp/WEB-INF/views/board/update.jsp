<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.a {
		display: block;
	}
	input {
		margin: 5px 0;
	}
</style>
</head>
<body>
	<h2>update.jsp</h2>
	<form action="/board/update" method="post" name="update_form">
		글번호: <input class="a" type="text" name="b_number" value="${board.b_number}" readonly>
		작성자: <input class="a" type="text" name="b_writer" value="${board.b_writer}" readonly>
		제목: <input class="a" type="text" name="b_title" value="${board.b_title}">
		내용: <textarea class="a" rows="5" name="b_contents">${board.b_contents}</textarea>
		<input class="a" type="submit" value="수정">
	</form>
</body>
</html>