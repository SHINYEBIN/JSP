<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean"></jsp:useBean>	<!-- //객체생성 -->
	1. 자바 빈 객체 생성 후 저장된 정보 출력하기<br><br>
	이름:<%=member.getName() %><br>
	아이디:<%=member.getUserid() %>
	<hr>
	2.정보 변경한 후 변경된 정보 출력하기<br><br>
	<%
		member.setName("홍길동");
		member.setUserid("hong");
	%>
	이름:<%=member.getName() %>
	아이디:<%=member.getUserid() %>
</body>
</html>