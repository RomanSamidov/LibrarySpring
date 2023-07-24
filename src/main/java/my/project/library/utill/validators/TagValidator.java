package my.project.library.utill.validators;

import my.project.library.models.Tag;
import my.project.library.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TagValidator implements Validator {

    private final TagsService tagsService;

    @Autowired
    public TagValidator(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Tag.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Tag tag = (Tag)target;
    }
}
