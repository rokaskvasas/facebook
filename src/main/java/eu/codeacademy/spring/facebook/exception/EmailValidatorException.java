package eu.codeacademy.spring.facebook.exception;


public class EmailValidatorException extends RuntimeException{
    public EmailValidatorException(String msg){
        super(msg);
    }
}
