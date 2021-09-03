# 스프링 프레임워크

* Spring tool suite4

  https://spring.io/tools

  

  * 스프링 환경설정

  1. sts툴 새로 설치해서 spring3 추가

  2. web, server 기능 사용하기 위해 추가

![image-20210901162025041](../md-images/image-20210901162025041.png)



* 프레임워크

  경량의 컨테이너(여러 jar 파일(mb수준) - ioc, di 기능)

  일정 규격에 맞추어 프로그래밍을 하라는 것 => 강제적으로 규칙에 맞게 프로그래밍 해라

  프로그래밍의 뼈대 설계 => 살은 사용자가 구현한다.

  반은 이미 구현되어 제공되어있고, 나머지 반은 사용자가 구현해라 => 간결해짐

  

* 예를들어 지금까지 프로그래밍 할 때 일정한 규격은 있었지만 강제적으로는 없었다.

  로그인 - 요청/db연결/결과/응답

  회원가입 - 

  게시판 글쓰기 - 



* struts 프레임워크
* spring 프레임워크 - 자바로 구현된 대표적인 프레임워크 툴
  * spring 기능들 - ioC, DI, AOP, MVC, 다른 프레임워크 연동



| interface TV                                                 |                                                              |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| powerOn(), Off, SoundUp(), Down                              |                                                              |
|                                                              |                                                              |
| SamsungTV implements TV                                      | LgTV implements TV                                           |
| TVFactory<br />TV getTV(String name)<br />=> spring에서 factory 역할을 하는 api를 사용할 것이다. | TVMain<br />1. TV 객체 변경시에도 기능 메소드 수정 필요없다.<br />2. TVFactory 전달하는 TV 객체 사용이 가능하고 의존한다.<br />3. 소스코드 변경시 최소화 할 수 있음<br />=> spring 프레임워크에서 di 전달 객체를 사용 |
| spring bean configuration xml<br />                          |                                                              |

1. 여러개 클래스에 규칙 강제화

2. TV 객체 변경시에도 기능이 들어있는 메소드의 수정이 필요없다.

   TV tv = xxxxTV();



* 스프링은 ioc 기능을 지원하며 di 구현방법을 사용한다.

## IOC => Inversion Of Control

* 제어의 역전

  * 원하는 객체 수정하고자 한다면 클래스 내부 new xxxx()

  * 원하는 객체 수정하고자 한다면 클래스 내부 new xxxx()

    => main 객체 생성 제어권 기본 있다

    =>TVFactory 객체 생성 제어권 줌 그래서 main을 역전함

    => 객체 타입은 한정하자 아무 객체나 받지말고 TV라는 객체로 => 그래서 TV인터페이스가 필요한 것

## DI  => Dependency Injection

* IOC라는 개념을 구현하는 방법

  main으로부터 전달받아야 함

  tvfactory 의존하여 생성한 객체만 주입받는다

  => 의존성 주입



* 우리가 필요해서 생성하는 객체는 없고 spring에 있는 api를 쓸 것임

```xml
<bean id="tv" class="spring.tv.SamsungTV" /> <!-- ???tv = new SamsungTV 이런 객체 만드는 것 -->
```



```java
public static void main(String[] args) {
		//spring factory 역할하는 api
		ApplicationContext factory = 
		new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		
		TV tv = (TV)factory.getBean("tv");
		// LgTV tv = new LgTV();
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		}
```

* xml

  <bean

  <property

  <constructor-arg

![image-20210902134032293](../md-images/image-20210902134032293.png)

* member.xml

```xml
<bean id="dao" class="member.MemberDAO">
	<property name="membervo" ref="vo2"/>
</bean>

<bean id="vo" class="member.MemberVO">
	<property name="memberid" value="spring"/>
	<property name="password" value="1111"/>
</bean>

<bean id="vo2" class="member.MemberVO">
	<constructor-arg value="servlet"/>
	<constructor-arg value="2222"/>
</bean>
```

* MemberVO

  ```java
  public MemberVO() {}
  	public MemberVO(String memberid, int password) {
  
  		this.memberid = memberid;
  		this.password = password;
  	}
  setter, getter
  ```

  

* MemberDAO

  ```java
  MemberVO membervo;
  	
  public void setMembervo(MemberVO vo) {
      this.membervo = vo;
  }
  public boolean selectMember() {
      if(membervo.getMemberid().equals("spring") && membervo.getPassword() == 1111) {
          return true;
      }
      return false;
  }
  public void insertMember() {
      System.out.println(membervo.getMemberid() + " 회원님 정상적으로 회원 가입되셨습니다.");
  }
  ```

  

