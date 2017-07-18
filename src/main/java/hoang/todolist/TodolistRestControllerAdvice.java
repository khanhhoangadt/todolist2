package hoang.todolist;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class TodolistRestControllerAdvice {
	
    @ResponseBody
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    VndErrors illegalArgumentExceptionHandler(Exception e) { // 2
        return new VndErrors("error", e.getMessage()); // 3
    }
}
