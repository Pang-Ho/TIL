# day 9

## day8 리뷰

java.util.컬렉션프레임워크 클래스

* 여러개 객체 저장 / 동일타입이거나 서로 다른 타입 / 갯수 정적, 동적으로도 바뀜

  | java.util.ArrraylList                                        | java.utl.HashSet                                             | java.util.HashMap                                            |
  | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | 데이터 저장 순서대로 관리한다<br />동일한 객체 여러번 저장 가능 | 데이터 저장 순서가 없다.<br />동일한 객체 여러번 저장 불가능<br />(무시가 됨) | 데이터 저장 순서가 없다.<br />데이터가 키와 밸류로 저장된다.<br />동일한 키는 여러번 저장 불가능<br />(수정이 됨) |

## GENERIC

* jdk 1.0, 1.1
* jdk 1.2 - 새로운 api 추가 대량 1.3 1.4
* jdk 1.5 - 새로운 문법 도입됨 1.6 1.7
* jdk 1.8 - 새로운 문법, api, 내부 동작 원리다 달라짐 - 내가 쓰는 버전

1. 여러개 객체 저장한다면 => 저장 객체 동적 변경 장점 / Object 타입으로 자동 형변환 됨

   원래 저장 객체 타입으로 복원할 때 명시적 형변환을 해야함.

2. 1개 객체 저장 저장한다면 => 컴파일러에게 미리 객체 타입을 정하여 알려줌

   명시적 형변환이 필요 없다.

* Array list = new ArrayList(); => 여러개 객체 저장

  list.add(Obgect o)

  list.get(o) => Object o

* Array<String> list2 = new ArrayList<String> (); => String 객체 저장

  list2.add(String o)

  list2.get(o) => String o

``` java
class UserClass {
    String / Integer id; //학번, 사번, 주민번호 : 100-2000 타이푼도 있기에 어쩔 땐 String으로 받고싶고 어쩔 땐 Integer로 받고 싶음
    
}
```

``` java
class UserClass<T>{
    T id;
}
class User {
	UserClass<String uer1 = new UserClass<String>();
    user1.id = "100-2000";
    
    UserClass<Integer> user2 = new UserClass<Integer>();
    user2.id = 1002000;
}
```



# 18장 IO 기반 입출력 및 네트워킹

## 입출력

| 자바 프로그램<br />Stirng s =;<br />int i =;<br />String s2 =;<br />----------------------------------------------------------------> 입력 | 키보드 입출력<br />파일 입출력<br />메모리 입출력<br />- java.io.* <br />DB 입출력 - java.sql<br />네트워크 다른 컴퓨터 입출력 - java.net.*<br />출력<---------------------------------------------------------------------- |
| :----------------------------------------------------------- | -----------------------------------------------------------: |

* 입출력 - 자바 프로그램이 외부 환경으로부터 데이터를 전달 주거나 받는 것

### java.io. 50여개의 클래스

|                                    | 입력 용도 클래스                       | 출력 용도 클래스 |
| ---------------------------------- | -------------------------------------- | ---------------- |
| 2byte씩 읽어줌 - 문자단위 입출력   | Reader<br />FileReader, BufferedReader | Writer           |
| 1byte씩 읽어줌 - 바이트단위 입출력 | FileInputStream                        | OutputStream     |

| File 클래스 - 입출력 기능이 없다. <br />파일이나 디렉토리 크리, 리스트 목록, 파일저장 경로... |
| ------------------------------------------------------------ |



* 이미지 파일 => a.png파일 - 자바 입력 - 이미지(이진수 차례로 입력) - 출력

* 문자 파일 => 자바 입력
  ascii code (알파벳) 문자 표현 - 1byte
  unicode (전 세계 모든 문자) 표현 - 2byte - 자바 문자 unicode

* class Reader{ 메소드 정의 }
  class FileReader extends Reader { 자동포함 + 오버라이딩 메소드 + 추가 메소드 }

* class InputStream { 메소드 정의 }
  class FileInputStream extends InputStream { 자동포함 + 오버라이딩 메소드 + 추가 메소드 }

InputStream / Reader - 입력 공통 / 1바이트씩/2바이트씩

