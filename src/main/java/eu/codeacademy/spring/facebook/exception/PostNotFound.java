package eu.codeacademy.spring.facebook.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostNotFound extends RuntimeException {

    public PostNotFound(String msg){
        super(msg);
    }
}
