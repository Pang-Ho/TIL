# RESTful API



## Web Service 이해

* 사전적 의미로 네트워크 상에서 서로 다른 종류의 컴퓨터들 간에 상호 작용을 하기 위한 소프트웨어 시스템
* 웹 서비스를 구현할 때 두 가지 기술을 사용할 수 있다. Web Service, RESTful Service
* 두 가지로 생각하면 되는데, SOAP, REST
  * 각기 다른 두 가지 온라인 데이터 전송 방식
  * 둘 다 API를 구축하는 방법이다.
  * SOAP는 W3C에서 유지관리하는 공식 프로토콜이다.
  * REST(Representational State Transfer)은 아키텍처 원칙 세트이다.
* Web Service
  * SOAP, WSDL, UDDI 등 표준 기술을 사용하여 네트워크에 연결된 다른 컴퓨터 간의 분산 컴퓨팅을 지원하는 소프트웨어 및 기술들
  * 호출 당사자 사이에 엄격한 계약이 있을 경우 사용된다.
* RESTful Service
  * 웹 상의 자료를 HTTP 위에서 SOAP나 쿠키를 통한 세션 트랙킹 같은 별도의 전송 계층 없이 전송하기 위한 아주 간단한 인터페이스
  * 개방형 서비스를 위한 API를 제공하려면 HTTP 기술 기반인 JAX-RS를 사용한다.



## RESTful 아키텍처 스타일

* REST는 분산 하이퍼미디어 시스템을 위한 아키텍처 스타일이다.
  * 아키텍처 스타일이라고 하는 것은 제약 조건들의 집합을 뜻한다.
  * 아키텍처 제약 조건
    1. 모든 리소스는 URI로 식별한다.
    2. 모든 리소스는 다중 표현(multiple representation)을 가질 수 있다.
    3. 모든 리소스는 표준 HTTP 메서드로 접근/변경/생성/삭제 할 수 있다.
    4. 서버는 상태 정보를 갖지 않는다.
       * 클라이언트의 세션 정보들을 서버에서 관리하지 않는다는 뜻
* REST의 세 가지 요소
  * 자원(Resource) - URI 
    * URL은 자원이 있는 위치
    * URI는 위치 뿐만 아니라 식별자까지
  * 행위(Verb) - HTTP Method
    * POST - 해당 URI를 요청하면 리소스를 생성한다.
    * GET - 해당 리소스를 조회하고 해당 도큐먼트에 대한 자세한 정보를 가져온다.
    * PUT - 해당 리소스를 수정한다.
    * DELETE - 리소스를 삭제한다.
  * 표현(Representation)
    * URI에 특정 행위를 요청하면 그 결과로 Representation을 응답받는다.
    * html, xml, json, text 등 다양한 형태로 표현될 수 있다.



## RESTful API 설계

RESTful API를 만든다는 것은 서버가 가지고 있는 리소스들의 접근을 명확하고 알기 쉽게 만드는 것



**RESTful 디자인 첫 번째 원칙**

간결하고 직관적인 기준 URL을 유지하는 것

* 기준 URL에는 동사를 두지 않는다.

  * /article/delete/1 (x)
  * /articles/1 (o)

* 컬렉션이나 요소를 다룰 때 HTTP 메서드를 사용한다.

  * /articles - 목록을 위한 URL
  * /articles/123 - 목록 중 특정 개체를 위한 URL

  | Resource     | POST(create)        | GET(retrieve) | PUT(update)                   | DELETE(delete)     |
  | ------------ | ------------------- | ------------- | ----------------------------- | ------------------ |
  | /articles    | 새로운 article 생성 | article 목록  | articles에 대한 대량 업데이트 | 모든 articles 삭제 |
  | /articles/12 | 에러                | 특정 article  | 있으면 업데이트 없으면 오류   | 삭제               |

  

