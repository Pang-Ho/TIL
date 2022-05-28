package pang.spring.databasepractice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pang.spring.databasepractice.dto.UserDto;
import pang.spring.databasepractice.entity.User;
import pang.spring.databasepractice.repository.UserRepository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    DataSource dataSource;
    UserRepository userRepository;

    public List<UserDto> users() throws SQLException {
        return userRepository.findAllUsers();
    }

    public void create(User user) {

    }

    @Transactional
    public void accountPoint(String from, String to, int point) throws SQLException {
        User fromUser = userRepository.findByEmail(from);
        User toUser = userRepository.findByEmail(to);
        userRepository.updatePoint(fromUser, fromUser.getPoint() - point);
        userRepository.updatePoint(toUser, toUser.getPoint() + point);
    }
}
