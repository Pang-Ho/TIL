# session 값 jsp에서 Controller로 보내기

```java
session.setAttribute("login_info")
```

* 위 세션을 넣음으로써 같은 브라우저 내에서는 세션을 이용할 수 있다.
* 나 같은 경우 로그인 내용을 계속 이용하였다.

```jsp
<c:if test="${login_info.user_no eq list[0].user_no}">
	<li style="list-style: none"><a class="btn" href="/recipemodify">수정</a></li>
	<li style="list-style: none"><a class="btn" href="/recipedelete">삭제</a></li>
</c:if>
```

* 위 같은 형식으로 user_id가 같은지에 따라 글 수정 버튼을 생성 시켰다.



* 그러나 세션에 있는 user_id 내용을 브라우저에 안 보이게 한 상태로 Controller에 보내고 싶을 때 
* 방법1

```jsp
<%@page import ="main.UserVO" %> 

<%
UserVO vo = (UserVO)session.getAttribute("login_info");
int User_no = vo.getUser_no();
%>

<input type="hidden" name="user_no" value="<%=User_no%>">
```

* 방법2

```jsp
<input type="hidden" name="user_no" value="${login_info.user_no}">
```

