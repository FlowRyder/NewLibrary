package com.netcracker.edu.businessobjects;

import com.netcracker.edu.util.Check;

import java.util.Arrays;

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

    @Override
    public String write() {
        return this.getName() + " " + this.getGenre().write() + " " + this.getAuthor().write() + " " + this.getId();
    }

    public static BookType load(String[] parameters) {
        String[] genreParameters = new String[2];
        System.arraycopy(parameters, 1, genreParameters, 0, 2);
        Genre genre = null;
        genre = (Genre) genre.load(genreParameters);
        String[] authorParameters = new String[2];
        System.arraycopy(parameters, 3, authorParameters, 0, 2);
        Author author = null;
        author = (Author) author.load(authorParameters);
        BookType bookType = new BookType(parameters[0], genre, author);
        bookType.setId(Integer.parseInt(parameters[5]));
        return bookType;
    }
}
