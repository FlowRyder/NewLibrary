package com.netcracker.edu.businessobjects;

import com.netcracker.edu.util.Check;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class Book extends IDObject {
    private BookType bookType;

    public Book(BookType bookType) {
        setBookType(bookType);
    }


    public void setBookType(BookType bookType) {
        Check.isNull(bookType);
        this.bookType = bookType;
    }

    public BookType getBookType() {
        return bookType;
    }

    @Override
    public String toString() {
        return bookType.getName() + " [" + getId() + "]";
    }

    @Override
    public String write() {
        return this.getBookType().write() + " " + this.getId();
    }

    public static Book load(String[] parameters) {
        String[] bookTypeParameters = new String[6];
        System.arraycopy(parameters, 0, bookTypeParameters, 0, 6);
        BookType bookType = null;
        bookType = bookType.load(bookTypeParameters);
        Book book = new Book(bookType);
        book.setId(Integer.parseInt(parameters[6]));
        return book;
    }
}
