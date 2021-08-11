# Day 8

## 기본 API 클래스

## API

* 자바에서 제공하는 API(Application Programming Interface) = 자바 라이브러리
* 프로그램 개발에 자주 사용되는 클래스 및 인터페이스 모음을 말한다.
* jdk에는 api가 설치되어 있음

## java.lang

* 자바 프로그램의 기본적인 클래스를 담고있는 패키지
* String, System 같은 클래스들이 java.lang에 속해있기 때문에 import 하지 않고도 사용할 수 있었다.

| 클래스                                                       | 용도                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Object                                                       | 자바 클래스의 최상위 클래스                                  |
| System                                                       | 표준 입출력 장치로부터 입출력하기 위해 사용<br />자바 가상 기계 종료시킬 때 사용<br />쓰레기 수집기를 실행 요청할 때 사용 |
| Class                                                        | 클래스를 메모리로 로딩할 때                                  |
| String                                                       | 문자열을 저장하고 여러가지 정보를 얻을 때 사용               |
| StringBuffer, StringBuilder                                  | 문자열을 저장하고 내부 문자열을 조직할 때 사용               |
| Math                                                         | 수학함수 사용                                                |
| Wrapper<br />Byte Short Character Integer<br /> Float Double Boolean Long | 기본 타입 데이터를 갖는 객체를 만들 때 사용<br />문자열을 기본타입으로 변환할 때<br />입력값 검사에 사용 |

##  java.util

* 컬렉션 클래스들이 대부분 차지한다

| 클래스          | 용도                                       |
| --------------- | ------------------------------------------ |
| Arrays          | 배열 조작할 때 사용                        |
| Calendar        | 운영체제의 날짜와 시간 얻을 때 사용        |
| Date            | 날짜와 시간 정보를 저장하는 클래스         |
| Objects         | 객체 비교, null 여부 등 조사할 때 사용     |
| StringTokenizer | 특정 문자로 구분된 문자열을 뽑아낼 때 사용 |
| Random          | 난수를 얻을 때 사용                        |

* Object 클래스

  클래스 상속을 선언하지 않으면 자동적으로 extends Object 가 붙어 Object 클래스를 상속하게 된다.

  필드가 없고 메소드들로 구성되어 있다.

  * equals(Object obj)

    equals의 매개변수 타입은 Object로 모든 객체가 매개값으로 대입될 수 있음을 뜻한다.

    두 객체를 동등 비교할 때 equals() 메소드를 흔히 사용한다. 

    * 같은 객체이건 다른 객체이건 상관없이 객체가 저장하고 있는 데이터가 동일함을 뜻함.

  * String 클래스의 equals()

    String 클래스의 equals() 메소드는 오버라이딩을 통해 데이터 번지 비교가 아닌 문자열 비교로 재정의 했기 때문이다.

  ====> Boolean equals()는 객체 번지수를 비교하지만 오버라이딩을 통해 주소가 아닌 다른 대상을 비교하도록 재정의할 수 있다. 

  

  * 같은 객체에서 id 필드가 같으면 true가 나오도록 

    오버라이딩 한 메소드

  ```java
  @Override
  public boolean equals(Object obj) {
   if(obj instanceof Member) { //모든 객체가 매개값으로 제공될 수 있으므로 기준 객체와 동일한 타입인지 비교해야한다.
      Member member = (member) obj;
      if(id.equals(member.id)) {
      return true;
      }
      return false;
   }
  }
  ```

  * toString()

    Object 클래스의 toString() 메소드는 객체의 문자 정보를 리턴한다.

    "클래스명@16진수해시코드" 로 구성된 문자 정보

    별 값어치 없는 정보이기에 toString() 메소드를 오버라이딩하여 간결하고 유익한 정보를 리턴하도록 되어있다.

    ```java
    class SmartPhone {
    	private String com;
    	private String os;
    	
    	public SmartPhone(String com, String os) {
    		this.com = com;
    		this.os = os;
    	}
    	
    	public String toString() { //오버라이딩 재정의
    		return com + ", " + os;
    	}
    }
    public class ToStringExample {
    	public static void main(String args[]) {
    		SmartPhone myPhone = new SmartPhone("삼성", "안드로이드");
    		
    		String strobj = myPhone.toString();
    		System.out.println(myPhoe);
            //s.o.p의 매개 값 myPhone은 myPhone.toString()으로 출력됨.
    	}
    }
    
    ```

    => 여기서 System.out.println( )의 매개 값이 기본타입이라면 해당 값을 그대로 출력하지만, 매개 값으로 객체를 주면 객체의 toString()  메소드를 호출해서 리턴값을 받아 출력하도록 되어있다.

