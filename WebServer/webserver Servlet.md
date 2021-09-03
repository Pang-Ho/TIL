# 웹 서버

## 웹 클라이언트 / 웹 서버

* 웹 클라이언트 html, css, js, jquery
* (tomcat+jdk) servlet jsp spring

## servlet 만들기 - extends HttpServlet

![image-20210826100750080](C:/Users/Pang/Desktop/TIL/md-images/image-20210826100750080.png)

![image-20210826101016974](C:/Users/Pang/Desktop/TIL/md-images/image-20210826101016974.png)

* // http://localhost:9090/servlettest/src/first.FirstServlet.class => http://localhost:9090/servlettest/src/FirstServlet

* //패키지명.서블릿클래스명.class(실제 파일명) --> 별칭으로 호출 예정 

* @WebServlet("\FirstServlet") // 이것이 별칭임 이게 바뀌면 바뀐대로 창이 열림

  @ -> annotation(주석)
  
  / <= 컨텍스트루트 ex)/memberlist
  
  html에서 / 는 서버루트임 ex)/servlettest/memberlist //서로 같은 주소

## 매핑하는 방법 2가지

- 서블릿 4.0버전 자바 파일 정의한 후 tomcat 서버 설정 알려주는 2가지 방법

  | @WebServlet<br />3.0 이상에서 가능한 방법 | @WebServlet("url매핑")<br />class 서블릿 extends HttpServlet<br />doGet 오버라이딩 |
  | ----------------------------------------- | ------------------------------------------------------------ |
  | web.xml                                   | class 서블릿 extends HttpServlet<br />doGet 오버라이딩<br /> |

  ```java
  web.xml에서 매핑하려면 바꿔야하는 부분
  <servlet>
      <servlet-name>t</servlet-name>  => 임시 서블릿 이름
      <servlet-class>test.TestServlet</servlet-class> =>패키지명.서블릿실제클래스명
  </servlet>
  <servlet-mapping>
      <servlet-name>t</servlet-name> => 임시 서블릿 이름
      <url-pattern>/test</url-pattern>
  </servlet-mapping>
  ```
  
  확실히 @WebServlet 이 편리함
  
  => web.xml 파일 대신 설정
  
  어떤 의미인지는 알아야 한다!
  
  <servlet
  
  ​	<servlet-name (임시)서블릿 이름
  
  ​	<servelt-class 패키지명.서블릿실제클래스명
  
  </servlet
  
  <servlet-mapping
  
  ​	<servlet-name (임시)서블릿이름
  
  ​	<url-pattern 
  
  </servlet-mapping



## 작성

| 작성 | @WebServlet("/context명")<br />class A extends HttpServlet<br />doGet / doPost 오버라이딩<br /> |
| ---- | ------------------------------------------------------------ |



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
   
      * 5- 1,2,3은 톰캣이 하는거임
   
   4. 요청정보 request
   
      응답정보 response
   
   5. doGet 메소드 실행
   
6. (응답)실행 결과를 클라이언트에게 전송

7. 브라우저 표현 출력

8. http://ip:port/test/sample?id=jsp

9. 브라우저 표현 출력

10. destroy()가 서블릿 객체 메모리 삭제

| 클라 | 서버   |
| ---- | ------ |
| 1    | 2      |
| 7    | 3      |
| 8    | 4      |
| 9    | 5 6 10 |



* url

  ? = 앞에까지만 url이고 뒤에는 데이터변수명, 데이터값 

  ?id=test&pw=1111

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
        //=> 타입이 체크박스같은 경우 여러 값을 받아오기 위한 방법
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

* get => 

* response.setContentType("text/html;charset=utf-8");

  브라우저 출력을 위해 인코딩하는 코드

  보안에 취약하고 파일 전송 불가

* post => 

* request.setCharacterEncoding("utf-8");

* response.setContentType("text/html;charset=utf-8");

  브라우저에서 받아오는 값을 디코딩, 브라우저 출력을 위한 인코딩 코드	

  보안에 유리하고 길이 무제한

  

