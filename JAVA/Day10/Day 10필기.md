

리뷰 

18장 java.io패키지 클래스

표준창치 = 물리적장치 / 파일 등 입출력 기능 / 파일시스템 정보 추출

System.in => java.io.InputStream 타입

System.in.read() => 키보드 입력 - 1byte(영문 숫자 특수문자) / 한글, 다국어는 1byte로는 제대로 표현안됨

그래서 쓰는 클래스가

* java.util.Scanner

Scanner s = new Scanner(System.in); => 키보드로 받겠다.

s.nextInt() => 정수로 해석가능

s.nextDouble() => 실수로

s.next() / s.nextLine() => 한줄로



* System.out => java.io.PrintStream타입

System.out.print / println



* 파일 입출력

* 입력

  java.io.File - 파일 시스템 정보제공, 입출력 기능의 메소드는 없고 탐색기 기능과 같다.

* java.io.FileReader (한글)

* java.io.FileInputStream (한글 깨져서 보임 / 한글 제대로 보일 때도 있음) 

* int r = read()

* close()

* 출력

* java.io.FileWriter

* java.io.FileOutputStream

* 

* java.io.FileWriter

* write(char c[]) / write(String)

* 

* java.io.FileOutputStream

* write(byte b[])

* close()

18.5 보조 스트림

1024p ~ 1052

System.in.read()

Scanner s = new Scanner(System.in);



Scanner변환 - 보조스트림 / Scanner에서 쓸 수 있는 기능을 따로 보조적으로 할 수 있는것들

InputStreamReader / OutputStreamWriter - 1byte를 2byte로 

BufferedReader / BufferedWriter- 입력속도 향상 / 외부메모리에 있는 걸 내부메모리에 넣어서 입력속도를 향상시키는 것 / readLines() 한줄읽기

DataInputStream / DataOutputStream - 자바 데이터타입 변환 입력



java.io.50여개 클래스가 너무 복잡해서 jdk 1.5에서 Scanner가 나와서 간결하게 사용할 수 있도록 나옴

# Day 10

## 18장 네트워크 기능

java.net 패키지

다른 컴퓨터와 데이터를 주고받기

네트워크 - 물리적 통신 회선으로 연결되어 다른 컴퓨터와 입출력통신 / 인터넷상 모든 컴퓨터 고유한 식별 번호

1. ip address - 연결 컴퓨터 식별번호

   IPv4 주소 .... : 192.168.254.190

   2^(8*4)

   ip갯수가 부족해서 IPv6로 쓸 예정

2. port number - 한 컴퓨터와 동잘할 프로그램과 연결하는 식별번호

   2^16개

=> ip + port 알아야 서로 통신할 수 있음.



java.net.InetAddress 클래스 

| tcp 통신방식 - 서로 동시 통신 (전화)                         | udp 통신 방식 - 일방적 통신 (우편)                           |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| java.net.SeverSocket<br />java.net.Socket<br />처음부터 끝까지 남들이 개입 못함<br />나 - 전화번호 - 건다 - 내용 - 끊는다 - 친구1<br />연결 해제 | java.net.DatagramSocket<br />java.net.DatagramPacket<br />대량의 메세지 동시발송 할 때 좋음<br />나 - (내용, 누가, 누구한테) - 친구2<br />연결 해제 개념이 없음 |

- 이미 구현을 해놓고 제공된 네트워크 방식

  인터넷 = 웹 = http / 파일 전송 특화 = FTP / 원격접속  = telnet

  http://www.xxx.xxx

* protocol  = 통신 컴퓨터 약속 규칙



| 로그인 서버역할 프로그램                                     | 로그인 클라이언트 프로그램                                   |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1. 서버 시작(port 번호)<br /><br />SeverSocket ss = new SeverSocket(9999);<br />3. 클라이언트 요청 승인<br /><br />Socket s = ss.accept();<br />5. 클라이언트가 전송한 아이디와 암호를 입력받아서 처리한다.<br />byte[] id_byte_sever = new byte[100];<br />InputStream is = s.getInputStream();<br />is.read(id_byte)<br />String id = new String(id_byte_server)<br />6. 처리 결과( 정상, 오류 ) 클라이언트에게 전송<br /><br />OutputsStream os =  s.getOutputStream();<br />os.write(...)<br />9.클라리언트와 접속 해제 <br />s.close() | 2. 서버에 접속, 요청(서버 ip, 서버 port)<br />Socket s = new Socket(ip , 9999)<br />4. 서버로 로그인아이디 암호 전송<br />String id = "multi" //nextline으로 받으면 \n을 쓰도록<br />byte[] id_byte = id.getBytes(); -> 숫자코드 'm', 'u', 'l', 't', 'i'<br />OutputsStream os =  s.getOutputStream();<br />os.write(id_byte)<br />* write는 byte b[] 배열만 가짐<br />7. 서버가 전송한 결과를 이용한다.<br /><br />InputStream is = s.getInputStream();<br />??? <<-- is.read()<br />8. 서버와 접속 해제<br />s.close() |
| 읽어올 때는 read<br />InputStream is = s.getInputStream();<br />is.read(byte[]);<br />바이트 배열 => String 변환 | String => 바이트 배열 변환 후 <br />OutputStream os = s.getOutputStream[]<br />os.write |



```java
1. 서버시작
    SeverSocket ss = new SeverSocket(포트번호);
2. 서버 접속 요청
    Socket s = new Socket(ip, 9999);
3. 클라이언트 요청 승인
    ss.accept();
  ...
8. s.close();
9. ss.close();
```

java.net.ConnectException : Connection refused : connect => 서버 아직 시작되지 않았는데 클라이언트가 접속 상태 ( 서버를 먼저 시작해라 )

java.net.BindException : ADDRESS IS AL..... 이미 사용중 => 서버 이미 시작한 상태에서 서버 또 실행 상태(포트번호 중복) (이미 실행중 1개 서버만 사용해라)

### 실습예제

| 클라이언트<br />LoginClient.java          | 서버<br />LoginSever.java                                    |
| ----------------------------------------- | ------------------------------------------------------------ |
| 키보드<br />아이디 multi<br />암호 campus | 클라이언트가 키보드로 입력하여 전송한 아이디와 암호를 받아서 적합성을 검사<br />HashMap<String, String> users = <br />new HashMap<String, String>();<br />users.put("multi", "campus");// key - 아이디 value - 암호<br />users.put("java", "program");<br />users.put("oracle", "db");<br />users 해당 아이디가 없다면  "회원가입부터 하세요" 클라이언트에게 출력<br />users 해당 아이디가 있는데 암호가 다르면 "암호를 확인하세요"<br />다 되면 "정상 로그인 사용자입니다." |

1066p부터

18.7.5 스레드 병렬 처리

1. 채팅 서버 1개 / 채팅 클라이언트 여러개 - 스레드 구조를 알아야됨,  

   awt, swing, java fx(화면 마우스 클릭과 메뉴 선택 하는 화면 구성api = gui 구성)

여기서 18장 끝

자바도 끗...

# sql

1. oracle - run sql command line
2. conect system/system
3. 

