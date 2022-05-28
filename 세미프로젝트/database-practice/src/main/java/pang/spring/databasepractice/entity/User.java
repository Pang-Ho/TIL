package pang.spring.databasepractice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pang.spring.databasepractice.statusCode.Status;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class User {

    private Long id;
    private String email, pw, name;
    private int age, point;
    private Status status;
}
