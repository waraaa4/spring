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
	<h2>findAll.jsp</h2>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>글비밀번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성시간</th>
			</tr>
		</thead>
		<c:forEach items="${boardList}" var="b">
			<tbody>
				<tr>
					<td>${b.b_number}</td>
					<td>${b.b_writer}</td>
					<td>${b.b_password}</td>
					<td>${b.b_title}</td>
					<td>${b.b_contentsl}</td>
					<td>${b.b_date}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>