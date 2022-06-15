package pang.spring.databasepractice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pang.spring.databasepractice.dto.*;
import pang.spring.databasepractice.service.UserService;
import pang.spring.databasepractice.statusCode.Status;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> find_users() {
        return userService.users();
    }

    @GetMapping("/users/{email}")
    public UserDetailDto find_userDetail(
            @PathVariable String email
    ) {
        log.info("find : email:{}", email);
        return userService.getUserDetail(email);
    }

    @PostMapping("/users")
    public CreateUser.Response create_user(
           @Valid @RequestBody CreateUser.Request request
    ) {
        log.info("create : request:{}", request);
        return userService.create(request);
    }

    @PutMapping("/users/{email}")
    public UpdateUser.Response edit_user(
            @Valid @RequestBody UpdateUser.Request request,
            @PathVariable String email
    ) {
        log.info("edit : email:{}, request:{}", email, request);
        return userService.editInfo(email, request);
    }

    @DeleteMapping("/users/{email}")
    public UserDto delete_user(
            @PathVariable String email
    ) {
        log.info("delete : email:{}", email);
        return userService.editStatus(email, Status.JOIN);
    }

    @PutMapping("/users/{email}/recover")
    public UserDto recover_user(
            @PathVariable String email
    ) {
        log.info("recover : email:{}", email);
        return userService.editStatus(email, Status.QUIT);
    }

    @PostMapping("/users/{email}/account-point")
    public AccountPoint.Response account_point(
            @PathVariable String email,
            @RequestBody AccountPoint.Request request
    ) {
        log.info("account-point : from : {}, to : {}, point : {}", email, request.getToEmail(), request.getPoint());
        return userService.accountPoint(email, request);
    }
}
