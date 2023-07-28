package my.project.library.security;

import my.project.library.models.Password;
import my.project.library.models.User;
import my.project.library.services.PasswordsService;
import my.project.library.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UsersService usersService;
    private final PasswordsService passwordsService;

    @Autowired
    public UserDetailsService(UsersService usersService, PasswordsService passwordsService) {
        this.usersService = usersService;
        this.passwordsService = passwordsService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersService.findOne(username).get();
        Password password = passwordsService.findOne(user.getId()).get();
        return new my.project.library.security.UserDetails(user, password);
    }
}
