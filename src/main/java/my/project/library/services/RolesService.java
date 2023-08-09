package my.project.library.services;

import my.project.library.models.Role;
import my.project.library.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//        admin(1),
//        librarian(2),
//        reader(3);


@Service
@Transactional(readOnly = true)
public class RolesService {

    public final String ADMIN = "admin";
    public final String LIBRARIAN = "librarian";
    public final String READER = "reader";
    private final RolesRepository rolesRepository;

    @Autowired
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public Role findOne(String name){
        return rolesRepository.findByName(name).stream().findFirst().orElseThrow( () -> new RuntimeException("Wrong ROLE name was " + name));
    }


    public List<Role> findAll(){
        return rolesRepository.findAll();
    }

    public Role findOne(long id){
        return rolesRepository.findById(id).orElseThrow( () -> new RuntimeException("Wrong ROLE id expected from 1 to 3 but was " + id));
    }

}
