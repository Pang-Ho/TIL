package pang.spring.databasepractice.dto;

import lombok.*;
import pang.spring.databasepractice.entity.User;
import pang.spring.databasepractice.statusCode.Status;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdateUser {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        @NotNull(message = "비밀번호는 필수로 입력해주세요.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,20}$",
                message = "비밀번호는 최소 8~20자 영문 숫자 및 특수문자를 조합해주세요.")
        private String pw;

        @NotNull(message = "이름은 필수로 입력해주세요.")
        @Pattern(regexp = "^[A-Za-z가-힣]$")
        private String name;

        @NotNull(message = "나이는 필수로 입력해주세요.")
        private int age;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class Response {
        private String email, name;
        private int age;

        public static UpdateUser.Response fromEntity(User user) {
            return UpdateUser.Response.builder()
                    .email(user.getEmail())
                    .name(user.getName())
                    .age(user.getAge())
                    .build();
        }
    }
}
