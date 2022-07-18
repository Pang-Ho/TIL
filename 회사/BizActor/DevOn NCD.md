# DevOn NCD

Source Code가 아닌 Flow Chart로 작성하는 개발
코딩 없이 시스템 개발이 가능한 개발 platform
DevOn UI Prototper, UI-BIZ Connector, BizActor를 이용하여 모델을 기반으로 시스템을 개발

* 자바를 이용해서 테스트로 오류제거가 편함



**DevOn Studio**

Eclipse기반 개발 도구



**DevOn NCD 테스팅**

편리한 테스트 지원도구를 통해 트스트 가능



**Bizactor 관리계층**

* Service
  * 기능을 수행하는 단위
* Component
  * Service들의 집합
  * 소유권을 가지고 있는 사용자만 수정, 삭제 가능
* Group
  * Component들의 집합
  * 소유권 개념 없이 모든 사용자들이 함께 사용
* Layer
  * Business Rule Service (BR)
    * DA/SA/BR을 호출하여 조건 등 제어 Logic을 수행하는 Service
    * 복잡한 비즈니스 로직은 대부부분 BR로 구현
  * Data Access Service (DA)
    * DB와 관련된 기능을 수행하는 Service
    * SQL을 수행
  * Service Access Service (SA)
    * 외부시스템과 연계를 담당하는 Service



**Service 상태**

* C* : 아무 제약 없이 수정 가능
* A : 다른 BR에서 호출가능, 호출되고 있는 경우 Deactivate 불가
* M* : 수정중인 상태, 다른 BR에서 호출시는 수정 전 상태로 호출됨
* S : UI 화면 서비스 가능, BR에서 조회 가능

**Service 소유권**

소유권이 있어야만 수정/삭제가 가능하고, 없을 땐 View/Test만 가능하다.

**DataSet**

BizActor에서 사용하는 데이터 타입으로 DataSet, DataTabe, DataAccess

**Service Parameter**

DataSet 형태로 파라미터 전송됨

**Business Rule Layer Step**

* call
* If
* Switch
* Loop
* Script
* Substitution
* Error
* Group
* Poin



**NCD 1분완성 레시피**

* 포인트 스텝

  * 설계할 때 사용

    <img src="../../md-images/image-20220718154834390.png" alt="image-20220718154834390" style="zoom:50%;" />

* search

  * 목록에 search를 통해 원하는 br이나 DB 컬럼 등 찾을 수 있다.

* Exception 발생 위치

  * Test시 예외가 발생했다면 테스트 메세지 창에서 LOC를 통해 위치를 찾을 수 있다.

* 예외처리하기 Ignore Exception

  * 예외가 생기면 로직은 실패하고 예외를 던지고 롤백된다.
  * 예외가 발생하는 step을 클릭하면 Ignore를 선택할 수 있다.
  * 예외가 발생했을 때, RslNum이 -1이면 에러가 발생하고, 아니면 예외가 발생하지 않도록 if문을 사용하면,
  * 예외가 발생하여도 롤백되지 않고, 사용자가 지정한 메세지를 출력한다.

* Service Access Legacy

  * SA Legacy 연계를 하면 다른 서버에 있는 BizActor의 서비스를 호출할 수 있다.
  * 업무별로 서버를 여러 개 구축했을 때나 Transaction을 분리하고 싶을 때 유용하다.
    1. admin 계정에 들어가서 Legacy System에 연계할 BizActor 서버를 넣어서 만든다
    2. 사용할 서버에서 디자이너 아이디로 접속하고, Service Access에서 추가한다.
    3. 연계할 서버의 호출할 서비스를 입력한다. Service ID는 'EXT.호출할 Service ID', 반드시 S상태여야함
    4. 호출 Service 정보를 참고하여 DataSet을 추가해서 Service 생성

