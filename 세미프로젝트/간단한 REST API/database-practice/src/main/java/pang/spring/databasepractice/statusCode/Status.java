package pang.spring.databasepractice.statusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum Status {

    JOIN("join"),
    QUIT("quit");

    private final String status;
}
