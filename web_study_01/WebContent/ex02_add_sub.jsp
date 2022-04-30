<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	public int add(int a,int b){
		int sum=a+b;
		
		return sum;
}
	public int sub(int a,int b){
		int sum=a-b;
		
		return sum;
	}

%>

<%
	int num1=50;
	int num2=20;
	
	int num3=add(num1,num2);
	int num4=sub(num1,num2);
%>
<%=num1%>+<%=num2%>=<%=num3%><br>
<%=num1%>-<%=num2%>=<%=num3%><br>
</body>
</html>