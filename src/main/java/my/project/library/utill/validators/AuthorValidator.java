package my.project.library.utill.validators;

import my.project.library.models.Author;
import my.project.library.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AuthorValidator implements Validator {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorValidator(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Author.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Author author = (Author)target;


    }
}
