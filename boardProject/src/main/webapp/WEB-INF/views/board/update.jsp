<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	/*
		비밀번호 입력창에서 비밀번호를 입력받고 DB에서 가져온 비밀번호와 비교해서 일치하면 update처리 일치하지 않으면
		비밀번호가 일치하지 않습니다 alert 출력
	*/
	function update() {
		const pw = document.getElementById('b_password').value;
		const pwDB = '${board.b_password}';
		if(pw==pwDB){
			// 이 문장이 아래 form을 전송하는 문장
			update_form.submit();
		} else {
			alert('비밀번호가 틀립니다.')
		}
	}
</script>
</head>
<body>
	<h2>update.jsp</h2>
	<form action="/board/update" method="post" name="update_form">
		<input class="a" type="hidden" name="page" value="${page}">
		글번호: <input class="a" type="text" name="b_number" value="${board.b_number}" readonly>
		작성자: <input class="a" type="text" name="b_writer" value="${board.b_writer}" readonly>
		비밀번호: <input class="a" id="b_password" type="password" name="b_password">
		제목: <input class="a" type="text" name="b_title" value="${board.b_title}">
		내용: <textarea class="a" rows="5" name="b_contents">${board.b_contents}</textarea>
		<input class="a" type="button" value="수정" onclick="update()">
	</form>
</body>
</html>