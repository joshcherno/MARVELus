package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.ComicDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/collection")
public class CollectionController {

    private CollectionDao collectionDao;
    private ComicDao comicDao;
    private UserDao userDao;

    @Autowired
    public CollectionController(CollectionDao collectionDao, ComicDao comicDao, UserDao userDao) {
        this.collectionDao = collectionDao;
        this.comicDao = comicDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/{collectionId}", method = RequestMethod.GET)
    public Collection getCollectionById(@PathVariable ("id") int collectionId){

        Collection collection = null;

        try{
            collection = collectionDao.getCollectionById(collectionId);
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
            collection = collectionDao.getCollectionByUserId(userId);
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found for this User ID.");
        }
        return collection;

    }
}
