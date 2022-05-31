package pang.spring.databasepractice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pang.spring.databasepractice.dto.CreateUser;
import pang.spring.databasepractice.dto.UserDto;
import pang.spring.databasepractice.entity.User;
import pang.spring.databasepractice.repository.UserRepository;
import pang.spring.databasepractice.statusCode.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> users() {
        return userRepository.findAllUsers().stream().map(UserDto::fromEntity).collect(Collectors.toList());
    }

    public CreateUser.Response create(CreateUser.Request request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPw(request.getPw());
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setPoint(request.getPoint());
        user.setStatus(Status.JOIN);
        user.setCreated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());
        return CreateUser.Response.fromEntity(userRepository.save(user));
    }

    @Transactional
    public void accountPoint(String from, String to, int point) {
        User fromUser = userRepository.findByEmail(from);
        fromUser.setPoint(fromUser.getPoint() - point);
        User toUser = userRepository.findByEmail(to);
        toUser.setPoint(toUser.getPoint() + point);

        userRepository.save(fromUser);
        userRepository.save(toUser);
    }

    public UserDto findByEmail(String email) {
        return UserDto.fromEntity(userRepository.findByEmail(email));
    }
}