* DAO와 VO 이용하기 (자바 application,servlet , jsp, spling)

  1. 프레임워크! = 반은 완성 되어있으니 xml + 나머지 구현
  2. 경량의 컨테이너다!

  ====>

  servlet과 jsp은 tomcat, jdk 필요

  tomcat에는 꽤 많은 라이브러리가 있음 그에 반해 spring의 라이브러리는 적음

  3. 독립적 실행
  4. pojo 클래스 - plain old java object - 평소에 쓰던 자바 클래스 파일
  5. ioc, di 기능

* SERVICE 추가하기

  dao의 메소드 1개는 sql 1개 실행 // insertmember는 insert 하는 sql 메소드

  

  기능 = 서비스 1개 = 여러개의 sql = 여러개의 dao 메소드

  login(){ selectMember() }

  register(){ selectMember() 후 insertMember() }

  => MemberService 는 인터페이스로 만듦

  => 상속받은걸로 MemberFileService나 MemberDBService를 만듦

![image-20210902151819587](../md-images/image-20210902151819587.png)

* member.xml

```xml
<bean id="service" class="service.member.MemberServiceImpl">
	<property name="memberDAO" ref="dao"></property>
</bean>

<bean id="dao" class="service.member.MemberDAO">
	<property name="membervo" ref="vo"/>
</bean>

<bean id="vo" class="service.member.MemberVO">
	<property name="memberid" value="spring"/>
	<property name="password" value="1111"/>
</bean>

<bean id="vo2" class="service.member.MemberVO">
	<constructor-arg value="servlet"/>
	<constructor-arg value="2222"/>
</bean>
```

* MemberVO

  ```java
  public MemberVO() {}
  	public MemberVO(String memberid, int password) {
  
  		this.memberid = memberid;
  		this.password = password;
  	}
  setter, getter
  ```

  

* MemberDAO

  ```java
  	MemberVO membervo;
  	
  	public void setMembervo(MemberVO vo) {
  		this.membervo = vo;
  	}
  	public boolean selectMember() {
  		if(membervo.getMemberid().equals("spring") && membervo.getPassword() == 1111) {
  			return true;
  		}
  		return false;
  	}
  	public void insertMember() {
  		System.out.println(membervo.getMemberid() + " 회원님 정상적으로 회원 가입되셨습니다.");
  	}
  ```

  * MemberMain

  ```java
  ApplicationContext factory = new ClassPathXmlApplicationContext("service/member/member.xml");
  MemberService service = (MemberService)factory.getBean("service"); //vo 객체도 얘가 가져옴
  
  service.login();
  		
  service.register();
  ```

  * MemberService.Interface

  ```java
  	public void login();
  	public void register();
  ```

  * MemberServiceImpl

  ```java
  	MemberDAO dao;
  	public void setMemberDAO(MemberDAO dao){
  		this.dao = dao;
  	}
  	@Override
  	public void login() {
  	 boolean result = dao.selectMember();
  	 if(result) {
  		 System.out.println("정상 로그인 사용자");
  	 }
  		
  	}
  	@Override
  	public void register() {
  		boolean result = dao.selectMember();
  		if(!result) {
  			dao.insertMember();
  		
  	}
  	}
  ```

  

1.  spring pojo 클래그(dao, vo, service) 구현한다

2. 서로 다른 클래스 공통 메소드 필요로 하면 인터페이스를 만든다

3. 1. spring 연결하는 xml을 작성한다 <bean, <property, <constructor-arg
   2. 자바 

   ​		@WebServlet() => WebServlet annotation

   ​		annotation - 자바 실행시 실행 환경으로 알려주는 설명



## Spring annotation

| ioc di xml 태그 방식                   | annotation                                                   |
| -------------------------------------- | ------------------------------------------------------------ |
| <bean id ="a" class="ss.A"             | @Component("a")<br />class A{}                               |
| <bean id="a" class="ss.xxxServiceImpl" | @Service<br />class xxxServiceImpl implements xxxService{}   |
| <bean id="a" class="ss.ADAO"           | @Repository<br />class ADAO{<br /> @Autowired => 찾아와라<br />AVO vo;}<br /><br />@Component("vo")<br />class AVO{}<br /><br />@Repository<br />class BDAO{} |
| <property                              | @Autowired                                                   |
| <constructor-arg                       | @Qualifier 우선순위                                          |



![image-20210902170204222](../md-images/image-20210902170204222.png)



* 스프링 AOP 기능

  AOP - (aspect oriented programming)



## Spring MVC

### 모델 1

* web server - servlet, jsp(html포함), dao, vo 
* 웹서버 개발 형식 - 흐름 복잡하다. 서버 내부 jsp 파일 관계 분석이 어렵다

