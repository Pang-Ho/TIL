package pang.spring.databasepractice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pang.spring.databasepractice.dto.CreateUser;
import pang.spring.databasepractice.dto.UserDto;
import pang.spring.databasepractice.entity.User;
import pang.spring.databasepractice.repository.UserRepository;
import pang.spring.databasepractice.statusCode.Status;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    DataSource dataSource;
    UserRepository userRepository;

    public List<UserDto> users() {
        return userRepository.findAllUsers();
    }

    public CreateUser.Response create(CreateUser.Request request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPw(request.getPw());
        user.setPoint(0);
        user.setStatus(Status.JOIN);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return CreateUser.Response.fromEntity(userRepository.save(user));
    }

    @Transactional
    public void accountPoint(String from, String to, int point) {
        UserDto fromUser = userRepository.findByEmail(from);
        fromUser.setPoint(fromUser.getPoint() - point);
        UserDto toUser = userRepository.findByEmail(to);
        toUser.setPoint(toUser.getPoint() + point);

        userRepository.save(fromUser);
        userRepository.save(toUser);
    }

    public UserDto findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
