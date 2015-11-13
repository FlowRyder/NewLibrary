package com.netcracker.edu.businessobjects;

import com.netcracker.edu.util.Check;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class User extends NamedObject {
    private String login;
    private String email;
    private String password;

    public User(String name, String login, String email, String password) {
        super(name);
        setLogin(login);
        setEmail(email);
        setPassword(password);
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        Check.isNullOrVoid(login);
        Pattern pattern = Pattern.compile("^(?=.{3,24})[a-z][a-z0-9]*[._-]?[a-z0-9]+$");
        Matcher matcher = pattern.matcher(login);
        if (!(matcher.matches())) {
            throw new IllegalArgumentException("Invalid format of login.");
        } else {
            this.login = login;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Check.isNullOrVoid(email);
        Pattern pattern = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
        Matcher matcher = pattern.matcher(email);
        if (!(matcher.matches())) {
            throw new IllegalArgumentException("Invalid format of email address.");
        } else {
            this.email = email;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Check.isNullOrVoid(password);
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");
        Matcher matcher = pattern.matcher(password);
        if (!(matcher.matches())) {
            throw new IllegalArgumentException("Invalid format of password.");
        } else {
            this.password = password;
        }
    }
}
