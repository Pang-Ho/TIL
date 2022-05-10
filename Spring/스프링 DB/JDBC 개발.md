# JDBC 개발

DB를 사용할 때 3가지 방법을 얘기했었다.

1. JDBC 직접 사용
2. SQL Mapper (JDBC Template, MyBatis)
3. ORM 기술

여기서는 JDBC를 직접 사용하는 애플리케이션을 개발할 것이다.



Member.class

~~~java
@Data
public class Member {

    private String memberId;
    private int money;

    public Member() {
    }

    public Member(String memberId, int money) {
        this.memberId = memberId;
        this.money = money;
    }
}
~~~

member 테이블에 데이터를 저장하고 조회할 때 사용하는 객체 클래스이다.



MemberRepositoryVO

~~~java
@Slf4j
public class MemberRepositoryVO {

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values (?, ?)"; //sql

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            con = getConnection(); //getConnection()
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());
          	pstmt.executeUpdate();
            return member;

        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }

    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if (stmt != null) {
            try {
                stmt.close(); //pstmt와 stmt
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
~~~

* 커넥션 획득

  * getConnection() : 이전에 만들어둔 DBConnectionUtil을 통해서 데이터베이스 커넥션을 획득한다.
    

* save() - SQL 전달

  * sql : 데이터베이스에 전달할 SQL을 정의한다.
  * con.prepareStatement(sql) : 데이터베이스에 전달할 SQL과 파라미터로 전달할 데이터들을 준비한다.
    * sql : sql 정의
    * pstmt.setString(1, member.getMemberId()) : SQL 첫 번째 ?에 값을 지정한다.
    * pstmt.setInt(2, member.getMoney()) : SQL 두 번째 ?에 값을 지정한다.
    * pstmt.executeUpdate() : Statemenet를 통해 준비된 SQL을 커넥션을 통해 실제 데이터베이스에 전달한다.

  

* 리소스 정리

  * 쿼리를 실행하고 나면 리소스를 정리해야한다. 예외가 발생하든 하지 않든 항상 수행되어야 하므로 finally구문에서 작성해야한다.

    * 이 부분을 놓치게 되면 커넥션이 끊어지지 않고 계속 유지되는 문제가 생긴다. 이 것을 리소스 누수라고 하고, 결과적으로 커넥션 부족으로 장애가 발생할 수 있다.

  * Connection, PreparedStatement를 사용했기 때문에 close()를 통해 닫아주어야 한다. 정리 순서는 역순이다.

    

* 참고

  * PreparedStatement는 Statement의 자식 타입인데, ? 를 통한 파라미터 바인딩을 가능하게 해준다.
  * SQL Injection 공격을 예방하려면 PreparedStatement를 통한 파라미터 바인딩 방식을 사용해야한다.