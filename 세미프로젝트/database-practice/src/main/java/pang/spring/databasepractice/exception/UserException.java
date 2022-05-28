package pang.spring.databasepractice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserException extends RuntimeException{
    private UserErrorCode userErrorCode;
    private String message;
}
