<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		Connection conn=null;
		PreparedStatement pstmt=null;	
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String uid="scott";
		String pass="tiger";
		String sql="insert into item values(?,?,?)"; /* ?바인딩 변수*/
	%>	
	<%
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection(url,uid,pass);
		pstmt=conn.prepareStatement(sql);
		
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		
		pstmt.setString(1,name);
		pstmt.setInt(2,Integer.parseInt(price));
		pstmt.setString(3,description);
		
		pstmt.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(pstmt !=null)
			pstmt.close();
		if(conn !=null)
			conn.close();
	}
	 %>
	 
	 <h2>레코드가 추가 되었습니다.</h2>
	 <a href="ex02_itemWrite.jsp">결과 보기</a>
</body>
</html>