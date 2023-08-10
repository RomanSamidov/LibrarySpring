package my.project.library.models;

import jakarta.annotation.Generated;
import jakarta.persistence.*;


//        admin(1),
//        librarian(2),
//        reader(3);

@Entity
@Table(name = "role")
@Cacheable
@org.springframework.cache.annotation.Cacheable("roles")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
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
}
