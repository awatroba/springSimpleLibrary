package pk.ztp.springlibrary.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pk.ztp.springlibrary.beans.User;
import pk.ztp.springlibrary.enums.Role;

import java.util.HashMap;

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
