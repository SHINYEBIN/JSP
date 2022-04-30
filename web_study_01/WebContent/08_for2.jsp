<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
1부터 10까지 1씩 증가하면서 짝수만 출력하세요.<br>
scriptlet,expression 사용<br>
<%
	for(int i=0;i<=10;i++){
		if(i%2 ==0){
				
%>
	<%=i%><br>
<%
		}
	}
%>
</body>
</html>