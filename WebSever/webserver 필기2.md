# 웹 서버.2

## api 이름

| 상속                                                    | javax.servlet.http.HttpServlet                               |
| ------------------------------------------------------- | ------------------------------------------------------------ |
| 매개변수 선언                                           | javax.servlet.http.HttpServletRequest<br />javax.servlet.http.HttpServletResponse |
| 다른 서블릿 포함 or 이동<br />다른 서블릿과 데이터 공유 | RequestDispatcher<br />request.setAttribute("","");<br />request.getAttribute("");<br />request.removeAttribute(""); |
| 다른 서블릿과 데이터 공유                               | javax.servlet.http.Cookie                                    |
| 다른 서블릿과 데이터 공유                               | javax.servlet.http.HttpSession<br />session.setAttribute("","");<br />session.getAttribute("");<br />session.removeAttribute(""); |



## Attribute

```java
AServelt
@WebServlet("/")
request.getParameter("id");
request.setAttribute("name", "campus"); // 데이터를 주고받아야할 때 
RequestDispatcher rd = request.getRequestDispatcher("/");
rd.forward(request, response)
```

```java
BServelt
@WebServlet("/")
request.getParameter("id");
String name = (String)request.getAttribute("name"); // "campus" 데이터를 공유받을 수 있음
```



## Session, Cookie

* include나 forward 관계가 아님에도 데이터를 공유할 수 있는 것이 Cookie와 Session임

| http 프로토콜이 url을 요청                                   |
| ------------------------------------------------------------ |
| 파라미터 전송 방식 두 가지 get/post                          |
| 첫번째 요청(id = test)-연결생성(init)-처리-응답-연결해제(destroy) => 연결이 해제되면 모든 요청/응답객체삭제 |
| 두번째 요청(id = ???? 서버에 정보가 남아있지 않음) -연결생성(init)-처리-응답-연결해제(destroy) |

* http 프로토콜 서버는 모든 클라이언트의 이전 정보를 서버에 남기지 않음 => 메모리한계 때문에



### 서블릿 데이터 공유

| 쿠키                                               | 세션                   |
| -------------------------------------------------- | ---------------------- |
| 브라우저 종료시 혹은 종료 이후 지정 시각까지       | 부라우저 종료시        |
| 클라이언트 컴퓨터측 저장기술                       | 서버 컴퓨터측 저장기술 |
| 문자열만 저장 가능<br />(인코딩 설정해서 보내야함) | 자바객체 저장 가능     |
| 보안에 취약함                                      | 보안에 유리함          |



| 1. 클라이언트 요청한다.<br /><br />4. 쿠키 내용이 브라우저로 전송된다. | 2. 서버 에서 쿠키 객체로 생성한다.<br />Cookie c = new Cookie("쿠키명", "값");<br />c.setMaxAge(60x60x24); => 쿠키 살아있는 시간<br />3. 클라이언트에게 응답한다<br />response.addCookie(c); |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 5. 클라이언트 요청한다<br />(동일 서버로부터 받은 쿠키도 같이 전송) | 6. 클라이언트로부터 쿠키를 읽어온다<br />Cookies[] coo = request.getCookies(); |



### 쿠키 만들기

* 부라우저 종료시 쿠키 삭제

```java
Cookie c = new Cookie("book", "thisisjava");
response.addCookie(c);
		
response.setContentType("text/html;charset=utf-8");
PrintWriter out = response.getWriter();
out.println("클라이언트로 주문한 책 정보를 전송했습니다.");
```

![image-20210830104448049](TIL/md-images/image-20210830104448049.png)

* 부라우저 종료되어도 쿠키 유지

```java
Cookie c = new Cookie("book", "thisisjava");
c.setMaxAge(60x60x24);
response.addCookie(c);
		
response.setContentType("text/html;charset=utf-8");
PrintWriter out = response.getWriter();
out.println("클라이언트로 주문한 책 정보를 전송했습니다.");
```

![image-20210830110144309](TIL/md-images/image-20210830110144309.png)

### 쿠키 가져오기

```java
response.setContentType("text/html;charset=utf-8");
PrintWriter out = response.getWriter();
Cookie[] coo = request.getCookies();
for(int i = 0 ; i < coo.length ; i++) {
    String name = coo[i].getName();
    String value = coo[i].getValue();
    out.println("책 제목을 지정한 쿠키 이름은 " + name + 
                " 이고 책 제목은" + value + "인 책을 주문해 놓으신 적이 있습니다.");
```

* 쿠키는 문자열만 저장 가능하기에 한글인경우 인코딩을 해야함

  Cookie c = new Cookie("book", URLEncoder.encode("이것이 자바다", "utf-8"));

* 인코딩을 했다면 디코딩을 해서 쿠키를 받아와야함

  value = URLDecoder.decode("value", "utf-8");



### 세션

| 1. 클라이언트 요청한다.<br />                                | 2. 처리 -  세션 데이터 저장 - 공유<br />HttpSession session = request.getSession();<br />false - 최초 연결시 setAttribute<br />3. session.setAttribute("세션 속성명", 값(object)); |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 4. 클라이언트 요청한다<br /><br /><br /><br />7. 응답        | 5. HttpSession session = request.getSession();<br />true - 이전 연결 중<br />6. Object o = session.getAttribute("세션 속성명");<br />=> 형변환 필요시 하면됨 |
| 8. 클라이언트 요청한다(로그아웃 경우처럼 서버에 남겨높은 정보 삭제) | 9.  HttpSession session = request.getSession();<br />true - 이전 연결 중<br />10. session.removeAttribute("세션 속성명") |

