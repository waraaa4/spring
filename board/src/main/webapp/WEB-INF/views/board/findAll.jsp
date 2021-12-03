<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<h2>글목록</h2>
		<table class="table table-dark">
	<tr>
		<th>글번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>작성시간</th>
		<th>조회수</th>
	</tr>
	<!-- 제목을 클릭했을 때 해당 글의 상세페이지 출력. 조회수도 하나 올라가야 함. -->
		<c:forEach items="${boardList}" var="board">
		<tr>
			<td>${board.b_number}</td>
			<td>${board.b_writer}</td>
			<td><a href="/board/detail?b_number=${board.b_number}">${board.b_title}</a></td> 
			<td>${board.b_date}</td>
			<td>${board.b_hits}</td>
		</tr>
		</c:forEach>
	</table>
	
	<!-- ajax로 가져온 상세조회 결과를 여기에 보여줌 -->
	<div id="detail-view"></div>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>