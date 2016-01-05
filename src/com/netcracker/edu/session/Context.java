package com.netcracker.edu.session;

import com.netcracker.edu.businessobjects.Librarian;
import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.businessobjects.User;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by FlowRyder on 02.01.2016.
 */
public class Context {
    public static final Logger LOGGER = Logger.getLogger(Context.class);
    private static final ThreadLocal<User> threadLocalScope = new ThreadLocal<>();
    private static final Set<User> activeUsers = new HashSet<>();

    public final static User getLoggedHolder() {
        return threadLocalScope.get();
    }

    public synchronized static void setLoggedUser(User user) throws IOException {
        if (activeUsers.contains(user)) {
            throw new AccessDeniedException("User already signed in");
        }
        activeUsers.add(user);
        threadLocalScope.set(user);
    }

    public synchronized final static void removeUserFromSignedUsers() {
        activeUsers.remove(threadLocalScope.get());
    }
}
