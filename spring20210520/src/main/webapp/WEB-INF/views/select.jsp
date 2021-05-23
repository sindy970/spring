<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jstl : jsp에서 제공하는 문법으로 if,for등과 같은 제어문 문법을 사용할 수 있도록 한다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>select.jsp</h2>
	
	<!-- studyservice에서 가져온 dbList의 값을 출력해줘야 한다. 
		하나의 값이 아닌 여러개의 값을 출력해야 하기 때문에 반복문을 이용해줘야 한다.-->
	<!-- JSTL에서 제공하는 반복문 문법을 활용하여 dbList에 담긴 내용 출력 -->
	
	<c:forEach var="test" items="${dbList}">
	<!-- var속성 : 현재 위치에서 사용할 변수 이름
		items속성 : mav에 담을 때 지정한 이름  -->
		${test} <br>
	</c:forEach>
	
	<!-- 기본주소요청 -->
	<a href = "./">홈으로</a>
	
</body>
</html>