package eu.codeacademy.spring.facebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchPostById extends RuntimeException {

    public NoSuchPostById(String msg){
        super(msg);
    }
}
