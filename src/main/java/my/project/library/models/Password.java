package my.project.library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "password")
public class Password {

    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
//    @JoinColumn(name = "id")
    @PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @NotEmpty(message = "Password cant be empty")
    @Size(min=0, max=64, message = "Max size for password is 128")
    @Column(name = "password")
    private String password;


    public Password(Long id, User user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public Password() {
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
