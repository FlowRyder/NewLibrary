package com.netcracker.edu.businessobjects;

import com.netcracker.edu.util.Check;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class BookType extends NamedObject {
    private Genre genre;
    private Author author;

    public BookType(String name, Genre genre, Author author) {
        super(name);
        setGenre(genre);
        setAuthor(author);
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        Check.isNull(genre);
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        Check.isNull(author);
        this.author = author;
    }


}
