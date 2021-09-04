# 웹 서버

## JSP

jsp - java server page

​		html + java

* 처음 자바 웹서버는 서블릿 구조만 제공되었다.

  그 후 서블릿 기능 중 별도 화면 기능을 쉽고 간결하게 작업하기 위해 JSP가 등장했다.

  톰캣 서버가 jsp 내용을 자바 언어로 만들어줌
  
  	1. 컨테이너는 JSP파일을 자바 파일로 변환합니다
  	2. 변환된 자바 파일을 클래스 파일로 컴파일합니다
  	3. 컨테이너는 클래스 파일을 실행하여 부라우저로 전송합니다

| 서블릿                                                       | jsp                                                          |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 자바 언어 구현 + html태그 응답                               | 자바 언어 구현 + html태그 응답                               |
| 자바 언어 내부에 html 문장<br />doGet(){<br />처럼 오버라이딩 형식으로 문장 작성<br />out.prinln("<h1 ... ")} | html 언어 내부에 자바 문장<br />서블릿처럼 메소드 오버라이딩 필요없다<br /><% out.print() %> |



### 작성

1. servlet api + jsp api + html + 내장 객체들

| jsp 기본 태그   | 기본 자바문장<% 지역변수 선언 %><br />표현문 태그 <%=변수명     %><br />선언문 태그 <%! 메소드 정의, 필드변수 정의    %><br />jsp 주석 태그<%--     --%><br />지시문 태그<%@    %> |
| --------------- | ------------------------------------------------------------ |
| jsp action 태그 | <jsp:xxxx   />                                               |
| jsp custom 태그 | <c:xxx    />                                                 |
| el              | ${}<br />$("#i")                                             |
| 내장객체        | jsp는 서블릿보다 간결하게 응답, servlet api 그대로 사용할 수 있음 그러나 자바 문장 구현을 없애자 해서 나온 것이 내장 객체임<br />내장객체 : request, response, exception, session, application 서블릿과 달리 만들 필요가 없음 |

서블릿의 출력 형식 지정은 response.setContentType("text/html;charset=utf-8"); 

=> JSP 출력 형식 지정은 contentType="text/html;charset=utf-8"



