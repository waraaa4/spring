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
	<h2>insert.jsp</h2>
	<form action="insert" method="post">
		이름: <input class="a" type="text" name="t_name">
		나이: <input class="a" type="number" name="t_age">
		폰번호: <input class="a" type="text" name="t_phone">
		성별: <input type="radio" name="t_gender" value="male">남자
		<input type="radio" name="t_gender" value="female">여자 <br>
		생년월일: <input type="date" name="t_birth"> <br>
		집주소: <input type="text" name="t_address"> <br>
		<input class="a" type="submit" value="등록">
	</form>
</body>
</html>