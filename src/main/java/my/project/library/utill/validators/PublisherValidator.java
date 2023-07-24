package my.project.library.utill.validators;

import my.project.library.models.Publisher;
import my.project.library.services.PublishersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PublisherValidator implements Validator {

    private final PublishersService publishersService;

    @Autowired
    public PublisherValidator(PublishersService publishersService) {
        this.publishersService = publishersService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Publisher.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Publisher publisher = (Publisher)target;
    }
}
