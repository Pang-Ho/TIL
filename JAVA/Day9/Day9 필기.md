# Day 9

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
  System.out.println(asciiCode + inputChar);
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

