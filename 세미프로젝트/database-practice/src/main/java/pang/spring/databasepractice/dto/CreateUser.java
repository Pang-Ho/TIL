package pang.spring.databasepractice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pang.spring.databasepractice.entity.User;
import pang.spring.databasepractice.statusCode.Status;

import java.time.LocalDateTime;


public class CreateUser {
    //@Valid 적용하는 dto
    @Getter
    @Setter
    public class Request {
        private Long id;
        private String email, pw, name;
        private int age, point;
        private Status status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Getter
    @Setter
    public static class Response {
        private String email, name;
        private int age, point;

        public static Response fromEntity(User user) {
            Response response = new Response();
            response.setEmail(user.getEmail());
            response.setAge(user.getAge());
            response.setName(user.getName());
            response.setPoint(user.getPoint());
            return response;
        }
    }
}
