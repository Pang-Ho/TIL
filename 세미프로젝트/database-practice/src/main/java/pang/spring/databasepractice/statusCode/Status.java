package pang.spring.databasepractice.statusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum Status {

    JOIN("가입"),
    QUIT("탈퇴");

    private final String status;
}
