package pk.ztp.springlibrary.beans;

import pk.ztp.springlibrary.enums.Role;

public class User {
    protected String login;
    protected String pass;
    final protected Role role;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
        this.role = Role.USER;
    }

    public User(String login, String pass, Role role) {
        this.login = login;
        this.pass = pass;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return pass;
    }

    public Role getRole() {
        return role;
    }
}