| read()                                                       | 입력(1바이트씩/2바이트씩)                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| close()                                                      | 입력 종료 파일 반납 문장<br />finally 작성 문장              |
| InputStream<br />read(byte b[]) 1바이트씩 입력 데이터 b 배열저장 | Reader<br />read(char b[]) 2바이트씩 입력 문자데이터를 b 배열 저장 |

Output Stream / Writer - 출력 공통 / 1바이트씩/2바이트씩

| write(int i ) - [] [] [] []                         | 출력(1바이트씩/2바이트씩)                                    |
| --------------------------------------------------- | ------------------------------------------------------------ |
| close()                                             | 출력 종료 파일 반납 문장<br />finally 작성 문장              |
| write(byte b[]) => byte 배열 b (저장한 내용을 출력) | Writer<br />write(char c[]) => char 배열 b (저장한 내용을 출력)<br />write(String s) => String s (저장한 내용을 출력) |

키보드 입력 / 모니터 출력 = 표준 입력System.out.read() / 표준 출력 System.out.print()

System.out.printe()

* System클래스 - java.lang 패키지 / 자바 실행 컴퓨터 정보 제공 클래스
* System.out 변수 - 자바 실행 컴퓨터의 모니터 장치 변수. java.io.PrintStream 타입 선언(OutputStream 하위)
* System.out.메소드 - java.io.PrintStream(write(), close()) 클래스에 포함 된 메소드를 사용



* System클래스 - java.lang 패키지 자바 실행 컴퓨터 정보 제공 클래스
* System.in 변수 - 자바 실행 컴퓨터의 모니터 장치 변수.java.io.InputStream 타입선언
* System.in.read() - java.io.InputStream 클래스 포함 출력

```java
int result = System.in.read() ; 1바이트
    4Byte 정수 result에 1바이트만 저장. 문자의 코드값이 나옴  a입력시 96
```

1. 키보드 입력 데이터임. 그대로 출력하는 것 뿐 연산이 안됨
2. 한글 데이터 표현은 안됨.
2-1. 1바이트 표현만 가능해서 데이터 타입 변환 불가능

* java.util.Scanner

* 생성자

  Scanner s = new Scanner( 키보드 = System.in);

* 메소드

  s.nextInt() => 정수 타입 변환 입력

  s.nextDouble

  s.nextBoolean

  s.next => 1개 단어 문자열

  s.nextLine() => 1개 라인 문자열 String 변환 입력



<실습 예제>

계산기 메뉴 첫 화면

1. 덧셈
2. 뺄셈
3. 곱셈
4. 나눗셈

| 계산기 메뉴 첫 화면<br />덧셈<br />뺼셈<br />곱셈<br />나눗셈<br />종료<br /><br />변호입력 : | 5번 입력하면 <br />mail 종료 - return<br />프로그램 종료 | 1~4 번 입력하면<br />첫번째 데이터 : 100<br />두번째 데이터 : 200<br /><br />1 번 입력후 ...<br />100 + 200 출력<br /><br />다시 첫 화면 메뉴 <br />2번 입력 후<br />100-200 |
| ------------------------------------------------------------ | -------------------------------------------------------- | ------------------------------------------------------------ |



## 파일 입력 /파일 출력

* File - 입출력 기능 없음.(보조기능) windows 탐색기 기능 / 길이 / 출력 가능파일 형태 판단
  역할 - 파일과 폴더 시스템관리

* 생성자

  * File f = new File("a.txt")  => c:\kdigital2\workspace\자바프로젝트폴더\a.txt

  * File f = new File("c:\test\a.txt")

  * File f = new File("."); => 상대경로(기준폴더)  c:\kdigital2\workspace\자바프로젝트폴더
  * File f = new File(".."); => 상대경로(기준폴더의 상위폴더)  c:\kdigital2\workspace
  * File f = new File("..\jsp"); => 상대경로(기준폴더의 상위폴더)  c:\kdigital2\workspace\jsp폴더

* 메소드

  * f.canRead() / f.canWrite() => 파일 입력 가능? / 출력 가능?

    윈도우 파일 기본 특성은 입력인데 입력 안되는 파일들이 있음(숨김파일 등)

  * f.length() => byte 단위

  * f.lastModified() => 파일 최근 수정시각( 년 월 일 시 분 초 => 1/1000초)

  * f.getXXXXPath();

  * f.list(); => 폴더 내부 세부 목록

  * f.exists() => 파일 존재 유무

  

<1바이트 파일 입출력>

* FileInputStream / FileOutputStream