```jsp
<%! String user = "다른값"; %> <!-- =>필드변수 -->

<%! void notService(){
	System.out.println(user); /* =>필드변수 불러옴 */
} %>

<% String user = "test"; %> <!-- =>_jspService 메소드의 지역 변수라서 -->

<h1 id="jsp">지역변수<%=user %>, 필드변수<%=this.user %></h1>
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



## JSP기본태그

### 페이지 디렉티브 태그

```jsp
<%@ page 속성1="" 속성2="" .... %>
```

| 속성         | 설명                                         |
| ------------ | -------------------------------------------- |
| info         | 페이지 설명해주는 문자열                     |
| contentType  | jsp페이지 출력 형식 지정                     |
| pageEncoding | jsp 페이지에서 사용하는 문자열 인코딩을 지정 |
| import       |                                              |
| session      |                                              |
| buffer       |                                              |
| autoFlush    | 출력 전 버퍼가 다 채워질 경우 동작 지정      |
| errorPage    | 예외 발생시 예외 처리 담당 지정              |
| isErrorPage  | 예외처리 담당 페이지인지 안내                |
| isELIgnored  | EL 사용유무                                  |
| languager    |                                              |

### 인클루드 디렉티브 태그

* 공통으로 사용하는 JSP페이지를 다른 JSP 페이지에 추가할 때 사용

  ```jsp
  <%@ include file="c.jsp"%>
  ```

  보통 페이지마다 똑같이 보여지는 메뉴가 있다면 사용



## JSP 스크립트 요소

### 스크립트릿

* jsp 페이지에서 여러가지 동적인 처리를 제공하는 기능으로 <% %> 기호안에 자바코드로 구현한다. //<% %> 이 기호를 스크립트릿이라고 부름
* 선언식, 표현식, 주석문  



### 내장 객체(자주 사용하는 객체가 미리 변수 선언되어 제공)

1. JSP 페이지의 내장 객체란 JSP가 서블릿으로 변환될 떄 컨테이너가 자동으로 생성시키는 서블릿 멤버 변수를 말한다.
2. <%! %> 태그 제외하면 jsp 모든 내용은 _jspService() 메서드에 생성된 내장 객체를 저장하는 내장 변수가 선언된 코드다
3. _jspService() 지역변수처럼 취급됨

| 내장 객체 이름 | 서블릿 타입                                                  | 역할                                                         | 메소드                 |
| -------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ---------------------- |
| request        | javax.servlet.http.HttpServletRequest                        | 요청                                                         | request.getParameter() |
| response       | javax.servlet.http.HttpServletResponse                       | 응답                                                         |                        |
| out            | javax.servlet.jsp.JspWriter(PrintWriter 하위)                | 응답 출력 객체                                               | out.println()          |
| session        | javax.servlet.http.HttpSession                               | 브라우저 내부 공유                                           |                        |
| page           | java.lang.Object(자바에서 this같은 존재)                     | 현재 jsp 소스를 서블릿 소스로 변환 - 컴파일 -  객체로 생성(tomcat 서버가 사용) |                        |
| pageContext    | javax.servlet.jsp.PageContext                                | 현재 jsp 내장객체 조회 객체                                  |                        |
| config         | javax.servlet.ServletConfig                                  | web.xml 파일에 변수 저장하고 jsp 파일에서 사용               |                        |
| application    | javax.servlet.ServletContext<br />application.getAttribute("변수");<br />application.setAttribute("변수", ""); | 현재 컨텍스트의 모든 jsp파일 공유(브라우저 종료 이후에도 가능) |                        |
| exception      | java.lang.Throwable                                          | 예외                                                         |                        |

### session, application

포함/이동 서블릿까지만 공유 request.setAttribute("","")

하나의 브라우저 내부에서 종료까지 공유 session.setAttribute("","")

ie + 크롬 모든 브라우저에서 서버 종료까지 공유 application.setAttribute("","")



### jsp 작성

```jsp
<% 
if(request.getMethod().equals("POST")) { //request.getMethod => get인지 post인지 확인
request.setCharacterEncoding("utf-8");  //post 방식에선 인코딩 설정 필요하다.
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String[] con = request.getParameterValues("con"); 
%>

<h1> 아이디 = <%=id %></h1>
<h1> 암호 = <%=pw %></h1>
<% for(int i = 0 ; i < con.length ; i++) { %>
	<h1> 관심사항 = <%=con[i] %></h1>
<% }
} %>
```



```jsp
<h1>총 버퍼 크기 = <%= out.getBufferSize() %> </h1>
<% out.println("출력합니다"); %>
<%= "출력합니다." %>
<h1>남은 버퍼 크기 = <%= out.getRemaining() %> </h1> //out.getRemaining() => 남은 버퍼크기 확인
<!-- 1. out.println 메소드는 클라이언트 즉각 출력되는 것이 아님
	 2. 서버 jsp 출력내용 모아서 버퍼 메모리에 임시 저장함
	 3. 다른 파일로 이동이 없고, 출력을 하지말라는 명령도 없으면 파일 끝까지 수행
	 4. 브라우저 출력
	 다른 파일로 이동시에는 현재 파일 출력 내용 무시하고 이동 -->
```

### jsp주석과 html주석

* html 주석은 브라우저까지 보내지만

* jsp 주석은 서버까지만 보냄 

  즉, 버퍼 크기에서도 jsp 주석은 크기 차지 안함

```jsp
<% out.clearBuffer(); %> <!-- 모든 출력이 취소됨 -->
```



### 예외처리 

* http 프로토콜 응답코드

| 200, 300                  | 정상 실행 정상 결과 응답                                     |
| ------------------------- | ------------------------------------------------------------ |
| 404                       | 요청파일 서버내부 존재x                                      |
| 405                       | get방식 => doPost메소드구현<br />post방식 => doGet메소드구현 |
| 400<br />http:....?su=aaa | 스프링에서 보임<br />처리메소드(int su)<br />클라가 요청한 타입과 서버에서 정한 타입이 맞지 않을 때 |
| 500                       | 서블릿이나 jsp 논리적인 오류                                 |
|                           | exception 내장객체로 예외처리                                |

### 예외처리 방법 3가지

#### 1. try/catch RequestDispatcher

```jsp
<%
try(){
...
}
catch(Exception e){
   ...
RequestDispatcher rd = request.getRequestDispatcher("b.jsp");
rd.forward(request, response);
}
```

#### 2. errorPage/isErrorPage

```jsp
a.jsp
<%@ page errorPage="b.jsp" >

