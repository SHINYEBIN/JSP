<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String id,pw;

%>
<%
	id=request.getParameter("id");
	pw=request.getParameter("pw");
	
	if(id.equals("ezen")&& pw.equals("1234")){
		Cookie cookie=new Cookie("id",id);
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		response.sendRedirect("10_welcome.jsp");	//10_welcome.jsp 이쪽으로 재 요청해~
	}else{
		response.sendRedirect("08_login.jsp");
	}
%>
</body>
</html>