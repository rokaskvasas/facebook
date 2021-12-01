package eu.codeacademy.spring.facebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundUserById extends RuntimeException {

    public NotFoundUserById(String msg){
        super(msg);
    }
}
