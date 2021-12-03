<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function update() {
		const pw = document.querySelector("#b_password").value;
		const pw1 = document.getElementById("b_password").value; 
		const pwDB = '${board.b_password}';
		if(pw == pwDB) {
			update_form.submit();
		} else {
			alert('비밀번호 틀려요');
		}
	}
</script>
</head>
<body>
	<h2>update.jsp</h2>
	<form action="/board/update" method="post" name="update_form">
		글번호: <input type="text" name="b_number" value="${board.b_number}" readonly> <br>
		작성자: <input type="text" name="b_writer" value="${board.b_writer}" readonly> <br> 
		비밀번호: <input type="text" name="b_password" id="b_password"> <br>
		제목: <input type="text" name="b_title" value="${board.b_writer}"> <br>
		내용: <textarea name="b_contents" rows="5">${board.b_contents}</textarea><br>
		<input type="button" value="수정" onclick="update()">
	</form>
	
	
</body>
</html>