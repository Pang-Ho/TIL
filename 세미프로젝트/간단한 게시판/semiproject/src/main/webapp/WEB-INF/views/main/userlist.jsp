<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${userlist }" var="marketVO">
<h3> 사번 : ${marketVO.id} 이름 : ${marketVO.name } 메일 : ${marketVO.mail }</h3>
</c:forEach>
<h3>${marketVO.id}</h3>
</body>
</html>