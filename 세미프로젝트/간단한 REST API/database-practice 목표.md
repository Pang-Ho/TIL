# 이번 세미프로젝트 목표

## DB

~~~sql
create table user (
 id int not null auto_increment,
 email varchar(20) not null,
 pw varchar(20) not null,
 name varchar(20),
 age int not null,
 point int not null,
 status varchar(20) not null,
 created_at timestamp not null default current_timestamp,
 updated_at timestamp not null default current_timestamp on update current_timestamp,

 primary key(id),
 unique key uk_email(email)
);
~~~

## 리포지토리

1. 데이터베이스 연결
2. `DataSource`를 스프링 컨테이너에서 빈으로 가져와서 커넥션 획득 방법 작성
3. 커넥션을 획득하고 사용한 후 커넥션 풀에 커넥션 반환을 하는 방법 작성
4. `JDBC`를 기초로 하는 CRUD sql 리포지토리 코드 작성

## 서비스

1. 리포지토리를 빈으로 가져와서 필요한 기능 만들기(필요한 경우 트랜잭션 적용)
   1. 유저 1명 조회
   2. 전체 유저 조회
   3. 유저 생성
   4. 유저 정보 변경
   5. 유저 탈퇴 (유저 탈퇴시 회원을 지우는 게 아닌 `status` 컬럼으로 가입 상태와 탈퇴 상태를 표기해서 분리)
   6. 탈퇴한 유저 복구 (`status`를 탈퇴 상태에서 가입 상태로 변경)
   7. 유저끼리 포인트 전송
2. 그 사이에 필요한 개발자가 만든 런타임 예외를 작성하여 예외 보내기
   1. 이메일이 중복되면 `DUPLICATED_USER_EMAIL` 예외 보내기
   2. 조회하려는 아이디가 없다면 `NO_USER` 예외 보내기
   3. 포인트 전송시 포인트가 부족하다면 `LACKED_POINT` 예외 보내기

## 컨트롤러

1. Get 메서드 - 조회
2. Post 메서드 - 생성
3. Put 메서드 - 수정
4. Delete 메서드 - 삭제(분리 보관)
5. `Entity`와 `DTO`를 사용하면서 왜 분리하는지 생각하고 설계
6. `@RequestBody`로 `http request` 내용을 받아서 사용하기
7. `@PathVariable`로 `URL`에 있는 파라미터 사용하기
8. `@Valid` 적용하고, `DTO`에 `@Pattern`과 `@NotNull`등 유효성 검사 적용하기

## DTO

1. `Entity`와 `DTO`의 차이
2. `@Valid`를 위해 유효성 검사 적용

## HTTP

1. 테스트를 위한 HTTP 요청 작성

   * CRUD, 탈퇴유저 복구, 포인트 전송 / HTTP 요청

   ~~~http
   POST http://localhost:8080/create_user
   Content-Type: application/json
   
   {
     "email" : "test4",
     "pw" : "password1@",
     "name" : "test",
     "age" : 25,
     "point" : 1000
   }
   ~~~

   