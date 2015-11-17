package com.netcracker.edu.businessobjects;

import com.netcracker.edu.util.Check;

import java.util.Calendar;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class Account extends IDObject {
    private Reader reader;
    private Book book;
    private boolean isActual;
    private Calendar issueDate;
    private Calendar returnDate;

    public Account(Reader reader, Book book, Calendar issueDate, Calendar returnDate) {
        setReader(reader);
        setBook(book);
        setIsActual(true);
        setIssueDate(issueDate);
        setReturnDate(returnDate);
    }

    public Reader getReader() {
        return reader;

    }

    public void setReader(Reader reader) {
        Check.isNull(reader);
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        Check.isNull(book);
        this.book = book;
    }

    public boolean isActual() {
        return isActual;
    }

    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }

    public Calendar getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Calendar issueDate) {
        Check.isNull(issueDate);
        this.issueDate = issueDate;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Calendar returnDate) {
        Check.isNull(returnDate);
        this.returnDate = returnDate;
    }
}
