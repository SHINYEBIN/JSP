<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="product" class="com.saeyan.javabeans.Product" scope="session"></jsp:useBean>
	<select>
		<c:forEach items="${product.productList}" var="item">
			<option>${item}</option>
		</c:forEach>
	</select>
</body>
</html>