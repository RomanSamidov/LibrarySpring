package my.project.library.services;

import my.project.library.dao.UserDao;
import my.project.library.models.User;
import my.project.library.models.enums.searchFields.ISearchFields;
import my.project.library.models.enums.sortings.ISorting;
import my.project.library.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersService {
    private final UsersRepository usersRepository;
    private final UserDao userDao;

    @Autowired
    public UsersService(UsersRepository usersRepository, UserDao userDao) {
        this.usersRepository = usersRepository;
        this.userDao = userDao;
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

    public List<User> findAllWithAuthoritiesAndLanguage(int page, int size, ISorting sorting){
        return userDao.findAllWithAuthoritiesAndLanguage(PageRequest.of(page, size, Sort.by(sorting.getDirection(), sorting.getProperty()))).stream().toList();
    }

    public long countAll(){
        return usersRepository.count();
    }
    public long countAllStartingWith(String startingWith, ISearchFields searchFields){
        return userDao.count(startingWith, searchFields);
    }

    public List<User> findAllStartingWithWithAuthoritiesAndLanguage(String startingWith, int page, int size, ISorting sorting, ISearchFields searchFields){
        return userDao.findAllStartingWithWithAuthoritiesAndLanguage(startingWith,
                PageRequest.of(page, size, Sort.by(sorting.getDirection(), sorting.getProperty())),
                searchFields).stream().toList();
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
