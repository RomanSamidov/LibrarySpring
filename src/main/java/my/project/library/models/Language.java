package my.project.library.models;

import jakarta.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Language(Long id) {
        this.id = id;
    }

    public Language() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
