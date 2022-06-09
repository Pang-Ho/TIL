package pang.spring.databasepractice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pang.spring.databasepractice.entity.User;

@Getter
@Setter
@Builder
public class UserDto {
    private String email, name;
    private int age, point;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .age(user.getAge())
                .point(user.getPoint())
                .build();
    }
}
