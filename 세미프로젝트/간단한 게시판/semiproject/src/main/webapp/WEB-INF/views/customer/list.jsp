<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/main/main.jsp"></jsp:include>
<div id="content">
	<h3>[${vo.name }]유저 정보</h3>
	<table class='w-pct60'>
		<tr>
			<th>아이디</th>
			<td>${vo.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${vo.pw }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${vo.mail }</td>
		</tr>
	</table>
	<div class='btnSet'>
		<a class='btn-fill'>수정</a>
		<a class='btn-fill'>삭제</a>
	</div>
</div>
</body>
</html>