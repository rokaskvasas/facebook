package eu.codeacademy.spring.facebook.validation.validators;

import eu.codeacademy.spring.facebook.repository.UserEntityRepository;
import eu.codeacademy.spring.facebook.validation.ValidEmail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RequiredArgsConstructor
public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String> {

    private ValidEmail validEmail;

    private final UserEntityRepository userEntityRepository;

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        this.validEmail = constraintAnnotation;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext ctx) {
        try {
            if (!patternIsValid(email)) {
                return false;
            }
            if (!emailIsUnique(email)) {
                return false;
            }
        } catch (ValidationException exception) {
            log.info("Error at ValidEmailValidator: {}", exception.getMessage());
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean patternIsValid(String email) {
        Pattern pattern =
                Pattern.compile("^[\\w]{1,}[\\w.+-]{0,}@[\\w-]{2,}([.][a-zA-Z]{2,}|[.][a-zA-Z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean emailIsUnique(String email) {
        return userEntityRepository.findByUsernameOrEmail(null, email).isEmpty();
    }
}
