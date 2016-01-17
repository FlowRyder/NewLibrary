package com.netcracker.edu.businessobjects;

import java.util.Arrays;

/**
 * Created by FlowRyder.
 */
public class User extends NamedObject {
    private String login;
    private String email;
    private char[] password;
    private boolean rights;

    public User(String name, String login, String email, char[] password) {
        super(name);
        setLogin(login);
        setEmail(email);
        setPassword(password);
        rights = false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Error: login shouldn't be null or empty.");
        }
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Error: email shouldn't be null or empty.");
        }
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        if (password == null || password.length == 0) {
            throw new IllegalArgumentException("Error: password shouldn't be null or empty.");
        }
        this.password = password;
    }

    public boolean getRights() {
        return this.rights;
    }

    public void setRights(boolean rights) {
        this.rights = rights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User that = (User) o;
        return login.equals(that.getLogin()) && email.equals(that.getEmail()) && Arrays.equals(password, that.getPassword());
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }

    @Override
    public String toString() {
        return getName() + " " + getLogin() + " " + getEmail() + " [" + getId() + "]";
    }
}
