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

### String 생성자

* String 생성자는 byte[] 배열을 문자열로 변환하는데 쓰인다.

  바이트 배열을 String으로 변환해서 출력한다면 바이트 값은 저장하고 있던 문자열 값으로 변환된다.

  ```java
  String str = new String(byte[] bytes); //바이트 배열 전체를 String 객체로 생성
  String str = new String(byte[] bytes, String charsetName); //지정한 문자셋으로 디코딩
  ```

  

| 메소드                               |                                                              |
| ------------------------------------ | ------------------------------------------------------------ |
| equals()                             | 문자열 대소문자 구분해서 동등 비교                           |
| equalsIgnoreCase()                   | 문자열 대소문자 구분않고 동등 비교                           |
| toUpperCase()                        | 문자열 모두 대문자로 변경                                    |
| toLowerCase()                        | 문자열 모두 소문자로 변경                                    |
| 문자열.Length()                      | 문자열에선 () 표시                                           |
| 배열.Length                          | 배열에선 () 표시x                                            |
| split("/"), split(" ") 등등          | " " 안에 문자열을 구분하고 분리한다.                         |
| StringBuffer / StringBuilder         | 문자열 자주 변경 저장구조?                                   |
| StringTokenizer("문자열" , "구분자") | String을 구분자로 token분리                                  |
| hasMoreTokenizer()                   | 띄어쓰기로 분리되어있는 데이터 다음에 또 데이터가 있는지<br />true, false |
| nextToken()                          | 분리된 데이터를 리턴함 // 여러번 쓰면서 다음 데이터 소환     |
| concat()                             | 두 문자열 합침                                               |
| charAt(0~n)                          | 문자열에서 특정 위치 문자 1개 리턴                           |
| getBytes()                           | byte[]로 리턴                                                |
| indexOf("java")                      | 특정 문자가 몇 번째 위치에 발견되었는지 숫자 리턴<br />발견 안되면 -1 |
| substring(1, 5)<br />substring(3)    | 특정 인덱스 범위 내의 부분 문자열 리턴<br />1부터 5 전까지<br />3부터 쭉 |
| replace("a", "b")                    | a 문자를 b로 바꿔라                                          |
| trim()                               | 문자열 앞 뒤 공백 잘라내기                                   |
| valueOf                              | int 를 String으로 변환                                       |

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
  
  

## 컬렉션 프레임워크

* 객체 여러개를 저장해두고 필요할 때마다 꺼내서 사용하는 방법

  배열 이용!

```java
//길이가 10인 배열 생성
Product[] array = new Product[10];
//객체 추가
array [0] = new Product("Model1");
array [1] = new Product("Model2");
//객체 검색?
Product model1 = array[0];
Product model2 = array[1];
//객체 삭제
array[0] = null;
array[1] = null;
```

* 배열은 생성 및 사용이 편리하지만 객체 수가 결정되어있기 때문에 불특정 다수의 객체를 저장하기에는 문제가 있다.

  이러한 문제점을 해결한 java.util 패키지에 컬렉션과 관련 인터페이스, 클래드들이 있는데, **컬렉션 프레임워크**라고 부른다.

  

* 프레임워크란?

  사용방법을 미리 정해 놓은 라이브러리

### java.util.객체여러개저장클래스

| Collection 프레임워크                                        | Collection 프레임워크                                        |                                                              |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **java.util.List** 인터페이스                                | **java.util.Set** 인터페이스                                 | **java.util.Map** 인터페이스                                 |
| class A implements List{<br />void add(Object o){...}<br />} | class xxxSet implements Set{<br />void add(Object o){...}<br />} | class xxxMap implements Map{<br />void add(Object o){...}<br />} |
| ArrayList                                                    | HashSet                                                      | HashMap                                                      |
| Vector                                                       | TreeSet                                                      | Hashtable                                                    |
| LinkedList                                                   |                                                              | TreeMap                                                      |
| Stack                                                        |                                                              | Properties                                                   |
| 서로 다른 타입의 데이터 저장 가능<br />저장 데이터 개수 동적으로 변경됨<br />데이터 저장 순서가 유지됨 (index)<br />같은 데이터 2번 이상 저장 가능 | 서로 다른 타입의 데이터 저장 가능<br />저장데이터 개수 동적으로 변경됨<br />데이터 저장 순서가 유지안됨<br />같은 데이터 2번이상 저장 불가능 | 서로 다른 타입 데이터 저장 가능<br />저장 데이터 개수 동적 변경<br />데이터 저장 순서가 유지안됨<br />같은 key 데이터 2번 이상 저장 가능<br />데이터 (key + value) |

