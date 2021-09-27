# Naver API

``` 
url : https://www.ncloud.com/nsa/kdth4
h-class16 몽환0!
```



```
kdigital
client id : 454frc6xdi
client secret : LqQmYOWxHCPdsJ1DFWhlCtKS5bmcLsCBCrgMLsak
```

* 네이버에서 제공하는 API

```java
사람1명
{
    "info":{"size":{"width":640,"height":640},
            "faceCount":1},
    "faces":[
        {"celebrity":{"value":"아이유","confidence":1.0}}
    ]
}

info변수
    info.size.width
    info.size.height
    info.faceCount
faces변수
    faces[0].celebrity
    faces[0].confience
    
사람2명
{"info":{"size":{"width":223,"height":226},"faceCount":2},"faces":[{"celebrity":{"value":"송중기","confidence":0.773768}},{"celebrity":{"value":"이연희","confidence":0.150873}}]}

사물
{"info":{"size":{"width":280,"height":180},"faceCount":0},"faces":[]}

2mb초과한 데이터
error!!!!!!! responseCode= 400
java.io.IOException: Server returned HTTP response code: 400 for URL: https://naveropenapi.apigw.ntruss.com/vision/v1/celebrity

```

* 볼 수 있는 오류

  | 오류 코드 | 오류 내용                                     |
  | --------- | --------------------------------------------- |
  | 400       | 2mb 초과 데이터<br />image파라미터 누락<br /> |
  | 401       | 접속 client key, secret 확인                  |
  | 404       | api url 확인                                  |





## 스프링부트

1. pom.xml

   jsp, jstl depencency 설정

2. application.properties

   server.port 설정

   view 위치와 확장자 설정

   DB를 사용한다면  설정

3. src/main/webapp/WEB-INF/views 폴더 생성

4. Application.java 실행해서 돌아가는지 확인

| 스프링     |                           |
| ---------- | ------------------------- |
| Controller | 요청 M-V 정의             |
| Service    | M - 1개 메소드에 1개 기능 |
| DAO        | M - DB접근하는 1개 메소드 |
| VO         |                           |
| JSP        | V                         |

| 데이터베이스가 필요없는 AI서비스 |                                                             |
| -------------------------------- | ----------------------------------------------------------- |
| NaverFaceController              | 요청 M-V정의                                                |
| NaverService 인터페이스          | APIExamFace.java에서 네이버 서버로부터 가져오는 json 데이터 |
| NaverFaceService                 |                                                             |
| JSP                              | V                                                           |

## 얼굴 인식 API 활용한 mvc

* NaveraiApplication

```java
@SpringBootApplication
@ComponentScan(basePackageClasses = NaverFaceController.class)
@ComponentScan//현재패키지 자동으로 인식해주는 거 안쓰면 숨겨져있지만 쓰는 순간 수동으로 다 해줘야됨
public class NaveraiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaveraiApplication.class, args);
		System.out.println("네이버 ai서비스 시작");
	}

}
```

* NaverFaceController

```java
@Controller
public class NaverFaceController {
	
	@Autowired
	NaverFaceService faceservice;
	
	@RequestMapping("/face") //get방식 C:/Users/Pang/Desktop/images (2)/images/ 뒤에 나오는 이미지 파일 입력
	public ModelAndView face(String image) {
		System.out.println("hi");
		ModelAndView mv = new ModelAndView();
		//NaverFaceService service = new NaverFaceService();
		String jsonModel = faceservice.test(image);
		mv.addObject("faceresult", jsonModel);
		mv.setViewName("/cfr/face");
		return mv;
	}
}
```

* NaverService.interface

```java
public interface NaverService {
	String test(String file);
}
```

* NaverFaceService

```java
@Service
public class NaverFaceService implements NaverService {

	@Override
	public String test(String file) {
        StringBuffer reqStr = new StringBuffer();
        StringBuffer response = new StringBuffer();
        String clientId = "454frc6xdi";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "LqQmYOWxHCPdsJ1DFWhlCtKS5bmcLsCBCrgMLsak";//애플리케이션 클라이언트 시크릿값";
        try {
            String paramName = "image"; // 파라미터명은 image로 지정
            String imgFile = "C:/Users/Pang/Desktop/images (2)/images/" + file;
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/celebrity"; // 유명인 얼굴 인식
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            // multipart request
            String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            OutputStream outputStream = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            String LINE_FEED = "\r\n";
            // file 추가
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
            writer.append("Content-Type: "  + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();
            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();
            BufferedReader br = null;
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            
            if(br != null) {
                //StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
        return response.toString();
	}
```

* face.jsp

```jsp
<body>
<h4>${faceresult }</h4>
<h4><%=request.getAttribute("faceresult") %></h4>

<%
//String --> json 으로 parsing 하기
String faceresult = (String)request.getAttribute("faceresul");
JSONObject obj = new JSONObject(faceresult);
JSONObcect info = (JSONObject)obj.get("info");
JSONObject size = (JSONObeject)info.get("size");
int width = (Integet)size.get("width");
int height = (Integet)size.get("heigt");

int faceCount = (Integer)info.get("faceCount");
%>

<%=width %>, <%=hieght %>, <%=faveCountt%>
</body>
```

