package my.project.library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import my.project.library.models.Language;
import my.project.library.models.Role;

import java.sql.Date;

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

    @OneToOne(fetch = FetchType.LAZY)
    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
