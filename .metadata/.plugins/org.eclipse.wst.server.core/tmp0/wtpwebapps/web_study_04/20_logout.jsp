<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.invalidate(); // 세션지우기
%>

<script type="text/javascript">
	alert("로그아웃 되었습니다.");
	location.href="17_loginForm.html";
</script>
	


</body>
</html>