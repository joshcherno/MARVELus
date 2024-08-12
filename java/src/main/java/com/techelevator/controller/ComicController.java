package com.techelevator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.dao.ComicDao;
import com.techelevator.model.Comic;
import com.techelevator.model.marvel.characters.ResultCharacters;
import com.techelevator.model.marvel.comics.ResultComics;
import com.techelevator.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ComicController {

    private ComicDao comicDao;
    private ApiService apiService;


    public ComicController(ComicDao comicDao, ApiService apiService){
        this.comicDao = comicDao;
        this.apiService = apiService;
    }



    //TODO: USE FOR EXPLORATION AND DELETE WHEN IMPLEMENTED FORMALLY

    @GetMapping(path = "/comic/search/title/{title}")
    public Object getComicsByTitle(@PathVariable String title){
        return  apiService.searchComicsByTitle(title);
    }
    @GetMapping(path = "/comic/search/upc/{upc}")
    public Object getComicsByUPC(@PathVariable String upc){
        return apiService.searchComicsByUPC(upc);
    }
    @GetMapping(path = "/comic/search/character/{character}")
    public Object getComicsByCharacter(@PathVariable String character){
        return apiService.searchComicsByCharacter(character);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/comic/save/")
    public Comic saveComic(@RequestBody Comic comic){
        return comicDao.saveComic(comic);
    }
    @GetMapping(path = "/search/comic/")
    public List<Comic> getAllComics(){
        return comicDao.getComics();
    }
    @GetMapping(path = "search/comic/title/{title}")
    public List<Comic> getComicByTitle(@PathVariable String title){
        return comicDao.getComicByTitle(title);
    }
    @GetMapping(path = "search/comic/id/{comicId}")
    public Comic getComicById(@PathVariable int comicId){
        return comicDao.getComicById(comicId);
    }

}