![image-20210903093331298](../md-images/image-20210903093331298.png)

초창기 모델임





### 모델 2 = servlet + jsp 구조

* 기능을 더 원하면 DAO를 늘리거나 추가하면 된다.

* 각 장점을 살리자

  servlet - 결국 자바이니까 자바 로직 처리하기가 쉽다. (dao 호출)

  dao, vo - 실제 처리 결과물들을 생성하고 저장

  jsp - 응답

* 모델 1보다는 규칙적이다

  ​				MVC

![image-20210903094453356](../md-images/image-20210903094453356.png)



### MVC 우선 구현해보자



=> spring MVC



// http://localhost:9090/ 이후  webmvc/member/a.spring = URI



DispatcherServlet - 클라리언트 모든 요청 집중 ("/") frontcontroller 중앙통제 역할

```java
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // http://localhost:9090/  이후  webmvc/member/a.spring = URI
		String[] sp = uri.split("/");
		
		String result = sp[sp.length - 1]; 
		System.out.println(result);
		
		//hello.spring => c
		HandlerMapping mapping = new HandlerMapping();
		Controller con = mapping.getController(result);
		
		// m, v
		String viewname = con.handleRequest(request, response);
		
		//이동
		RequestDispatcher rd = request.getRequestDispatcher(viewname);
		rd.forward(request, response);
		
	}
}
```



HandlerMapping - 특정  url - 컨트롤러 매핑 정보

```java
	HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("hello.spring", new HelloController());
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
```



Controller - 메소드

```java
	public String handleRequest(HttpServletRequest request, HttpServletResponse response);
```



HelloController - 특정 url - model, view 설정

```java
@Override
public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	request.setAttribute("insa", "hello jsp"); //model 
	return "hello.jsp"; //view
	
	/*jsp 내에서 
	 * 받아내는 방법 <%=request.getAttribute("insa")
	 * ${insa}
	 * */
	}
```



hello.jsp - 응답

```jsp
<h1>컨트롤러부터 전달하는 모델 데이터</h1>
<h3><%=request.getAttribute("insa") %></h3>
<h3>${insa}</h3>
```

servlet-context 

```xml
	<context:component-scan base-package="edu.spring.multi" />
	
	<!-- hello.spring url - new HelloController() - HandlerMapping 하는거 설정할 예정 -->
	
	<beans:bean id="hello" class="edu.spring.multi.HelloController"/> 
	
	<beans:bean id="urlMapping" class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping"> 
		<beans:property name="mappings">
			<beans:props>
				<beans:prop key="/hello.spring">hello</beans:prop>
			</beans:props>
		</beans:property> <!-- HandlerMapping의 mapping 메소드 만드는중-->
```



### spring api를 이용한 MVC 구현

![image-20210903111630140](../md-images/image-20210903111630140.png)

![image-20210903111932640](../md-images/image-20210903111932640.png)

* HelloController에서 implements 하는 Contoller는 우리가 만든 인터페이스가 아닌

  스프링 프레임워크에서 제공하는 Controller 사용함

HelloController로 모델"hello" 뷰"hello.jsp" 만드는건 동일하였음



## annotation



| ioc id | @Component                                          |
| ------ | --------------------------------------------------- |
|        | @Service                                            |
|        | @Repository                                         |
|        | @Autowired                                          |
|        | @Qualifier                                          |
|        |                                                     |
| mvd    | @RequestParam                                       |
|        | @RequestMapping                                     |
|        | @ModelAttribute                                     |
|        | @Controller- 상속 안받는 대신에 컨트롤러클래스 위에 |



HelloAnnotationController

```java
@Controller
public class HelloAnnotationController {

	/*
	 * @Override public String handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) { request.setAttribute("insa", "hello jsp");
	 * //model return "hello.jsp"; //view
	 * }
	 */
	@RequestMapping("/hello.spring")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView mv = new ModelAndView();
	mv.addObject("insa", "Hello spring mvc~~~");
	mv.setViewName("hello"); //확장자 필요없음 /WEB-INF/views/hello.jsp => hello
	return mv;
```

servlet-context.xml

```xml
	<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
	<resources mapping="/resources/**" location="/resources/" />
```

=========================================================================

![image-20210903140636394](../md-images/image-20210903140636394.png)



![image-20210903142255944](../md-images/image-20210903142255944.png)

* 모든 요청은 처음부터 jsp로 가는것이 아니다.



LoginController

