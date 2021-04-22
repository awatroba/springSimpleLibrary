package pk.ztp.springlibrary.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import pk.ztp.springlibrary.beans.User;
import pk.ztp.springlibrary.enums.Role;

import java.util.HashMap;

/**
 *UserService - serwis, który zawiera użytkowników aplikacji. Użytkownicy
 * powinni być oni przechowywani w mapie. W serwisie powinna znajdować
 * się metoda pobierająca użytkownika po loginie.
 */
public class UserDetailsServiceImp implements UserDetailsService {
    private HashMap<String, User> users ;
    public UserDetailsServiceImp() {
        users = new HashMap<String, User>();
        users.put("admin",new User("admin","admin", Role.ADMIN));
        users.put("user",new User("user","user",Role.USER));
        users.put("user1",new User("uszer1","user1",Role.USER));
        users.put("angelika",new User("angelika","angelika",Role.USER));
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = findUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("No such user in database");
        }
        UserDetailsImp userDetailsImp = new UserDetailsImp(user);
        return userDetailsImp;
    }
    private User findUserByUserName(String username) {
        return users.get(username);
    }
}
   /* private HashMap<String, User> users ;

    public UserDetailsServiceImp() {
        users = new HashMap<String, User>();
        users.put("admin",new User("admin","admin", Role.ADMIN));
        users.put("user",new User("user","user",Role.USER));
        users.put("user1",new User("uszer1","user1",Role.USER));
        users.put("angelika",new User("angelika","angelika",Role.USER));

        /*UserDetails user = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username("usezr")
                .password("user")
                .roles("USER")
                .build();
        UserDetails admin = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        new InMemoryUserDetailsManager(user, admin);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("No such user in database");
        }
        return user;*/
    /*Here we are using dummy data, you need to load user data from
     database or other third party application*/
       /* User user = findUserByUsername(username);

        UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.roles(user.getRole().name());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

    private User findUserByUserName(String username) {
        return users.get(username);
    }
}*/