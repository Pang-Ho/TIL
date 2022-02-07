# HTTP(Hyper Text Transfer Protocol)

* 그냥 문자가 아닌 Hyper 텍스트를 전송하는데 활용하는 프로토콜
* 웹 상에서 정보를 주고받을 수 있는 프로토콜

## HTTP 메시지

서버와 클라이언트가 데이터를 교환하는 방식

* 클라이언트 => 서버 : Request Message
* 서버 => 클라이언트 : Response Message



## HTTP Request 메시지 스펙

* 첫째줄 : start line / 실행되어야하는 요청이 기록되어 있음 (HTTP 메서드(GET, PUT, POST 등))
* 두번째줄 부터 줄바꿈 전까지: HTTP Headers / 요청에 대한 설명 Header(User-Agent, Accept 등)
* blank line
* 헤더에서 줄바꿈 이후 : Request Body / 요청과 관련된 내용

~~~java
POST /create-developer HTTP/1.1
Content-Type: application/json
Accept: application/json

{
  "developerLevel": "JUNIOR",
  "developerSkillType": "FULL_SRACK",
  "name": "sun"
}
~~~



## HTTP Response 메시지 스펙

* 첫째줄: 상태라인(200, 500, 등) / 요청에 대한 성공, 실패
  * 상태코드
  * 1xx : 정보성
  * 2xx : 성공
  * 3xx : 리다이렉트
  * 4xx : 클라이언트오류
  * 5xx : 서버오류
* 두번째줄부터 줄바꿈 나오기 전까지: Header / 메시지 설명
* 헤더에서 줄바꿈 이후: Request Body / 응답과 관련된 문서

~~~java
HTTP/1.1 200 OK
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 17 Jul 2021 15:33:34 GMT
Keep-Alive: timeout=60
Connection: keep-alive
  
{
  "developerLeve": "JUNIOR",
  "developerSkillType": "FULL_STACK",
  "name": "sun"
}
~~~