```java
@Controller
public class LoginController {
	1. 
	@RequestMapping("/loginform")
	public ModelAndView loginstart() {
		ModelAndView mv = new ModelAndView();
		//mvc (m이 없는 경우)
		mv.setViewName("loginform");
		return mv;
	}
	2. view만 필요할 때
    @RequestMapping("/loginform")
	public String loginstart() {
		return "loginform"; //view만 필요할 때 
	}
    3. return도 싫다
     @RequestMapping("/loginform")
	public void loginstart() {
	}
    4. view를 알려주지 않으면 view 이름은 요청한 uri이름과 동일해진다.
    @RequestMapping("/loginform")
	public ModelAndView loginstart() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "모델값입니다.");
		return mv;
    5. String 뒤에는 생략되는게 좀.. 많다
    @RequestMapping("login")
	public String login() {
		return "redirect:/loginform";//redirect://uri
		//String이고 redirect로 시작된다면 /loginform을 찾아서 메소드를 실행하라는 뜻
	}
    
	@RequestMapping("/loginresult")
	public ModelAndView loginresult(HttpServletRequest request) {
        //post 방식으로 갈거면 한글 깨지니까 request.setCharacterEncoding("utf-8");
        //request 필요없이 파라미터 이름이 같으면 받아올 수 있음 String인데 int로도 받아올 수 있음
        public ModelAndView loginresult(String id, int pw) throws Exception{
        public ModelAndView loginresult(@RequsetParam("id") String memberid,@RequsetParam("pw") int pw) throws Exception{ 
            
            //객체로도 가져올 수 있음
            public ModelAndView loginresult(@ModelAttribute("vo") LoginVO vo) throws Exception{
            
		String memberid = request.getParameter("memberid");
		String password = request.getParameter("password");
		String result = "";
		if(memberid.equals("spring") && password.equals("1111")) {
			result = "정상 로그인 사용자입니다.";
		}
		else {
			result = "로그인 정보 오류입니다.";
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("login", result);
		mv.addObject("user", memberid);
		mv.setViewName("loginresult");
		return mv;//spring이 setview를 보고 forward해주는거임 이 때 request객체도 같이 전송됨
        		//즉 addObject로 안보내도 loginresult에서 result.getparameter로 읽을 수 있음
	}
}
```

loginform.jsp

```jsp
<form action="loginresult">
아이디<input type="text" name="memberid"><br>
암호<input type="password" name="password"><br>
<input type=submit value="스프링로그인">
</form>
```

loginresult.jsp

```jsp
<h1>로그인 처리 결과입니다</h1>
<h3>${user }</h3>
<h3>${login }</h3>
```



| 400      | 매핑 메소드 매개변수가 form 전달 데이터 타입과 일치하지 않을 때<br />"111a1" => int <br />파일 업로드 - 파일 타입이 인식안됐을 때 |
| -------- | ------------------------------------------------------------ |
| 404      | spring<br />@RequestMapping, @Controller 확인 , jsp 확인     |
| 405      |                                                              |
| 500      |                                                              |
| 200, 300 | 정상실행                                                     |



컨트롤러 메소드의 매개변수(선언이 좀 자유로움)

| 서블릿 api              | HttpSession에 데이터 저장한다면 서블릿에 하던 그대로 사용하면 된다. |
| ----------------------- | ------------------------------------------------------------ |
| 자바 데이터 타입의 변수 | 요청 파라미터 이름과 동일한 이름으로 변수를 둔다면 자동으로 저장됨.<br />타입을 자동으로 변환시킬 수 있어서 편하기도 함<br />@RequestParam("요청 파라미터 이름") |
| 자바 객체               | @ModelAttribute("jsp이름") LoginVO                           |



모든 spring mvc

| web.xml             | "/" -이게 있으면 DispatcherServlet으로 실행해줄게<br />(...servlet-context.xml 설정을 참고해라 라고 dispatcher에게 알려줌)<br /> |
| ------------------- | ------------------------------------------------------------ |
| servlet-context.xml | view 저장경로 / 확장자<br />@xxx 설정 인식 패키지 설정       |
|                     |                                                              |
|                     |                                                              |



### web.xml에서 한글 인코딩하기

서블릿 api를 안쓰려고 하는데 request를 쓰면 안되잖아? request.setCharaterEncoding("utf-8") 그럼 이걸 설정을 어디서 할까?

```xml
	<filter>
	<filter-name>encoding</filter-name>
	<filter-class>
	org.springframework.web.filter.CharacterEncodingFilter
	</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>utf-8</param-value>
	</init-param>
	</filter>
	<filter-mapping>
	<filter-name>encoding</filter-name>
	<url-pattern>/*</url-pattern>
	</filter-mapping>
```



실습

![image-20210903165636354](../md-images/image-20210903165636354.png)
