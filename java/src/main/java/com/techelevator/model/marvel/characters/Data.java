package com.techelevator.model.marvel.characters;

import com.techelevator.model.marvel.MarvelComicCharacter;
import com.techelevator.model.marvel.comics.ResultComics;

import java.util.ArrayList;

public class Data {
    public int offset;
    public int limit;
    public int total;
    public int count;
    public ArrayList<ResultComics> results;
}
