<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>response 객체 예제-sendRedirect()메서드 사용</h2>
	현재 페이지는 <b>13_responseredirect.jsp</b>페이지입니다.
	
	<%
		response.sendRedirect("14_responseredirected.jsp"); //내가 마지막으로 요청한 게 뜸. //외부의 특정 페이지를 노출시키고 싶지 않을 때 사용. // 들어온 아이디,패스워드가 있는지 없는지 비교할 때 사용할 수 있는 건가ㅏㅏ...?(근데 그 때 그 비교하는 페이지를 안 보여줄 수 있게 할때) 
	%>
</body
>
</html>