<2바이트 파일 입출력>

* FileReader / FileWriter

### 파일입력

```java
FileInputStream fi = new FileInputStream("a.jpg");
while(true) {
	int r = fi.read();
		if(r == -1) {
		break
		}
```

fi.close(); => 다른 프로그램이 a.jpg 사용하려고 대기중이면 끝났다고 말해주는 것

```java
FileReader fr = new FileReader("a.txt")
while(true) {
	int r = fr.read();
		if(r == -1) {
		break
		}
```

fr.close(); => 다른 프로그램이 a.txt 사용하려고 대기중이면 끝났다고 말해주는 것

### 파일출력

```java
FileOutputStream fo = new FileOutputStream("a.jpg");
fo.write(65); => A
fo.write(66); => B
```

* FileOutputStream fo = new FileOutputStream("a.jpg");

  FileOutputStream fo = new FileOutputStream("a.jpg", false);

  a.jpg 파일 존재o => 저장 내용을 삭제 + 새로 추가 

  a.jpg 파일 존재x => 새롭게 파일 생성 + 출력 시작

* FileOutputStream fo = new FileOutputStream("a.jpg", true); 

  => a.jpg 파일 존재o => 저장 내용 유지 + 추가

fi.close(); => 다른 프로그램이 a.jpg 사용하려고 대기중이면 끝났다고 말해주는 것

```java
FileWriter fw = new FileWriter("a.txt")
fw.write(65); => A
fw.write(66); => B
```

fr.close(); => 다른 프로그램이 a.txt 사용하려고 대기중이면 끝났다고 말해주는 것

<예제>

| input dat<br />김수미 99 100 45<br/>백종원 67 13 99<br/>이연복 91 88 93<br/>여경래 85 83 76<br/>고길동 100 50 100 | class Student{<br />String name;<br />int score1, score2, score3<br /><br />int sum, avg;<br />calc(){}<br />Student(){}<br />}<br />class StudentTest{<br />main()[]<br />} | output.dat<br />김수미 99 100 45 sum avg<br/>백종원 67 13 99 sum avg<br/>이연복 91 88 93 sum avg<br/>여경래 85 83 76 sum avg<br/>고길동 100 50 100 sum avg<br />1등 : 이름 평균 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |

1. 학생수 동적 변경
2. input.adt 파일 현재의 학생수만큼 Student객체 생성 - Student 생성자 형태 정의
3. 생성된 Student 객체들마다 sum을 계산해주고 3으로 나눠서 avg를 구함 - calc 메소드에 정의
4. output.dat 파일에 출력



## IO 기반 입출력 및 네트워킹

* 프로그램이 데이터를 입력 받을 때 InputStream
* 프로그램이 데이터를 보낼 때 OutputStream

|             | 바이트 기반 스트림                    |                                         | 문자 기반 스트림            |                             |
| ----------- | ------------------------------------- | --------------------------------------- | --------------------------- | --------------------------- |
|             | 입력                                  | 출력                                    | 입력                        | 출력                        |
| 상위 클래스 | InputStream                           | OutputStream                            | Reader                      | Writer                      |
| 하위 클래스 | XXXInPutStream<br />(FileInputStream) | XXXOutputStream<br />(FileOutputStream) | XXXReader<br />(FileReader) | XXXWriter<br />(FileWriter) |

스트림 클래스는 크게 두 종류로 구분된다.

1. 바이트 기반 스트림  => 그림, 멀티미디어, 문자 등 모든 데이터 받고 보내도록

   ​								=> 1byte씩 바이트 단위로 입출력

2. 문자 기반 스트림  => 오로지 문자만 받고 보내도록

   ​							=> 2byte씩 문자 단위 입출력

### InputStream

* 바이트 기반 입력 스트림의 최상위 클래스로 추상클래스이다.

| 리턴타입 | 메소드                           | 설명                                                         |
| -------- | -------------------------------- | ------------------------------------------------------------ |
| int      | read()                           | 입력 스트림으로부터 1바이트를 읽고 읽은 바이트를 리턴        |
| int      | read(byte[] b)                   | 입력 스트림으로부터 읽은 바이트들을 매개값으로 주어진 바이트 배열에 저장하고 읽은 바이트 수를 리턴한다. |
| int      | read(byte[] b, int off, int len) | 입력 스트림으로부터 len개의 바이트만큼 읽고 주어진 바이트 배열을 b[off]부터 len개까지 저장한다. 실제로 읽은 바이트 수 len개를 리턴한다. |
| void     | close()                          | 사용한 시스템 자원을 반납하고 스트림을 닫는다.               |

