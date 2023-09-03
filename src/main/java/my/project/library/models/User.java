package my.project.library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import my.project.library.models.enums.entityes.Authority;
import my.project.library.models.enums.entityes.Language;
import my.project.library.models.enums.entityes.converters.AuthorityConverter;
import my.project.library.models.enums.entityes.converters.LanguageConverter;
import org.hibernate.annotations.Type;

import java.sql.Date;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @NotEmpty(message = "Name cant be empty")
    @Size(min=0, max=64, message = "Max size for name is 64")
    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "user_authority",
//            joinColumns = { @JoinColumn(name = "user_id") },
//            inverseJoinColumns = { @JoinColumn(name = "authority_id") }
//    )


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_authority",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "authority_id"),
//            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "authority_id"})})

    @ElementCollection(targetClass = Authority.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "authority_id", nullable = false)
//    @Type(type = "com.sample.data.common.IntValuedEnumType", parameters = { @Parameter(name = "enumClass", value = "com.sample.data.model.types.Category") })
//    private Set<Category> categories = new HashSet<Category>();

    @Convert(converter = AuthorityConverter.class)
    private Set<Authority> authorities = new HashSet<>();


    @Column(name = "language_id")
    @Convert(converter = LanguageConverter.class)
    private Language language;

    @NotEmpty(message = "Email cant be empty")
    @Size(min=0, max=64, message = "Max size for email is 64")
    @Column(name = "email")
    private String email;

    @Column(name = "allow_letters")
    private boolean allowLetters;

    @Column(name = "confirmed")
    private boolean confirmed;

    @NotEmpty(message = "Login cant be empty")
    @Size(min=0, max=64, message = "Max size for login is 64")
    @Column(name = "login")
    private String login;

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void addAuthorities(Authority... authorities) {
        Collections.addAll(this.authorities, authorities);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRole(){
         String s = "NO_ROLE";

        for (Authority a : authorities) {
            String aut = a.name();
            s = aut.equals("ROLE_READER") ? "READER":s;
            s = aut.equals("ROLE_LIBRARIAN") ? "LIBRARIAN":s;
            s = aut.equals("ROLE_ADMIN") ? "ADMIN":s;
        }

        return s;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAllowLetters() {
        return allowLetters;
    }

    public void setAllowLetters(boolean allowLetters) {
        this.allowLetters = allowLetters;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
