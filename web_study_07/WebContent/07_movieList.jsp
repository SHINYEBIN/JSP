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
<%
	String[] movieList={"타이타닉","시네마 천국","혹성 탈출","킹콩"};
	pageContext.setAttribute("movieList",movieList);	/* pageContext는 현재 페이지에서만 사용할 수 있는 객체 */
%>

<c:forEach var="movie" items="${movieList}"> <!-- items는 저장되어있는 위치 -->
${movie}<br>

</c:forEach>
</body>
</html>