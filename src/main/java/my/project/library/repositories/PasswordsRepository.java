package my.project.library.repositories;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

import my.project.library.models.Author;
import my.project.library.models.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordsRepository extends JpaRepository<Password, Long> {
}
