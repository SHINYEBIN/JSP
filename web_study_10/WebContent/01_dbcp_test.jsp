<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>DB연동</h4>
	<%--DBCP(DataBase Connection Pool) --%>
	<%
		Context context=null;	//CONTEXT:현재 작업하고 있는 프로젝트 그 정도로 이해해두기
		DataSource dataSource=null;	//DATASOURCE: 자원이 있는 소스(근원지 or 원본)
		Connection connection=null;
		
		try{
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:/comp/env/jdbc/Oracle11g");		//자원 경로 작성
			connection=dataSource.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		out.println("DBCP 연동 성공!");
	%>
</body>
</html>