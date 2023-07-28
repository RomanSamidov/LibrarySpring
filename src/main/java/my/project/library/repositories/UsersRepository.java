package my.project.library.repositories;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

import my.project.library.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
}
