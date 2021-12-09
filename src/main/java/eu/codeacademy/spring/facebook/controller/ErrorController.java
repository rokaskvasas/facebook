package eu.codeacademy.spring.facebook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice
public class ErrorController {


    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Throwable throwable, final Model model) {
        log.info("Exception during execution of SpringSecurity application", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String badSearchParams(MissingServletRequestParameterException exception, Model model) {
        log.info("Exception when changing search by username params: {}", exception.getMessage());
        String errorMessage = "Don't mess with PARAMS!";
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noPage(NoHandlerFoundException exception, Model model) {
        log.info("Exception when changing search by username params: {} ", exception.getMessage());
        String errorMessage = exception.getMessage();
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String accessDenied(AccessDeniedException e, Model model) {
        log.info("Access: {}", e.getMessage());
        String errorMessage = e.getMessage();
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
}