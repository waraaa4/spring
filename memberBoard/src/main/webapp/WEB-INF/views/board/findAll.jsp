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
	
	<form action="/board/search" method="get">
		<select name="searchtype">
			<option value="b_title">제목</option>
			<option value="b_writer">작성자</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어..">
		<input type="submit" value="검색">
	</form>
	
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성시간</th>
				<th>조회수</th>
			</tr>
		</thead>
		<c:forEach items="${boardList}" var="board">
			<tbody>
				<tr>
					<td>${board.b_number}</td>
					<td>${board.b_writer}</td>
					<td><a href="/board/detail?b_number=${board.b_number}">${board.b_title}</a></td>
					<td>${board.b_date}</td>
					<td>${board.b_hits}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	<div>
		<c:choose>
			<c:when test="${paging.page<=1}">
				[이전]&nbsp;
			</c:when>
			<c:otherwise>
				<a href="/board/findAll?page=${paging.page-1}">[이전]</a>&nbsp;
			</c:otherwise>
		</c:choose>
		
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
					${i}
				</c:when>
				<c:otherwise>
					<a href="/board/findAll?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
		<c:choose>
			<c:when test="${paging.page>=paging.maxPage}">
				[다음]
			</c:when>
			<c:otherwise>
				<a href="/board/findAll?page=${paging.page+1}">[다음]</a>
			</c:otherwise>
		</c:choose>
		<a href="/board/save">글쓰기</a>
	</div>
	
</body>
</html>