#### java.util.List

* 인터페이스 상속 구현한 클래스들 - List 포함 메소드들 오버라이딩 필수

##### ArrayList

* List list = new ArrayList();

  1. 자바 모든 타입 저장 가능 

     => 그러나 객체가 저장될 때 Object 타입으로 변환되어 저장되지만 찾아올 땐 원래 타입으로 변환해야 하므로 실행 성능에 좋지 못하다.

     => 그래서 필요한 것이 제너릭!!  List<String> list = new ArrayList<String>(); 변환이 필요없다.

  2. 최초 객체 저장 가능한 길이는 10 / 계속해서 10개씩 추가

     ㄴ List list = new ArrayList(5, 2); => 최초 5개 그 후 2개씩 추가

1. 저장 메소드

   ```java
   boolean add(E e) //주어진 객체를 맨 끝에 추가
   void add(int index, E element) //주어진 인덱스에 객체 추가
    E set(int index, E element) //주어진 인덱스에 객체를 주어진 객체로 바꿈
   ```

   ``` java
   list.add(100);
   list.add(3.14);
   list.add(true);
   list.add(new A());
   list.add("java");
   list.add(2, "java"); // 지정된 인덱스에 객체 삽입
   ```

2. 삭제 메소드

   ```java
   void.clear() //저장된 모든 객체 삭제
   E remove(int index) //주어진 인덱스에 저장된 객체 삭제
   boolean remove(Object o) //주어진 객체 삭제
   ```

   ```JAVA
   list.remove(1); // add된 3.14 삭제
   list.remove("java") // add된 "java" 삭제
   ```

3. 수정 메소드

   ```java
   list.set(1, "aaa"); //1번 리스트 값을 "aaa"로 바꾼다.
   ```

4. 조회 메소드

   ```java
   boolean contains(Object o) //주어진 객체가 저장되어 있는지 여부
   E get(int index) //주어진 인덱스에 저장된 객체를 리턴
   boolean isEmpty //컬렉션이 비어있는지 조사
   int size() //저장되어있는 객체 수 리턴
   ```

   ```java
   list.size(); // 저장 데이터 개수(int) 리턴
   list.get(1); // 저장 데이터 내용 조회 / 1번 인덱스 값 (Object 타입)리턴
   			// toString 오버라이딩 해서 원하는 값 출력해야함. 
   			//안그러면 패키지명.클래스명@16진수주소값이 리턴
   list.indexOf("java"); // 특정 데이터가 저장되어있는 위치(int) 리턴 
   list.contains("java"); // 특정 데이터의 포함여부(boolean) 리턴
   ```

#### java.util.set

##### Set 컬렉션

* 저장 순서가 유지되지 않음
* 중복 데이터 저장 불가능 // null도 하나만 저장 가능
* 인덱스로 관리하지 않기 때문에 인덱스를 매개값으로 갖는 메소드가 없다.

1. 객체 추가

   ```java
   boolean add(E e) //주어진 객체를 저장, 객체가 저장되면 true 리턴 
       			//중복된 객체이면 falss 리턴
   ```

   ```java
   set.add("java")
   ```

2. 객체 검색

   ```java
   boolean contains(Object o) //주어진 객체가 저장되어있는지 여부
   boolean isEmpty() //컬렉션이 비어있는지 조사
   Iterator<E> iterator() //저장된 객체를 한 번씩 가져오는 반복자 리턴
   int size() //저장되어 있는 객체 수 리턴
   ```

   ```java
   set.contins("java");
   Iterator iterator = set.iterator();
    ㄴ ArrayList의 토큰 같은 것이라 hasNext() / Next() / remove()
        Iterator 인터페이스에 선언된 메소드들을 사용한다.
   set.size();
   ```

   

3. 객체 삭제

   ```java
   void clear() //저장된 모든 객체를 삭제
   boolean remove(Object o) //주어진 객체를 삭제
   ```

   ```java
   set.remove("java");
   set.clear
   ```

   E라는 타입의 파라미터는 Set 인터페이스가 제네릭 타입이기 때문에 생긴다.



