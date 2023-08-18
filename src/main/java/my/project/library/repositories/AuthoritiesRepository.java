package my.project.library.repositories;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

import my.project.library.models.Authority;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authority, Long> {

    @Cacheable("authorities")
    Optional<Authority> findByName(String name);


    @Override
    @Cacheable("authorities")
    Optional<Authority> findById(Long aLong);
}
