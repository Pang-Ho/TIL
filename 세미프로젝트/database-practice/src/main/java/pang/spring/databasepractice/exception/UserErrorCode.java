package pang.spring.databasepractice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserErrorCode {
    NO_USER("해당되는 유저가 없습니다."),
    DUPLICATED_USER_EMAIL("Email이 중복되는 유저가 있습니다."),
    LACKED_POINT("포인트가 부족합니다."),

    INTERNAL_SERVER_ERROR("서버 내부에 오류가 발생했습니다."),
    INVALID_REQUEST("잘못된 요청입니다.");

    private final String message;
}
