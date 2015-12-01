package com.netcracker.edu.util;

import com.netcracker.edu.businessobjects.NamedObject;
import com.netcracker.edu.dao.MemoryDAO;

import java.util.Collection;

/**
 * Created by FlowRyder on 29.11.2015.
 */
public class Uniqueness {
    public static boolean isNonUnigue(String value, Collection<? extends NamedObject> namedObjects) {
        for (NamedObject namedObject : namedObjects) {
            if (value.equals(namedObject.getName())) {
                return true;
            }
        }
        return false;
    }
}
