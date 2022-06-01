package pang.spring.databasepractice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;
import pang.spring.databasepractice.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepository {

    private final DataSource dataSource;

    public static User user(String email, String name, int age) {
        return User.builder()
                .email(email)
                .name(name)
                .age(age)
                .build();
    }

    public List<User> findAllUsers() {
        String sql = "select * from user";// where status = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            //pstmt.setString(1, String.valueOf(Status.JOIN));
            rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(
                        user(
                                rs.getString("email"),
                                rs.getString("name"),
                                rs.getInt("age")
                        ));
            }
            return list;
        } catch (SQLException e) {
            log.error("db error", e);
        } finally {
            close(con, pstmt, rs);
        }
        return list;
    }

    //update 종류는 모두 save()로 통일
    public User save(User user) {
        String sql = "insert into user(email, pw, name, age, point, status) values(?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPw());
            pstmt.setString(3, user.getName());
            pstmt.setInt(4, user.getAge());
            pstmt.setInt(5, 0);
            pstmt.setString(6, user.getStatus().getStatus());
            pstmt.executeUpdate();
            return user;
        } catch (SQLException e) {
            log.error("db error", e);
        } finally {
            close(con, pstmt, null);
        }
        return null;
    }

    public User findByEmail(String email) {
        String sql = "select * from user where email = ? and status = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, "JOIN");
            rs = pstmt.executeQuery();
            User user = null;
            while (rs.next()) {
                user = user(
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
            }
            return user;
        } catch (SQLException e) {
            log.error("db error", e);
        } finally {
            close(con, pstmt, rs);
        }
        return null;
    }

    public void delete(String email) {
        String sql = "delete from user where email=" + email;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("db error", e);
        } finally {
            close(con, pstmt, null);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(pstmt);
        DataSourceUtils.releaseConnection(con, dataSource);
    }
}
