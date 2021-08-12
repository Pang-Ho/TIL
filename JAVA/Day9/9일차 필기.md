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

