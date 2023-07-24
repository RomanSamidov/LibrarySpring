package my.project.library.services;

import my.project.library.models.Author;
import my.project.library.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AuthorsService {

    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public Optional<Author> findOne(String name){
        return authorsRepository.findByNameOrderById(name).stream().findFirst();
    }

    public List<Author> findAllStartingWith(String startingWith){
        return authorsRepository.findByNameStartingWithOrderById(startingWith);
    }


    public List<Author> findAll(){
        return authorsRepository.findAll();
    }

    public Optional<Author> findOne(long id){
        return authorsRepository.findById(id);
    }

    @Transactional
    public void save(Author author){
        authorsRepository.save(author);
    }

    @Transactional
    public void update(long id, Author author){
        author.setId(id);
        authorsRepository.save(author);
    }

    @Transactional
    public void delete(long id){
        authorsRepository.deleteById(id);
    }
}
