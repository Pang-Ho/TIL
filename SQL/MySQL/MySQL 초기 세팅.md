# MySQL 초기세팅



* MySQL 서버 실행

  ~~~bash
  mysql.server start
  ~~~

* root 계정 로그인

  ~~~bash
  mysql -u root -p
  ~~~

  패스워드 입력하면 root 계정으로 접속된다.

* 시스템 데이터베이스 조회

  ~~~
  show databses;
  ~~~

  결과중에 mysql 데이터베이스를 볼 수 있다.

  ~~~
  use mysql;
  ~~~

  mysql 데이터베이스가 사용상태로 바뀌게 된다.

  ~~~
  show tables;
  ~~~

  테이블 조회를 통해 시스템 데이터베이스의 테이블을 확인할 수 있는데, user 테이블을 이용할 것이다.

  ~~~
  select host, user from user
  ~~~

  위 명령어를 통해 mysql에 등록된 사용자 계정정보를 조회할 수 있다.

* 새로운 사용자 계정 생성

  ~~~sql
  create user '사용자 계정'@'localhost' identified by '비밀번호';
  ~~~

  사용자 계정을 생성시킬 수 있고, mysql 데이터베이스의 user 테이블을 확인해보면 계정이 생성된 것을 확인할 수 있다.

* 데이터베이스 생성

  ~~~sql
  create database 생성할DB명 default character set utf8;
  ~~~

* 생성한 계정에 권한부여

  ~~~sql
  grant all privileges on 생성한DB명.* to '사용자'@'localhost';
  ~~~

  all privileges : 데이터베이스의 모든 권한

  .* : 지정한 DB에 모든 DB에 관한 권한

  이렇게 되면 생성한 계정에 생성한 DB를 이용할 권한을 모두 부여한 것이다.

* 생성한 계정 로그인 및 DB 조회

  ~~~
  mysql -u 사용자 -p
  ~~~

  