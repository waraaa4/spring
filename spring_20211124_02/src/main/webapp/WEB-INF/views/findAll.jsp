<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- JSTL(JSP Standard Library)사용 -->
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
          		<th>번호</th>
          		<th>이름</th>
          		<th>나이</th>
          		<th>전번</th>
          		<th>성별</th>
          		<th>생년월일</th>
          		<th>주소</th>
          		<th>상세조회</th>
          		<th>삭제</th>
          		<th>수정</th>
          		
        	</tr>
      	</thead>
		<c:forEach items="${tList}" var="t">
      		<tbody>
        		<tr>
          			<td>${t.t_number}</td>
          			<td>${t.t_name}</td>
          			<td>${t.t_age}</td>
          			<td>${t.t_phone}</td>
          			<td>${t.t_gender}</td>
          			<td>${t.t_birth}</td>
          			<td>${t.t_address}</td>
          			<!-- 
          			detail이라는 주소로 t_number 파라미터를 전달함 
          			링크로 서버에 데이터 전송
          			서버에서 t_number를 받아서 sysout으로 출력해보세요
          			-->
          			<td><a href="detail?t_number=${t.t_number}">조회</a></td>
          			<td><a href="delete?t_number=${t.t_number}">삭제</a></td>
          			<td><a href="update?t_number=${t.t_number}">수정</a></td>
        		</tr>
  			</tbody>
  		</c:forEach>
    </table>
</body>
</html>