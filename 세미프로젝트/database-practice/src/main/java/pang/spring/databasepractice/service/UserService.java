package pang.spring.databasepractice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pang.spring.databasepractice.dto.CreateUser;
import pang.spring.databasepractice.dto.UserDto;
import pang.spring.databasepractice.entity.User;
import pang.spring.databasepractice.exception.UserErrorCode;
import pang.spring.databasepractice.exception.UserException;
import pang.spring.databasepractice.repository.UserRepository;
import pang.spring.databasepractice.statusCode.Status;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> users() {
        return userRepository.findAllUsers()
                .stream().map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    public CreateUser.Response create(CreateUser.Request request) {
        if (findByEmail(request.getEmail()) != null) {
            throw new UserException(UserErrorCode.DUPLICATED_USER_EMAIL);
        }

        User user = User.builder()
                .email(request.getEmail())
                .pw(request.getPw())
                .name(request.getName())
                .age(request.getAge())
                .point(request.getPoint())
                .status(Status.JOIN)
                .build();
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
        User byEmail = userRepository.findByEmail(email);
        if (byEmail == null) throw new UserException(UserErrorCode.NO_USER);
        return UserDto.fromEntity(byEmail);
    }
}