* http 프로토콜 오류코드

  | 404  | url 지정 파일 없다<br />서블릿 url 매핑 오류<br />파일명 오류 |
  | ---- | ------------------------------------------------------------ |
  | 405  | get => doPost() 요청과 처리 방식이 서로 다름                 |
  | 500  | 서블릿 실행 오류들<br />오류 이름이나 메세지 라인번호        |





* drop table 하려는데 다른 곳에서 fk로 쓰고있다면

  drop table member cascade constraint;

## DAO  VO 

| logindb.html | LoginDBServlet                                               | MemberDAO                                       | MemberVO                                                     |
| ------------ | ------------------------------------------------------------ | ----------------------------------------------- | ------------------------------------------------------------ |
| id, password | 2개 파라미터 입력 요청<br />응답 3가지<br />id o pw  x<br />id x<br />id o pw o | int getMember(String id, String password)<br /> | MemberVO(String id, String password, String name, String mail){ ... } |

===================================

select 구문 구하기

DAO에서 ArrayList 타입의 getMemberList메소드를 만들어서 여러개 나오는 selelct 구문을 배열로 받아오기

메인인 MemberListServlet에서 Arraylist를 배열로 받아오면서 print(객체) 하기위해

MemberDAO에서 toString 설정하기

```java
public class MemberDAO {
	public ArrayList<MemberVO> getMemberList() {
		Connection con = null;
		ArrayList<MemberVO> result = new ArrayList<MemberVO>();
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결성공");
		
		String sql = "select * from member";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String db_memberid = rs.getString("memberid");
			int db_password = rs.getInt("password");
			String name = rs.getString("membername");
			String email = rs.getString("email");
			MemberVO vo = new MemberVO(db_memberid, db_password, name, email);
			result.add(vo);
			
		}
		
		con.close();
		System.out.println("연결해제성공");
		}catch(SQLException e) {/**/}
		catch(ClassNotFoundException e) {/**/}	
		
		return result;
	}
}

```

MemberListServlet

```java
@WebServlet("/memberlist")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.getMemberList();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		for(MemberVO vo : list) {
			out.print("<h3>" + vo + "</h3>");
		}
	}
}
```

MemberVO

```java
package vo;

public class MemberVO {
	String memberid;
	int password;
	String membername;
	String email;
	
	
	public MemberVO(String memberid, int password, String membername, String email) {
		super();
		this.memberid = memberid;
		this.password = password;
		this.membername = membername;
		this.email = email;
	}

	public String toString() {
		return "회원아이디=" + memberid + "암호= " + password + "이름= " + membername + "이메일= " + email;
	}
}
```



========================================

회원가입

MemberDAO

```java
	public int insertMember(MemberVO vo) {
		Connection con = null;
		int result = 0;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결성공");
		
		String sql = "insert into member values(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getMemberid());
		st.setInt(2, vo.getPassword());
		st.setString(3, vo.getMembername());
		st.setString(4, vo.getEmail());
		
		result = st.executeUpdate();
		
		con.close();
		System.out.println("연결해제성공");
		}
		catch(SQLException e) {/**/}
		catch(ClassNotFoundException e) {/**/}	
		
		return result;
	}
```

MemberInsertServlet

```java
@WebServlet("/memberinsert")
public class MemberInsertServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("mail");
		MemberVO vo = new MemberVO(id, Integer.parseInt(pw), name, email);
		
		MemberDAO dao = new MemberDAO();
		int row = dao.insertMember(vo);
		
		//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(row == 1) {out.print("<h3>회원가입이 완료되었습니다.</h3>");
		}
	}
```

MemberVO

```java
package vo;

public class MemberVO {
	String memberid;
	int password;
	String membername;
	String email;
	
	
	public MemberVO(String memberid, int password, String membername, String email) {
		super();
		this.memberid = memberid;
		this.password = password;
		this.membername = membername;
		this.email = email;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "회원아이디=" + memberid + "암호= " + password + "이름= " + membername + "이메일= " + email;
	}
}

```





## DataSource 이용해 데이터베이스 연동

* 데이터베이스 이클립스에서 connection 68번정도 하면 메모리 공간이 부족해서 뻑감

* 그래서 사용하는 방법이 **커넥션풀**