b.jsp
<%@ page isErrorPage="true">
```



#### 3. web.xml 수정 / isErrerPage

```xml
<error-page>
	<exception-type>java.lang.ArithmeticException</exception-type>
    <location>/b.jsp</location>
</error-page>
```



### Attribute

* pagecontext, request, session, application속성을 갖고있다.
* JSP 페이지 사이에서 정보를 주고 받거나 공유하기 위한 목적으로 사용된다.
* request - 이 기본객체는 한번의 요청에 대해 유효하게 동작하며, 한 번의 요청을 처리하는데 사용되는 모든 jsp에서 공유된다.

* 오류 전달 및 setAttribute로 오류 발생 파일명 전달

```jsp
<% 
request.setAttribute("filename", request.getRequestURI());
String name = request.getParameter("name");
if(name.length() <= 10) {
	out.println("<h1>올바른값</h1>");
	System.out.print("b");
}
%>
```

* c.jsp를 통해 예외 처리 및 오류 발생 파일명 확인

```jsp
<%
if(exception.getClass().getName().equals("java.lang.NumberFormatException")){
	out.println(request.getAttribute("filename"));
	out.println("<h3>숫자를 입력해야 진행됩니다.</h3>");
} else if(exception.getClass().getName().equals("java.lang.nullPointerException")){
	out.println(request.getAttribute("filename"));
	out.println("<h3>이름은 필수 입력 사항입니다.<h3>");
}
%>
```



### welcome 파일 지정하기

![image-20210831133456383](../md-images/image-20210831133456383.png)

* jsptest까지 쳤을 때 순서대로 welcome-file을 찾음



## 자바 코드를 없애는 액션 태그

### forward, include

* 서블릿에서 사용하던 include와 forward

```java
RequestDispatcher rd = requset.getRequestDispatcher("/b or b.jsp");
rd.include();
rd.forward();
```

* jsp에서 사용할 수 있는 액션태그 inclue와 forward

```jsp
<jsp:include page="/b or b.jsp"/>
<jsp:forward page="/b or b.jsp"/>
```

#### Include 액션태그는 공통적으로 사용하는 홈페이지의 화면에 사용된다.

* image.jsp

```jsp
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String imgName = request.getParameter("imgName");
%>
<body>
	<h1>이름은 <%=name></h1>
    <img src="./img/<%=imgName %>"/>
</body>
```

* include.jsp

```jsp
<body>
    안녕하세요. 팡 쇼핑몰입니다.<br>
    <jsp:include page="image.jsp" flush="true">
    	<jsp:param name="name" value="팡"/>
        <jsp:param name="imgName" value="pang.png"/>
    </jsp:include>
</body>
```

#### include 디렉티브, include 액션태그

* include 디렉티브는 파일 소스만 복붙하는 정적방식
* include 액션태그는 포함될 페이지 결과들까지 합쳐서 보이는 동적방식(param 액션태그들을 이용해 동적처리가 가능해짐)

#### forward 태그

* 자바태그 없이 포워딩 할 수 있는 것이 장점

```jsp
<jsp:forward page="포워딩할 jsp페이지">
	...
</jsp:forward>
```





### useBean

* 서블릿에서 객체 생성 방법

```java
MemberVO vo = new MemberVO("","","","");
request.setAttribute("이름",vo);
```

* jsp에서 사용할 수 있는 액션태그 useBean

```jsp
<jsp:useBean id="vo" class="vo.MemberVO" scope="request" >
    				class="패키지명.클래스명"
