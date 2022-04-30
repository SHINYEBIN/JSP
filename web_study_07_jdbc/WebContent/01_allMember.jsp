<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	String url="jdbc:oracle:thin:@localhost:1521:XE"; /* 그냥 이건 외워두는 것이 좋을 듯! */
	String uid="scott";
	String pass="tiger";
	String sql="select * from member";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member 테이블 출력</title>
</head>
<body>
	<table width="800" border="1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>암호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>권한(1:관리자,2:일반회원)</th>
		</tr>
		<%
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver"); /* 드라이버 가져옴 */
				conn=DriverManager.getConnection(url,uid,pass);
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql); /* rs에는 쿼리문에 대한 결과가 와 있다. */
				
				while(rs.next()){
					out.println("<tr>");
					out.println("<td>"+rs.getString("name")+"</td>");
					out.println("<td>"+rs.getString("userid")+"</td>");
					out.println("<td>"+rs.getString("pwd")+"</td>");
					out.println("<td>"+rs.getString("email")+"</td>");
					out.println("<td>"+rs.getString("phone")+"</td>");
					out.println("<td>"+rs.getInt("admin")+"</td>");
					out.println("</tr>");
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
		%> 
	</table>

</body>
</html>