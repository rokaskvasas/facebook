package eu.codeacademy.spring.facebook.validation.validators;

import eu.codeacademy.spring.facebook.repository.UserEntityRepository;
import eu.codeacademy.spring.facebook.validation.ValidUsername;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {

    private ValidUsername validUsername;


    private final UserEntityRepository userEntityRepository;

    @Override
    public void initialize(ValidUsername constraintAnnotation) {
        this.validUsername = constraintAnnotation;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext ctx) {
        return userEntityRepository.findByUsername(username).isEmpty();
    }
}