```

* ​	scope는 자바 빈(VO)에 대한 접근 범위를 지정하는 역할

  jsp:usebean scope=" "

  page - 공유 안하고 페이지 내에서만 쓰겠다.

  request - forward, include 되어도 공유하겠다.

  session - 같은 브라우저 내에서는 계속 쓰겠다.

  application - 서버가 시작돼서 종료까지 계속 쓰겠다.

  

* setter 태그 setProperty

```jsp
<jsp:setProperty name="vo" property="id" value='<%=vo.getParameter("id")%>' />
```

```jsp
<jsp:setProperty property="memberid" name="vo" param="id"/>
			usebean파라미터 명	useBean 이름    불러오는 파라미터 명
```

​			* 여기서 property 명과 param 명이 같다면 property와 name만 써도 된다

* getter 태그 getProperty

```jsp
<jsp:getProperty property="memberid" name="vo"/>
                 가져올파라미터 명     가져오는 bean이름
```

<%= 안써도 브라우저 출력됨						

| a.jsp                      | b.jsp                |
| -------------------------- | -------------------- |
| 처리 응답 이미지출력       | 처리 응답 이미지출력 |
| bottom.jsp로 이미지를 출력 |                      |

```jsp
<h1>a.jsp 처리 내용입니다.</h1>
<h1>회원 리스트를 출력합니다.</h1>
<jsp:include page="bottom.jsp" /> => 
<h3>a.jsp 추가 내용입니다.</h3>
```

![image-20210831141651608](../md-images/image-20210831141651608.png)

action 태그와 page 태그 차이

![image-20210831144251198](../md-images/image-20210831144251198.png)





### 생성자 호출, setter, getter  

```jsp
<%@page import="vo.MemberVO">
<% MemberVO vo = new MemberVO();  => 기본생성자만 호출가능
vo.setMemeberid("member1")%>  => setter 호출
<%=vo.getMemberid()%> => getter 호출
```

```jsp
<jsp:useBean id="vo" class="vo.MemberVO" scope="page"/>
<jsp:setProperty name="vo" property="memberid" value="member1" />
<jsp:setProperty name="vo" property="memberid" param="id" />
<jsp:getProperty name="vo" property="memberid" />
```

* 자바 코드로 짜는 방법

```jsp
<%
//파라미터 받아오기
String memberid = request.getParameter("memberid");
String password = request.getParameter("password");
String membername = request.getParameter("membername");
String email = request.getParameter("email");
//생성자 생성 및 setter
MemberVO vo = new MemberVO();
vo.setMemberid(memberid);
vo.setPassword(Integer.parseInt(password));
vo.setMembername(membername);
vo.setEmail(email);

%>
<%//getter%>
아이디:<%=vo.getMemberid() %><br>
암호:<%=vo.getPassword() %><br>
이름:<%=vo.getMembername()%><br>
이메일:<%=vo.getEmail() %><br>

```

* 액션 태그로 짜는 방법

```jsp
//생성자 생성
<jsp:useBean id="vo" class="vo.MemberVO"/> <!-- MemberVO 기본생성자 호출 --> 
//setter 및 파라미터
<jsp:setProperty property="memberid" name="vo" value="<%=request.getParameter(\"id\") %>"/>
<jsp:setProperty property="password" name="vo" value="<%=Integer.parseInt(request.getParameter(\"pw\")) %>"/>
<jsp:setProperty property="membername" name="vo" value="<%=request.getParameter(\"name\") %>"/>

<jsp:setProperty property="email" name="vo" param="mail" %>"/>

value 속성이 너무 길어서 param 사용하자 => param="id"처럼

//getter
<h1> 액션 태그로 읽어옵니다.</h1>
<jsp:getProperty property="memberid" name="vo" />
<jsp:getProperty property="password" name="vo" />
<jsp:getProperty property="membername" name="vo"/>
<jsp:getProperty property="email" name="vo" />
```

### request

```jsp
other.jsp

<jsp:useBean id="vo" class="vo.MemberVO" scope="request"/>
 
<h1> 액션 태그로 읽어옵니다.</h1>
<jsp:getProperty property="memberid" name="vo" />
<jsp:getProperty property="password" name="vo" />
<jsp:getProperty property="membername" name="vo"/>
<jsp:getProperty property="email" name="vo" />
```

```jsp
<jsp:useBean id="vo" class="vo.MemberVO" scope="request"/> //전달하는 쪽 전달 받는쪽 둘 다 써야됨

= 같은 의미

