<%@page import="com.javalec.daotoex.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javalec.daotoex.MemberDAO"%>
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
	MemberDAO memberdao=new MemberDAO();
	ArrayList<MemberDTO> dtos=memberdao.memberSelect();
	
	for(int i=0;i<dtos.size();i++){
		MemberDTO dto=dtos.get(i);			
		
		String name=dto.getName();			// 꺼내온 걸 저장..?
		String id=dto.getId();
		String pw=dto.getPw();
		String phone=dto.getPhone1()+"-"+dto.getPhone2()+"-"+dto.getPhone3();
		String gender=dto.getGender();
		
		out.println("이름:"+name+", 아이디:"+id+", 비밀번호:"+pw+", 연락처:"+phone+", 성별:"+gender+"<br>");
	}

%>
</body>
</html>