* 로그인을 할 필요 없는 상황에서
* 브라우저가 종료되고
* Object 타입으로 받기 때문에 모든 타입의 데이터를 받을 수 있음



### 세션만들기

```java
HttpSession session = request.getSession();
session.setAttribute("session1", "multicampus"); //브라우저 종료시
		
//브라우저에 응답
response.setContentType("text/html;charset=utf-8");
PrintWriter out = response.getWriter();
out.println("서버에 세션 정보를 저장했습니다.");
```



### 세션 꺼내오기

```java
HttpSession session = request.getSession();
//Object o = session.getAttribute("session1");
String o = (String)session.getAttribute("session1");

//브라우저에 응답
response.setContentType("text/html;charset=utf-8");
PrintWriter out = response.getWriter();
out.println("서버에 세션 정보" + o + "를 조회하였습니다.");
//인코딩 안해도됨 서버에서 저장하고 브라우저에 올리는 것이 아니기 때문에
```

### 세션 삭제 방법

1. 브라우저가 종료돼도 삭제된다.
2. removeAttribute("속성") - 하나씩 삭제
3. invalidate() - 모든 속성 삭제(브라우저 종료하지 않았어도)
4. 30분간 액션이 없으면 자동으로 삭제
   * 30분이란 것은 web.xml에 session-timeout에 설정되어 있음
   * session.setMaxInactiveInterval(30*60); 코드로도 변경 가능

![image-20210830131321780](TIL/md-images/image-20210830131321780.png)



* datasource 설정, port 번호 수정 설정 - Servers\tom...\server.xml, web.xml => 모든 프로젝트 공통 설정
* 서블릿 url 매핑 - dynamic web project\webcontent\WEB-INF\web.xml => 각 프로젝트마다

```java
session.invalidate();
```



### 세션이 있는지 없는지

```java
if(session.isNew() == false && session.getAttribute("session1") != null && session.getAttribute("session2") != null) {
    
}
```



### 실습

![image-20210830135606276](TIL/md-images/image-20210830135606276.png)





## JSP

jsp - java server page / html + java

* 처음 자바 웹서버는 서블릿 구조만 제공되었다.

  그 후 서블릿 기능 중 별도 화면 기능을 쉽고 간결하게 작업하기 위해 JSP가 등장했다.

  톰캣 서버가 jsp 내용을 자바 언어로 만들어줌

| 서블릿                                                       | jsp                                                          |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| class A extends HttpServlet<br />doGet(){<br />응답 - 자바 언어 내부에 html 언어를 포함한 형식<br />out.prinln("<h1 ... ")} | <% 서블릿 api + db + DVO, VO객체생성 자바문장; %><br /><html<br /><body<br />html 양식 언어 내부 자바 문장 포함<br />jsp 태그와 html 태그 혼용 |



### 작성

1. servlet api + jsp api + 내장 객체들
2. <% %>

| html       | html<br />css<br />js<br />jquery                            |
| ---------- | ------------------------------------------------------------ |
| jsp 기본   | <%  지역변수 선언, 자바 문장   %><br />표현문 태그 <%=변수명     %><br />선언문 태그 <%! 메소드 정의, 필드변수 정의    %><br />jsp 주석 태그<%--     --%><br />지시문 태그<%@     %> |
| jsp action | <jsp:xxxx   />                                               |
| jsp custom | <c:xxx    />                                                 |
| el         | ${}<br />$("#i")                                             |
| 내장객체   | jsp는 서블릿보다 간결하게 응답, servlet api<br />내장객체 : request, response, exception, session .... 서블릿과 달리 만들 필요가 없음 |

response.setContentType("text/html;charset=utf-8"); => contentType="text/html;charset=utf-8"



```jsp
<%! String user = "다른값"; %> <!-- =>필드변수 -->

<%! void notService(){
	System.out.println(user); /* =>필드변수 불러옴 */
} %>

<% String user = "test"; %> <!-- =>_jspService 메소드의 지역 변수라서 -->

<h1 id="jsp"><%=user %>, <%=this.user %></h1>
```



* jsp 사용 스크립트 언어 = 자바 언어문장 = 스크립트릿 태그

### jsp에서 구구단 만드는 방법 2가지

1. html 안에 jsp 넣기

```jsp
<table>
<% 	for(int j=1 ; j<10 ; j++){ %>
	<tr><%for(int i=2 ; i<10 ; i++){%>
			<td><%=i + "*" + j + "=" + i * j%></td>
		<%}%>
	</tr>
	<%}%>

</table>
```

2. jsp안에 서블릿에서 사용하던 것들 넣기

```jsp
<table>
<%	for(int j=1 ; j<10 ; j++){ 
	out.println("<tr>");
	for(int i=2 ; i<10 ; i++){
	out.println("<td>" + i + "*" + j + "=" + i * j + "</td>");
		}
	out.println("</tr>");
	}
%>
</table>
```







