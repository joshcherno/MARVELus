package com.techelevator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.dao.ComicDao;
import com.techelevator.model.Comic;
import com.techelevator.model.marvel.MarvelComic;
import com.techelevator.model.marvel.characters.ResultCharacters;
import com.techelevator.model.marvel.comics.ResultComics;
import com.techelevator.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getComicsByTitle(@PathVariable String title) {
        try {
            Object comicsRoot = apiService.searchComicsByTitle(title);

            if (comicsRoot == null || (comicsRoot instanceof List && ((List<?>) comicsRoot).isEmpty())) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No comics found with this title.");
            }

            return ResponseEntity.ok(comicsRoot);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while searching for comics by title.");
        }
    }
    @GetMapping(path = "/comic/search/upc/{upc}")
    public ResponseEntity<?> getComicsByUPC(@PathVariable String upc) {
        try {
            Object comicsRoot = apiService.searchComicsByUPC(upc);

            if (comicsRoot == null || (comicsRoot instanceof List && ((List<?>) comicsRoot).isEmpty())) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No comics found with this UPC.");
            }

            return ResponseEntity.ok(comicsRoot);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while searching for comics by UPC.");
        }
    }
@GetMapping(path = "/comic/search/character/{character}")
public ResponseEntity<?> getComicsByCharacter(@PathVariable String character) {
    try {
        Object comicsRoot = apiService.searchComicsByCharacter(character);

        if (comicsRoot == null || (comicsRoot instanceof List && ((List<?>) comicsRoot).isEmpty())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This character doesn't exist.");
        }

        return ResponseEntity.ok(comicsRoot);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("This character doesn't exist.");
    }
}
@GetMapping(path = "/comic/search/upcoming-releases")
public ResponseEntity<?> getRecentReleases(){
    try {
        Object comicsRoot = apiService.getRecentReleases();

        if (comicsRoot == null || (comicsRoot instanceof List && ((List<?>) comicsRoot).isEmpty())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Upcoming realeases not found.");
        }

        return ResponseEntity.ok(comicsRoot);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("This character doesn't exist.");
    }
}
    @ResponseStatus(HttpStatus.CREATED)
    // MAP TO "/collection/{id}/add"
    @PostMapping(path = "/comic/save/")
    public Comic saveComic(@RequestBody ResultComics rComic){
        return comicDao.saveComic(rComic);
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
    @GetMapping(path = "search/comic/{collectionId")
    public List<Comic> getComicsFromCollection(int collectionId){
        return comicDao.getComicsFromCollection(collectionId);
    }


}
