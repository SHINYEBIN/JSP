<%@page import="java.net.URLEncoder"%>
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
	String userID=request.getParameter("userID");
	String userpwd=request.getParameter("userpwd");
	String loginCheck=request.getParameter("loginCheck");
	
	if(loginCheck.equals("user")){	
%>
	<jsp:forward page="07_userMain.jsp">
		<jsp:param value='<%=URLEncoder.encode("전고객","utf-8")%>' name="userName"/>
	</jsp:forward>
<%
	}else{
%>
	<jsp:forward page="08_managerMain.jsp">
		<jsp:param value='<%=URLEncoder.encode("성관리","utf-8")%>' name="userName"></jsp:param>
	</jsp:forward>

<% 
	}
%>
</body>
</html>