package pang.spring.databasepractice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pang.spring.databasepractice.statusCode.Status;

import java.time.LocalDateTime;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class User {
    //db에 저장하는 데이터
    private Long id;
    private String email, pw, name;
    private int age, point;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
