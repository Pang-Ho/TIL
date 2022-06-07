# Day 7

## 예외처리 

### 예외란?

1. 프로그래머가 제어할 수 있는 오류

   컴파일러, 실행에서 생기는 **예외** ~~Exception들

   실행 도중에 생기는 오동작이기에 프로그램 내부에서 제어 가능

2. 프로그래머가 제어할 수 없는 오류

   JVM 오류, 메모리 부족, 전원 Off 등 

### 예외종류

1. NullPointerException

   null 값을 갖는 참조변수로 객체를 사용하려 할 때

   ```java
   String data;
   System.out.println(data.toString);
   =>NullPointerException
   ```

2. ArrayIndexOutOfBoundException

   배열 인덱스가 벗어난 상태

   ```java
   String[] A = new String[3];
   System.out.println(A[3]);
   =>ArrayIndexOutOfBoundException
   ```

3. NumberFormatException

   숫자로 변환할 수 없는 문자열을 변환하려 할 때

   ```java
   String data = "a100";
   Doubl.parseDouble(data);
   =>NumberFormatException
   ```

4. ClassCastException

   타입 변환이 불가능 한데, 강제변환 하는 경우

   ```java
   class Dog extends Animal{ }
   
   Animal animal = new Animal();
   Dog dog = (Dog)animal;
   =>ClassCastException
   ```

### 예외처리

* try - catch - finally

  ```java
  try {
     예외 발생 가능 코드
  } catch (예외클래스 e) {
      예외 처리
  } finally {
      항상 실행할 코드
  }
  ```

* catch 순서

  다중으로 catch를 사용할 경우 위부터 차례대로 예외를 처리한다.

  catch(Exception e)는 모든 예외를 처리한다는 경우로 Array 예외를 제외한 다른 모든 예외는 예외처리2에서 처리한다. 

  ```java
  try {
      
  } catch(ArrayIndexOutOfBoundsException e) {
      예외처리1
  } catch(Exception e) {
      예외처리2
  }
  ```

* 에러내용 출력

  e.getMassage : 에러 이벤트와 함께 들어오는 메세지 출력

  e.toString() : 에러 이벤트의 toString()을 호출해서 간단한 에러 메세지 출력

  e.printStackTrace() : 에러 발생 근원지를 찾아 단계별로 출력

* 자동 리소스 닫기

  ```java
  FileInputStream fis = null;
  try{
      fis = new FileInputStream("file.txt");
  } catch(IOException e) {
      ...
  } finally {
      if(fis != null){
          try {
              fis.close();
          } catch(IOException e) { }
      }
  }
  ```

  위 처럼 close() 메소드를 호출하여 안전하게 리소스를 닫아주어야 한다.

  => finally 블록을 보면 다소 복잡한 모습을 볼 수 있다.

*  try - with - resources 를 사용해서 간단하게 만들 수 있다.

  close() 메소드를 호출한 적이 없지만, try블록이 정상적으로 실행 완료했거나, 예외가 발생하게 되면 자동적으로 close() 메소드가 호출된다.

  ```java
  try(FileInputStream fis = new FileInputStream("file.txt");
      FileOutputStream fos = new FileOutputStream("file.txt")
     ) {
      ...
  } catch(IOEXception e) {
      ...
  }
  ```

### 예외 떠넘기기

* 메소드 예외를 호출한 곳으로 떠넘길 수 있다.

  method() 뒤에 throws 예외클래스1 명, 예외클래스2 명

  을 통해 넘긴다.

  이렇게 떠넘긴 method()는 try 블록 내에서 호출되어 예외를 반드시 처리해야한다.

```java
public void method() throws ClassNotFoundException, ... , ... {Class clazz = Class.forName("java.lang.String2")}

public void method2() {
    try {
        method();
    } catch(ClassNotFoundException e) {
        ...
    }
}
```

### 사용자 정의 예외

* 사용자가 예외를 만들 수 있다.

  Exception을 상속하는 예외 클래스를 만들면 된다.

```java
public class BalanceInsufficientException extends Exception {
	public BalanceInsufficientException() {	}
	public BalanceInsufficientException(String message) {
		super(message);
	}
}
```

* 예외 발생시키기

  throw new XXXException();

  throw new XXXException(message);

  이런 형식으로 조건을 충족하지 않으면 예외 발생하도록 쓰면 된다.

  ```java
  public void method() throws XXXException {
      if(false) {
          throw new XXXException("메세지");
      }
  }
  ```

* 예제

```java
class Account {
	private long balance;
	public long getBalance () {
		return balance;
	}
	public void deposit(int money) {
		balance += money;
	}
	public void withdraw(int money) throws BalanceInsufficientException { //사용자정의 예외 떠넘기기
		if(balance < money) {
			throw new BalanceInsufficientException("잔고부족 : " + (money - balance) + " 모자람");
		} //사용자 정의 예외 발생시키고 메세지 출력 
		balance -= money;
	}
}
public class AccoutExample {

	public static void main(String[] args) {
		Account account = new Account();
		//예금
		account.deposit(10000);
		System.out.println("예금액 : " + account.getBalance());
		//출금
		try {
		account.withdraw(30000);
		} catch(BalanceInsufficientException e) {
			String message = e.getMessage(); //day7.BalanceInsufficientException: 잔고부족 : 20000 모자람  =>예외메세지 얻기
			System.out.println(message);
			System.out.println();
			e.printStackTrace(); //	at day7/day7.Account.withdraw(AccoutExample.java:22)
								//at day7/day7.AccoutExample.main(AccoutExample.java:36)
            					// => 예외메세지 얻기

		}
	}

}

```



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