<%
if(requset.getAttribute("vo") ==null){
 MemberVO vo = new MemberVO();
 request.setAttribute("vo",vo);
 } 
 else{
 	MemberVO vo = request.getAttribute("vo");
 }
%>
 
<jsp:setProperty name="vo" property="*" />

<jsp:forward page="other.jsp"/>
```



### session

```jsp
<jsp:useBean id="vo" class="vo.MemberVO" scope="session"/>
 
<h1> 액션 태그로 읽어옵니다.</h1>
<jsp:getProperty property="memberid" name="vo" />
<jsp:getProperty property="password" name="vo" />
<jsp:getProperty property="membername" name="vo"/>
<jsp:getProperty property="email" name="vo" />
```

```jsp
<jsp:useBean id="vo" class="vo.MemberVO" scope="session"/>

= 같은 의미

if(requset.getAttribute("vo") ==null){
 MemberVO vo = new MemberVO();
 session.setAttribute("vo",vo);
 } 
 else{
 	MemberVO vo = request.getAttribute("vo");
 }

<jsp:setProperty property="*" name="vo"/>

```



* 실습

action = "/jsptest/memberinform" or "memberinform"

슬래쉬가 있으면 컨텍스트루트부터

슬래쉬가 없으면 현재 파일과 같은 루트에 있다.



page="/action/bottom.jsp" or "bottom.jsp"

슬래쉬가 있으면 WebContent 하위폴더부터

슬래쉬가 없으면 현재 파일과 같은 루트에 있다.



* servlet에 넣음

```java
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("action") && pw.equals("1111")) {
			MemberVO vo = new MemberVO(id, Integer.parseInt(pw), "이기술", "lee@campus.net");
			
			
			request.setAttribute("vo", vo);
			RequestDispatcher rd = request.getRequestDispatcher("/memberinform.jsp");
			rd.forward(request, response);
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h3>id나 암호 입력이 올바르지 않습니다.</h3>");
		}
```

* vo에서 정한 필드변수이름

  memberid, password, membername, email

```jsp
<jsp:useBean id="vo" class="vo.MemberVO" scope="request"/>

<jsp:getProperty property="memberid" name="vo"/>
<jsp:getProperty property="password" name="vo"/>
<jsp:getProperty property="membername" name="vo"/>
<jsp:getProperty property="email" name="vo"/>

<%-- <h1><% out.println(vo); %></h1> --%>
```





## 표현 언어

* EL : EXPRESSION LANGUAGE 

  스크립트 요소에 들어있는 자바 코드를 줄여 좀 더 편리하게 사용하기 위해 도입된 데이터 출력 기능

<% request.getParameter("id"); %>

==>${param.id}

${ el 언어 문법 }

- 변수 연산자 제어문 객체 함수



* 데이터 타입

  논리값 true, false

  정수, 실수 

  문자열 - " ", ' '

  null

```jsp
<h3>${ i2 = 100 }</h3>
<h3>${ i3 = 3.14 }</h3>

덧셈 : ${"100" + i3} => 1003.14 가 아닌 103.14
덧셈 : ${null + i3} => 계산 못하는 것이 아닌 null을 0으로 계산
덧셈 : ${"백" + i3} => 이건 계산 못하지만 ${"백" += i3} 이건 계산 가능

나눗셈 : ${10 / 3} => 정수 실수 나누지 않아서 3.3333... 나옴
나눗셈 : ${10 div 3}

나머지 : ${10 % 3} 나머지 : ${10 mod 3}

비교 : ${10 != 3} 비교 : ${10 ne 3}
비교 : ${10 == 3}
비교 : ${10 > 3} 비교 : ${10 gt 3} 
비교 : ${10 >= 3} 비교 : ${10 ge 3}
```

* 형변환이 자동으로 돼서 계산이 된다.

* empty 연산자

  자바 빈의 속성 값이 설정되어 있는지 또는 list나 map 같은 저장 객체의 값이 존재하는지 판단하는 연산자

```jsp
<jsp:useBean id="vo" class="vo.MemberVO2"/>
<jsp:setProperty name="vo" property="id" value="member1"/>

