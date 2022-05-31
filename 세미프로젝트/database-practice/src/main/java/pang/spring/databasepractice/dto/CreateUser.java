package pang.spring.databasepractice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