* Iterator를 사용하지 않더라도 향상된 for문을 이용해 전체 객체 대상으로 반복 가능

  ```java
  Set<String> set = ...;
  for(String str : set) {
      System.out.println(str);
  }
  ```

##### Hashset

* Set 인터페이스의 구현 클래스이다.

  ```java
  Set<E> set = HashSet<E>();
  ```



#### java.util.Map

* key 와 value로 구성되어있음

1. 객체 추가

   ```java
   V put(K key, V vlaue) //키와 값을 지정해서 저장
       			//동일한 키가 있을 경우 값을 대체하고 이전 값을 리턴
   ```

   ```java
   map.put("Title", "자바");
   map.put("Title", "SQL"); // 수정
   ```

   

2. 객체 검색

   ```java
   boolean containsKey(Object key) //주어진 키 있는지 여부
   boolean containsValue(Object value) //주어진 값 있는지 여부
   Set<Map.Entry<K,V>> entrySet() //키와 값의 쌍으로 구성된 모든 
       						//Map.Entry 객체를 Set에 담아 리턴
   V get(Object key) //주어진 키가 있는 값을 리턴
   Boolean isEmpye() //컬렉션이 비어있는지 여부
   Set<K> keySet() //모든 키를 Set 객체에 담아서 리턴
   int size() //저장된 키의 총 수를 리턴
   Collection<V> values() //저장된 모든 값을 Collection에 담아서 리턴
   ```

   ```java
   map.get("Title"); //조회
   ```

   ```java
   Map<K, V> map = ~;
   Set<K> keySet = map.keySet();
   Iterator<K> keyIterator = keySet.iterator();
   while(keyIterator.hasNext()){
       K key = keyIterator.next();
       V value = map.get(key);
   }
   ```

   ```java
   Set<Map.Entry<K, V>> entrySet = map.entrySet();
   Iterator<Map.Entry<K, V>> entryIterator = entrySet.iterator();
   while(entryIterator.hasNext()) {
       Map.Entry<K, V> entry = entryIterator.next();
       K key = entry.getKey();
       V value = entry.getValue();
   }
   ```

   

3. 객체 삭제

   ```java
   void clear() //모든 Map.Entry(키와 값)을 삭제
   V remove(Object key) //주어진 키와 일치하는 Map.Entry를 삭제하고 리턴
   ```

   

   ```java
   map.remove("Title"); //삭제
   ```

##### HashMap

* 키와 값은 기본 타입을 사용할 수 없다.

  String, Integer 등 클래스 및 인터페이스 타입만 가능하다.

  ```java
  Map<String, Integer> map = new HashMap<String, Integer>();
  ```



## 제네릭

* 제네릭 즉 타입 파라미터를 왜 사용할까?

  ```java
  public class Box{
      private Object object;
      public void set(Object object) {
          this.object = object
      }
      public Object get() {
          return object
      }
  }
  ```

  ```java
  public class BoxExample{
      public static void main(String[] args){
          Box box = new Box();
          box.set("java"); //String => Object (자동타입변환)
          String name = (String) box.get();//Obj => Str (강제타입변환)
          
          box.set(new Apple()); // Apple => Object (자동타입변환)
          Apple apple = (Apple) box.get(); //Obj => App (강제타입변환)
      }
  }
  ```

  타입 파라미터가 없으면 저장할 때 자동타입변환이 생기고, 읽어올 때에 강제타입변환을 시키며 복잡해진다.

  =>

  ```java
  public class Box<T> {
      private T t;
      public T get() {
          return t;
      }
      public void set(T t) {
          this.t = t;
      }
  }
  ```

  ```java
  public class BoxExample {
      public static void main(String args[]) {
          Box<String> box = new Box<String>();
          box.set("java");
          String name = box.get();    
      }
  }
  ```

  



* 이해 안가는점

  ```java
  public boolean equals(Object obj) {
      if(obj instanceof Member) {
          obj.name // 이건 왜 안되고
          Member member = (Member) obj;
          member.name // 이렇게 객체를 호출해야 필드를 쓸 수 있음?
      }
  }
  ```

  

