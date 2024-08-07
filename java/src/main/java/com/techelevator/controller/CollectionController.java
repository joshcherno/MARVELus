package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.ComicDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import com.techelevator.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/collection")
public class CollectionController {

    private CollectionDao collectionDao;
    private ComicDao comicDao;
    private UserDao userDao;
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
    @RequestMapping(path = "/{collectionId}", method = RequestMethod.GET)
    public Collection getCollectionById(@PathVariable ("id") int collectionId){

        Collection collection = null;

        try{
            collection = collectionService.getCollectionById(collectionId);
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found for this Collection ID.");
        }
        return collection;
    }
    // TODO it needs to be figured out
    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public Collection getCollectionByUserId(@PathVariable("id") int userId){

        Collection collection = null;

        try{
            collection = collectionService.getCollectionByUserId(userId);
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found for this User ID.");
        }
        return collection;

    }


    @RequestMapping(path = "/{collectionName}", method = RequestMethod.GET)
    public Collection getCollectionByName(@PathVariable("name") String name){
        Collection collection = null;

        try{
            collection = collectionService.getCollectionByName(name);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found for this name");
        }
        return collection;
    }

    @RequestMapping(path="/{myCollections}", method = RequestMethod.GET)
    public List<Collection>getCollections(){

            return collectionService.getCollections();

    }

    @RequestMapping(path="/create-collection", method = RequestMethod.PUT)
    public Collection createCollection (Collection collection){
        return collectionService.createCollection(collection);
    }

    @RequestMapping(path="/add-comic", method = RequestMethod.PUT)
    public Collection addingComic (Comic comic) {
        return collectionService.addingComic(comic);
    }















}
