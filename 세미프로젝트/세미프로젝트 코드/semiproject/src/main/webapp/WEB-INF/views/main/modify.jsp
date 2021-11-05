<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/main/main.jsp"></jsp:include>
<h3>회원정보 수정</h3>
<form action="modify.cu" method="post" >
	<table border='1'>
		<input type="hidden" name="id" value=${login_info.id } />
		<tr>
			<td>현재 비밀번호 : ******</td>
			<th>변경 할 비밀번호</th>
			<td><input type="password" name="pw" /></td>
		</tr>
		<tr>
			<td>현재 이름 : ${login_info.name }</td>
			<th>변경 할 이름</th>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>현재 이메일 : ${login_info.mail }</td>
			<th>변경 할 이메일</th>
			<td><input type="email" name="mail" /></td>
		</tr>
	</table><br />
	<input type="submit" value="수정" />
	</form>
</body>
</html>