<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 관리</title>
</head>
<body>
<%!
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String uid="scott";
	String pass="tiger";
	String sql="select * from employee";
%>

<%
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver"); /* 드라이버 가져옴 */
				conn=DriverManager.getConnection(url,uid,pass);
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql); /* rs에는 쿼리문에 대한 결과가 와 있다. */
				
				out.println("<table border=1>");
				while(rs.next()){
					out.println("<tr>");
					out.println("<td>"+rs.getString("name")+"</td>");
					out.println("<td>"+rs.getString("address")+"</td>");
					out.println("<td>"+rs.getString("ssn")+"</td>");
					out.println("</tr>");
				}
				out.println("<table border=1>");
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
		%> 
</body>
</html>