<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="msg" value="Hello"></c:set> <!-- var(variable) 변수 -->
EL 출력<br>
\${msg}=${msg}<br>

<c:set var="age">
	30
</c:set>
\${age}=${age}<br><br>

<c:set var="member" value="<%= new com.saeyan.javabeans.MemberBean()%>"></c:set>
<c:set target="${member}" property="name" value="홍길동"></c:set>
<c:set target="${member}" property="userid" value="hong"></c:set>

\${member}=${member}<br><br>

\${member}=${member.name}<br>
\${member}=${member.userid}<br>

<c:set var="add" value="${10+5}"></c:set>
\${add}=${add}<br>

<c:set var="flag" value="${10>5}"></c:set>
\${flag}=${flag}<br>

<c:remove var="flag"></c:remove>
\${flag}=${flag}<br>



</body>
</html>