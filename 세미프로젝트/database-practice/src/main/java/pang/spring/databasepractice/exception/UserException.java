package pang.spring.databasepractice.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException {
    private UserErrorCode userErrorCode;
    private String message;

    public UserException(UserErrorCode errorCode) {
        super(errorCode.getMessage());
        this.userErrorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
