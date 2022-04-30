<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		List<String> seasonList=new ArrayList<String>();
		seasonList.add("봄");
		seasonList.add("여름");
		seasonList.add("가을");
		seasonList.add("겨울");
		
		request.setAttribute("list", seasonList);
	%>
	<select>
	<%
		ArrayList<String> list=(ArrayList<String>)request.getAttribute("list");
		for(int i=0;i<list.size();i++){
	%>	
		<option value="<%=list.get(i)%>"><%=list.get(i)%></option>
		
	<%
		}
	%>	
	</select>
	<select>
		<c:forEach var="item" items="${list}">
			<option value="${item}">${item}</option>
		</c:forEach>
	</select>
</body>
</html>