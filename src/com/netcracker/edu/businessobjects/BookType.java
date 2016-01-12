package com.netcracker.edu.businessobjects;

import java.math.BigInteger;

/**
 * Created by FlowRyder.
 */
public class BookType extends NamedObject {
    private BigInteger genreID;
    private BigInteger authorID;

    public BookType(String name, BigInteger genreID, BigInteger authorID) {
        super(name);
        setGenreID(genreID);
        setAuthorID(authorID);
    }

    public BigInteger getGenreID() {
        return genreID;
    }

    public void setGenreID(BigInteger genreID) {
        if (genreID == null || genreID.compareTo(BigInteger.ZERO) < 0) {
            throw new NullPointerException("Error: genreID shouldn't be null or negative value.");
        }
        this.genreID = genreID;
    }

    public BigInteger getAuthorID() {
        return authorID;
    }

    public void setAuthorID(BigInteger authorID) {
        if (authorID == null || authorID.compareTo(BigInteger.ZERO) < 0) {
            throw new NullPointerException("Error: authorID shouldn't be null or negative value.");
        }
        this.authorID = authorID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BookType that = (BookType) o;
        return this.getName().equals(that.getName()) && this.getGenreID().equals(that.genreID)
                && this.getAuthorID().equals(that.authorID);
    }

    @Override
    public String toString() {
        return getName() + " genre ID[" + getGenreID() + "] authorID[" + getAuthorID() +
                "] [" + getId() + "]";
    }
}