#### read() 메소드

* 입력 스트림으로부터 1바이트를 읽고 4바이트 int 타입으로 리턴한다.

* 더 이상 입력스트림으로부터 바이트를 읽을 수 없다면 -1을 리턴한다.

* 밑을 통해 루프를 돌며 한 바이트씩 읽을 수 있다.

  ```java
  InputStream is = new FileInputStream("test.jpg");
  int readByte;
  while( (readByte = is.read()) != -1 ) {
      ...
  }
  ```

#### read(byte[] b) 메소드

* 입력 스트림으로부터 주어진 배열의 길이만큼 바이트를 읽고 읽은 바이트의 수를 리턴한다. 
* 더이상 읽을 수 없다면 -1을 리턴한다.

### OutputStream

* 바이트 기반 출력 스트림의 최상위 클래스로 추상클래스이다.

| 리턴타입 | 메소드                            | 설명                                                         |
| -------- | --------------------------------- | ------------------------------------------------------------ |
| void     | write(int b)                      | 출력 스트림으로 1바이트를 보낸다                             |
| void     | write(byte[] b)                   | 출력 스트림으로 주어진 바이트 배열 b의 모든 바이트를 보낸다. |
| void     | write(byte[] b, int off, int len) | 출력 스트림으로 주어진 바이트 배열 b[off] 부터 len개까지의 바이트를 보낸다 |
| void     | flush()                           | 버퍼에 잔류하는 모든 바이트를 출력한다.                      |
| void     | close()                           | 사용한 시스템 자원을 반납하고 스트림을 닫는다.               |

#### write(int b) 메소드

* 주어진 int 값에서 끝에 있는 1바이트만 출력 스트림으로 보낸다

  왜냐면 read가 동작할 때도 1바이트가 저장될 떄 int 끝 값에 저장되기 때문

  ```java
  OutputStream os = new FileOutputStream("test.txt");
  byte[] data = "ABC".getBytes();
  for(int i=0; i < data.length ; i++) {
      os.write(data[i]);   => "A" , "B" , "C" 하나씩 출력
  }
  ```

#### write(byte[] b) 메소드

* 매개값으로 주어진 배열b 의 모든 바이트를 출력 스트림으로 보낸다

  ```java
  OutputStream os = new FileOutputStream("test.txt");
  byte[] data = "ABC".getBytes();
  os.write(data);   => "ABC" 출력
  ```



### Reader

* 문자 기반 입력 스트림의 최상위 클래스로 추상클래스 이다.

| 리턴타입 | 메소드                              | 설명                                                         |
| -------- | ----------------------------------- | ------------------------------------------------------------ |
| int      | read()                              | 입력 스트림으로부터 1개 문자를 읽고 리턴                     |
| int      | read(char[] cbif)                   | 입력 스트림으로부터 읽은 문자들을 매개값으로 주어진 문자 배열에 저장하고 읽은 문자 수를 리턴한다. |
| int      | read(char[] cbuf, int off, int len) | 입력 스트림으로부터 len개의 문자를 읽고 주어진 문자 배열을 b[off]부터 len개까지 저장한다. 실제로 읽은 문자 수 len개를 리턴한다. |
| void     | close()                             | 사용한 시스템 자원을 반납하고 스트림을 닫는다.               |

#### read() 메소드

* 입력 스트림으로부터 한 개의 문자(2byte)를 읽고 4바이트 int 타입으로 리턴한다.

* read() 메소드가 리턴한 값으로 char 타입으로 변환하면 읽은 문자를 얻을 수 있다.

  ```java
  char chardata = (char) read();
  ```

#### read(char[] cbuf) 메소드

* 매개값으로 주어진 문자 배열의 길이만큼 문자를 읽고 배열에 저장
* 읽은 문자 수 리턴



### Writer

* 문자 기반 출력 스트림의 최상위 클래스로 추상클래스 이다.

