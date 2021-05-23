<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		h2{
			color= blue;
		}
	</style>
</head>
<body>
	<h2>abc.jsp</h2>
	<h2>Hello world!!</h2>
	
	<!--  form태그를 이용하여 controller로 데이터 보내기 
			form태그에 입력한 값을 서버로 보내기 위해선 name 속성을 사용한다.
			action 속성 : 데이터를 전송할 주소(목적지)-->
	<!-- paramtest라는 주소에 param1이라는 변수에 데이터를 담아서 전송한다. -->
	<!-- http://localhost:8081/paramtest?param1=오늘은 월요일 의 형태로 전달이 된다. -->
	<form action="paramtest">
		<input type="text" name="param1">
		<input type="submit" value="서버로 전송">
	</form>	
</body>
</html>