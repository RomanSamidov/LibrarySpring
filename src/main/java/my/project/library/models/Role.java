package my.project.library.models;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Role(Long id) {
        this.id = id;
    }

    public Role() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
