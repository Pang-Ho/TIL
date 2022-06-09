package pang.spring.databasepractice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pang.spring.databasepractice.dto.*;
import pang.spring.databasepractice.entity.User;
import pang.spring.databasepractice.exception.UserErrorCode;
import pang.spring.databasepractice.exception.UserException;
import pang.spring.databasepractice.repository.UserRepository;
import pang.spring.databasepractice.statusCode.Status;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserDetailDto getUserDetail(String email) {
        User byEmail = userRepository.findByEmail(email);
        userException(byEmail == null, UserErrorCode.NO_USER);
        return UserDetailDto.fromEntity(byEmail);
    }

    public List<UserDto> users() {
        return userRepository.findAllUsers()
                .stream().map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public CreateUser.Response create(CreateUser.Request request) {
        userException(
                userRepository.findByEmailAndStatus(request.getEmail(), Status.JOIN) != null,
                UserErrorCode.DUPLICATED_USER_EMAIL
        );

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
    public UpdateUser.Response editInfo(String email, UpdateUser.Request request) {
        User byEmail = userRepository.findByEmailAndStatus(email, Status.JOIN);
        userException(byEmail == null, UserErrorCode.NO_USER);
        byEmail.setPw(request.getPw());
        byEmail.setName(request.getName());
        byEmail.setAge(request.getAge());
        log.info("email:{}", byEmail.getEmail());
        return UpdateUser.Response.fromEntity(userRepository.update(byEmail));
    }

    @Transactional
    public UserDto editStatus(String email, Status status) {
        User byEmail = userRepository.findByEmailAndStatus(email, status);
        userException(byEmail == null, UserErrorCode.NO_USER);
        if (status == Status.JOIN) byEmail.setStatus(Status.QUIT);
        else byEmail.setStatus(Status.JOIN);
        return UserDto.fromEntity(userRepository.updateStatus(byEmail));
    }

    @Transactional
    public AccountPointResponse accountPoint(String from, String to, int point) {

        User fromUser = userRepository.findByEmailAndStatus(from, Status.JOIN);
        userException(fromUser == null, UserErrorCode.NO_USER);
        if (fromUser.getPoint() < point) throw new UserException(UserErrorCode.LACKED_POINT);

        fromUser.setPoint(fromUser.getPoint() - point);
        User toUser = userRepository.findByEmailAndStatus(to, Status.JOIN);
        userException(toUser == null, UserErrorCode.NO_USER);
        toUser.setPoint(toUser.getPoint() + point);

        fromUser = userRepository.updatePoint(fromUser);
        userRepository.updatePoint(toUser);

        return AccountPointResponse.builder()
                .fromEmail(from)
                .toEmail(to)
                .emptyPoint(fromUser.getPoint())
                .build();
    }

    private void userException(boolean isTure, UserErrorCode errorCode) {
        if (isTure) {
            throw new UserException(errorCode);
        }
    }

}
