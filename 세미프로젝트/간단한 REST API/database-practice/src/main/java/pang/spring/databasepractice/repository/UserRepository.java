package pang.spring.databasepractice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;
import pang.spring.databasepractice.entity.User;
import pang.spring.databasepractice.statusCode.Status;

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

    public static User user(String email, String name, int age, int point) {
        return User.builder()
                .email(email)
                .name(name)
                .age(age)
                .point(point)
                .build();
    }

    public List<User> findAllUsers() {
        String sql = "select * from user where status = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Status.JOIN.getStatus());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(
                        user(
                                rs.getString("email"),
                                rs.getString("name"),
                                rs.getInt("age"),
                                rs.getInt("point")
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
            pstmt.setInt(5, user.getPoint());
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

    public User update(User user) {
        String sql = "update user set pw = ?, name = ?, age = ? where email = ?";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getPw());
            pstmt.setString(2, user.getName());
            pstmt.setInt(3, user.getAge());
            pstmt.setString(4, user.getEmail());
            pstmt.executeUpdate();
            return user;
        } catch (SQLException e) {
            log.error("db error", e);
        } finally {
            close(con, pstmt, null);
        }
        return null;
    }

    public User updatePoint(User user) {
        String sql = "update user set point = ? where email = ?";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user.getPoint());
            pstmt.setString(2, user.getEmail());
            pstmt.executeUpdate();
            return user;
        } catch (SQLException e) {
            log.error("db error", e);
        } finally {
            close(con, pstmt, null);
        }
        return null;
    }

    public User updateStatus(User user) {
        String sql = "update user set status = ? where email = ?";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getStatus().getStatus());
            pstmt.setString(2, user.getEmail());
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
        String sql = "select * from user where email = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            User user = null;
            while (rs.next()) {
                user = User.builder()
                        .email(email)
                        .name(rs.getString("name"))
                        .age(rs.getInt("age"))
                        .point(rs.getInt("point"))
                        .status(rs.getString("status").equals(Status.JOIN.getStatus()) ?
                                Status.JOIN : Status.QUIT)
                        .build();
            }
            return user;
        } catch (SQLException e) {
            log.error("db error", e);
        } finally {
            close(con, pstmt, rs);
        }
        return null;
    }

    public User findByEmailAndStatus(String email, Status status) {
        String sql = "select * from user where email = ? and status = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, status.getStatus());
            rs = pstmt.executeQuery();
            User user = null;
            while (rs.next()) {
                user = user(
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getInt("point")
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

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(pstmt);
        DataSourceUtils.releaseConnection(con, dataSource);
    }
}
