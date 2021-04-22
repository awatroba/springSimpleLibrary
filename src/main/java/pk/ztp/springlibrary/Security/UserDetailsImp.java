package pk.ztp.springlibrary.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pk.ztp.springlibrary.beans.User;

import java.util.Arrays;
import java.util.Collection;
/*
* Klasa implementująca interfejs UserDetails. Jest to swego rodzaju wrapper na obiekt użytkownika znajdujący
* się w aplikacji. Interfejs ten wykorzystywany jest przez Spring Security do pobrania informacji o użytkowniku takich
jak login, hasło, czy jego role*/

public class UserDetailsImp implements UserDetails {
    private User user;

    public UserDetailsImp(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_"+user.getRole().name()));
    }

    @Override
    public String getPassword() {
        return new BCryptPasswordEncoder().encode(this.user.getPassword());
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
}
