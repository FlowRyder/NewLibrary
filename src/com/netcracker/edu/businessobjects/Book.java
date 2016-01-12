package com.netcracker.edu.businessobjects;

import java.math.BigInteger;

/**
 * Created by FlowRyder.
 */
public class Book extends IDObject {
    private BigInteger bookTypeID;

    public Book(BigInteger bookTypeID) {
        setBookTypeID(bookTypeID);
    }

    public BigInteger getBookTypeID() {
        return bookTypeID;
    }

    public void setBookTypeID(BigInteger bookTypeID) {
        if (bookTypeID == null || bookTypeID.compareTo(BigInteger.ZERO) < 0) {
            throw new NullPointerException("Error: bookTypeID shouldn't be null or negative value.");
        }
        this.bookTypeID = bookTypeID;
    }

    @Override
    public String toString() {
        return "bookTypeID[" + getBookTypeID() + "] [" + getId() + "]";
    }
}
