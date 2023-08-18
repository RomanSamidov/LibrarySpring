package my.project.library.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


//        admin(1),
//        librarian(2),
//        reader(3);

@Entity
@Table(name = "authority")
@Cacheable
@org.springframework.cache.annotation.Cacheable("authorities")
public class Authority {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

//    @ManyToMany
//    @JoinTable(
//            name = "user_authority",
//            joinColumns = { @JoinColumn(name = "user_id") },
//            inverseJoinColumns = { @JoinColumn(name = "authority_id") }
//    )
    @ManyToMany(mappedBy = "authorities", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Authority() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String) return name.equals(obj);
        if(obj instanceof Authority) return name.equals(((Authority) obj).getName());
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
