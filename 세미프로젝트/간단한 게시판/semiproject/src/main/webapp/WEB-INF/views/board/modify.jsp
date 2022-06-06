<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<title>modify JSP</title>
</head>
<body>
<h3>판매글 수정</h3>
<!-- 
 - 파일 첨부 시 form 반드시 갖고 있어야 할 속성 
	1. 반드시 method는 post이어야만 한다.
	2. enctype을 지정한다. ▶ enctype='multipart/form-data'
-->
<form action="modify.sale" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${vo.id }"/>
	<input type="hidden" name="attach" />
	<table>
		<tr>
			<th class="w-px160">제목</th>
			<td><input class="need" type="text" name="title" value="${vo.title }"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="need" name="content">${vo.content }</textarea></td>
		</tr>
		<tr>
			<th>첨부 파일</th>
			<td class="left">
				<label>
					<input id="attach-file" type="file" name="file" />
					<img src="resources/imgs/select.png" class="file-img" />
				</label>
				<span id="file-name">${vo.filename }</span>
				<span id="delete-file" style='display:${empty vo.filename ? "none" : "inline"}; color:red; margin-left:20px;'><i class="fas fa-times font-img"></i></span>
			</td>
		</tr>
	</table>
</form>
<div class="btnSet">
	<a class="btn-fill" onclick="$('form').submit()">저장</a>
	<a class="btn-empty" href="board.salemain?id=${vo.id }">취소</a>
</div>

<script type="text/javascript" src="resources/js/need_check.js"></script>
<script type="text/javascript" src="resources/js/file_attach.js"></script>
</body>
</html>