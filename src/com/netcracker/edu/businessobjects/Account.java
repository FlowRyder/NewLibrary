package com.netcracker.edu.businessobjects;

import java.math.BigInteger;
import java.util.Calendar;

/**
 * Created by FlowRyder.
 */
public class Account extends IDObject {
    private BigInteger readerID;
    private BigInteger bookID;
    private boolean isActual;
    private Calendar issueDate;
    private Calendar returnDate;

    public Account(BigInteger readerID, BigInteger bookID, Calendar issueDate, Calendar returnDate) {
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

    public Calendar getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Calendar issueDate) {
        if (issueDate == null) {
            throw new IllegalArgumentException("Error: issueDate shouldn't be null.");
        }
        this.issueDate = issueDate;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Calendar returnDate) {
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
                && issueDate.get(Calendar.YEAR) == that.issueDate.get(Calendar.YEAR) &&
                issueDate.get(Calendar.MONTH) == that.issueDate.get(Calendar.MONTH) &&
                issueDate.get(Calendar.DAY_OF_MONTH) == issueDate.get(Calendar.DAY_OF_MONTH) &&
                returnDate.get(Calendar.YEAR) == that.returnDate.get(Calendar.YEAR) &&
                returnDate.get(Calendar.MONTH) == that.returnDate.get(Calendar.MONTH) &&
                returnDate.get(Calendar.DAY_OF_MONTH) == returnDate.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        return getReaderID() + " " + getBookID() + " " + getIsActual() + " [" + getId() + "]";
    }
}
