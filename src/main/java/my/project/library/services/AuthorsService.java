package my.project.library.services;

import my.project.library.models.Author;
import my.project.library.models.enums.sortings.AuthorsSorting;
import my.project.library.models.enums.sortings.ISorting;
import my.project.library.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
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
        return authorsRepository.findByName(name).stream().findFirst();
    }

    public List<Author> findAllStartingWith(String startingWith, int page, int size, AuthorsSorting sorting){
        return authorsRepository.findByNameStartingWith(
                startingWith,
                PageRequest.of(page, size,Sort.by(sorting.getDirection(),
                        sorting.getProperty())));
    }
    public long countAllStartingWith(String startingWith){
        return authorsRepository.countByNameStartingWith(startingWith);
    }


    public List<Author> findAll(int page, int size, ISorting sorting){
        return authorsRepository.findAll(
                PageRequest.of(page, size, Sort.by(sorting.getDirection(), sorting.getProperty()))).stream().toList();
    }
    public long countAll(){
        return authorsRepository.count();
    }

    public Optional<Author> findOne(long id){
        return authorsRepository.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
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
