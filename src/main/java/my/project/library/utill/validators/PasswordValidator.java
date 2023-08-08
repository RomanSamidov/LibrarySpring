package my.project.library.utill.validators;

import my.project.library.models.Password;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class PasswordValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Password.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Password password = (Password)target;


        if(password.getPasswordText().length() < 8) {
            errors.rejectValue("password","", "Password is short!");
        }
    }
}