${empty id} : <%=vo.getId()%>   =>   true : member1
```



```jsp
jsp 변수를 el에 전달
<%
String s = "test";
pageContext.setAttribute("j", s); - 현재 jsp에 el 공유
request
session
%>

el 전달받기
${j}
${pageScope.j}

${ me = "test2" }
<%= pageContext.getAttribute("me") %>
```



| jsp 내장객체                                | el 내장객체                                       |                         |
| ------------------------------------------- | ------------------------------------------------- | ----------------------- |
| x<br />없어서 request.getParameter 사용했음 | param.파라미터명<br />paramValues.파라미터명[i]   |                         |
| pageContext                                 | pageScope // 변수를 사용하는 우선순위가 가장 높음 | 현재 페이지 el에게만    |
| request                                     | requestScope                                      | forward, include 까지만 |
| session                                     | sessionScope                                      |                         |
| application                                 | applicationScope                                  |                         |





<jsp:useBean id="vo" class="vo.MemberVO" scope="request />"

위는 아래랑 같음

MemberVO vo = new MemberVO(); => 기본생성자로 만드는거

request.setAttribute("vo", vo);

### 빈 사용

빈 = jsp bean = jsp 사용 자바 객체

<jsp:useBean id="vo" class="vo.MemberVO" scope="request />"

<jsp:setProperty name="vo" property="memberid" value=" " param=" " />

<jsp:getProperty name="vo" property="memberid"/>



```jsp
<jsp:setProperty property="*" name="vo"/>
<h1> 액션 태그로 읽어옵니다.</h1>
<jsp:getProperty property="memberid" name="vo" />
<jsp:getProperty property="password" name="vo" />
<jsp:getProperty property="membername" name="vo"/>
<jsp:getProperty property="email" name="vo" />

<h1> el로 읽어옵니다.</h1>
${ vo.memberId } <!-- vo.getMemberId() 메소드 호출과 똑같음 -->
${ vo.password }
${ vo.memberame }
${ vo.email }

<h1> 자바 문장으로 읽어옵니다.</h1>
<%=vo.getMemberid() %>
<%=vo.getPassword() %>
<%=vo.getMembername() %>
<%=vo.getEmail() %>
```



```jsp
<% 
String[] colors ={"빨강", "노", "초", "파", "보", "검", "흰"}; 
 pageContext.setAttribute("colors", colors);
%>

<h1> el로 배열 내용을 출력합니다.</h1>
<h3> ${colors[0] }</h3>

<%
ArrayList<MemberVO> list = new ArrayList<MemberVO>();
 list.add(new MemberVO("Member20", 2020, "김대한", "DAE@a.com"));
 list.add(new MemberVO("Member30", 3030, "박대한", "park@a.com"));
 
 pageContext.setAttribute("el_list", list);
%>
<h1> el로 회원 내용을 출력합니다.</h1>
<h3> ${el_list[0].memberid }</h3>
<h3> ${el_list[1].memberid }</h3>

<%
HashMap<String, MemberVO> map = new HashMap<String, MemberVO>();
 map.put("1번 회원" ,new MemberVO("Member20", 2020, "김대한", "DAE@a.com"));
 map.put("2번 회원" ,new MemberVO("Member30", 3030, "박대한", "park@a.com"));
 
 pageContext.setAttribute("el_map", map);
