package pang.spring.databasepractice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String email, name;
    private int age, point;
}
