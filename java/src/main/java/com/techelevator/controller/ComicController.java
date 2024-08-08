package com.techelevator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.dao.ComicDao;
import com.techelevator.model.Comic;
import com.techelevator.service.ApiService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class ComicController {

    private ComicDao comicDao;
    private ApiService apiService;


    public ComicController(ComicDao comicDao, ApiService apiService){
        this.comicDao = comicDao;
        this.apiService = apiService;
    }
//TODO THIN DOWN THE METHODS. WHAT DO WE REALLY NEED IN HERE
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

    //TODO: USE FOR EXPLORATION AND DELETE WHEN IMPLEMENTED FORMALLY

    @GetMapping(path = "/comic/search/{title}")
    public Object getComicsByTitle(@PathVariable String title){
        return  apiService.searchComicsByTitle(title);
    }
    @GetMapping(path = "/comic/search/{isbn}")
    public Object getComicsByIsbn(@PathVariable int isbn){
        return apiService.searchComicsByIsbn(isbn);
    }
    @GetMapping(path = "/character/search/{character}")
    public Object getComicsByCharacter(@PathVariable String character){
        return apiService.searchComicsByCharacter(character);
    }


    @RequestMapping(path = "/comic", method = RequestMethod.PUT)
    public Comic saveComic(@RequestBody Comic comic){
        return comicDao.saveComic(comic);

    }




}
