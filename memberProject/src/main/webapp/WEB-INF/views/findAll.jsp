<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function detailAjax(m_number) {
		console.log(m_number);
		const view = document.getElementById('detail-view');
		$.ajax({
			type: 'post',
			url: 'detailAjax',
			data: {'m_number': m_number},
			dataType: 'json',
			success: function(result) { // 처리결과를 받는 부분
				console.log(result);
				console.log(result.m_number);
				console.log(result.m_id);
				
				let output = "<table class='table'>";
				output += "<tr><th>number</th> <th>id</th> <th>password</th> <th>name</th>";
				output += "<th>email</th> <th>phone</th> </tr>";
				output += "<tr>";
				output += "<td>"+result.m_number+"</td>";
				output += "<td>"+result.m_id+"</td>";
				output += "<td>"+result.m_password+"</td>";
				output += "<td>"+result.m_name+"</td>";
				output += "<td>"+result.m_email+"</td>";
				output += "<td>"+result.m_phone+"</td>";
				output += "</tr>";
				output += "</table>";
				
				view.innerHTML = output;
			},
			error: function() {
				console.log('오타를 찾으세요.')
			}
		});
	}
</script>
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
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>폰번호</th>
				<th>조회</th>
				<th>조회(ajax)</th>
				<th>삭제</th>
				<th>수정</th>
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
					<!-- detail 이라는 주소요청을 통해 회원 상세조회를 해봅시다. 상세조회 데이터는 detail.jsp에 출력합니다. -->
					<td><a href="detail?m_number=${m.m_number}">조회</a></td>
					<td><button onclick="detailAjax('${m.m_number}')">조회(ajax)</button></td>
					<td><a href="delete?m_number=${m.m_number}">삭제</a></td>
					<!-- 
						1. 수정화면 요청 
							수정화면을 요청하면 DB로부터 해당 회원의 정보를 가져와서 update.jsp 에 출력함(form 태그사용)
						2. 수정 처리
							이메일, 전화번호만 수정할 수 있음.
							update.jsp에 입력한 내용을 서버로 전달하여 수정을 처리하고 해당 회원의 detail 페이지를 출력할 것
					-->
					<td><a href="update?m_number=${m.m_number}">수정</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	<!-- ajax로 가져온 조회 결과를 여기에 보여줌 -->
	<div id="detail-view"></div>
	
	
</body>
</html>