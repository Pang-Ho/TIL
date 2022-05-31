package pang.spring.databasepractice.dto;


import lombok.*;
import pang.spring.databasepractice.entity.User;


public class CreateUser {
    //@Valid 적용하는 dto
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private String email, pw, name;
        private int age, point;
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
