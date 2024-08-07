package com.techelevator.controller;

import com.techelevator.dao.ComicDao;
import com.techelevator.model.Comic;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class ComicController {

    private ComicDao comicDao;


    public ComicController(ComicDao comicDao){
        this.comicDao = comicDao;
    }

    @RequestMapping(path = "/comic/{comicId}", method = RequestMethod.GET)
    public Comic getComicById(@PathVariable int comicId, Principal principal) {
        return comicDao.getComicById(comicId);
    }
    @RequestMapping(path = "/comic/{comicTitle}", method = RequestMethod.GET)
    public Comic getComicByTitle(@PathVariable String title, Principal principal) {
        return comicDao.getComicByTitle(title);
    }
    @RequestMapping(path = "/comic/{author}", method = RequestMethod.GET)
    public Comic getComicByAuthor(@PathVariable String author){
        return comicDao.getComicByAuthor(author);
    }
    @RequestMapping(path = "/comic", method = RequestMethod.PUT)
    public Comic saveComic(@RequestBody Comic comic){
        return comicDao.saveComic(comic);

    }




}
