package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.ComicDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import com.techelevator.service.CollectionService;
import com.techelevator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@PreAuthorize("isAuthenticated()")
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
    @RequestMapping(path = "/collection/id/{collectionId}", method = RequestMethod.GET)
    public Collection getCollectionById(@PathVariable ("collectionId") int collectionId){

        Collection collection = null;

        try{
            collection = collectionService.getCollectionById(collectionId);
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found for this Collection ID.");
        }
        return collection;
    }
    // TODO Principal needs to be properly implemented
    @RequestMapping(path = "/collection/user/{userId}", method = RequestMethod.GET)
    public Collection getCollectionByUserId(@PathVariable("userId") int userId,Principal principal){

        Collection collection = null;

        try{
            String username = principal.getName();
            int authUserId = userService.getUserIdByUsername(username);
            collection = collectionService.getCollectionByUserId(userId);
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found for this User ID.");
        }
        return collection;

    }

    //TODO map out endpoints a bit better. refactor some methods

    @RequestMapping(path = "/collection/name/{collectionName}", method = RequestMethod.GET)
    public Collection getCollectionByName(@PathVariable("name") String name){
        Collection collection = null;

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
    public Collection createCollection (@RequestBody Collection collection){
        return collectionService.createCollection(collection);
    }

    @RequestMapping(path="/collection/add-comic", method = RequestMethod.PUT)
    public Collection addingComic (int collectionId, Comic comic) {
        return collectionService.addingComic(collectionId, comic);
    }















}
