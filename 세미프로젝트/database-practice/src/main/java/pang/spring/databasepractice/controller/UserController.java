package pang.spring.databasepractice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping
    public void create_user() {

    }

    @GetMapping
    public UserDto find_user() {

    }
}
