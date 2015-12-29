package com.netcracker.edu.util;

import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.businessobjects.IDObject;
import com.netcracker.edu.dao.FileDAO;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by FlowRyder on 29.12.2015.
 */
public class Save {
    public static final Logger LOGGER = Logger.getLogger(Save.class);

    public static void saveCollection(String collectionName) {
        String path = "C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\";
        switch(collectionName) {
            case "book":
                break;
            case "account":
                break;
            case "author":
                break;
            case "genre":
                try(FileWriter genreWriter = new FileWriter(path + collectionName + ".txt",false)) {
                    HashSet<Genre> genres = (HashSet<Genre>) FileDAO.getInstance().getGenres();
                    for(Genre genre : genres) {
                        genreWriter.write(genre.getName() + " " + genre.getId());
                        genreWriter.write(System.lineSeparator());
                    }
                } catch(IOException e) {
                    LOGGER.info(e.getMessage());
                }
                break;
            case "reader":
                break;
            case "booktype":
                break;
            case "librarian":
                break;
        }
    }
}
