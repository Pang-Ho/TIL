package pang.spring.databasepractice.dto;


import lombok.*;

public class AccountPoint {

    @Builder
    @Getter
    @Setter
    public static class Request {
        private String toEmail;
        private int point;
    }

    @Builder
    @Getter
    @Setter
    public static class Response {
        private String fromEmail, toEmail;
        private int emptyPoint;

        public static Response fromEntity(String fromEmail, String toEmail, int emptyPoint) {
            return Response.builder()
                    .fromEmail(fromEmail)
                    .toEmail(toEmail)
                    .emptyPoint(emptyPoint)
                    .build();
        }
    }
}
