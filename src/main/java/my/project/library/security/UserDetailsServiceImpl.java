package my.project.library.security;

import my.project.library.models.Password;
import my.project.library.models.User;
import my.project.library.services.PasswordsService;
import my.project.library.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersService usersService;
    private final PasswordsService passwordsService;

    @Autowired
    public UserDetailsServiceImpl(UsersService usersService, PasswordsService passwordsService) {
        this.usersService = usersService;
        this.passwordsService = passwordsService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = usersService.findOne(username);

        if(user.isEmpty()) throw new UsernameNotFoundException("User not found!");

        User user1 = user.get();

        Optional<Password> password = passwordsService.findOne(user1.getId());
        if(password.isEmpty()) throw new UsernameNotFoundException("User don't have password!");

        return new UserDetailsImpl(user1, password.get());
    }
}
