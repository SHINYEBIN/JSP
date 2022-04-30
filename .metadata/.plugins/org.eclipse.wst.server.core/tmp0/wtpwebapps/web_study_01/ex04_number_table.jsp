<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		width:20%;
		border:1px solid #333333;
	}
	
	td{
		padding:10px;
		border:1px solid #333333;
		text-align:center;
	}
	
	.a{
		/* border-collapse:collapse; */
		/* border-collapse:seperate; */
	}

</style>
</head>
<body>
	<table class="a">
		<%
			for(int i=0;i<3;i++){
		%>
			<tr>
				<td>Number</td>
				<td><%=i+1%></td>
			</tr>
		<% 
			}
		%>
	</table>
</body>
</html>