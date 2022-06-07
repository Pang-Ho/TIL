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
    public List<UserDto> users() {
        return userService.users();
    }

    @PostMapping("/create_user")
    public CreateUser.Response create_user(
           @Valid @RequestBody CreateUser.Request request
    ) {
        log.info("create : request:{}", request);
        return userService.create(request);
    }

    @GetMapping("/user/{email}")
    public UserDetailDto find_userDetail(
            @PathVariable String email
    ) {
        log.info("find : email:{}", email);
        return userService.getUserDetail(email);
    }

    @PutMapping("/edit_user/{email}")
    public UpdateUser.Response edit_user(
            @Valid @RequestBody UpdateUser.Request request,
            @PathVariable String email
    ) {
        log.info("edit : email:{}, request:{}", email, request);
        return userService.editInfo(email, request);
    }

    @DeleteMapping("/delete_user/{email}")
    public UserDto delete_user(
            @PathVariable String email
    ) {
        log.info("delete : email:{}", email);
        return userService.editStatus(email, Status.JOIN);
    }

    @PutMapping("/recover_user/{email}")
    public UserDto recover_user(
            @PathVariable String email
    ) {
        log.info("recover : email:{}", email);
        return userService.editStatus(email, Status.QUIT);
    }

    @PutMapping("/account_point/{fromEmail}/{toEmail}/{point}")
    public AccountPointResponse account_point(
            @PathVariable String fromEmail,
            @PathVariable String toEmail,
            @PathVariable int point
    ) {
        log.info("account_point : from : {}, to : {}, point : {}", fromEmail, toEmail, point);
        return userService.accountPoint(fromEmail, toEmail, point);
    }
}
