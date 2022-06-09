package pang.spring.databasepractice.dto;


import lombok.*;
import pang.spring.databasepractice.entity.User;

@Builder
@Getter
@Setter
public class AccountPointResponse {
    private String fromEmail, toEmail;
    private int emptyPoint;
}