%>
<h1> el로 map을 출력합니다.</h1>
<h3> ${el_map.1번회원 }</h3>
<h3> ${el_map.2번회원 }</h3> => map은 안되네?? jstl을 알아야함!
```



### JSTL

* 쓰기위한 준비물

![image-20210901135015123](../md-images/image-20210901135015123.png)

![image-20210901135037834](../md-images/image-20210901135037834.png)

* jstl을 쓰는 이유는 el에 접근하기 위해서다

  ```jsp
  <c:set var="name" value="jstltest"/> == pageContext.setAttribute("name", "jstltest");
  
  ${name }<br>
  <%=pageContext.getAttribute("name") %><br>
  ```

  * 둘이 똑같은 것을 추출하지만 되도록이면 ${ }를 사용하자

* set

```jsp
<c:set var="name" value="jstltest"/>
```

* out

```jsp
<c:out value="${name}"/> => 이걸 굳이??
${name } => 이러면 되는데?
```

* remove

```jsp
<c:remove var="name"/>
```



* if - 자바문을 쓰는 표현문으로 조건문 만들 수 있지만

  ​		el을 쓰기위해 나온 것이기 때문에 최대한 el태그를 써라

  ​		else가 없기 때문에 if문으로 해결

  ```jsp
  <c:if test="${empty param.id }">
   <h1>아이디 입력은 필수사항입니다.</h1>
  </c:if>
  <c:if test ="${!empty param.id }">
   <h1>${param.id } 회원님 환영입니다. 어딜 보시는거죠?</h1>
  </c:if>
  ```

* choose

  ```jsp
  <c:choose>
  	<c:when test="${param.age <=13 }">
  	 <h1> 초등학생입니다. </h1>
  	</c:when>
  	<c:when test="${param.age <=16 }">
  	 <h1> 중학생입니다.</h1>
  	</c:when>
  	<c:when test="${param.age <=19 }">
  	 <h1> 고등학생입니다.</h1>
  	</c:when>
  	<c:otherwise>
  	 <h1> 성인입니다.</h1>
  	</c:otherwise> 
  </c:choose>
  ```

  * forEach

    1. begin / end / step / var
    2. items / var

    * 배열

    ```jsp
    % 
    String[] colors ={"빨강", "노", "초", "파", "보", "검", "흰"}; 
     pageContext.setAttribute("el_colors", colors);
    %>
    
    <h1> el로 배열 내용을 출력합니다.</h1>
    <c:forEach items="${el_colors }" var="one_color">
    <h3>${one_color }</h3>
    </c:forEach>
    
    <h1> el로 배열 내용을 출력합니다.</h1>
    <c:forEach begin="1" end="10" step="2" var="one_color">
    <h3>${one_color }</h3>
    </c:forEach>
    ```

    * ArrayList

    ```jsp
    <%
    ArrayList<MemberVO> list = new ArrayList<MemberVO>();
     list.add(new MemberVO("Member20", 2020, "김대한", "DAE@a.com"));
     list.add(new MemberVO("Member30", 3030, "박대한", "park@a.com"));
    pageContext.setAttribute("el_list", list);
    %>
    <h1> el jstl로 회원 내용을 출력합니다.</h1>
    <c:forEach items="${el_list }" var="vo">
    <h3> ${vo }</h3>
    <h3> ${vo.memberid }</h3> => getter메소드 없이 쉽게 getter를 가져올 수 있는 방법
    </c:forEach>
    ```

    * Map

    ```jsp
    <%
    HashMap<String, MemberVO> map = new HashMap<String, MemberVO>();
     map.put("1번 회원" ,new MemberVO("Member20", 2020, "김대한", "DAE@a.com"));
     map.put("2번 회원" ,new MemberVO("Member30", 3030, "박대한", "park@a.com"));
     
     pageContext.setAttribute("el_map", map);
    %>
    <h1> el jstl로 map을 출력합니다.</h1>
    <c:forEach items="${el_map}" var="vo">
     ${vo.key} : ${vo.value}
    </c:forEach>
    ```

    * Map 응용

    ```jsp
    <% 
    HashMap<String, String> map2 = new HashMap<String, String>();
    map2.put("red", "빨강");
    map2.put("orange", "주황");
    map2.put("yellow", "노랑");
    map2.put("green", "초록");
    map2.put("blue", "파랑");
    map2.put("navy", "남색");
    map2.put("purple", "보라");
    pageContext.setAttribute("col_map", map2);
    %>
    
    <h1> el jstl로 map2를 출력합니다.</h1>
    <c:forEach items="${col_map }" var="color">
    <h3 style= "color:${color.key}" >${color.value }</h3>
    </c:forEach>
    ```

    * Map에서 varStatus
      * index
      * count
      * first
      * last
      * current

    ```jsp
    <h1> el jstl로 map2를 출력합니다.</h1>
    <c:forEach items="${col_map }" varStatus="st">
     <c:if test="${st.index == 3}"> or  <c:if test="${st.first}">
    <h3 style= "color:${st.current.key}" >${st.current.value }</h3>
     </c:if>
    </c:forEach>
    ```

    



