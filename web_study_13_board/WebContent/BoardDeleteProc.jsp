<%@page import="model.BoardDAO"%>
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
	String pass=request.getParameter("password");
	int num=Integer.parseInt(request.getParameter("num"));	//패스워드도 가져와야하지만 번호도 가져와야 한다.
	
	BoardDAO bdao=new BoardDAO();
	// 해당 게시글의 패스워드 값을 얻어옴.
	String password=bdao.getPass(num);
	
	if(pass.equals(password)){
		bdao.deleteBoard(num);
		response.sendRedirect("BoardList.jsp");
	
	}else{	
%>
	<script type="text/javascript">
		alert("패스워드가 일치하지 않아 삭제할 수 없습니다. 패스워드를 확인해주세요.")
		history.go(-1);
	</script>
<%
	}
%>

</body>
</html>