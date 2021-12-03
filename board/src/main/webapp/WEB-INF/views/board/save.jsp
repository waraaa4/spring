<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function imagePre(event) {
		console.log(event);
	}
</script>

</head>
<body>
	<h2>save.jsp</h2>
	<form action="/board/save" method="post">
		작성자: <input type="text" name="b_writer"> <br> 
		비밀번호: <input type="text" name="b_password"> <br>
		제목: <input type="text" name="b_title"> <br>
		내용: <textarea name="b_contents" rows="5"></textarea><br>
		파일: <input type="file" name="b_files" id="b_files" multiple="multiple" onchange="imagePre(event)">
		<input type="submit" value="작성">
	</form>
	
	<div id="images-preview">
	
	</div>
	
</body>
</html>