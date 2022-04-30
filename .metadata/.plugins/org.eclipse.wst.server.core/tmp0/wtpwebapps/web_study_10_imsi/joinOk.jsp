<%@page import="com.javalec.ex.MemberDao"%>
<%@page import="java.sql.Timestamp"%>
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
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.javalec.ex.MemberDto"></jsp:useBean>
	<jsp:setProperty property="*" name="dto"/>
	
	<%
		dto.setrDate(new Timestamp(System.currentTimeMillis()));
		MemberDao dao=MemberDao.getInstance();
		
		if(dao.confirmId(dto.getId())==MemberDao.MEMBER_EXISTENT){
	%>
		<script type="text/javascript">
			alert("이미 존재하는 아이디 입니다.");
			history.go(-1);
		</script>
	<%
		}else{
			int ri=dao.insertMember(dto);
			if(ri==MemberDao.MEMBER_JOIN_SUCCESS){
				session.setAttribute("id", dto.getId());
	%>
			<script type="text/javascript">
				alert("회원 가입을 축하합니다!");
				document.location=href="login.jsp";
			</script>
	<%
			}else{
	%>
			<script type="text/javascript">
				alert("회원 가입에 실패했습니다.");
				document.location=href="login.jsp";
			</script>
	<%			
			}
		}
	%>
</body>
</html>