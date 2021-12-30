<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<h2>detail.jsp</h2>
	<ul>
		<li>글번호: ${board.b_number}</li>
		<li>작성자: ${board.b_writer}</li>
		<li>제목: ${board.b_title}</li>
		<li>내용: ${board.b_contents}</li>
		<li>작성시간: ${board.b_date}</li>
		<li>조회수: ${board.b_hits}</li>
		<li>파일: <img alt="" src="/resources/upload/${board.b_filename}"></li>
	</ul>
	<c:if test="${sessionScope.loginId eq board.b_writer}">
		<a href="/board/delete?b_number=${board.b_number}">삭제</a>
		<a href="/board/update?b_number=${board.b_number}">수정</a>
	</c:if>
	<c:if test="${sessionScope.loginId eq 'admin'}">
		<a href="/board/delete?b_number=${board.b_number}">삭제</a>
	</c:if>
	<a href="/board/findAll">목록</a>
	
	<div id="comment-write">
		<input type="text" id="c_writer" value="${sessionScope.loginId}" readonly="readonly">
		<input type="text" id="c_contents" placeholder="댓글내용">
		<button id="comment-write-btn">댓글등록</button>
	</div>
	
	<!-- 댓글목록출력 -->
	<div id="comment-list">
		<table class="table">
			<tr>
				<th>댓글번호</th>
				<th>작성자</th>
				<th>내용</th>
				<th>작성시간</th>
			</tr>
			<c:forEach items="${commentList}" var="comment">
				<tr>
					<td>${comment.c_number}</td>
					<td>${comment.c_writer}</td>
					<td>${comment.c_contents}</td>
					<td>${comment.c_date}</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script>
	/*
	const commentBtn = document.getElementById("comment-write-btn");
	commentBtn.addEventListener("click", function() {
		console.log("댓글등록버튼 클릭");
	});
	*/
	$("#comment-write-btn").click(function(){
		console.log("댓글등록버튼 클릭")
		/*
		ajax 문법을 이용하여 댓글 작성자, 작성내용을 comment/save 주소로 post 방식으로 전송하는
		코드를 작성해봅시다.
		CommentController도 하나 선언해서 여기서 보낸 데이터를 받는지 sysout으로 출력해봅시다.
		팁) data: {"c_writer": 작성자입력값, "c_contents": 내용입력값}
		*/
		//const commentWriter = document.getElementById('c_writer').value;
		//const commentContents = document.getElementById('c_contents').value;
		const commentWriter = $("#c_writer").val();
		const commentContents = $("#c_contents").val();
		const boardNumber = '${board.b_number}';
		console.log(commentWriter,commentContents,boardNumber)
		$.ajax({
			type: 'post', // 전송방식(get, post, delete, put등)
			url: '/comment/save', // 요청주소(컨트롤러로 요청하는 주소)
			data: {
				"c_writer": commentWriter, 
				"c_contents": commentContents, 
				"b_number": boardNumber}, // 전송할 데이터
			dataType: 'json', // 요청 후 리턴받을 때의 데이터 형식
			success: function(result) { // 요청이 성공적으로 처리됐을 때 실행할 함수
				console.log(result);
				let output = "<table class='table'>";
				output += "<tr><th>댓글번호</th>";
				output += "<th>작성자</th>";
				output += "<th>내용</th>";
				output += "<th>작성시간</th></tr>";
				for(let i in result){
					output += "<tr>";
					output += "<td>"+result[i].c_number+"</td>";
					output += "<td>"+result[i].c_writer+"</td>";
					output += "<td>"+result[i].c_contents+"</td>";
					output += "<td>"+result[i].c_date+"</td>";
					output += "</tr>";
				}
				output += "</table>";
				// id가 comment-list인 div에 출력
				document.getElementById('comment-list').innerHTML = output;
				// 댓글 입력창을 비움. 
				document.getElementById('c_writer').value='';
				document.getElementById('c_contents').value='';
			},
			error: function() { // 요청이 실패했을 때 실행할 함수
				console.log();
			}
		});
		
	});
</script>
</html>