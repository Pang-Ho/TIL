package pang.spring.databasepractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pang.spring.databasepractice.entity.User;

@Getter
@Setter
public class UserDto {
    private String email, name;
    private int age, point;

    public static UserDto fromEntity(User user) {
        UserDto userDto = new UserDto();
        userDto.email = user.getEmail();
        userDto.name = user.getName();
        userDto.age = user.getAge();
        userDto.point = user.getPoint();
        return userDto;
    }
}
