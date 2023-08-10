package my.project.library.models;

import jakarta.persistence.*;


//            en_US(1),
//            uk_UA(2);
@Entity
@Table(name = "language")
@org.springframework.cache.annotation.Cacheable("languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Language(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Language() {
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