| 리턴타입 | 메소드                               | 설명                                                         |
| -------- | ------------------------------------ | ------------------------------------------------------------ |
| void     | write(int c)                         | 출력 스트림으로 1개 문자를 보낸다                            |
| void     | write(char[] cbif)                   | 출력 스트림으로부터 주어진 문자 배열에 저장하는 모든 문자를 보낸다. |
| void     | write(char[] cbuf, int off, int len) | 출력 스트림으로 b[off]부터 len개까지 문자를 보낸다.          |
| void     | write(String str)                    | 출력 스트림으로부터 주어진 문자열을 전부 보낸다.             |
| void     | flush()                              | 버퍼에 잔류하는 모든 문자열을 출력한다                       |
| void     | close()                              | 사용한 시스템 자원을 반납하고 스트림을 닫는다.               |

#### write(int c) 메소드

* 출력 스트림으로 한 개의 문자(2byte)를 보낸다..

  ```java
  Writer writer = new FileWriter(test.txt);
  char[] data = "홍길동".toCharArray();
  for(int i=0; i<data.length ; i++) {
      writer.write(data[i]);  => "홍", "길", "동" 하나씩 출력
  }
  ```

#### write(char[] cbuf) 메소드

* 매개값으로 주어진 문자 배열의 모든 문자를 출력 스트림으로 보낸다.

  ```java
  Writer writer = new FileWriter("test.txt");
  char[] data = "홍길동".toCharArray();
  writer.write(data);  => "홍길동" 모두 출력
  ```



### 콘솔 입출력

* 콘솔로부터 데이터를 받을 수 있도록 InputStream 타입의 필드인 System.in이 제공되고 있다.

  ```java
  InputStream is = System.in; 
  int asciiCode = is.read(); //키보드로 입력하게 만들고 변수에 저장됨 
  char inputChar = (char)is.read(); //아스키코드 말고 문자로 얻고싶다면 
  ```

  * IOException예외가 생길 수 있다고 뜨므로 throws Exception 하면 정상 작동 된다.
  * InutStream의 read() 메소드는 1바이트만 읽기 때문에 한글과 같이 2바이트를 필요로 하는 유니코드는 read()메소드로 읽을 수 없다.
  * 키보드로 입력된 한글을 얻기 위해서는 read(byte[] b)를 이용해서 전체 내용을 바이트 배열로 받고, 이 배열을 통해 String 객체를 생성하면 된다.

  ```java
  byte[] byteData = new byte[20];
  InputStram is = System.in; //키보드 입력
  int readBytesNo = is.read(byteData); //읽은 바이트 수 /입력받은 데이터
  
  String strData = new String(byteData, 0 , readBytesNo -2 );
  ```

  * 위 처럼 주어진 바이트 배열에 읽은 문자를 저장한다.
  * 실제로 읽은 바이트 수는 Java를 입력하면 J A V A 엔터 포함해서 6바이트이다. 그래서 JAVA까지 문자열로 변환하기 위해 0 ~ readBytesNo-2 를 이용하는것이다.



* 이해 안가는점

  ```java
  InputStream is = System.in;
  
  int asciiCode = is.read();
  
  char cha = (char) is.read();
  
  //왜 두번 안쳐짐?
  ```

  ```java
  InputStream is = System.in;
  
  byte[] data = new byte[100];
  
  int code1 = is.read(data);
  
  int code2 = is.read(data);
  
  //이건 왜 두번 쳐짐?
  ```

  ```java
  InputStream is = System.in;
  
  byte[] data = new byte[100];
  
  int asciiCode = is.read();
  
  int code1 = is.read(data);
  
  //그럼 이건 왜 두번 안쳐짐?
  ```

  

* 콘솔에서 System.in으로 데이터를 읽었다면, 반대로 콘솔로 데이터를 출력하기 위해서는 System 클래스의 out 필드를 사용한다.

  ```java
  public class OSWriteTest {
  	public static void main(String[] args) throws Exception {
  		OutputStream os = System.out;
  		
  		for(byte b=48 ; b<58 ; b++) {
  			os.write(b);
  		}
  		os.write(10);
  		
  		for(byte b=97 ; b<123 ; b++) {
  			os.write(b);
  		}
  		os.write(10); // 라인피드 : 다음 행
  		
  		String hangul = "가나다라마바사아자차카타파하";
  		byte[] hangulByte = hangul.getBytes();
  		os.write(hangulByte);
  		
  		os.flush();
  	}
  }
  ```

### Scanner 클래스

