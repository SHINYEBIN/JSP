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
	String age=request.getParameter("age"); //없어지지 않는 한 계속 가져올 수 있다.
	String name=(String)request.getAttribute("name");	//Object
%>

forward방식으로 이동된 페이지<br>
나이:<%=age %><br>
이름:<%=name %>
</body>
</html>