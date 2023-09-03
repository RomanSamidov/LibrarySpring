package my.project.library.dao;

import jakarta.persistence.EntityManager;
import my.project.library.models.User;
import my.project.library.models.enums.searchFields.ISearchFields;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
@Transactional(readOnly = true)
public class UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //TODO: pagination
    public Set<User> findAllWithAuthoritiesAndLanguage(Pageable pageable){
        Session session = entityManager.unwrap(Session.class);

//        return new HashSet<User>(session.createQuery("select u from User u left join fetch u.language left join fetch u.authorities")
//                .getResultList());
        return new HashSet<User>(session.createQuery("select u from User u left join fetch u.authorities")
                .getResultList());
    }
    //TODO: pagination
    public Set<User> findAllStartingWithWithAuthoritiesAndLanguage(String startingWith, Pageable pageable, ISearchFields searchField){
        Session session = entityManager.unwrap(Session.class);
        String field = searchField.getProperty();

//        return new HashSet<User>(session.createQuery("select u from User u where u." + field + " like :startingWith left join fetch u.language left join fetch u.authorities")
//                .getResultList());
        return new HashSet<User>(session.createQuery("select u from User u where u." + field + " like :startingWith left join fetch u.authorities")
                .getResultList());
    }

    public long count(String startingWith, ISearchFields searchField){
        Session session = entityManager.unwrap(Session.class);
        String field = searchField.getProperty();

        return (long) session.createQuery("select count (*) from User u where u." + field + " like '%startingWith%' ").getSingleResult();
    }

    public User findOneWithAuthoritiesAndLanguage(long id){
        Session session = entityManager.unwrap(Session.class);

//        return (User) session.createQuery("select u from User u left join fetch u.language left join fetch u.authorities where u.id = :id")
//                .getSingleResult();
        return (User) session.createQuery("select u from User u left join fetch u.authorities where u.id = :id")
                .getSingleResult();
    }
}