* 웹 애플리케이션이 실행됨과 동시에 연동할 데이터베이스와의 연결을 미리 설정해둔다. 필요할 때마다 미리 연결해놓는 상태를 이용해 빠르게 데이터베이스와 연동하는 작업 - 미리 데이터베이스와 연결시킨 상태를 유지하는 기술

  1.  con을 미리 생성하기 때문에(tomcat server가 시작할 때)
  2. 일정 갯수 생성

  3. tomcat 라이브러리에 dbcp 포함 라이브러리

  4. dbcp 사용하기위한 설정

     Servers\Tomcat\server.xml / 리소스 추가

     ```html
           <Context docBase="servlettest" path="/servlettest" reloadable="true" 				    	  source="org.eclipse.jst.jee.server:servlettest">
           
           <Resource type="javax.sql.DataSource" 
           name="jdbc/myoracle" 
           username="hr" 
           url="jdbc:oracle:thin:@127.0.0.1:1521:xe" 
           password="hr" 
           maxIdle="5" 
           driverClassName="oracle.jdbc.driver.OracleDriver" 
           MaxActive="5"/> //자동으로 5개 만들어달라
           
           </Context>
     ```

     

  5. 서블릿 javax.sql.DataSource 객체

     ```java
     //1. context명+정보 저장 객체 생성
     Context initContext = new InitialContext();
     //2. server.xml 읽어와서 1번 컨텍스트 설정만 찾아줘
     Context envContext = (Context)initContext.lookup("java:/comp/env");
     //name="jdbc/myoracle" 설정만 찾아와
     DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
     
     for(int i = 1 ; i <= 100 ; i++){
         Connection con = ds.getConnection();
     }
     ```



## 서블릿 확장 forward/include

* context = html - servlet - db

* 이번에는 servlet - servlet 호출(서버 내부 2개이상 파일 연동)



### Aservlet에서 - Bservlet 호출

```java
BServlet b = new BServlet();
b.doGet(request, response){}

RequestDispatcher rd = request.getRequestDispatcher("/bservlet");
rd.include(request, response); / rd.forward(request, response);

```

* include

logindb.html 요청 - LogintDBServlet('logindb') 응답

​							 - include MemberListServlet('memberlist') 너도 응답

* forward

logindb.html 요청 - LogintDBServlet('logindb') 응답 x

​							 - forward MemberListServlet('memberlist') 너만 응답

실습

![image-20210827172823568](../md-images/image-20210827172823568.png)



* 아주 간단함

```java
if(id.equals("admin")) {
	RequestDispatcher rd =request.getRequestDispatcher("/admin");
	rd.forward(request, response);	
} else {
	RequestDispatcher rd =request.getRequestDispatcher("/user");
	rd.forward(request, response); 	
	}
```



## api 이름(서블릿, jsp)

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

공유받는 방법 2가지
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
| 5. 클라이언트 요청한다<br />(동일 서버로부터 받은 쿠키도 같이 전송) | 6. 클라이언트로부터 쿠키를 읽어온다<br />Cookies[] coo = request.getCookies();<br />coo[].getName();<br />coo[].getValue(); |



### 쿠키 만들기

* 부라우저 종료시 쿠키는 삭제된다
* 전달하는 데이터가 한글이라면 java.net.URLDecoder.

```java
Cookie c = new Cookie("book", "thisisjava");
response.addCookie(c);
		
response.setContentType("text/html;charset=utf-8");
PrintWriter out = response.getWriter();
out.println("클라이언트로 주문한 책 정보를 전송했습니다.");
```

![image-20210830104448049](../md-images/image-20210830104448049.png)

* 부라우저 종료되어도 쿠키 유지

```java
c.setMaxAge(60x60x24);
```

![image-20210830110144309](../md-images/image-20210830110144309.png)

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
| 4. 클라이언트 2번째 요청<br /><br /><br /><br />7. 응답      | 5. HttpSession session = request.getSession();<br />true - 이전 연결 중<br />6. Object o = session.getAttribute("세션 속성명");<br />=> 형변환 필요시 하면됨 |
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

![image-20210830131321780](../md-images/image-20210830131321780.png)



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

![image-20210830135606276](../md-images/image-20210830135606276.png)

