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
public class RecCalculator implements Calculator { 
    public long factorial(long num) { 
        if (num == 1) 
            return 1; 
            
        return num * factorial(num - 1); 
    } 
} 
~~~



**ExeTimeCalculator.class**

~~~java
public class ExeTimeCalculator implements Calculator { 
    private Calculator delegate; 
    
    public ExeTimeCalculator(Calculator delegate) { 
        this.delegate = delegate; 
    } 
    
    public long factorial(long num) { 
        long start = System.nanoTime(); 
        long result = delegate.factorial(num); 
        long end = System.nanoTime(); 
        
        System.out.printf("%s.factorial(%d) 실행 시간 = %d\n", 
                delegate.getClass().getSimpleName(), num, (end - start)); 
                
        return result; 
    } 
}
~~~