![image-20210927134225680](../md-images/image-20210927134225680.png)

```xml
<!-- json parsing -->
<dependency>           
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20201115</version>
</dependency>
```

* JSONArray
* JSONObject

{ "a" : "java", "b" : [ { "c" : "ccc", "d" : "DDD"} ] }



![image-20210927142051636](../md-images/image-20210927142051636.png)



## 모든 이미지를 띄우고 확인

* faceinput.jsp

```jsp
<body>
<c:forEach items="${filelist }" var="onefile">
	<a href="/face?image=${onefile }"> ${onefile }</a><br>
	<img src="/naverimages/${onefile }" width=100 height=100><br>
</c:forEach>
<%-- <a href="/face?<%=filelist.get[i]%>"><img src="C:/Users/Pang/Desktop/images (2)/images/<%=filelist.get[i]%>"></a> --%>
</body>
```

* NaverFaceController

```java
	@RequestMapping("/faceinput")
	public ModelAndView faceinfut() {
		File f = new File("C:/Users/Pang/Desktop/images (2)/images/");
		String[] namelist = f.list(); //song.jpg 처럼 파일 이름들 가져옴 이 때 다른 폴더가있다면 조건도... jpg, tfif, png
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", namelist);
		mv.setViewName("/cfr/faceinput");
		return mv;
	}
```



## img src를 내 컴퓨터로

* MyWebMVCConfig.java

```java
@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/naverimages/**").addResourceLocations("file:///C:/Users/Pang/Desktop/images (2)/images/");
	}	
}
```

## jstl 쓰는 경우는

* 표현태그로 쓰기 힘들때 간편하게 쓰고싶을때

```jsp
<%
if(...){
    
}
%>
    
```



```jsp
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${filelist }" var="onefile">
	<a href="/face?image=${onefile }"> ${onefile }</a><br>
	<img src="/naverimages/${onefile }" width=100 height=100><br>
</c:forEach>
```





## 얼굴 인식 API2 활용한 mvc

```
{
"info":{"size":{"width":264,"height":200},"faceCount":1},
"faces":[{"roi":{"x":80,"y":45,"width":61,"height":61},
"landmark":null,
"gender":{"value":"female","confidence":0.999912},
"age":{"value":"24~28","confidence":0.856547},
"emotion":{"value":"neutral","confidence":0.999967},
"pose":{"value":"right_face","confidence":0.61542}}]
}



{
"info":{"size":{"width":640,"height":407},"faceCount":7},
"faces":[{"roi":{"x":478,"y":132,"width":29,"height":29},
"landmark":null,
"gender":{"value":"male","confidence":0.87414},
"age":{"value":"13~17","confidence":0.0640293},
"emotion":{"value":"neutral","confidence":0.999991},
"pose":{"value":"left_face","confidence":0.634878}},{"roi":{"x":312,"y":123,"width":27,"height":27},"landmark":null,"gender":{"value":"female","confidence":0.942221},"age":{"value":"25~29","confidence":0.651118},"emotion":{"value":"neutral","confidence":0.961848},"pose":{"value":"part_face","confidence":0.881817}},{"roi":{"x":556,"y":129,"width":31,"height":31},"landmark":null,"gender":{"value":"female","confidence":0.995143},"age":{"value":"26~30","confidence":0.946422},"emotion":{"value":"smile","confidence":0.995922},"pose":{"value":"left_face","confidence":0.815061}},{"roi":{"x":223,"y":121,"width":30,"height":30},"landmark":{"leftEye":{"x":230,"y":127},"rightEye":{"x":244,"y":127},"nose":{"x":239,"y":133},"leftMouth":{"x":235,"y":141},"rightMouth":{"x":244,"y":141}},"gender":{"value":"female","confidence":0.991381},"age":{"value":"24~28","confidence":0.651005},"emotion":{"value":"talking","confidence":0.478676},"pose":{"value":"frontal_face","confidence":0.999092}},{"roi":{"x":144,"y":140,"width":26,"height":26},"landmark":null,"gender":{"value":"male","confidence":0.660668},"age":{"value":"29~33","confidence":0.248786},"emotion":{"value":"neutral","confidence":0.965207},"pose":{"value":"right_face","confidence":0.494472}},{"roi":{"x":56,"y":124,"width":33,"height":33},"landmark":null,"gender":{"value":"child","confidence":0.911531},"age":{"value":"23~27","confidence":0.407081},"emotion":{"value":"neutral","confidence":0.998719},"pose":{"value":"false_face","confidence":0.77988}},{"roi":{"x":386,"y":119,"width":28,"height":28},"landmark":null,"gender":{"value":"male","confidence":0.53611},"age":{"value":"23~27","confidence":0.530643},"emotion":{"value":"neutral","confidence":0.98827},"pose":{"value":"part_face","confidence":0.825163}}]}
```

