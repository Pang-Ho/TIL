package pang.spring.databasepractice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pang.spring.databasepractice.dto.CreateUser;
import pang.spring.databasepractice.dto.UserDto;
import pang.spring.databasepractice.repository.UserRepository;
import pang.spring.databasepractice.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> users() {
        return userService.users();
    }

    @PostMapping("/create_user")
    public void create_user(
            @RequestBody CreateUser.Request request
    ) {
        userService.create(request);
    }

    @GetMapping("/user/{email}")
    public UserDto find_user(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
