<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 	table {
	    width: 100%;
	    border-top: 1px solid #444444;
	    border-collapse: collapse;
	    margin-bottom: 30px;
  	}
  	th, td {
	    border-bottom: 1px solid #444444;
	    padding: 10px;
	    text-align: center;
  	}
</style>
</head>
<body>
	<h2>adminPage.jsp</h2>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>폰번호</th>
				<th>삭제</th>
			</tr>
		</thead>
		<c:forEach items="${memberList}" var="m">
			<tbody>
				<tr>
					<td>${m.m_number}</td>
					<td>${m.m_id}</td>
					<td>${m.m_password}</td>
					<td>${m.m_name}</td>
					<td>${m.m_email}</td>
					<td>${m.m_phone}</td>
					<td><a href="delete?m_number=${m.m_number}">삭제</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>