package com.netcracker.edu.businessobjects;

import java.math.BigInteger;
import java.sql.Date;

/**
 * Created by FlowRyder.
 */
public class Account extends IDObject {
    private BigInteger readerID;
    private BigInteger bookID;
    private boolean isActual;
    private Date issueDate;
    private Date returnDate;

    public Account(BigInteger readerID, BigInteger bookID, Date issueDate, Date returnDate) {
        setReaderID(readerID);
        setBookID(bookID);
        setIsActual(true);
        setIssueDate(issueDate);
        setReturnDate(returnDate);
    }

    public BigInteger getReaderID() {
        return readerID;
    }

    public void setReaderID(BigInteger readerID) {
        if (readerID == null || readerID.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Error: readerID shouldn't be null or negative value.");
        }
        this.readerID = readerID;
    }

    public BigInteger getBookID() {
        return bookID;
    }

    public void setBookID(BigInteger bookID) {
        if (bookID == null || bookID.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Error: readerID shouldn't be null or negative value.");
        }
        this.bookID = bookID;
    }

    public boolean getIsActual() {
        return isActual;
    }

    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        if (issueDate == null) {
            throw new IllegalArgumentException("Error: issueDate shouldn't be null.");
        }
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        if (returnDate == null) {
            throw new IllegalArgumentException("Error: returnDate shouldn't be null");
        }
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account that = (Account) o;
        return readerID.equals(that.readerID) && bookID.equals(that.bookID) && isActual == that.getIsActual()
                && issueDate.equals(that.getIssueDate()) && returnDate.equals(that.getReturnDate());
    }

    @Override
    public String toString() {
        return getReaderID() + " " + getBookID() + " " + getIsActual() + " [" + getId() + "]";
    }
}
