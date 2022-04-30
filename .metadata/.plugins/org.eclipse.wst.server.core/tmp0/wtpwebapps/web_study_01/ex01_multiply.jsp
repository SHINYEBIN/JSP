<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public int multiply(int x,int y){
		int result=x*y;
		return result;
}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
두 정수의 곱셈=<%=multiply(10,20)%>
</body>
</html>