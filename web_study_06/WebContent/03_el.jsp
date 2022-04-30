<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
\${5+2}:${5+2}<br> <!-- \ 쓰면 표기법 그대로 나온다! -->
\${5/2}:${5/2}<br>	
<%-- ${5 div 2} --%> <!-- div는 나누기지만 표기가 이클립스하고 안맞아서 빨갛게 뜨는 거임 -->
\${5%2}:${5%2}<br>
\${5 mod 2 }:${5 mod 2}<br> <!-- mod는 나머지 -->
\${5 > 2}:${5 > 2}<br>
\${(5 > 2)}? 5:2}:${(5>2)? 5:2}<br>
\${(5 > 2)} || (2<10)}:${(5>2) || (2<10)}<br>
\${(5 > 2)} && (2<10)}:${(5>2) && (2<10)}<br>
<%String input=null;%>
\${empty input}:{empty input}<br><br> <%--empty 널 검사 --%>
<%
	if(input == null){
		out.println("텅 빈 객체(null)입니다."+"<br>");
	}
%>

<%--JSTL(JSP Standard Tag Library) --%> <!-- 이거 사용하려면 외부 라이브러리가 필요하다. -->
<%-- <c:if test=${empty input}>
	텅 빈 객체입니다. --%>
	
</body>
</html>