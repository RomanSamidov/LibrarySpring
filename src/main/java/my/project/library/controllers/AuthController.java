package my.project.library.controllers;

import jakarta.validation.Valid;
import my.project.library.models.Language;
import my.project.library.models.Password;
import my.project.library.models.Role;
import my.project.library.models.User;
import my.project.library.services.RegistrationService;
import my.project.library.utill.validators.PasswordValidator;
import my.project.library.utill.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final UserValidator userValidator;
    private final PasswordValidator passwordValidator;

    @Autowired
    public AuthController(RegistrationService registrationService,
                          UserValidator userValidator,
                          PasswordValidator passwordValidator) {
        this.registrationService = registrationService;
        this.userValidator = userValidator;
        this.passwordValidator = passwordValidator;
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user, @ModelAttribute("password") Password password) {
        password.setUser(user);
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute(value = "user") @Valid User user,
                                      BindingResult binding,
                                      @ModelAttribute(value = "password") @Valid Password password,
                                      BindingResult binding2) {
        userValidator.validate(user, binding);
        passwordValidator.validate(password, binding2);
        if (binding.hasErrors()){
            return "/auth/registration";
        }

        user.setRole(new Role(3L));
        user.setLanguage(new Language(1L));
        password.setUser(user);
        registrationService.register(user, password);
        return "redirect:/auth/login";
    }
}
