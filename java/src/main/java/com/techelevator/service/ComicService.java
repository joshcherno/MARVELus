package com.techelevator.service;


import com.techelevator.dao.ComicDao;
import com.techelevator.model.Comic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicService {
    private final ComicDao comicDao;

    public ComicService(ComicDao comicDao) {
        this.comicDao = comicDao;
    }

    public Comic getComicById(String comicId){
        return comicDao.getComicById(comicId);
    }
    public List<Comic> getComics(){
        return comicDao.getComics();
    }
    public Comic saveComic(Comic comic){
        return comicDao.saveComic(comic);
    }
}
