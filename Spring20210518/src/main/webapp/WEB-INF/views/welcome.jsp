<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style type="text/css">
		h1{
			color: blue;
		}
	</style>
</head>
<body>
	<h1>welcome.jsp</h1>
	<h1>안녕하세요</h1>
	
<!-- welcomemsg라는 주소로 msg라는 파라미터에 데이터를 담아서 전송 
		데이터를 보낼때는 어디에 담아서 보내는 것이 좋다!! 꼭 담아서 보내줘야 오류가 적다
		name속성의 값에 담아서 보낸다.-->
		<!-- form태그의 전송방식
				1. post
				2. get -->
	<form action="welcomemsg" method="get">
		입력 메시지 : <input type="text" name="msg"><br>
		입력 메시지2 : <input type="text" name="msg2"><br>
		<input type="submit" value="전송">
	</form>
	
	<!-- 링크를 통해 파라미터 전송하기 -->
	<a href="linkmsg?val1=데이터1&val2=데이터2">링크로 데이터 전송</a>
	<!-- 내가 보내고자 하는 주소값에 ?로 구분하여 변수와 변수 값을 보낼 수 있다. 여러개를 보낼경우 &오 구본해준다. -->
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>