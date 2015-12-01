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
}
