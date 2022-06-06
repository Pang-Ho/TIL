<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<jsp:include page="/WEB-INF/views/main/main.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<h3>   판매 게시판</h3>

<div id="list-top">
	<div>
		<ul>
			<c:if test="${not empty login_info.id}">
				<li style="list-style: none;"><a class="btn-fill" href="new.sale">글쓰기</a></li>
			</c:if>
			<c:if test="${empty login_info.id}">
				
			</c:if>
		</ul>
	</div>
</div>

<table>
	<tr>
		<th class="w-px60">번호</th>
		<th>제목</th>
		<th class="w-px100">작성자</th>
		<th class="w-px120">작성일자</th>
		<th class="w-px60">첨부파일</th>
	</tr>
	<c:forEach items="${list }" var="vo">
		<tr>
			<td><a href="board.salemain?id=${vo.id}">${vo.id }</td>
			<td><a href="board.salemain?id=${vo.id}">${vo.title }</td>
			<td>${vo.writer }</td>
			<td>${vo.writedate }</td>
			<td></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>