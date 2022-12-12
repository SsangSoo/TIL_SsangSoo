package todo.app.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    // 예외의 경우.

    // post시
    // 1. title 중복.
    // 2. todoOrder 중복

    // patch시
    // 1. complete가 중복일 때,
    // 2. title이 null일 때,
    // 3. todoOrder가 null일 때,

    // 4. 조회, 수정, 삭제할 데이터가 존재하지 않을 때.

}
