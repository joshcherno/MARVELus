package com.techelevator.service;

import com.techelevator.dao.CollectionDao;
import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import com.techelevator.model.marvel.comics.ResultComics;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.security.Principal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@CrossOrigin(origins = "*")
public class CollectionService {
    //TODO ALL OF THE WORK HERE JASDOLFKJAPSLIEFGJRVAOELPSRDIKJGVAOLPIKWESJ

    private final CollectionDao collectionDao;

//constructor
    public CollectionService(CollectionDao collectionDao) {
        this.collectionDao = collectionDao;
    }

    // extending the CollectionDao methods
    //TODO Consider how to add methods for restTemplate purposes to make sure we are talking to the client side appropriately

    public Collection getCollectionById(int collID) {
       return collectionDao.getCollectionById(collID);
    }
    public List <Collection> getCollectionsByUserId(int userId){
        return collectionDao.getCollectionsByUserId(userId);
    }
    public Collection getCollectionByName(String collectionName){
        return collectionDao.getCollectionByName(collectionName);
    }

    public List<Collection> getCollections () {
        return collectionDao.getCollections();
    }

    public Collection createCollection(Collection collection, Principal principal){
        return collectionDao.createCollection(collection, principal);
    }

    public Collection addingComic (int collectionId, List<Integer> comicIds){
        for (int comicId : comicIds) {
            collectionDao.addComicToCollection(collectionId,comicId);
        }
        return collectionDao.getCollectionById(collectionId);
    }

    //TODO new implementation? --------
    public Collection addComic (int collectionId, ResultComics comic){

            collectionDao.addComicToCollection(collectionId, comic.id);

        return collectionDao.getCollectionById(collectionId);
    }

    public List<Comic> getComicByCollectionId (int collectionId){
        return collectionDao.getComicsByCollectionId(collectionId);
    }
    public int totalNumberOfCollections(){
        return collectionDao.totalNumberOfCollections();
    }
    public int numberOfSavedComics(){
        return collectionDao.numberOfSavedComics();
    }
    public int numberOfComicsInCollections(){
        return collectionDao.numberOfComicsInCollections();
    }



}
