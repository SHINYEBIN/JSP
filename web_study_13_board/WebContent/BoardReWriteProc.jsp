<%@page import="model.BoardDAO"%>
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
	request.setCharacterEncoding("utf-8");
%>
<!-- 데이터를 한번에 받아오는 빈클래스 사용 -->
<jsp:useBean id="boardBean" class="model.BoardBean">	<!-- usebean의 아이디와 프로펄티 네임이 같아야한다. -->
	<jsp:setProperty name="boardBean" property="*"></jsp:setProperty>
</jsp:useBean>

<%
	BoardDAO dbao=new BoardDAO();
	dbao.reWriteBoard(boardBean);
	
	// 게시글 저장 후 전체 게시글 보기
	response.sendRedirect("BoardList.jsp");
	
%>
</body>
</html>