package com.techelevator.model.marvel;

import java.util.ArrayList;
//TODO: WARNING!! THIS NESTED COLLECTION OF CLASSES WAS CREATED FOR CONVENIENCE. IT CANNOT BE INSTANTIATED AND USED FOR DESERIALIZATION
public class MarvelComicCharacter {
    public class Comics{
        public int available;
        public String collectionURI;
        public ArrayList<Item> items;
        public int returned;
    }

    public class Data{
        public int offset;
        public int limit;
        public int total;
        public int count;
        public ArrayList<Result> results;
    }

    public class Events{
        public int available;
        public String collectionURI;
        public ArrayList<Item> items;
        public int returned;
    }

    public class Item{
        public String resourceURI;
        public String name;
        public String type;
    }

    public class Result{
        public int id;
        public String name;
        public String description;
        //public Date modified;
        public Thumbnail thumbnail;
        public String resourceURI;
        public Comics comics;
        public Series series;
        public Stories stories;
        public Events events;
        public ArrayList<Url> urls;
    }

    public class Root{
        public int code;
        public String status;
        public String copyright;
        public String attributionText;
        public String attributionHTML;
        public String etag;
        public Data data;
    }

    public class Series{
        public int available;
        public String collectionURI;
        public ArrayList<Item> items;
        public int returned;
    }

    public class Stories{
        public int available;
        public String collectionURI;
        public ArrayList<Item> items;
        public int returned;
    }

    public class Thumbnail{
        public String path;
        public String extension;
    }

    public class Url{
        public String type;
        public String url;
    }

}
