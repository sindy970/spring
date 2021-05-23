<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		background-color: yellow;
	}
	
	table,tr,td {
		border: 1px black solid;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<c:forEach  var="test" items="${dbList}">
		${test} <br> 
	</c:forEach>
	
	<div>
	<table>
		<c:forEach var = "value" items="${dbList}">
		<tr>
		<!-- 세분화 하여 각각의 필드가 가진 요소를 뽑아낼 수 있다. -->
			<td>${value.col1}</td>
			<!-- var속성 값.필드이름 의 형식으로 각필드의 값을 출력할 수 있다. -->
			<td>${value.col2}</td>
			<td>${value.col3}<br></td>
			</tr>
		</c:forEach>
		</table>
	</div>

</body>
</html>