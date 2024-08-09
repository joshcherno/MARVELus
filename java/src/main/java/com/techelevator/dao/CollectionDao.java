package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import com.techelevator.model.User;

import java.util.List;

public interface CollectionDao {

    public Collection getCollectionById(int collId);

    public Collection getCollectionByUserId(int userId);

    public Collection getCollectionByName(String collectionName);

    public List<Collection> getCollections();

    public Collection createCollection(Collection newCollection);

    public Collection addingComic(int collectionId, Comic comic);


}
