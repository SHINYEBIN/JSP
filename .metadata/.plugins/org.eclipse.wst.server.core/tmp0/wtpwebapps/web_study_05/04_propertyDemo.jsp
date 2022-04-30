<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean"></jsp:useBean>
	1. 자바 빈 객체 생성 후 저장된 정보 출력하기<br><br>
	<%-- 이름:<%=member.getName() %><br> --%>
	이름:<jsp:getProperty name="member" property="name"></jsp:getProperty> <!-- 라인 12 액션태그로 바꾸기 -->
	<%-- 아이디:<%=member.getUserid() %> --%>
	아이디:<jsp:getProperty name="member" property="userid"></jsp:getProperty>
	<hr>
	2.정보 변경한 후 변경된 정보 출력하기<br><br>
	<%-- <%
		member.setName("홍길동");
		member.setUserid("hong");
	%> --%>
	<jsp:setProperty name="member" property="name" value="홍길동"></jsp:setProperty>
	<jsp:setProperty name="member" property="userid" value="hong"></jsp:setProperty>
	
	이름:<%=member.getName() %>
	아이디:<%=member.getUserid() %>
</body>
</html>