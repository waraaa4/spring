<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>myPage.jsp</h2>
	<c:forEach items="${memberList}" var="m">
		<c:if test="${sessionScope.loginNumber eq m.m_number}">
			<ul>
				<li>아이디: ${m.m_id}</li>
				<li>이름: ${m.m_name}</li>
				<li>이메일: ${m.m_email}</li>
				<li>전화번호: ${m.m_phone}</li>
				<li><a href="update?m_number=${m.m_number}">정보수정</a></li>
			</ul>
		</c:if>
	</c:forEach>
</body>
</html>