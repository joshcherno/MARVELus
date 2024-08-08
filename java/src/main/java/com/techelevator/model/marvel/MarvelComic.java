package com.techelevator.model.marvel;

import java.util.ArrayList;

//TODO: WARNING!! THIS NESTED COLLECTION OF CLASSES WAS CREATED FOR CONVENIENCE. IT CANNOT BE INSTANTIATED AND USED FOR DESERIALIZATION
public class MarvelComic {

    public class Characters{
        public int available;
        public String collectionURI;
        public ArrayList<Item> items;
        public int returned;
    }

    public class Creators{
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

    public class Date{
        public String type;
        public Date date;
    }

    public class Events{
        public int available;
        public String collectionURI;
        public ArrayList<Object> items;
        public int returned;
    }

    public class Image{
        public String path;
        public String extension;
    }

    public class Item{
        public String resourceURI;
        public String name;
        public String role;
        public String type;
    }

    public class Price{
        public String type;
        public double price;
    }

    public class Result{
        public int id;
        public int digitalId;
        public String title;
        public int issueNumber;
        public String variantDescription;
        public String description;
        public Date modified;
        public String isbn;
        public String upc;
        public String diamondCode;
        public String ean;
        public String issn;
        public String format;
        public int pageCount;
        public ArrayList<Object> textObjects;
        public String resourceURI;
        public ArrayList<Url> urls;
        public Series series;
        public ArrayList<Variant> variants;
        public ArrayList<Object> collections;
        public ArrayList<Object> collectedIssues;
        public ArrayList<Date> dates;
        public ArrayList<Price> prices;
        public Thumbnail thumbnail;
        public ArrayList<Image> images;
        public Creators creators;
        public Characters characters;
        public Stories stories;
        public Events events;
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
        public String resourceURI;
        public String name;
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

    public class Variant{
        public String resourceURI;
        public String name;
    }

}