## java.lang.String

String 문자열 표현을 조작 구현하는 클래스

String 객체를 생성하는 방법은 2가지

1. String s1 = new String("문자열");
2. String s2 = "문자열";

| stack                                              | heap                                                         |
| -------------------------------------------------- | ------------------------------------------------------------ |
| s1 : 100<br />s2 : 500<br />s3 : 200<br />s4 : 500 | 100 : [java]<br />200 : [java]<br /><br /><br /><br />500 : [java] |

String s1 = new String("java")

String s2 = "java"

String s3 = new String("java")

String s4 = "java"

============

s1 == s2 ==> false / s2 == s4 ==> true

s1.equals(s2) ==> true / s2.equals(s4) ==> true

* ''==" 주소값 비교 // "equals()" 문자열 내용 비교

| 메소드                            |                                                              |
| --------------------------------- | ------------------------------------------------------------ |
| equals()                          | 문자열 대소문자 구분해서 동등 비교                           |
| equalsIgnoreCase()                | 문자열 대소문자 구분않고 동등 비교                           |
| toUpperCase()                     | 문자열 모두 대문자로 변경                                    |
| toLowerCase()                     | 문자열 모두 소문자로 변경                                    |
| 문자열.Length()                   | 문자열에선 () 표시                                           |
| 배열.Length                       | 배열에선 () 표시x                                            |
| split("/"), split(" ") 등등       | " " 안에 문자열을 구분하고 분리한다.                         |
| StringBuffer / StringBuilder      | 문자열 자주 변경 저장구조?                                   |
| StringTokenizer                   | String을 띄어쓰기로 token분리 구조                           |
| hasMoreTokenizer()                | 띄어쓰기로 분리되어있는 데이터 다음에 또 데이터가 있는지<br />true, false |
| nextToken()                       | 분리된 데이터를 리턴함 // 여러번 쓰면서 다음 데이터 소환     |
| concat()                          | 두 문자열 합침                                               |
| charAt(0~n)                       | 문자열에서 특정 위치 문자 1개 리턴                           |
| indexOf("java")                   | 특정 문자가 몇 번째 위치에 발견되었는지 숫자 리턴<br />발견 안되면 -1 |
| subString(1, 5)<br />subString(3) | 특정 인덱스 범위 내의 부분 문자열 리턴<br />1부터 5 전까지<br />3부터 쭉 |
| replace("a", "b")                 | a 문자를 b로 바꿔라                                          |
| trim()                            | 문자열 앞 뒤 공백 잘라내기                                   |
| valueOf                           | int 를 String으로 변환                                       |

* split()

  ```java
  String address = "서울시 강남구 역삼동";
  String[] a = address.split(" ");
  a[] => {서울시, 강남구, 역삼동}
  a => java.lang. ~~
  a[0] => "서울시"
  ```

* StringTokenizer()

  ```java
  StringTokenizer st = new StringTokenizer("서울시 강남구 역삼동", " ");
  st => java.util.StringTokenizer@723279cf //st자체로 쓰는게 아닌 hasMoreTokens와 nextToken 이용
      while (st.hasMoreTokens()) {
  	         System.out.println(st.nextToken());
  	     }
  => 
  서울시
  강남구
  역삼동
  ```

* hasMoreTokens()

  ```java
  st.hasMoreTokens(); => true
  ```

* concat()

  ```java
  address.concat(address); => 서울시 강남구 역삼동서울시 강남구 역삼동
  ```

* charAt()

  ```java
  address.charAt(2) => '시'
  ```

* indexOF

  ```java
  address.indexOf("울") => 1
  ```

* subString

  ```java
  address.subString(3) => " 강남구 역삼동"
  ```

* valueOf

  ```java
  String.valueOf(34) => "34"
  ```

## java.util.Date / Calendar

* Date 클래스의 대부분 기능은 사용자제 권도 되어 있으니 보통 Calendar 사용한다.

* Calendar cal = Calendar.getInstance();

  abstract class 이기에 new Calendar() 불가 위 처럼 선언

  cal.get(Calendar.[static 변수])

  ```java
  int year = cal.get(Calendar.YEAR);
  ```

## java.text.SimpleDateFormat / DecimalFormat

* SimpleDateFormat sf = new SimpleDateFormat("yyyy - MM - dd -HH : mm : ss E")

  날짜 형식 결정

  sf.format(Date 메소드)

* DecimalFormat df = new DecimalFormat("#.##")

  자릿수 결정

  df.format(7 / 3); => 2.33



