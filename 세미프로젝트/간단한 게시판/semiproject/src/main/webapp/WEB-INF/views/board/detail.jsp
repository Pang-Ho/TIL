<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail JSP</title>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/main/main.jsp"></jsp:include>
<h3>${vo.title }</h3>
<table>
	<tr>
		<th class="w-px160">제목</th>
		<td colspan="5" class="left">${vo.title }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${vo.writer }</td>
		<th class="w-px120">작성일자</th>
		<td class="w-px120">${vo.writedate }</td>
		<th class="w-px80">조회수</th>
		<td class="w-px80">${vo.readcnt }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="5" class="left">${fn:replace(vo.content, crlf, '<br>') }</td>
	</tr>
	<tr>
		<th>첨부 파일</th>
		<td colspan="5" class="left">
			<c:if test="${!empty vo.filename }">
				${vo.filename }
				<span id="preview"></span>
				<a href="download.bo?id=${vo.id }" style='margin-left: 15px'><i class="fas fa-download font-img"></i></a>
			</c:if>
			
		</td>
	</tr>
</table>

<div class="btnSet">
	<a class="btn-fill" href="board.sale">목록으로</a>
	<c:if test="${login_info.id eq vo.writer}">
		<a class="btn-fill" href='modify.sale?id=${vo.id }'>수정</a>
		<a class="btn-fill" onclick="if(confirm('정말 삭제하시겠습니까?')) {href='delete.sale?id=${vo.id }' }">삭제</a>
	</c:if>
</div>
<div id="popup" onclick ="$('#popup, #popup-background').css('display', 'none')"></div>
<div id="popup-background"></div>
<script type="text/javascript">
function showAttachImage(id) {
	//첨부된 파일이 이미지인 경우 보여지게
	var filename = '${vo.filename}';
	var ext = filename.substring( filename.lastIndexOf('.') + 1 ).toLowerCase(); //확장자
	var imgs = [ 'gif', 'jpg', 'jpeg', 'png', 'bmg' ];
	if( imgs.indexOf(ext) > -1 ) {
		var img = '<img src="' + '${vo.filepath}'.substring(1) + '" '
			+ 'id="preview-img" ' 
			+ 'class="' + (id == '#popup' ? 'popup' : 'file-img') + '" '
			+ 'style="border-radius: 50%"/>';
		$(id).html(img);
	}
}

if( ${!empty vo.filename} ) {
	showAttachImage('#preview');
}

$('#preview-img').click(function() {
	$('#popup, #popup-background').css('display', 'block');
	showAttachImage('#popup');
});
</script>
</body>
</html>