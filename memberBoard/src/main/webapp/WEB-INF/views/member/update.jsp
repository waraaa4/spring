<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
<script>
	function update() {
		const pw = document.getElementById('m_password').value;
		const email = document.getElementById('m_email').value;
		console.log(email);
		const pwDB = '${member.m_password}';
		if(pw==pwDB){
			update_form.submit();
		} else {
			alert('비밀번호가 틀립니다.')
		}
	}
	

</script>
</head>
<body>
	<h2>update.jsp</h2>
	<form action="update" method="post" name="update_form">
		번호: <input class="a" type="hidden" name="m_number" value="${member.m_number}" readonly>
		아이디: <input class="a" type="text" name="m_id" value="${member.m_id}" readonly="readonly">
		비밀번호: <input class="a" id="m_password" type="text" name="m_password">
		이름: <input class="a" type="text" name="m_name" value="${member.m_name}" readonly="readonly">
		이메일: <input class="a" id="m_email" type="email" name="m_email" value="${member.m_email}">
		전화번호: <input class="a" id="m_phone" type="text" name="m_phone" value="${member.m_phone}">
		<input class="a" type="button" value="수정" onclick="update()">
	</form>
</body>
</html>