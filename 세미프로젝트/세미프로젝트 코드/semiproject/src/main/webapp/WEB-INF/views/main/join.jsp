<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/main/main.jsp"></jsp:include>
<h3>회원가입 화면</h3>
<form action="joinRequest" method="post" >
	<table border='1'>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<th>비번</th>
			<td><input type="password" name="pw" /></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" name="mail" /></td>
		</tr>
	</table><br />
	<input type="submit" value="회원가입" />
</form>
</body>
</html>