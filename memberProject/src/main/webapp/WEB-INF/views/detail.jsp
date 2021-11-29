<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>detail.jsp</h2>
	${member.m_number}
	${member.m_id}
	${member.m_password}
	${member.m_name}
	${member.m_email}
	${member.m_phone}
	<br>
	<a href="findAll">목록으로 돌아가기</a>
</body>
</html>