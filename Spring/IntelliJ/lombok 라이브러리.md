# lombok



## 롬복이란?

Getter, Setter 등 자바에서 반복적으로 쓰는 메서드들을 어노테이션으로 간편하게 쓸 수 있도록 만든 라이브러리



~~~java
public class DTO {
  String name;
  Integer age;
  
  void setName(String name) {
    this.name = name;
  }
  ...
}
~~~



~~~java
@Setter
@Getter
public class DTO {
  String name;
  Integer age;
}
~~~



### 추가 어노테이션

* @NoArgsConstructor

  * 파라미터가 없는 생성자 생성

* @AllArgsConstructor

  * 모든 파라미터가 있는 생성자 생성

* @RequiredArgsConstructor

  * 필요한 파라미터가 있는 생성자 생성

    ~~~java
    @Setter
    @Getter
    @RequiredArgsConstructor
    public class DTO {
    	@NonNull
      String name;
      Integer age;
    }
    ~~~

    NonNull 어노테이션을 통해 name은 Null일 경우 경고를 내게 된다.

    * Shift + command + T를 통해 테스트 코드를 만들어서 확인해보자

      ~~~java
      class DTOTest {
        @Test
        void test() {
          DTO dto = new DTO(); //파라미터가 없는 생성자 name 파라미터가 없기 때문에 오류가 뜬다
          DTO dto = new DTO("snow"); //name NonNull을 지키는 생성자를 만들어주는 걸 볼 수 있다. @RequiredArgsConstructor
        }
      }
      ~~~

      

* @Builder

  * builder() 메서드를 쓸 수 있다.

  * set 메서드를 자주 쓰면 코드 퀄리티가 테스트가 어렵고 한 번 세팅하고 안바꾸는 것이 좋다.

  * 그래서 가능한 안바꾸도록 final을 걸어서 쓰는 것이 좋다.

    ~~~java
    @Setter
    @Getter
    @RequiredArgsConstructor
    @Builder
    public class DTO {
    	@NonNull
      String name;
      Integer age;
    }
    ~~~

    ~~~java
    class DTOTest {
      @Test
      void test() {
    		final DTO dto = DTO.builder()
          .name("snow")
          .age(21)
          .build();
      }
    }
    ~~~



* @Slf4j

  * Logger를 쓰고싶은 상황에 반복적인 코드를 사용하곤 했다.

    ~~~java
    private static final Logger log = LoggerFacory.getLogger(DTO.class);
    //위 코드를 어노테이션으로 줄일 수 있다.
    @Slf4j
    public class DTO {
      
    }
    ~~~

    

* @UtilityClass

  * static 메서드들을 만들어서 사용할 때 이용한다.

    ~~~java
    @UtilityClass
    public class Util {
      public static void printLog() {
        System.out.println(LocalDateTime.of(2022, 2, 7, 15, 5));
      }
      public static void printNow() {
        System.out.println(LocalDateTime.now());
      }
    }
    ~~~

    