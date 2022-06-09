package pang.spring.databasepractice.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pang.spring.databasepractice.dto.UserDto;
import pang.spring.databasepractice.repository.UserRepository;

import java.util.List;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void users() {
        List<UserDto> list = userService.users();
        Assertions.assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void create() {
    }
}