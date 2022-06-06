<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/main/main.jsp"></jsp:include>
<h3>회원 탈퇴</h3>
<form action="delete.cu" method="post" >
	<table border='1'>
		<input type="hidden" name="id" value=${login_info.id } />
		<tr>
			<td>회원 탈퇴하려면 비밀번호를 작성해주세요.</td>
			<th>비밀번호</th>
			<td><input type="password" name="pw" /></td>
		</tr>
		</table><br />
	<input type="submit" value="회원탈퇴" />
	</form>
</body>
</html>