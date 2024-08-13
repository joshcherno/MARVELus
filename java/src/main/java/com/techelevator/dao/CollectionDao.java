package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Comic;

import java.security.Principal;
import java.util.List;

public interface CollectionDao {

    public Collection getCollectionById(int collId);

    public List <Collection> getCollectionsByUserId(int userId);

    public Collection getCollectionByName(String collectionName);

    public List<Collection> getCollections();

    public Collection createCollection(Collection collection, Principal principal);

    public Collection addComicToCollection(int collectionId, int comic);
    int totalNumberOfCollections();
    int numberOfSavedComics();
    int numberOfComicsInCollections();

    List<Comic> getComicsByCollectionId(int collectionId);
}
