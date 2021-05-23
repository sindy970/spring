<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		tabel,tr,td {
			border: 1px black solid;
			border-collapse: collapse;
		}
	</style>
</head>
<body>
<h2>memberlist.jsp 페이지 입니다.</h2>
<form action="memberlist">
<table>
	<c:forEach var = "member" items="${mdtoList}">
	<tr>
		<td>${member.mid}</td>
		<td>${member.mpassword}</td>
		<td>${member.mname}</td>
		<td>${member.memail}<br></td>
		
	</tr>
	</c:forEach>
	</table>
</form>
</body>
</html>