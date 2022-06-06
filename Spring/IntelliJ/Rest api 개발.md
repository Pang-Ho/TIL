Spring @RestController 를 이용하여 REST API 개발

@Controller 어노테이션 : view 페이지를 찾아서 띄워주는 역할
하지만 REST API는 각 메서드마다 데이터를 그래도 반환시켜서 만들어야하낟.

그럴 때 필요한 것이 @ResponseBody

~~~java
@Controller public class FirstController {
  
  @ResponseBody // View 페이지가 아닌 응답값 그대로 반환하기 위해 사용 
  @RequestMapping (value = "/helloworld", method = RequestMethod.GET) 
  public String helloWorld() { 
    return "hello world"; 
  } 
  
}

~~~

