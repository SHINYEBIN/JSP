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
<jsp:useBean id="boardBean" class="com.mission.javabeans.BoardBean"></jsp:useBean>
<jsp:setProperty name="boardBean" property="*"></jsp:setProperty>
	<h2>입력 완료된 정보</h2>
	<table border="1">
		<tr>
			<td>작성자</td>
			<td><jsp:getProperty name="boardBean" property="name"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><jsp:getProperty name="boardBean" property="pass"/></td>
		</tr>	
		<tr>
			<td>이메일</td>
			<td><jsp:getProperty name="boardBean" property="email"/></td>
		</tr>	
		<tr>
			<td>글제목</td>
			<td><jsp:getProperty name="boardBean" property="title"/></td>
		</tr>	
		<tr>
			<td>글내용</td>
			<td><jsp:getProperty name="boardBean" property="content"/></td>
		</tr>	
			
			
	
	
	</table>
</body>
</html>