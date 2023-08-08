package my.project.library.services;

import my.project.library.models.Password;
import my.project.library.models.User;
import my.project.library.repositories.PasswordsRepository;
import my.project.library.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RegistrationService {

    private final UsersRepository usersRepository;
    private final PasswordsRepository passwordsRepository;

    @Autowired
    public RegistrationService(UsersRepository usersRepository, PasswordsRepository passwordsRepository) {
        this.usersRepository = usersRepository;
        this.passwordsRepository = passwordsRepository;
    }

    @Transactional
    public void register(User user, Password password){
        usersRepository.save(user);
        passwordsRepository.save(password);
    }
}
