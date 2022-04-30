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
	String str1=request.getParameter("num1");	//10	
	String str2=request.getParameter("num2");	//20
	int num1=Integer.parseInt(str1);
	int num2=Integer.parseInt(str2);
	
	request.setAttribute("sum", new Integer(num1+num2));	//request에 저장하려면 다 객체여야한다.
	request.setAttribute("difference", num1-num2);
	request.setAttribute("product",num1*num2);
	request.setAttribute("quotient", num1/num2);
	
	RequestDispatcher dispatcher=request.getRequestDispatcher("23_fourrulesresult.jsp");//저장된 걸 다른 페이지로 넘길때?
	dispatcher.forward(request,response); //forward:서버 내에서 이동
%>
</body>
</html>