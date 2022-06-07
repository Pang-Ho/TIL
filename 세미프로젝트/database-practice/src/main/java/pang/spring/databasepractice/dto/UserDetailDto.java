package pang.spring.databasepractice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pang.spring.databasepractice.entity.User;
import pang.spring.databasepractice.statusCode.Status;

@Getter
@Setter
@Builder
public class UserDetailDto {
    private String email, name;
    private int age, point;
    private Status status;

    public static UserDetailDto fromEntity(User user) {
        return UserDetailDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .age(user.getAge())
                .point(user.getPoint())
                .status(user.getStatus())
                .build();
    }
}
