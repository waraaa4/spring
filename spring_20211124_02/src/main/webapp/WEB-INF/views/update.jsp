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
	<form action="update" method="post">
		번호: <input class="a" type="hidden" name="t_number" value="${trainee.t_number}" readonly>
		이름: <input class="a" type="text" name="t_name" value="${trainee.t_name}" readonly="readonly">
		나이: <input class="a" type="number" name="t_age" value="${trainee.t_age}" readonly="readonly">
		폰번호: <input class="a" type="text" name="t_phone" value="${trainee.t_phone}">
		집주소: <input class="a" type="text" name="t_address" value="${trainee.t_address}">
		<input class="a" type="submit" value="수정">
	</form>
</body>
</html>