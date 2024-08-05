package com.techelevator.dao;

import com.techelevator.model.Comic;

import java.util.List;

public interface ComicDao {

    Comic getComicById(String comicId);
    Comic getComicByTitle(String title);
    Comic getComicByAuthor(String author);
    List<Comic> getComics();
    Comic saveComic(Comic comic);

}
