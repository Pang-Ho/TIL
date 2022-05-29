package pang.spring.databasepractice.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;
import pang.spring.databasepractice.dto.CreateUser;
import pang.spring.databasepractice.dto.UserDto;
import pang.spring.databasepractice.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class UserRepository {

    DataSource dataSource;

    public List<UserDto> findAllUsers() {
        String sql = "select * from user where status = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<UserDto> list = new ArrayList<>();

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "JOIN");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                UserDto user = new UserDto();
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                list.add(user);
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
    public UserDto save(CreateUser user) {
        String sql = "insert into user(email, pw, name, age, point, status) value(?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.get());
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
        return user;
    }

/*    public void quit(String id) {
        String sql = "update user set status=? where id=" + id;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "QUIT");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("db error", e);
        } finally {
            close(con, pstmt, null);
        }
    }*/

    /*

        public void save(User user) throws SQLException {
            String sql = "update user set email=?, pw=?, name=?, age=? where id=" + user.getId();
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = getConnection();
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, user.getEmail());
                pstmt.setString(2, user.getPw());
                pstmt.setString(3, user.getName());
                pstmt.setInt(4, user.getAge());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                log.error("db error", e);
                throw e;
            } finally {
                close(con, pstmt, null);
            }
        }

        public void updatePoint(User user, int point) throws SQLException {
            String sql = "update user set point=? where id=" + user.getId();
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = getConnection();
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, point);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                log.error("db error", e);
                throw e;
            } finally {
                close(con, pstmt, null);
            }
        }
    */

    public UserDto findByEmail(String email) {
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
            UserDto user = new UserDto();
            while (rs.next()) {
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
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
