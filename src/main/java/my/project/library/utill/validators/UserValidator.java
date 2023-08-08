package my.project.library.utill.validators;

import my.project.library.models.User;
import my.project.library.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserValidator implements Validator {

    private final UsersService usersService;

    @Autowired
    public UserValidator(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        Optional<User> oUser = usersService.findOne(user.getLogin());

        if(oUser.isPresent()) {
            errors.rejectValue("login","", "Login already used!");
        }
    }
}
