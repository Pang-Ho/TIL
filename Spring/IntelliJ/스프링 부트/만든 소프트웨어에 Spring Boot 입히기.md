# 만든 소프트웨어에 Spring Boot 입히기



## Spring Boot란?

스프링 부트는 스프링 베이스로된 어플리케이션을 바로 실행시켜 준다.

* 스프링이 밀키트라면 부트는 완성된 요리다.



## Spring Boot 주요기능

* Stand-alone 스프링 애플리케이션
  * 단독으로 실행이 가능하다. = 톰캣이 내장돼 있어서
* 임베디드 톰캣 내장 (WAR 파일 배포 필요 없음)
  * 스스로 웹 애플리케이션 서버 기능을 가지고 있다.
  * 톰캣 서버에 배포를 하려면, WAR파일이 필요했다.
  * 그러나 스프링 부트에서는 JAR로 실행한 다음 run 하면, 동작하게끔 돼 있다.
    * 즉, 일반적인 자바 애플리케이션처럼 메인 메서드와 진입점 런 포인트가 똑같이 사용되고 있다.
* 빌드 설정을 단순화해줄 기초 세팅과 의존성
  * auto configuration이 된다.
    * component-scan으로 component를 찾고 bean을 생성하는데, auto configuration에 의해 추가적인 bean들이 함께 생성된다.
    * `@EnableAutoConfiguration`
* 스프링 및 서드 파티 라이브러리의 자동 설정
* 제품 레벨로 사용할 수 있는 각종 기능들
* XML 설정 필요 없음



## 요점

스프링이 할 일과 작성할 코드를 줄여주었고(강력한 프레임워크)
스프링 부트가 그것을 더 줄여주었다. (굿 프랙티스)



## Initialize Spring boot

https://start.spring.io/ 를 통해 스프링 부트 프로젝트를 만들어준다.

spring으로 만든 내용들 spring boot에서 실행할 것이기에, spring starter web만 추가해준다.

그 전에 만든 controller, logic, service를 가져오고 실행해본다.

잘 작동하는 것을 볼 수 있다.