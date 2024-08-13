package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Comic;

import java.util.List;

public interface ComicDao {

    Comic getAllComics();
    Comic getComicById(int comicId);
    List<Comic> getComicByTitle(String title);
    Comic getComicByAuthor(String author);
    List<Comic> getComics();
    Comic saveComic(Comic comic);
    List<Comic> getComicsFromCollection(int collectionId);


}
