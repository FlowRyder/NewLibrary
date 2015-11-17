package com.netcracker.edu.util;

import com.netcracker.edu.businessobjects.*;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class Choice {
    // There is really complicated logic, because can exists to book type with equal names,
    // but different author or genre.
    public static BookType chooseBookType() throws IOException {
        Iterator<BookType> bookTypeIterator = MemoryDAO.getInstance().getBookTypes().iterator();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(bookTypeIterator.hasNext()) {
            BookType nextBookType = bookTypeIterator.next();
            System.out.println(nextBookType.getName() + " " + nextBookType.getAuthor() + " "
                    + nextBookType.getGenre() + " " + nextBookType.getId());
        }
        System.out.println("Choose book type - enter id:");
        int id  = Integer.getInteger(bufferedReader.readLine());
        while(bookTypeIterator.hasNext()) {
            BookType bookType = bookTypeIterator.next();
            if(id == bookType.getId()) {
                return bookType;
            }
        }
        return null;
    }

    public static Genre chooseGenre() throws IOException {
        Iterator<Genre> genreIterator = MemoryDAO.getInstance().getGenres().iterator();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (genreIterator.hasNext()) {
            System.out.println(genreIterator.next().getName());
        }
        System.out.println("Choose genre");
        String genreName = bufferedReader.readLine();
        while (genreIterator.hasNext()) {
            Genre genre = genreIterator.next();
            if (genre.getName().equals(genreName)) {
                return genre;
            }
        }
        return null;
    }

    public static Author chooseAuthor() throws IOException {
        Iterator<Author> authorIterator = MemoryDAO.getInstance().getAuthors().iterator();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (authorIterator.hasNext()) {
            System.out.println(authorIterator.next().getName());
        }
        System.out.println("Choose author");
        String authorName = bufferedReader.readLine();
        while (authorIterator.hasNext()) {
            Author author = authorIterator.next();
            if (author.getName().equals(authorName)) {
                return author;
            }
        }
        return null;
    }
}
