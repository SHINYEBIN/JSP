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
	<jsp:useBean id="dto" class="com.javalec.ex.MemberDto"></jsp:useBean> <%-- 클래스를 객체로 만들때 useBean 사용 --%>
	<jsp:setProperty property="*" name="dto"></jsp:setProperty> <!-- 자바에서는 필드, jsp에서는 property라고 한다. -->

	<%
		dto.setrDate(new Timestamp(System.currentTimeMillis()));
		MemberDao dao=MemberDao.getInstance();	//dao 객체 생성
		
		if(dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT){
	%>
		<script type="text/javascript">
			alert("이미 존재하는 아이디입니다.");
		</script>
	<%
		}else{	
			int ri=dao.insertMember(dto);	//db에 저장
			if(ri==MemberDao.MEMBER_JOIN_SUCCESS){
				session.setAttribute("id", dto.getId());
	%>
		<script type="text/javascript">
			alert("회원 가입을 축하합니다!");
			document.location.href="login.jsp";
		</script>
	<%
			}else{
	%>
		<script type="text/javascript">
			alert("회원가입에 실패했습니다.");
			document.location.href="login.jsp";
		</script>
		
	<%
			}
		}
	%>
			
		
	
</body>
</html>