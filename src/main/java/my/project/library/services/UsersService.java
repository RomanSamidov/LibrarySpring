package my.project.library.services;

import my.project.library.models.User;
import my.project.library.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

//    public Optional<User> findOne(String name){
//        return usersRepository.findByNameOrderById(name).stream().findFirst();
//    }
//
//    public List<User> findAllStartingWith(String startingWith){
//        return usersRepository.findByNameStartingWithOrderById(startingWith);
//    }


    public List<User> findAll(){
        return usersRepository.findAll();
    }

    public Optional<User> findOne(long id){
        return usersRepository.findById(id);
    }
    public Optional<User> findOne(String login){
        return usersRepository.findByLogin(login);
    }

    @Transactional
    public void save(User user){
        usersRepository.save(user);
    }

    @Transactional
    public void update(long id, User user){
        user.setId(id);
        usersRepository.save(user);
    }

    @Transactional
    public void delete(long id){
        usersRepository.deleteById(id);
    }
}
