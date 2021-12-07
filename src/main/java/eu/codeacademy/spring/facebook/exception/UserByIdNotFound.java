package eu.codeacademy.spring.facebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserByIdNotFound extends RuntimeException {

    public UserByIdNotFound(String msg){
        super(msg);
    }
}
