package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.ComicDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import com.techelevator.model.marvel.comics.ResultComics;
import com.techelevator.service.CollectionService;
import com.techelevator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@PreAuthorize("isAuthenticated()")
public class CollectionController {

    private CollectionDao collectionDao;
    private ComicDao comicDao;
    private UserDao userDao;
    private UserService userService;
    private CollectionService collectionService;

    @Autowired
    public CollectionController(CollectionDao collectionDao, CollectionService collectionService,ComicDao comicDao, UserDao userDao) {
        this.collectionDao = collectionDao;
        this.comicDao = comicDao;
        this.userDao = userDao;
        this.collectionService = collectionService;
    }

    //extending CollectionService methods
    //TODO Consider how to add methods for restTemplate purposes to make sure we are talking to the client side appropriately
    @RequestMapping(path = "/collections/{collectionId}", method = RequestMethod.GET)
    public Collection getCollectionById(@PathVariable ("collectionId") int collectionId){

        Collection collection;

        try{
            collection = collectionService.getCollectionById(collectionId);
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found for this Collection ID.");
        }
        return collection;
    }
    // TODO Principal needs to be properly implemented
    @RequestMapping(path = "/collection/user/{userId}", method = RequestMethod.GET)
    public List <Collection> getCollectionByUserId(@PathVariable("userId") int userId,Principal principal){

        List <Collection> collection = new ArrayList<>();

        try{
            String username = principal.getName();
            int authUserId = userDao.getUserByUsername(username).getId();
            collection = collectionService.getCollectionsByUserId(userId);
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found for this User ID.");
        }
        return collection;

    }

    //TODO map out endpoints a bit better. refactor some methods

    @RequestMapping(path = "/collection/name/{collectionName}", method = RequestMethod.GET)
    public Collection getCollectionByName(@PathVariable("name") String name){
        Collection collection;

        try{
            collection = collectionService.getCollectionByName(name);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found for this name");
        }
        return collection;
    }

    //TODO distinguish between collections and mycollections
    @RequestMapping(path="/collection/{myCollections}", method = RequestMethod.GET)
    public List<Collection>getCollections(){

            return collectionService.getCollections();

    }

    @RequestMapping(path="/collection/create-collection", method = RequestMethod.POST)
    public Collection createCollection (@RequestBody Collection collection, Principal principal){
        return collectionService.createCollection(collection, principal);
    }


    //TODO: RGS -> ONLY EVER USE THIS END POINT TO ADD  A COMIC TO A USER COLLECTION. ask Rich if this needs deleted now
    @RequestMapping(path="/collection/{collectionId}", method = RequestMethod.POST)
    public Collection addComicToCollection (@PathVariable("collectionId") int collectionId, @RequestBody ResultComics comic) {

        //TODO: RGS ->  \/ \/ \/ \/REFACTOR \/ \/ \/ \/ TO MIMIC LOGIC OUTLINED IN JdbcComicDao.saveComic(ResultComics rcomic)
        //TODO: RGS -> ...CONT ... OR REFACTOR THE ABOVE METHOD AND CALL IT BELOW INSTEAD OF COLLECTION SERVICE METHOD
        return collectionService.addComic(collectionId, comic);
    }
    @RequestMapping(path="/collection/{collectionId}/comics", method = RequestMethod.GET)
    public List<Comic> getComicsByCollectionId (@PathVariable("collectionId") int collectionId) {
        return collectionService.getComicByCollectionId(collectionId);
    }
    @GetMapping(path = "/collection/collection-total")
    public int totalNumberOfCollections(){
        return collectionService.totalNumberOfCollections();
    }
    @GetMapping(path = "/collection/saved-total")
    int numberOfSavedComics(){
        return collectionService.numberOfSavedComics();
    }
    @GetMapping(path = "/collection/collection-comics")
    int numberOfComicsInCollections(){
        return collectionService.numberOfComicsInCollections();
    }
    @RequestMapping(path = "/collection/delete/{collectionId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCollection(@PathVariable("collectionId") int collectionId) {
        try {
            collectionService.deleteCollection(collectionId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // added by dylan
    @RequestMapping(path="/collection/{collectionId}/comic/{comicId}", method = RequestMethod.DELETE)
    public Collection deleteComicFromCollection(@PathVariable ("comicId") int comicId, @PathVariable("collectionId") int collectionId) {
        return collectionService.deleteComicFromCollection(collectionId, comicId);
    }



}
