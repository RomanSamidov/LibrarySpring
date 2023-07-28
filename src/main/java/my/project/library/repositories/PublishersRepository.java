package my.project.library.repositories;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

import my.project.library.models.Author;
import my.project.library.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublishersRepository extends JpaRepository<Publisher, Long> {
    List<Publisher> findByNameOrderById(String name);

    List<Publisher> findByNameStartingWithOrderById(String startingWith);
}
