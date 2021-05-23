<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
		h1{
			background-color: yellow;
			color: red;
		}
	</style>
</head>
<body>
<h2>hello.jsp</h2>
<h1>안녕하세요</h1>

<!-- 링크 방식으로 화면이동(링크방식으로 컨트롤러 요청하기) -->
<a href="test123">test123</a>
<!-- 주소값이 test123으로 변하는 것이 아니라 기존 주소에 /test123이 추가된 형태로 주소이동이 된다. -->

<!-- 링크를 클릭했을 경우 welcome.jsp로 이동하는 링크 생성 -->
<a href="welcome">welcome.jsp로 이동</a>


<h2>DB에 데이터 저장하기</h2>
<!-- DB연동을 위한 form태그 -->
<form action="insertDB">
	입력1 : <input type="text" name="data1"><br>
	<input type="submit" value="저장">
</form>
</body>
</html>