# DB 규모를 키우거나 스키마를 변경하는 경우

BIGINT - 8bytes 정수 => 0 ~ $2^{64}$ -1
INT - 4bytes 정수 => 0 ~ $2^{32} -1$

* int형이 bigint보다 10% 이상의 디스크 용량을 절약할 수 있다고 한다. 수십억개의 데이터를 가지지 않을 것이라면 속도 등 효율성의 측면에서 int형이 좋다.
* 그러나 db 양이 작다면 어느것을 사용해도 속도나 디스크 용량에 큰 영향을 치지 않을 것이다.
* 만약 DB 규모가 큰 어플리케이션을 개발한다면 서버 운영 효율이 좀 낮아지더라고 bigint형으로 설정하는 것이 유리할 수 있다. db의 양이 int를 초과할 때 업그레이드 하는 것이 간단한 문제가 아니다.

## DB규모를 키우려고 할 때

테이블에서 스키마를 변경시켜야 하는 경우 사용되는 방법이다.

데이터가 100만, 1000만 정도인 경우는 몇 분안에 끝나지만, 1억건이 넘어가면 몇 시간동안 진행이 된다.

* 밑은 테이블의 데이터 형을 변경하는 명령이지만, 다른 테이블에서 외래키로 참조하고 있다면, 에러가 발생한다.

  ~~~sql
  ALTER TABLE MEMBER_TB MODIFY member_id BIGINT unsigned not null auto_increment;
  ~~~

* 외래키를 DROP하고 다시 외래키를 붙이는 작업을 한다.

  ~~~sql
  ALTER TABLE '외래키 적용 테이블' MODIFY DROP FOREIGN KEY '제약조건이름';
  ~~~

* 그 후 int에서 bigint로 바꾸는 작업을 한다.

  ~~~sql
  ALTER TABLE MEMBER_TB MODIFY member_id BIGINT unsigned not null auto_increment;
  ~~~

  데이터가 43억개라면 수 시간동안 서비스 중단이 불가피하다.

* 참조 테이블에 외래키를 다시 붙이는 작업을 한다.

  * 참조 테이블의 member_id가 기존에 int였기 때문에 bigint로 변경한다.

  ~~~sql
  ALTER TABLE '외래키 적용 테이블' MODIFY member_id BIGINT unsigned not null auto_increment;
  ~~~

  이 또한... 수 시간동안...

  * 외래키를 설정할 컬럼이 bigint로 바뀌었다면 외래키로 다시 설정한다.

  ~~~sql
  ALTER TABLE '외래키 적용 테이블' MODIFY ADD CONSTRAINT '제약조건이름' FOREIGN KEY (member_id) REFERENCES MEMBER_TB(member_id);
  ~~~



**ALTER TABLE이 아닌 카피 테이블을 이용하는 방법**

위 ALTER TABLE로만 진행한다면 수십시간이 걸리는 방법이지만, 카피 테이블을 이용한다면 몇 십분으로 줄어들 수 있다.

전체적인 과정 : 테이블 카피 => 카피된 테이블에 원본 테이블 데이터 복사 => 테이블 이름 변경

* 테이블을 카피하는 경우 FK 제약조건이 있을 경우엔 테이블을 카피할 수 없다.

* 그러므로 FK 제약조건 삭제

  ~~~sql
  ALTER TABLE MEMBER_TB MODIFY DROP FOREIGN KEY '제약조건이름'
  ~~~

* 카피 테이블 생성

  ~~~sql
  CREATE TABLE ORDER_TB_COPY (
  	order_id int not null auto_increment,
    member_id varchar(20) not null,
    product_id int not null,
    PRIMARY KEY (order_id),
    KEY FK_MEMBER_ID (member_id),
    KEY FK_PRODUCT_ID (product_id),
    CONSTRAINT FK_MEMBER_ID FOREIGN KEY (member_id) REFERENCES MEMBER_TB(member_id) ON UPDATE CASCADE,
    CONSTRAINT FK_PRODUCT_ID FOREIGN KEY (product_id) REFERENCES PRODUCT_TB(product_id) ON UPDATE CASCADE
  );
  ~~~

* 새로 생성된 카피 테이블에 기존 테이블 데이터를 복사

  ~~~sql
  INSERT INTO ORDER_TB_COPY (order_id, member_id, product_id)
  SELECT order_id, member_id, product_id from ORDER_TB;
  ~~~

  이 때 원본 테이블 상태에 따라 FK 제약조건이 발생할 수 있다.

  예를들어 ORDER_TB 테이블이 갖고있는 FK 컬럼인 member_id가 MEMBER_TB에 없는 값이라 복사가 안되는 등의 문제가 생길 수 있다. 이럴 때 복사하는 동안 제약조건 체크를 OFF 하고, 복사가 끝난 후 다시 ON 하는 것이 좋다.

* 제약조건 OFF

  ~~~sql
  SET FOREIGN_KEY_CHECKS=0
  ~~~

* 제약조건 ON

  ~~~sql
  SET FOREIGN_KEY_CHECKS=1
  ~~~

* 기존 테이블 명을 다른 이름으로 변경하고 카피 테이블 명을 원본 테이블 명으로 변경한다.

  ~~~sql 
  RENAME TABLE 'ORDER_TB' TO 'ORDER_TB_20220623'
  ~~~

  ~~~sql
  RENAME TABLE 'ORDER_TB_COPY' TO 'ORDER_TB'
  ~~~

  