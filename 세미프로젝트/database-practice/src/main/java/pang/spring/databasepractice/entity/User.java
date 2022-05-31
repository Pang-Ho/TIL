package pang.spring.databasepractice.entity;

import lombok.*;
import pang.spring.databasepractice.statusCode.Status;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    //db에 저장하는 데이터
    private Long id;
    private String email, pw, name;
    private int age, point;
    private Status status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
