package my.project.library.services;

import my.project.library.models.Authority;
import my.project.library.repositories.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//        admin(1),
//        librarian(2),
//        reader(3);


@Service
@Transactional(readOnly = true)
public class AuthoritiesService {

    public final Authority ADMIN;
    public final Authority LIBRARIAN;
    public final Authority READER;
    private final AuthoritiesRepository authoritiesRepository;

    @Autowired
    public AuthoritiesService(AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
        ADMIN = findOne("ROLE_ADMIN");
        LIBRARIAN = findOne("ROLE_LIBRARIAN");
        READER = findOne("ROLE_READER");
    }

    @org.springframework.cache.annotation.Cacheable("authorities")
    public Authority findOne(String name){
        return authoritiesRepository.findByName(name).stream().findFirst().orElseThrow( () -> new RuntimeException("Wrong ROLE name was " + name));
    }


    public List<Authority> findAll(){
        return authoritiesRepository.findAll();
    }

    @org.springframework.cache.annotation.Cacheable("authorities")
    public Authority findOne(long id){
        return authoritiesRepository.findById(id).orElseThrow( () -> new RuntimeException("Wrong ROLE id expected from 1 to 3 but was " + id));
    }

}
