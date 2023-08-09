package my.project.library.repositories;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

import my.project.library.models.Role;
import my.project.library.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
