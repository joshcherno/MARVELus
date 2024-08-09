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

@RestController
@CrossOrigin(origins = "*")
public class ComicController {

    private ComicDao comicDao;
    private ApiService apiService;


    public ComicController(ComicDao comicDao, ApiService apiService){
        this.comicDao = comicDao;
        this.apiService = apiService;
    }
//TODO THIN DOWN THE METHODS. WHAT DO WE REALLY NEED IN HERE


    //TODO: USE FOR EXPLORATION AND DELETE WHEN IMPLEMENTED FORMALLY

    @GetMapping(path = "/comic/search/title/{title}")
    public Object getComicsByTitle(@PathVariable String title){
        return  apiService.searchComicsByTitle(title);
    }
    @GetMapping(path = "/comic/search/isbn/{isbn}")
    public Object getComicsByIsbn(@PathVariable String isbn){
        return apiService.searchComicsByIsbn(isbn);
    }

    @GetMapping(path = "/comic/search/upc/{upc}")
    public Object getComicsByUPC(@PathVariable String upc){
        return apiService.searchComicsByUPC(upc);
    }

    @GetMapping(path = "/character/search/character/{character}")
    public Object getComicsByCharacter(@PathVariable String character){
        return apiService.searchComicsByCharacter(character);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/comic/save/")
    public Comic saveComic(@RequestBody Comic comic){
        return comicDao.saveComic(comic);
    }


    //TODO--
//    @RequestMapping(path = "/comic/{comicId}", method = RequestMethod.GET)
//    public Comic getComicById(@PathVariable int comicId, Principal principal) {
//        return comicDao.getComicById(comicId);
//    }
//    @RequestMapping(path = "/comic/{comicTitle}", method = RequestMethod.GET)
//    public Comic getComicByTitle(@PathVariable String title, Principal principal) {
//        return comicDao.getComicByTitle(title);
//    }
//    @RequestMapping(path = "/comic/{author}", method = RequestMethod.GET)
//    public Comic getComicByAuthor(@PathVariable String author){
//        return comicDao.getComicByAuthor(author);
//    }

    //Intelij wants the same parameters as the method in the ApiService class, not sure if it should be a Comic or ResultComic/Result/Character
//    @RequestMapping(path = "/comic", method = RequestMethod.PUT)
//    public Comic saveComic(@RequestBody ResultComics comic, ResultCharacters charComic){
//        return apiService.saveComicFromResult(comic, charComic);
//
//    }




}
