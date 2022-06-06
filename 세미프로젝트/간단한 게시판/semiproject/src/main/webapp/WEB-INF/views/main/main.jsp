<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<style>
header ul, header ul li {
	margin: 0;
	padding: 0;
	display: inline;
}

header .category {
	font-size: 18px;
}

header .category ul li:not(:first-child) { /* 첫번째 li만 빼고 지정 */
	padding-left: 30px;
}

header .category ul li a:hover, header .category ul li a.active {
	font-weight: bold;
	color: #0000cd;
}

header #userid, header #userpw {
	width: 100px;
	height: 18px;
	font-size: 14px;
}

header ul li input { display:block; }

</style>
<header style="border-bottom: 1px solid #ccc; padding: 15px 0; text-align: left">
	<div class="category" style="margin-left: 100px;"> 
		<ul>
			<li><a href="<c:url value='/'/>login"><img width="100" height="100" src="resources/imgs/logo.png" /></a></li>
			<li><a href='detail.cu'>내 정보</a></li>
			<li><a href='board.sale'>판매 게시판</a></li>
			<!-- <li><a href='board.free'>자유 게시판</a></li>
			<li><a href='board.share'>나눔 게시판</a></li> -->
		</ul>
	</div>
	
	<div style="position: absolute; right: 0; top: 25px; margin-right: 100px;">
		<!-- 로그인한 경우 -->
		<c:if test="${!empty login_info }">
			<ul>
				<li>${login_info.name } [ ${login_info.id } ]</li>
				<li><a class="btn-fill" onclick="go_logout()">로그아웃</a></li>
				
			</ul>
		</c:if>

		 <!-- 로그인하지 않은 경우 -->
		 <c:if test="${empty login_info }">
			 <ul>
			 	<li>
			 		<span style="position: absolute; top: -14px; left: -120px">
						<input type="text" id="id" placeholder="아이디" />
						<input type="password" onkeypress="if(event.keyCode == 13) {go_login()}" id="pw" placeholder="비밀번호" />
			 		</span>
			 	</li>
			 	<li><br><br><br><a class="btn-fill" onclick="go_login()">로그인</a></li>
			 	<li><a class="btn-fill" href="/semiproject/join">회원가입</a></li>
			 </ul>
		 </c:if>
	</div>
</header>

<script>
function go_login() {
	if( $('#id').val() == '' ) {
		alert('아이디를 입력하세요!');
		$('#id').focus();
		return;
	} else if( $('#pw').val() == '' ) {
		alert('비밀번호를 입력하세요!');
		$('#pw').focus();
		return;
	}

	$.ajax({
		type: 'post',
		url: 'login',
		data: { id:$('#id').val(), pw:$('#pw').val() },
		success: function(data) {
			if(data == 'true') {
				location.reload();
			} else {
				alert('아이디나 비밀번호가 일치하지 않습니다!');
				$("#id").focus();
			}
		},
		error: function(req, text) {
			 alert(text + ': ' + req.status);
	 	}
	});
}

function go_logout() {
	$.ajax({
		type: "post",
		url: "logout",
		success: function() {
			location.reload();
		},
		error: function(req, text) {
			 alert(text + ': ' + req.status);
	 	}
	});
}
</script>
</head>
<body>
 
</body>
</html>