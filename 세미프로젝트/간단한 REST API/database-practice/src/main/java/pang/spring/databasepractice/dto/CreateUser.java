package pang.spring.databasepractice.dto;


import lombok.*;
import pang.spring.databasepractice.entity.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class CreateUser {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {

        @NotNull(message = "이메일은 필수로 입력해주세요.")
        @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z]+.[A-Za-z]+$")
        private String email;

        @NotNull(message = "비밀번호는 필수로 입력해주세요.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,20}$",
                message = "비밀번호는 최소 8~20자 영문 숫자 및 특수문자를 조합해주세요.")
        private String pw;

        @NotNull(message = "이름은 필수로 입력해주세요.")
        @Pattern(regexp = "^[A-Za-z가-힣]*$", message = "영문, 한글만 입력해주세요.")
        private String name;

        @NotNull(message = "나이는 필수로 입력해주세요.")
        private int age;

        private int point;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class Response {
        private String email, name;
        private int age, point;

        public static Response fromEntity(User user) {
            return Response.builder()
                    .email(user.getEmail())
                    .name(user.getName())
                    .age(user.getAge())
                    .point(user.getPoint())
                    .build();
        }
    }
}
