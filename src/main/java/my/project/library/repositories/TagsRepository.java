package my.project.library.repositories;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

import my.project.library.models.Author;
import my.project.library.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagsRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByNameOrderById(String name);

    List<Tag> findByNameStartingWithOrderById(String startingWith);
}
