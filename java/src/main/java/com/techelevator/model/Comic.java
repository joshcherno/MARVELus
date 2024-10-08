package com.techelevator.model;

import com.techelevator.model.marvel.characters.ResultCharacters;
import com.techelevator.model.marvel.comics.ResultComics;

import java.time.LocalDate;

public class Comic {

    private int comicId;
    private String title;
    private String author;
    private String description;
    private LocalDate releaseDate;
    private String coverArt;
    private String characterName;


    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }



    //TODO convert to comic model from json reply
    public static Comic convertMarvelResult(ResultComics comicResult, ResultCharacters characterResult){

        Comic appComic = new Comic();

        appComic.setComicId(comicResult.id);

        appComic.coverArt = comicResult.thumbnail.path + "." + comicResult.thumbnail.extension;
        appComic.title = comicResult.title;
        appComic.characterName = characterResult.name;

        return  appComic;
    }

    public static Comic convertMarvelResult(ResultComics comicResult){

        Comic appComic = new Comic();

        appComic.setComicId(comicResult.id);

        appComic.coverArt = comicResult.thumbnail.path + "." + comicResult.thumbnail.extension;
        appComic.title = comicResult.title;

        return  appComic;
    }





}
