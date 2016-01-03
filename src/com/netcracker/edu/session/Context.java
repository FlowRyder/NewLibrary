package com.netcracker.edu.session;

import com.netcracker.edu.businessobjects.Librarian;
import com.netcracker.edu.businessobjects.Reader;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by FlowRyder on 02.01.2016.
 */
public class Context {
    public static final Logger LOGGER = Logger.getLogger(Context.class);
    private static Context INSTANCE = new Context();
    private static Collection<Reader> activeReaders;
    private static Collection<Librarian> activeLibrarians;

    public static Context getInstance() {
        return INSTANCE;
    }

    private Context() {
        activeReaders = new HashSet<>();
        activeLibrarians = new HashSet<>();
    }

    public static void addReader(Reader reader) {
        if (!containReader(reader)) {
            activeReaders.add(reader);
        } else {
            LOGGER.info("Error: reader already logged in.");
        }
    }

    public static void addLibrarian(Librarian librarian) {
        if (!containLibrarian(librarian)) {
            activeLibrarians.add(librarian);
        } else {
            LOGGER.info("Error: librarian already logged in.");
        }

    }

    public static boolean containReader(Reader reader) {
        for (Reader activeReader : activeReaders) {
            if (reader.equals(activeReader)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containLibrarian(Librarian librarian) {
        for (Librarian activeLibrarian : activeLibrarians) {
            if (librarian.equals(activeLibrarian)) {
                return true;
            }
        }
        return false;
    }
}
