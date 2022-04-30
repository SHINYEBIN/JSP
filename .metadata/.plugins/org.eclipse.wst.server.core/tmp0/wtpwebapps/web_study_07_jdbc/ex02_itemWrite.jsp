<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	String url="jdbc:oracle:thin:@localhost:1521:XE"; /* 그냥 이건 외워두는 것이 좋을 듯! */
	String uid="scott";
	String pass="tiger";
	String sql="select * from item";
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공");
		conn=DriverManager.getConnection(url,uid,pass);
		System.out.println("연결 성공");
		stmt=conn.prepareStatement(sql);
		rs=stmt.executeQuery(sql);
		
		out.println("<table border='1'>");
		while(rs.next()){
			out.print("<tr>");
			out.println("<td>"+rs.getString("name")+"</td>");
			out.println("<td>"+rs.getString("price")+"</td>");
			out.println("<td>"+rs.getString("description")+"</td>");
		
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs !=null)
				rs.close();
			if(stmt !=null)
				stmt.close();
			if(conn !=null)
				conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	out.println("</table>");
%>
</body>
</html>