package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Comic;

import java.security.Principal;
import java.util.List;

public interface CollectionDao {

    public Collection getCollectionById(int collId);

    public Collection getCollectionByUserId(int userId);

    public Collection getCollectionByName(String collectionName);

    public List<Collection> getCollections();

    public Collection createCollection(Collection newCollection, Principal principal);

    public Collection addComicToCollection(int collectionId, int comic);


    List<Comic> getComicsByCollectionId(int collectionId);
}
