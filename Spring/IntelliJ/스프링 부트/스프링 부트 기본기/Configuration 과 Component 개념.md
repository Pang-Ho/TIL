# @Configuration vs @Component



## 이 클래스는 커스텀 빈이다 => @Component

@ComponentScan은 base package에서 모든 @Component를 검색

> 인스턴스화 : 필요한 의존성을 모두 주입하는 것
>
> 스프링 컨테이너에 등록 : 필요한 곳에 의존성을 주입하는 것



## 빈을 만드는 방법

1. @Component로 빈을 만드는 것

~~~java
@Component
public class BubbleSort <T extends Comparable<T>> {
  
}
~~~



@Bean으로 빈을 만드는 것

2. @Bean(in @Configuration)

~~~java
@Configuration
public class Config {
  
  @Bean
  public Sort<String> bubbleSort() {
    
  }
}
~~~

3. @Bean(in @Component) : LiteMode
   * 프록시 빈을 만드는 과정이 일반적인 인스턴스를 만드는 과정보다 느리다.

~~~java
@Component
public class Config {
  
  @Bean
  public Sort<String> bubbleSort() {
    
  }
}
~~~

