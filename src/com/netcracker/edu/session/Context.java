package com.netcracker.edu.session;

import com.netcracker.edu.businessobjects.User;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by FlowRyder.
 */
public class Context {
    public static final Logger LOGGER = Logger.getLogger(Context.class);
    private static final ThreadLocal<User> threadLocalScope = new ThreadLocal<>();
    private static final Set<User> activeUsers = new HashSet<>();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();

    public final static User getLoggedHolder() {
        return threadLocalScope.get();
    }

    public static Set<User> getActiveUsers() {
        return activeUsers;
    }

    public synchronized static void setLoggedUser(User user) throws IOException {
        if (user == null) {
            throw new NullPointerException("Error: User shouldn't be null.");
        } else {
            readLock.lock();
            try {
                if (activeUsers.contains(user)) {
                    throw new AccessDeniedException("Error: User already signed in.");
                }
            } finally {
                readLock.unlock();
            }
            writeLock.lock();
            try {
                activeUsers.add(user);
            } finally {
                writeLock.unlock();
            }
        }
        threadLocalScope.set(user);
    }

    public synchronized final static void removeUserFromSignedUsers() {
        activeUsers.remove(threadLocalScope.get());
    }
}
