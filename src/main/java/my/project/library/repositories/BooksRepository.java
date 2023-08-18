package my.project.library.repositories;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

import my.project.library.models.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String ful_name, Pageable pageable);

    List<Book> findByTitleStartingWith(String startingWith, Pageable pageable);

    long countByTitleStartingWith(String startingWith);
}
