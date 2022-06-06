<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/main/main.jsp"></jsp:include>
<h3>회원 정보</h3>

아이디 : ${login_info.id }<br>
성명 : ${login_info.name }<br> 
이메일 : ${login_info.mail }<br>

<div class='btnSet'>
		<a class='btn-fill' href="modify.cu?id=${login_info.id }">수정</a>
		<a class='btn-fill' onclick="if( confirm('정말 탈퇴하겠습니까?') ){ href='delete.cu' }" >회원탈퇴</a>
</div>
</body>
</html>