package my.project.library.repositories;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

import my.project.library.models.Language;
import my.project.library.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguagesRepository extends JpaRepository<Language, Long> {

    Optional<Language> findByName(String name);
}
