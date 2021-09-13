# 스프링 부트

* xml 설정이 최소화
* 

pom.xml수정

```xml
<!-- for jsp -->
	<dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
        <scope>provided</scope>
    </dependency>
<!-- for jsp jstl -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
    </dependency>
<!--for tomcat restart -->
	<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
	</dependency>

```

* application.properties



## spring boot ajax

* 스프링 부트는 몇 가지 라이브러리를 포함하고 있는데 그 중 하나가 spring-databind이다 pom.xml에서 추가할 필요가 없다.
  * jquery를 사용하기 위해 jquery js는 static 폴더에 넣는다
    * script src="http:localhost:9001/jquery-3.2.1.min.js"

## spring boot file upload

* 위와 동일하게 라리브러리 추가 필요 없다.
* 업로드 파일 용량을 늘릴려면

```xml
spring.servlet.multipart.maxFileSize=100MB
```

* xml componentscan 쓸 것을 @ComponentScan을 쓸것임
* Myboot0Application.java에 업로드 컨트롤러 인식하도록 씀
* 없으면 현재 패키지 컨트롤러만 인식함

```java
@ComponentScan(basePackageClasses = UploadController.class) => upload 패키지 컨트롤러만 인식
=> upload 패키지는 경로 안써도 됨
   패키지 구별은 패키지명만 배열 형식으로 나열하는 옵션을 씁니다 아님 패키지명.클래스명.class  형식으로 씁니다

```

* 현재 패키지도 인식하게 하려면

```java
@ComponentScan(basePackageClasses = TestController.class)
or
@ComponentScan => 현재 패키지 스캔
```

== hello.jsp ajaxbtn 작동 안되니 수정하셈

@SpringBootApplication

* 스프링 부트 시작 클래스임
* main 메소드라 생각하면 된다.

@ComponentScan(basePackageClasses = xxxController)

* xxxController 패키지를 스캔해라

### 업로드 된 이미지 올리기

@Configuration

* 특정 파일 외부 폴더 저장하고, 외부 폴더를 웹 서버에 등록

* 웹서버는 폴더 접근을 제한함
  * "src/main/resources/static" => 그래서 경로는 여기부터 시작해서 /images/americano.jpg 이 방식이 됨
  * 현재 프로젝트가 아닌 경로는 접근이 불가하다.
* 그러면 어떻게 웹서버가 무엇을 바뀌어야 할까?
  * servlet.jsp에선 server.xml에 <Context path=" c:/kdigital2 ... uri="/upload" 이런 형식을 추가
  * spring mvc에서도 쓸 수 있는거잖아!
    * ㅇㅇ 맞음 톰캣에 web.xml( 내장된 tomcat 설정)이 있음
  * 스프링 부트에서는  server.xml, web.xml이 없음
    * WebMvcConfigurer 인터페이스에서 상속받아 xxx메소드를 오버라이딩 해서 위 같은 내용을 쓰면됨
    * @Configuration = application.properties
* MyWebMVCConfig.java

```java
@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/kdigital2/upload/");
	}
    file:/// 뒤 부분 경로를
    /upload/... 으로 쓸게~ 라는 의미임.
```

## 스프링 부트에서  mybatis 실행하기

| spring mvc 에서는 어떻게 설정했나                            | spring boot 어떻게 설정할까?                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| pom.xml에서 4개 라이브러리 추가<br />mybatis.jar,mybatis-spring, framework, oracle | 스프링 부트 스타터 항목 설정<br />jdbc api, oracle driver, mybatis |
| spring-mybatis.xml<br />스프링과 마이바이트 연동<br />db연결, mapping 파일 정보 | application.properties에 설정                                |
| mybatis-config.xml<br />클래스 alias정보까지                 | 그대로 사용                                                  |
| sql-mapping.xml<br />sql 매핑                                | sql 매핑 방식은 같지만 <br />수정(표현 방법이 다름) 필요     |
| web.xml<br />spring-mybatis.xml이 연동 설정 등록<br />       | web.xml은 스프링 부트에 없다 <br />application.properties에서 설정한다. |
| servlet-context.xml<br /><context:component-scan...<br />jsp 확장자/경로<br />html 경로<br />파일업로드 api MultipartResolver | @ComponentScan으로 대신할 것<br /><br />jsp 같은 경로 확장자는 application.properties에서 설정<br />html 경로는 resources/static 폴더에 반영<br />부트에 내장됨 |

1. stater 설정

   ![image-20210913134745516](../md-images/image-20210913134745516.png)

2. application.properties

   ```
   #mybatis oracle
   spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
   spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
   spring.datasource.username=hr
   spring.datasource.password=hr
   
   #config파일
   mybatis.config-location=src.main/resources/mybatis-config.xml
   mybatis.config-location=classpath:mybatis-config.xml 위를 이렇게 줄이기
   #mapper파일
   mybatis.mapper-locations=classpath:mappers/sql-mapping.xml
   ```

   

| EmpDAO                                                       | sql-mapping.xml                                              |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| @Autowired<br />SqlSession session;                          |                                                              |
| session.selectList()<br />session.selectOne<br />session.insert<br />session.delete<br />session.update | <select id=" " resultType=" " parameterType=" "              |
|                                                              |                                                              |
| 스프링 부트에선                                              |                                                              |
| @Mapper<br />EmpDAO<br />클래스였는데 인터페이스로 바꿈      | sql-mapping.xml                                              |
| @Autowired<br />SqlSession session;                          | namespace는 매퍼 이름과 같게<br />select id를 DAO 메소드와 이름을 동일하게 만듦 |
| public void emplist();                                       | =>  namespace="xxx.EmpDAO"<br />=>  <select id="emplist"     |

3. EmpDAO interface !!

   ```java
   class EmpDAO => interface EmpDAO
       
   @Autowired
   SqlSession session; => @Mapper
       
   public List<EmpVO> getEmpList(){ ... } => public List<EmpVO> empList();
   ```

4. 부트 시작파일 MyBoot0Application 수정

   ```java
   @MapperScan(basePackageClasses = EmpDAO.class)
   ```

   

* 실습

