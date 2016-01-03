package com.netcracker.edu.businessobjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class Category extends NamedObject {
    private List<Book> bookList;

    public Category(String name) {
        super(name);
        this.bookList = new ArrayList<Book>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public String write() {
        return this.getName() + " " + this.getId();
    }

}
