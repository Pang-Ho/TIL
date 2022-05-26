# AOP 기본 개념 정리



## AOP 기본 개념

* AOP는 핵심 기능에 공통 기능을 삽입하는 것이다.
* 핵심 기능의 코드를 수정하지 않으면서 공통 기능의 구현을 추가하는 것이 핵심
* Spring MVC의 AOP는 프록시 객체를 자동으로 만들어준다.



## 용어

* Proxy 객체 : 핵심 기능 외에 공통적인 기능을 담은 객체
* Aspect : AOP에서 공통 기능. 여러 객체에 공통으로 적용되는 기능
* Advice : 공통 기능을 언제 핵심 기능에 삽입할지를 정의
* Joinpoint : Advice에서 '언제'에 해당
* Pointcut : Joinpoint의 부분집합으로 Advice가 실제로 적용되는 Joinpoint를 나타낸다
* Weaving : Advice를 핵심 로직 코드에 적용하는 것



## AOP 예제

| 인터페이스                 | Caculator         |
| -------------------------- | ----------------- |
| 핵심 기능 구현 객체        | ImpeCaculator     |
| 핵심 기능 구현 객체        | RecCalculator     |
| 공통 기능 구현 객체(Proxy) | ExeTimeCalculator |



**Calculator.interface**

~~~java
public interface Calculator { 
    public long factorial(long num); 
}
~~~



**ImpeCalculator.class**

~~~java
@Service
public class ImpeCalculator implements Calculator { 
 
    public long factorial(long num) { 
        long result = 1; 
        for (long i = 1; i <= num; ++i) 
            result *= i; return result; 
    } 
}
~~~



**RecCalculator.class**

~~~java
@Service
public class RecCalculator implements Calculator { 
    public long factorial(long num) { 
        if (num == 1) 
            return 1; 
            
        return num * factorial(num - 1); 
    } 
} 
~~~



**ExeTimeAspect.class**

~~~java
@Aspect
@Component
public class ExeTimeAspect {

    @Pointcut("execution(* com.aop.aoppractice..*(..))")
    private void publicTarget() {
    }

    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
            Signature signature = joinPoint.getSignature();
        }
    }
}

~~~

* `@Aspect`

  * `@Aspect`를 명시함으로써 AOP를 적용할 수 있는 클래스를 만들 수 있다.

  * depedencies

    ```java
    implementation group: 'org.springframework.boot', name: 'spring-boot-starter-aop', version: '2.7.0'
    ```

  * `@Aspect`를 명시하고 `@Component`를 통해 빈으로 등록하거나 `@Configuration`이 명시된 설정 파일에서 빈으로 등록해주어야 빈으로 작동할 수 있다.

  * `@Aspect`가 명시된 빈에는 Advice라 불리는 메서드를 작성할 수 있다. 메서드의 호출에 끼어드는 시점과 방법에 따라 `@Before`, `@After`, `@AfterReturning`, `@AfterThrowing`, `@Around` 등을 명시할 수 있다.

* `@Pointcut`

  * 어드바이스에 작성된 파라미터는 PointCut 이라 부르는 표현식이다. 끼어들 메서드의 범위를 지정할 수 있다. 

  ~~~java
  @Pointcut("execution(* com.aop.aoppractice..*.*(..))")
  /*  
  
  * 									: 모든 리턴 타입
  com.aop.aoppractice : 특정 패키지
  ..								  : 특정 패키지 내부에 패키지 내부
  * 									: 모든 클래스
  * 									: 모든 메서드
  (..)							  : 모든 아규먼트
  
  */
  ~~~

* `@Around`

  * 대상 메서드를 감싸는 느낌으로 실행 전후 시점에 원하는 작업을 할 수 있다.

    `Object result =  joinPoint.proceed();`를 하면 다음 메서드 후에 진행이 된다. 현재 우리는 PointCut에서 모든 클래스를 설정하였으므로 어떤 메서드를 실행하여도 이 `measure()`메서드인 AOP는 실행이 될 것이다.

  * 예를들어 내가 서비스 클래스에서만 이 AOP를 적용하고 싶다면, 

    ~~~java
    @Pointcut("execution(* com.aop.aoppractice.serviceImpl.*.*(..))")
    ~~~

    

**AOPCOntroller.class**

~~~java
@Controller
public class AopController {
    @Autowired
    ImplCalculator implCal;

    @Autowired
    RecCalculator recCal;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home1(Locale locale, Model model) {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        System.out.println(implCal.factorial(5));

        System.out.println(recCal.factorial(5));

        model.addAttribute("serverTime", formattedDate );

        return "home";
    }
}

~~~



**실행 결과**

~~~
START: execution(long com.aop.aoppractice.serviceImpl.ImplCalculator.factorial(long))
END: execution(long com.aop.aoppractice.serviceImpl.ImplCalculator.factorial(long)) 17ms
120
START: execution(long com.aop.aoppractice.serviceImpl.RecCalculator.factorial(long))
END: execution(long com.aop.aoppractice.serviceImpl.RecCalculator.factorial(long)) 11ms
120
~~~

