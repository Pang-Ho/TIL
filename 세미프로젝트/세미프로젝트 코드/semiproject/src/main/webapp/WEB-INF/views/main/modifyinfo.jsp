<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 완료</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/main/main.jsp"></jsp:include>
<h3>수정이 완료되었습니다.</h3>
	<table border='1'>
		<tr>
			<td>변경된 비밀번호 : ******</td>
		</tr>
		<tr>
			<td>변경된 이름 : ${login_info.name }</td>
		</tr>
		<tr>
			<td>변경된 이메일 : ${login_info.mail }</td>
		</tr>
	</table><br />
</body>
</html>