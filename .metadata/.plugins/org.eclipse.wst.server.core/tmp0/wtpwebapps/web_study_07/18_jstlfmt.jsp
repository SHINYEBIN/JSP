<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:formatNumber value="1234567.89"></fmt:formatNumber> <%-- 얘는 코어가 아닌 포멧에 해당한다 --%>
${value}<br>
<fmt:formatNumber value="1234567.89" groupingUsed="false"></fmt:formatNumber>
${value}<br>
<fmt:formatNumber value="0.5" type="percent"></fmt:formatNumber>
${value}<br>
<fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
${value }<br>
<fmt:formatNumber value="10000" type="currency" currencySymbol="$"></fmt:formatNumber>
${value }<br>
<fmt:formatNumber value="1234567.8912345" pattern="###,###.##"></fmt:formatNumber>
${value}<br>
<fmt:formatNumber value="1234567.89" pattern=".000"></fmt:formatNumber>
${value}<br>
<fmt:formatNumber value="123.89" pattern="00000.###"></fmt:formatNumber>
${value}<br>
<fmt:formatNumber value="456.89" pattern="##.#"></fmt:formatNumber>
${value}<br>
<fmt:formatNumber value="123456.89" pattern="##########.###"></fmt:formatNumber> <!-- #은 자릿수 -->
${value}<br>
</body>
</html>