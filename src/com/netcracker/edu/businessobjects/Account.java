package com.netcracker.edu.businessobjects;

import com.netcracker.edu.util.Check;
import com.netcracker.edu.util.Input;

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

    @Override
    public String toString() {
        return reader.getName() + " " + book.getBookType().getName() + " [" + getId() + "]";
    }

    @Override
    public String write() {
        return this.getReader().write() + " " + this.getBook().write() + " " + this.isActual() + " " + Input.writeCalendar(issueDate) + " "
                + Input.writeCalendar(returnDate) + " " + this.getId();
    }

    public static Account load(String[] parameters) {
        String[] readerParameters = new String[5];
        System.arraycopy(parameters, 0, readerParameters, 0, 5);
        Reader reader = null;
        reader = reader.load(readerParameters);
        String[] bookParameters = new String[7];
        System.arraycopy(parameters, 5, bookParameters, 0, 7);
        Book book = null;
        book = book.load(bookParameters);
        String[] issueDateParameters = new String[3];
        System.arraycopy(parameters, 13, issueDateParameters, 0, 3);
        Calendar issueDate = Input.loadCalendar(issueDateParameters);
        String[] returnDateParameters = new String[3];
        System.arraycopy(parameters, 16, returnDateParameters, 0, 3);
        Calendar returnDate = Input.loadCalendar(returnDateParameters);
        Account account = new Account(reader, book, issueDate, returnDate);
        if (parameters[12].equals("true")) {
            account.setIsActual(true);
        }
        account.setId(Integer.parseInt(parameters[19]));
        return account;
    }
}
