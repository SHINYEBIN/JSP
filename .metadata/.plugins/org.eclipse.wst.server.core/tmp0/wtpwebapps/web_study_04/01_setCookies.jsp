<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키설정</h3>
	<%
		Cookie c=new Cookie("id","pinksung");
		c.setMaxAge(365*24*60*60);	//내 컴퓨터에 유지되는 시간.
		response.addCookie(c);
		response.addCookie(new Cookie("pwd","test1234"));
		response.addCookie(new Cookie("age","20"));
	
	%>
</body>
</html>