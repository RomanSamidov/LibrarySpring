package my.project.library.services;

import my.project.library.models.Password;
import my.project.library.repositories.PasswordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PasswordsService {
    private final PasswordsRepository passwordsRepository;

    @Autowired
    public PasswordsService(PasswordsRepository passwordsRepository) {
        this.passwordsRepository = passwordsRepository;
    }

//    public Optional<Password> findOne(String name){
//        return passwordsRepository.findByNameOrderById(name).stream().findFirst();
//    }
//
//    public List<Password> findAllStartingWith(String startingWith){
//        return passwordsRepository.findByNameStartingWithOrderById(startingWith);
//    }


    public List<Password> findAll(){
        return passwordsRepository.findAll();
    }

    public Optional<Password> findOne(long id){
        return passwordsRepository.findById(id);
    }

    @Transactional
    public void save(Password password){
        passwordsRepository.save(password);
    }

    @Transactional
    public void update(long id, Password password){
        password.setId(id);
        passwordsRepository.save(password);
    }

    @Transactional
    public void delete(long id){
        passwordsRepository.deleteById(id);
    }
}
