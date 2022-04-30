<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		글쓴이:<input type="text" name="name"><br>
		제&nbsp;목:<input type="text" name="title"><br>
		파일 지정하기:<input type="file" name="uploadFile"><br>
		<input type="submit" value="전송">
	</form>
</body>

<!-- enctype="multipart/form=data" 파일처리하려면 이게 있어야한다. 이거 사용안하면 파일명만 전달된다.
	이때 input type은 file이다. -->
</html>