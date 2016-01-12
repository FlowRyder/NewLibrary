package com.netcracker.edu.businessobjects;

import com.netcracker.edu.util.IDGenerator;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by FlowRyder.
 */
public class IDObject implements Serializable {
    private BigInteger id;

    public IDObject() {
        id = IDGenerator.getInstance().getID();
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        if(id.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Error: ID shouldn't be negative value.");
        }
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
