<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	String name=(String)session.getAttribute("name");
%>
<%=name %>님의 회원 정보 수정이 정상처리 되었습니다. (이건 내 생각임) --%>
<%=session.getAttribute("name") %>님의 회원 정보 수정이 정상처리 되었습니다.
<a href="logout.jsp">로그아웃</a>&nbsp;&nbsp;<a href="modify.jsp">정보 수정</a>
</body>
</html>