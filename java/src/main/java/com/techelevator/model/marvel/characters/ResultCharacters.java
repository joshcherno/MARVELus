package com.techelevator.model.marvel.characters;

import com.techelevator.model.marvel.MarvelComicCharacter;

import java.util.ArrayList;

public class ResultCharacters {
    public int id;
    public String name;
    public String description;
    //public Date modified;
    public Thumbnail thumbnail;
    public String resourceURI;

    //TODO do we need the MarvelComicCharacter prefaces on these. i know rich deleted them
    public MarvelComicCharacter.Comics comics;
    public MarvelComicCharacter.Series series;
    public MarvelComicCharacter.Stories stories;
    public MarvelComicCharacter.Events events;
    public ArrayList<MarvelComicCharacter.Url> urls;
}
