<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<title>new JSP</title>
</head>
<body>
<h3>신규 판매 글</h3>

<form action="insert.sale" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th class="w-px160">제목</th>
			<td><input type="text" name="title" class="need"/></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${login_info.name }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" class="need"></textarea></td>
		</tr>
		<tr>
			<th>파일 첨부</th>
			<td class="left">
				<label>
					<input type="file" name="file" id="attach-file"/>
					<img src='resources/imgs/select.png' class="file-img" />
				</label>
				<span id="file-name"></span>
				<span id="delete-file" style="color: red; margin-left: 20px;" ><i class="fas fa-times font-img"></i></span>
			</td>
		</tr>
	</table>
</form>
<div class="btnSet">
	<a class="btn-fill" onclick="$('form').submit()">저장</a>
	<a class="btn-empty" href="board.sale">취소</a>
</div>

<script type="text/javascript" src="resources/js/need_check.js"></script>
<script type="text/javascript" src="resources/js/file_attach.js"></script>
</body>
</html>