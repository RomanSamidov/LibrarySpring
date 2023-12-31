package my.project.library.repositories;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

import my.project.library.models.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {
    List<Author> findByName(String name);

    List<Author> findByNameStartingWith(String startingWith, Pageable pageable);
    long countByNameStartingWith(String startingWith);
}
