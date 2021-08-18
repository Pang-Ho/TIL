# DAY5 JAVA+SQL

* interface Prepared Statement extends Statement

  => 상속 그대로 포함 / 오버라이딩 / 추가 메소드

* int <= executeUpdate("")

  ResultSet <= executeQuery("")

## Statement

```java
Statement st = con.createStatement();
ResultSet rs = st.executeQuery
("select id from emp where id=100")
rs.next()
rs.getxxx("id")

...

rs= st.executeQuery
("select id from emp where id=200")
rs.nex()
rs.getxxx("id")
```

* db sql 전송 받아서 실행 단계

1. 구문 문법 분석 = parsing
2. 컴파일(텍스트 > 이진코드 변환)
3. 실행 결과 리턴
4. ...
5. ~~구문 문법 분석 = parsing~~ 
6. ~~컴파일(텍스트 > 이진코드 변환)~~
7. 실행 결과 리턴

| Statement st = | PreparedStatement pt = con.prepareStatement<br />("select id from emp where id = ?")<br /> |
| -------------- | ------------------------------------------------------------ |
|                | db sql 전송 받아서 실행 단계<br />1. 구문 문법 분석<br />2. 컴파일<br />3. 저장 대기<br />4. 100 - 실행<br />5. 200 - 실행 |

## PreparedStatement

* Statement와 달리 sql 문장을 대사용 가능

```java
PreparedStatement pt = con.prepareStatement;
("select id from emp where id = ?"); // 구문 문법 분석

pt.setInt(1, 100);  // ? = 100;
ResultSet rs = pt.executeQuery(); //100 - 실행
rs.next();
rs.getxxx("id");

...
    
pt.setInt(1, 100);  // ? = 100;
ResultSet rs = pt.executeQuery(); 
rs.next();
rs.getxxx("id");
```



java.sql.Connection 객체를 생성하잖아?

1. jdbc 프로그램에서 dml들 자동으로 commit 상태로 만듦

   run sql command line => dml들 commit? rollback?? 입력을 해야함

생기는 일

1. run에서 update 한다면
2. 자바 update하면 대기중
3. run에서 commit/rollback 함
4. 자바에서 자동 commit해서 실행됨

con.setAutoCommit(true); => 자동 commit상태

con.setAutoCommit(false); => 수동 commit상태 => con.commit(); / con.rollback();

```java
st.executeIpdate("sql");
con.commit() / con.rollback
```



이클립스 data explorer => sql 작성 => 실행 => 결과 조회(run sql 대신 툴)

