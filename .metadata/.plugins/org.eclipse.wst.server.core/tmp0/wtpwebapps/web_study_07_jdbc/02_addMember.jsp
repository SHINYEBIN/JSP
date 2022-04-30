<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	String url="jdbc:oracle:thin:@localhost:1521:XE"; 
	String uid="scott";
	String pass="tiger";
	String sql="insert into member values(?,?,?,?,?,?)";	/*?바인딩 변수: 어떠한 값을 받는다(=연결한다) 얘 사용시 preparedStatement 사용*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String userid=request.getParameter("userid");
	String pwd=request.getParameter("pwd");
	String email=request.getParameter("email");
	String phone=request.getParameter("phone");
	String admin=request.getParameter("admin");
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver"); /* 드라이버 가져옴 */
		conn=DriverManager.getConnection(url,uid,pass);		/*연결*/
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1,name);
		pstmt.setString(2,userid);
		pstmt.setString(3,pwd);
		pstmt.setString(4,email);
		pstmt.setString(5,phone);
		pstmt.setInt(6,Integer.parseInt(admin));
		pstmt.executeUpdate();		 /* 어떤 결과를 가져올 것이 아니라 업데이트 할 거기때문에 rs가 필요 없다. */
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(pstmt !=null)
				pstmt.close();
			if(conn !=null)
				conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
%>
<h3>회원 가입 성공</h3>
<a href="01_allMember.jsp"></a>


</body>
</html>