# 웹 서버

## servlet 만들기

![image-20210826100750080](C:/Users/Pang/Desktop/TIL/md-images/image-20210826100750080.png)

![image-20210826101016974](C:/Users/Pang/Desktop/TIL/md-images/image-20210826101016974.png)

* // http://localhost:9090/servlettest/src/first.FirstServlet.class => http://localhost:9090/servlettest/src/FirstServlet

* //패키지명.서블릿클래스명.class(실제 파일명) --> 별칭으로 호출 예정 

* @WebServlet("\FirstServlet") // 이것이 별칭임 이게 바뀌면 바뀐대로 창이 열림

  @ -> annotation(주석)

## 매핑하는 방법 2가지

- 서블릿 4.0버전 자바 파일 정의한 후 tomcat 서버 설정 알려주는 2가지 방법

  | @WebServlet<br />3.0 이상에서 가능한 방법 | @WebServlet("url매핑")<br />class 서블릿 extends HttpServlet<br />doGet 오버라이딩 |
  | ----------------------------------------- | ------------------------------------------------------------ |
  | web.xml                                   | class 서블릿 extends HttpServlet<br />doGet 오버라이딩<br /> <servlet><br/>  <servlet-name>t</servlet-name><br/>  <servlet-class>test.TestServlet</servlet-class><br/>  </servlet><br/>  <br/>  <servlet-mapping><br/>  <servlet-name>t</servlet-name><br/>  <url-pattern>/test</url-pattern><br/>  </servlet-mapping> |

  확실히 @WebServlet 이 편하긴 함









## 메소드

| doGet   | 요청때마다 여러번 실행<br />매번 요청시 처리 반복<br />http://ip:port/context명/login.jsp?id=jsp&pw1234 |
| ------- | ------------------------------------------------------------ |
| doPost  |                                                              |
| service |                                                              |
| init    | 서버 시작 1번만<br />서블릿 최초 초기화 수행작업             |
| destroy | 서버 종료시, 서블릿 코드 수정 - 재컴파일시, 이전 서블릿객체 삭제시 |



## 서블릿 실행과정 - 요청 처리 응답

1. url입력 http://ip:port/test/sample?id=test
2. 요청 분석
3. sample
4. 서블릿 컴파일
5. 실행(처리)
   1. 서블릿 객체를 메모리 heap영역에 생성
   2. 서블릿 생성자 실행
   3. init 실행
   4. doGet 메소드 실행

6. (응답)실행 결과를 클라이언트에게 전송
7. 브라우저 표현 출력
8. http://ip:port/test/sample?id=jsp
9. 브라우저 표현 출력

| 클라 | 서버 |
| ---- | ---- |
| 1    | 2    |
| 7    | 3    |
| 8    | 4    |
| 9    | 5 6  |



javax.servlet.http.패키지

|      |      |
| ---- | ---- |
|      |      |



url

? = 앞에까지만 url이고 뒤에는 데이터변수명, 데이터값 

String id = request.getParameter("id"); = id에 해당하는 데이터를 불러와라

http://localhost:9090/servlettest/login?id=test => String id = test



* http 프로토콜 규칙
  1. url?파라미터명=값& ...
  2. form action="서블릿url" method="get" or "post"

```java
@WebServlet("/loginform")
public class LoginFormServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String[] con = request.getParameterValues("con");
		//처리
		String result ="";
		System.out.println(pw); 

		if(pw.length() <= 10) {
			result = "암호 입력 조건에 마즘";
		}
		else {
			result = "암호 입력 조건에 맞지아늠";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>" + id + " 아이디 받았습니다.</h3>");
		out.println("<h3>" + result + "</h3>");
		for(String a : con) {
			out.println("<h3> 관심 분야" + a + " </h3>");
		}
```

* get => response.setContentType("text/html;charset=utf-8");

  보안에 취약하고 파일 전송 불가

* post = request.setCharacterEncoding("utf-8");  디코딩 필요

​       		   response.setContentType("text/html;charset=utf-8");

​		보안에 유리하고 길이 무제한

* http 프로토콜 오류코드

  | 404  | url 지정 파일 없다<br />서블릿 url 매핑 오류<br />파일명 오류 |
  | ---- | ------------------------------------------------------------ |
  | 405  | get => doPost() 요청과 처리 방식이 서로 다름                 |
  | 500  | 서블릿 실행 오류들<br />오류 이름이나 메세지 라인번호        |

  

