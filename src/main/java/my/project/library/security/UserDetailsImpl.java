package my.project.library.security;

import my.project.library.models.Password;
import my.project.library.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class UserDetailsImpl implements UserDetails {

    private final User user;
    private final Password password;

    public UserDetailsImpl(User user, Password password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getAuthorities().forEach(a-> authorities.add(new SimpleGrantedAuthority(a.getName())));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password.getPasswordText();
    }

    @Override
    public String getUsername() {
        return this.user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
