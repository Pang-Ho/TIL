package pang.spring.databasepractice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pang.spring.databasepractice.dto.UserErrorResponse;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class UserExceptionHandler {

    @ExceptionHandler(UserException.class)
    public UserErrorResponse handleExceptions(UserException e, HttpServletRequest request) {
        log.info("errorCode: {}, url:{}, message:{}",
                e.getUserErrorCode(), request.getRequestURI(), e.getMessage());
        return new UserErrorResponse(e.getUserErrorCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public UserErrorResponse handleExceptions(Exception e, HttpServletRequest request) {

    }
}
