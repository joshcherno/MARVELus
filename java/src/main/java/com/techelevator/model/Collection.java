package com.techelevator.model;

public class Collection {

    private int collectionId;
    private String collectionName;
    private String colDescription;
    private int userId;

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getColDescription() {
        return colDescription;
    }

    public void setColDescription(String colDescription) {
        this.colDescription = colDescription;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