* Scanner 클래스를 이용하면 콘솔로부터 기본 타입의 값을 바로 읽을 수 있다.

* 또한 File, InputStream, Path 등 다양한 입력 소스를 지정할 수 있다.

  | 리턴타입             | 메소드     |
  | -------------------- | ---------- |
  | boolen byte short... | nextXXX()  |
  | String               | nextLine() |

  

  ```java
  Scanner scanner = new Scanner(System.in);
  		
  		System.out.println("문자열 입력 : ");
  		String inputString = scanner.nextLine();
  		System.out.println(inputString);
  		System.out.println();
  		
  		System.out.println("정수 입력 : ");
  		int inputInt = scanner.nextInt();
  		System.out.println(inputInt);
  		System.out.println();
  		
  		System.out.println("실수 입력 : ");
  		double inputDouble = scanner.nextDouble();
  		System.out.println(inputDouble);
  ```

  ```java
  Scanner s = new Scanner(System.in);
  		System.out.println("키보드로 정수 2개를 입력해주세요");
  		// 100 200
  		if(s.hasNextInt()) { //이거 없어두 됨
  		int first = s.nextInt(); //정수 입력시에만 가능
  		int second = s.nextInt();// 두개 써서 두개 연속 입력해야댐
  		System.out.println(first + second);
  		}
  		s.nextLine(); // 이게 왜 들어가야함?
  		System.out.println("키보드로 한글 데이터를 입력해 보세요");
  		String word = s.nextLine();
  		System.out.println(word);
  ```

### 파일 입출력

* File 클래스는 파일 크기, 속성, 이름 등의 정보를 얻어내거나 파일 생성, 삭제 기능 제공한다.

* 생성자

  * File f = new File("a.txt")  => c:\kdigital2\workspace\자바프로젝트폴더\a.txt
  * File f = new File("c:\test\a.txt")
  * File f = new File(".") => 기준폴더
  * File f = new File("..") => 기준폴더의 상위폴더
  * File f = new File("..\jsp")

* 메소드

* file.exists() => flase

  | 리턴타입 | 메소드          | 설명                           |
  | -------- | --------------- | ------------------------------ |
  | boolean  | createNewFile() | 파일 생성                      |
  | boolean  | mkdir()         | 새로운 디렉토리 생성           |
  | boolean  | mkdirs()        | 경로상 없는 모든 디렉토리 생성 |
  | boolean  | delete()        | 삭제                           |

* file.exists() => true

  | 리턴타입 | 메소드             | 설명                             |
  | -------- | ------------------ | -------------------------------- |
  | boolean  | canExecute()       | 실행할 수 있는 파일인가?         |
  | boolean  | canRead()          | 읽을 수 있는 파일인가?           |
  | boolean  | canWrite()         | 수정 및 저장할 수 있는 파일인가? |
  | String   | getName()          | 파일 이름 리턴                   |
  | String   | getParent()        | 부모 디렉토리를 리턴             |
  | long     | length()           | 파일 크기 (byte)리턴             |
  | long     | lastModified()     | 마지막 수정 날짜 및 시간 리턴    |
  | String   | getCanonicalPath() | 파일 경로 리턴                   |

```java
File f = new File("a.txt"); //a.txt파일의 생성자 만들기
System.out.println("파일 크기 byte단위 : " + f.length());
```

#### Reader / Writer

```java
Scanner s = new Scanner(System.in);
String sFile = s.nextLine();
String dFile = s.nextLine();

FileReader fr = null;
FileWriter fw = null;

try {
    fr = new FileReader(sFile);
    fw = new FileReader(dFile, true); 
    //true가 없으면 출력 파일이 존재시 내용 삭제 후 새로 만듦
    //true가 있으면 출력 파일이 존재시 내용 유지하고 추가 출력
}
```

* 파일 내용 복사

```java
Scanner s = new Scanner(System.in);
s.o.p("원본 파일명 : ");
String sFile = s.nextLine();
s.o.p("목적지 파일명 : ");
String dFile = s.nextLine();

FileReader fr = null;
FileWriter fw = null;

try {
    fr = new FileReader(sFile);
    fw = new FileWriter(dFile);
	int r;
    while((r=fr.read()) != -1) {
        fw.write(r);
    }
}
catch (IOException e){
    e.printStackTrace();
}
finally {
    try {
        fr.close();
        fw.close();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}
```

