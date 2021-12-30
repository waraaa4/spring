<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	button {
		margin-bottom: 10px;
	}
</style>
<script>
	function logout() {
		location.href="logout";
	}
</script>
</head>
<body>
	<h2>main.jsp</h2>
	<button onclick="logout()">로그아웃</button> <br>
	<a href="/board/findAll">게시판</a> <br>
	<a href="/member/myPage">마이페이지</a> <br>
	<c:if test="${sessionScope.loginId eq 'admin'}">
		<a href="/member/adminPage">관리자 페이지</a> 
	</c:if>
</body>
</html>